/*
 * Block Week 2 - Ping-Pong Akka example.
 */
package ch.bfh.akka.pingpong;

import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import akka.actor.typed.javadsl.AbstractBehavior;

/**
 * A simple actor having the 'ping' role. It receives the initialization message
 * containing the reference to pong. After having received the start message, it
 * sends a pong to pong, and awaits the answer of pong. Having received the
 * answer of pong, this repeats indefinitely.
 */
public class Ping extends AbstractBehavior<Ping.Message> {

    private ActorRef<Pong.Message> pong;

	interface Message { }

    public static class HelloPing implements Message { }

    public static class Start implements Message { }

    public static class SetUp implements Message {
        private ActorRef<Pong.Message> pongRef;

        public SetUp(ActorRef<Pong.Message> pongRef) {
            this.pongRef = pongRef;
        }
    }

    public static Behavior<Message> create() {
        return Behaviors.setup(context -> new Ping(context));
    }

    private Ping(ActorContext<Message> context) {
        super(context);
    }

    @Override
    public Receive<Message> createReceive() {
        return newReceiveBuilder()
                .onMessage(Ping.Start.class, this::handlerStart)
                .onMessage(Ping.SetUp.class, this::handlerSetUp)
                .onMessage(Ping.HelloPing.class, this::handlerHelloPing)
                .build();
    }

    private Behavior<Message> handlerHelloPing(HelloPing helloPing) {
        System.out.println("ping");
        pong.tell(new Pong.HelloPong());
        return this;
    }

    private Behavior<Message> handlerSetUp(SetUp setUp) {
        System.out.println("setup ping...");
        pong = setUp.pongRef;
        return this;
    }

    private Behavior<Message> handlerStart(Start start) {
        System.out.println("starting with ping...");
        this.handlerHelloPing(new HelloPing());
        return this;
    }
}
