package Activity2;

import java.util.LinkedList;
import java.util.Queue;
// Problem: The queue should remove the first person who entered.
/*
 * Group Members:
 * 
 * */
public class Group5 {
    public static void main(String[] args) {

        Queue<String> customers = new LinkedList<>();

        customers.add("Customer A");
        customers.add("Customer B");
        customers.add("Customer C");

        customers.remove("Customer C");

        System.out.println(customers);
    }
}
