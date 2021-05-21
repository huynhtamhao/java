package com.designpattern.creation.prototype;

public class PrototypeExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user1 = new User("user 1", "user1@gmail.com");
        System.out.println(user1.hashCode());

        // Implement Clone Java (Deep Copy)
        User user2 = user1.clone();
        user2.setDisplayName("user 2");
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());

        System.out.println(user1.getDisplayName());
        System.out.println(user2.getDisplayName());

        // Shallow Copy
        User user3 = user1;
        user3.setDisplayName("user 3");
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user3.hashCode());

        System.out.println(user1.getDisplayName());
        System.out.println(user2.getDisplayName());
        System.out.println(user3.getDisplayName());
    }
}
