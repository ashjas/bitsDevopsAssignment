package com.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, Jenkins Pipeline! Triggered from a github PR");
    }

    public String getGreeting() {
        return "Hello from myapp!";
    }
}