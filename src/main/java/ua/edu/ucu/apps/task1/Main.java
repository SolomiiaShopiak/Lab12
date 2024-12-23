package ua.edu.ucu.apps.task1;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.getMeMoney(1000);
        atm.getMeMoney(700);
        atm.getMeMoney(800);
        atm.getMeMoney(400);
        atm.getMeMoney(750);
    }
}