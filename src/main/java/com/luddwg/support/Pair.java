package com.luddwg.support;

public final class Pair <T> {

    private final T first;

    private final T second;

    private Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public static <T> Pair<T> of(T first, T second) {
        return new Pair<>(first, second);
    }

    public T getFirst() {
        return this.first;
    }

    public T getSecond() {
        return this.second;
    }
}
