package com.springcore.constructors;

public class Addition {
    private int a;

    private int b;

    /* Spring IOC container firstly search for string parameterize constructor and then call by appending order */

    public Addition (double a, double b) {
        this.a = (int) a;
        this.b = (int) b;
        System.out.println("Constructor: double, double");
    }

    public Addition (int a, int b) {
        this.a = a;
        this.b = b;
        System.out.println("Constructor: int, int");
    }

    public Addition (String a, String b) {
        this.a = Integer.parseInt(a);
        this.b = Integer.parseInt(b);
        System.out.println("Constructor: String, String");
    }

    public void doSum () {
        System.out.println("Sum = " + (this.a + this.b));
    }

    public void doSub () {
        System.out.println("Sub = " + (this.a - this.b));
    }
}
