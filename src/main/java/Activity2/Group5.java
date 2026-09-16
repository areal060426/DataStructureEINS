package Activity2;

import java.util.LinkedList;
import java.util.Queue;

// Problem: The queue should remove the first person who entered.
/*
 * Group Members:
 * 
 /*
 * Group Members:
 *Ian Nathaniel Sandrino
 * Jerryzon Egan
 * Adrin Cain España
 * Mike Camering
 * Kurt Balagtas
 */


 public class Group5 {
	    public static void main(String[] args) {

	        Queue<String> customers = new LinkedList<>();

	        customers.add("Customer A");
	        customers.add("Customer B");
	        customers.add("Customer C");

	        customers.remove();
	 // Updated by Group Members:
	 // Changed customers.remove("Customer  C") to customers.remove()
	 // so the first customer who entered the queue is removed
	 // following the First In, First Out rule.

	        System.out.println(customers);
	    }
	}