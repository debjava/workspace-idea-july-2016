package com.ddlab.rnd.funtionalinterface;

@FunctionalInterface
public interface Validator {
    boolean isValid( String s );

    //You can declare methods from Object class
    String toString();
    boolean equals(Object object);


}
