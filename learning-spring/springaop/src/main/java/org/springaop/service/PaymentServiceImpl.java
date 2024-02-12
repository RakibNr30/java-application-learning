package org.springaop.service;

public class PaymentServiceImpl implements PaymentService{
    @Override
    public void makePayment(double amount) {
        System.out.println(amount + " Amount Debited.");

        System.out.println(amount + " Amount Credited to Another A/C.");
    }
}
