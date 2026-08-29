package Activity1;

class Info {
    private String name = "Al-Jumong M. Ramos";
    private int age = 19;
    private String course = "BSIT - DATA STRUCTURE";
    private int yrlvl = 2;
    private String school = "University of Makati";
    private String hobbies = "Playing online games, video editing, and reading.";
    private String favorite = "JAVA & PHP";
    private String reason = "The reason why I wanted to learn Java is to learn and improve the language \ni've already been studying and to take it up to the next level";

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }
    public int getYearLevel() { return yrlvl; }
    public String getSchool() { return school; }
    public String getHobbies() { return hobbies; }
    public String getFavorite() { return favorite; }
    public String getReason() { return reason; }
}

public class Ramos {
    public static void main(String[] args) {
        Info info = new Info();

        System.out.println("-----------------------------");
        System.out.println("Name: " + info.getName());
        System.out.println("Age: " + info.getAge());
        System.out.println("Course: " + info.getCourse() + " (" + info.getYearLevel() + "nd Year)");
        System.out.println("School: " + info.getSchool());
        System.out.println("Hobbies: " + info.getHobbies());
        System.out.println("Favorite Language: " + info.getFavorite());
        System.out.println("Reason: " + info.getReason());
        System.out.println("-----------------------------");

    }
}