package com.designpattern.creation.prototype;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User implements UserPrototype {

    private String displayName;
    private String email;

    public User(String displayName, String email) {
        this.displayName = displayName;
        this.email = email;
    }

    /**
     * @return Thuộc tính dẵ dc copy
     */
    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
