package week5.music;

public class Guitarist extends Musician {
    private int yearsOfExperience;
    
    public Guitarist(String name, int yearsOfExperience) {
        super(name);
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    public String toString() {
        return name + ":" + yearsOfExperience + " years";
    }
}
