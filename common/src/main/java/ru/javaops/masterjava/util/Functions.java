package ru.javaops.masterjava.util;

/**
 *  @see <a href="https://github.com/diffplug/durian/blob/master/src/com/diffplug/common/base/Throwing.java">Throwing at Durian project</a>
 */
public interface Functions {
    /**
     * Variations on the standard functional interfaces which throw a specific subclass of Exception.
     */
    interface Specific {
        @FunctionalInterface
        interface Runnable<E extends Exception> {
            void run() throws E;
        }

        @FunctionalInterface
        interface Supplier<T, E extends Exception> {
            T get() throws E;
        }

        @FunctionalInterface
        interface Consumer<T, E extends Exception> {
            void accept(T t) throws E;
        }

        @FunctionalInterface
        interface Function<T, R, E extends Exception> {
            R apply(T t) throws E;
        }

        @FunctionalInterface
        interface Predicate<T, E extends Exception> {
            boolean test(T t) throws E;
        }

        @FunctionalInterface
        interface BiConsumer<T, U, E extends Exception> {
            void accept(T t, U u) throws E;
        }

        @FunctionalInterface
        interface BiFunction<T, U, R, E extends Exception> {
            R apply(T t, U u) throws E;
        }

        @FunctionalInterface
        interface BiPredicate<T, U, E extends Exception> {
            boolean accept(T t, U u) throws E;
        }
    }

    @FunctionalInterface
    interface RunnableEx extends Specific.Runnable<Exception> {
    }

    @FunctionalInterface
    interface SupplierEx<T> extends Specific.Supplier<T, Exception> {
    }

    @FunctionalInterface
    interface ConsumerEx<T> extends Specific.Consumer<T, Exception> {
    }

    @FunctionalInterface
    interface FunctionEx<T, R> extends Specific.Function<T, R, Exception> {
    }

    @FunctionalInterface
    interface PredicateEx<T> extends Specific.Predicate<T, Exception> {
    }

    @FunctionalInterface
    interface BiConsumerEx<T, U> extends Specific.BiConsumer<T, U, Exception> {
    }

    @FunctionalInterface
    interface BiFunctionEx<T, U, R> extends Specific.BiFunction<T, U, R, Exception> {
    }

    @FunctionalInterface
    interface BiPredicateEx<T, U> extends Specific.BiPredicate<T, U, Exception> {
    }
}