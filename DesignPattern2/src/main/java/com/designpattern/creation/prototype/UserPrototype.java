package com.designpattern.creation.prototype;

public interface UserPrototype extends Cloneable {
    public User clone() throws CloneNotSupportedException;
}
