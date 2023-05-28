package de.twomartens.sandbox.enums;

import java.util.function.BiConsumer;
import java.util.function.Function;

public record Task<T, V>(BiConsumer<T, V> setter, Function<String, V> parser) {

}
