package de.twomartens.sandbox.enums;

import java.util.function.BiConsumer;
import java.util.function.Function;

public class Task<T, V> {
    private final Function<String, V> parser;
    private final BiConsumer<T, V> setter;

    public Task(BiConsumer<T, V> setter, Function<String, V> parser) {
        this.parser = parser;
        this.setter = setter;
    }

    public Function<String, V> parser() {
        return parser;
    }

    public BiConsumer<T, V> setter() {
        return setter;
    }
}
