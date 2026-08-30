package Activity1;

class data {
	private String name = "Maron James Santos";
	private int Age = 20;
	private String Course = "Bachelor in Science Information Technology";
	private String Yearlvl = "2nd year";
	private String School = "University of Makati";
	private String Hobby1 = "Valorant";
	private String Hobby2 = "Basketball";
	private String Hobby3 = "Reading";
	private String FavLang = "Java";
	private String Reason = "Because I wanna create games";
	
	public String getName() {
		return name; 
	}
	public int getage() {
		return Age; 
	}
	public String getcourse() {
		return Course;
	}
	public String getyearlvl() {
		return Yearlvl;
	}
	public String getschool() {
		return School;
	}
	public String gethobby1() {
		return Hobby1;
	}
	public String gethobby2() {
		return Hobby2;
	}
	public String gethobby3() {
		return Hobby3;
	}
	public String getfavlang() {
		return FavLang;
	}
	public String getreason() {
		return Reason;
	}
}


public class Santos {
	public static void main(String [] args ) {
		data Mydata = new data();
		
		
		System.out.println("****************************************************************************************************");
		System.out.println("Name: " + Mydata.getName());
		System.out.println("Age: " + Mydata.getage());	
		System.out.println("Course & Year level: " + Mydata.getcourse() + "& " + Mydata.getyearlvl());
		System.out.println("School: " + Mydata.getschool());
		System.out.println("Hobbies: " + Mydata.gethobby1()+ ", " + Mydata.gethobby2() +" & "+ Mydata.gethobby3());
		System.out.println("Favourite Language: " + Mydata.getfavlang());
		System.out.println("What is your reason?; " + Mydata.getreason());
		System.out.println("****************************************************************************************************");
	}

}