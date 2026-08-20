package Activity1;

class Info {
    private String name = "Al-Jumong M. Ramos";
    private int age = 19;
    private String course = "Bachelor of Science in Information Technology";
    private int yrlvl = 2;
    private String school = "University of Makati";
    private String hobbies = "Playing online games, reading, and working out";
    private String favorite = "I don't have a favorite programming language but I usually use Java for school works and personal projects.";
    private String reason = "The reason why I wanted to learn Java is to learn new things and improve the language we've already been studying and to take it up to the next level";

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
        System.out.println("Course: " + info.getCourse());
        System.out.println("Year Level: " + info.getYearLevel());
        System.out.println("School: " + info.getSchool());
        System.out.println("Hobbies: " + info.getHobbies());
        System.out.println("Favorite Language: " + info.getFavorite());
        System.out.println("Reason: " + info.getReason());
        System.out.println("-----------------------------");

    }
}