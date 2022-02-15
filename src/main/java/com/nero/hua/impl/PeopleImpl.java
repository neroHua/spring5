package com.nero.hua.impl;

import aop.LogAOP;
import com.nero.hua.People;

public class PeopleImpl implements People {

    @Override
    public void fly() {
        System.out.println("people is flying");
    }

    @Override
    public void peopleTest() {
        System.out.println("people is Test");
    }

    @Override
    public void test() {
        System.out.println("people is test");
    }

    @LogAOP.Log
    @Override
    public void sleep1() {
        System.out.println("people is sleep1");
    }

    @Override
    public void sleep2() {
        System.out.println("people is sleep2");
    }
}
