package com.ddlab.rnd.funtionalinterface;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}