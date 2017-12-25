package ru.javaops.masterjava.util;

import lombok.experimental.UtilityClass;

/**
 *  @see <a href="https://github.com/diffplug/durian/blob/master/src/com/diffplug/common/base/Errors.java">full Errors at Durian project</a>
 */
@UtilityClass
public class Exceptions {
    public static <E extends Exception> java.lang.Runnable wrap(Functions.Specific.Runnable<E> runnableWitEx) {
        return () -> {
            try {
                runnableWitEx.run();
            } catch (Exception e) {
                throw asRuntime(e);
            }
        };
    }

    public static RuntimeException asRuntime(Throwable e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        } else {
            return new RuntimeException(e);
        }
    }
}
