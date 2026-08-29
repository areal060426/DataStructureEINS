package as;

import java.time.LocalDate;
import java.time.Period;

public class Paja {
	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		LocalDate Birthdate = LocalDate.of(2004, 6, 13);
		
		String name = "Philip Daryll D. Paja";
		int age = Period.between(Birthdate, today).getYears();
		String coursenyearlvl = "2nd Year-BSIT";
		String school = "University of Makati";
		String hobbies = "Playing Video Games, Playing Instruments, Reading Manga and other types of Comics, Cooking";
		String favproglang = "Java, Python and Lua";
		String reason = "To further improve my knowledge on how to create a software using Java and apply it to applications and programs that I will develop in the future";
		
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Course and Year Level: " + coursenyearlvl);
		System.out.println("School: " + school);
		System.out.println("Hobbies: " + hobbies);
		System.out.println("Favorite Programming Languages: " + favproglang);
		System.out.println("The reason why I want to learn Java: " + reason);
	}
}