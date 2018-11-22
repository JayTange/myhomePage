package com.wargod.controller;

/**
 * @author: tangJ
 * @Date: 2018/11/22 17:08
 * @description:
 */
public class HelloMessage {
    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
