/*
 * Block Week 2 - Ping-Pong Akka example.
 */
package ch.bfh.akka.pingpong;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

/**
 * A simple actor having the 'pong' role. It receives the initialization message
 * containing the reference to ping. After having received the pong, it sends a
 * ping to ping, and awaits the answer of ping. Having received the answer of
 * ping, this repeats indefinitely.
 */
public class Pong extends AbstractBehavior<Pong.Message> {

    private ActorRef<Ping.Message> ping;

    interface Message { }

    public static class HelloPong implements Message { }

    public static class SetUp implements Message {
        private ActorRef<Ping.Message> pingRef;

        public SetUp(ActorRef<Ping.Message> pingRef) {
            this.pingRef = pingRef;
        }
    }

    public static Behavior<Message> create() {
        return Behaviors.setup(context -> new Pong(context));
    }

    private Pong(ActorContext<Message> context) {
        super(context);
    }

    @Override
    public Receive<Pong.Message> createReceive() {
        return newReceiveBuilder()
                .onMessage(Pong.SetUp.class, this::handlerSetUp)
                .onMessage(Pong.HelloPong.class, this::handlerHelloPong)
                .build();
    }

    private Behavior<Pong.Message> handlerHelloPong(Pong.HelloPong helloPong) {
        System.out.println("pong");
        ping.tell(new Ping.HelloPing());
        return this;
    }

    private Behavior<Message> handlerSetUp(SetUp setUp) {
        System.out.println("setup pong...");
        ping = setUp.pingRef;
        return this;
    }
}
