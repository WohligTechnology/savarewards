package com.wohlig.sava;

import java.io.Serializable;

/**
 * Created by wohlig on 9/9/16.
 */
public class Person implements Serializable {
    private String name;
    private String email;

    public Person(String n, String e) { name = n; email = e; }

    public String getName() { return name; }
    public String getEmail() { return email; }

    @Override
    public String toString() { return name; }
}
