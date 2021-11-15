/*
 * Block Week 2 - Ping-Pong Akka example.
 */
package ch.bfh.akka.pingpong;

import akka.actor.typed.ActorSystem;
import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

/**
 * The root actor of the Akka ping-pong system. It spawns ping and pong child
 * actors and sets up the mutual references such that, as a next step, the
 * children can exchange messages.
 */
public class PingPongRoot extends AbstractBehavior<PingPongRoot.InitMessage> {

    private final ActorRef<Ping.Message> ping;
    private final ActorRef<Pong.Message> pong;

	interface InitMessage { }

    public static final class Start implements InitMessage { }

    public static Behavior<InitMessage> create() {
        return Behaviors.setup(context -> new PingPongRoot(context));
    }

    private PingPongRoot(ActorContext<InitMessage> context) {
        super(context);
        ping = context.spawn(Ping.create(), "ping");
        pong = context.spawn(Pong.create(), "pong");
    }

    @Override
    public Receive<InitMessage> createReceive() {
        return newReceiveBuilder()
                .onMessage(PingPongRoot.Start.class, this::handlerStart)
                .build();
    }

    private Behavior<InitMessage> handlerStart(Start start) {
        System.out.println("starting root...");
        // setUp
        pong.tell(new Pong.SetUp(ping));
        ping.tell(new Ping.SetUp(pong));

        // start
        Ping.Start startPing = new Ping.Start();

        // start ping
        ping.tell(startPing);
        return this;
    }
}
