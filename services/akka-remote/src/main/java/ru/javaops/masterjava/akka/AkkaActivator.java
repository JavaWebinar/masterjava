package ru.javaops.masterjava.akka;

import akka.actor.*;
import akka.japi.Creator;
import akka.util.Timeout;
import lombok.extern.slf4j.Slf4j;
import ru.javaops.masterjava.config.Configs;
import scala.concurrent.ExecutionContext;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

@Slf4j
public class AkkaActivator {
    private static final String AKKA_CONF = "akka.conf";

    private ActorSystem system;

    private AkkaActivator(String actorSystemName, String nodeName) {
        log.info("Start AKKA System {} : {}", actorSystemName, nodeName);
        system = ActorSystem.create(actorSystemName, Configs.getAppConfig(AKKA_CONF).getConfig(nodeName));
    }

    public static AkkaActivator start(String actorSystemName, String configName) {
        return new AkkaActivator(actorSystemName, configName);
    }

    public <T> void startTypedActor(Class<T> typedClass, String name, Creator<T> creator) {
        log.info("Start AKKA typed actor: {}", name);
        TypedActor.get(system).typedActorOf(
                new TypedProps<T>(typedClass, creator).withTimeout(new Timeout(Duration.create(20, TimeUnit.SECONDS))), name);
    }

    public <T> ActorRef startActor(Class<T> actorClass, String name) {
        log.info("Start AKKA actor: {}", name);
        return system.actorOf(Props.create(actorClass), name);
    }

    public <T> T getTypedRef(Class<T> typedClass, String path) {
        log.info("Get typed reference with path={}", path);
        return TypedActor.get(system).typedActorOf(new TypedProps<T>(typedClass), system.actorFor(path));
    }

    public ActorRef getActorRef(String path) {
        log.info("Get actor reference with path={}", path);
        return system.actorFor(path);
    }

    public ExecutionContext getExecutionContext() {
        return system.dispatcher();
    }

    public void shutdown() {
        if (system != null) {
            log.info("Akka system shutdown");
            system.terminate();
        }
    }
}