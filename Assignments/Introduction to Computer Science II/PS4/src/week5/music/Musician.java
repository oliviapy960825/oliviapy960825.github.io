package week5.music;

public class Musician {
    protected String name;
    
    public Musician(String name) {
        this.name = name;
    }
    
    public void play() {
        System.out.println(name + " plays silence");
    }
    
    public void compete() {
        System.out.println(this.name + " walks out onto the stage.");
        play();
        System.out.println(this.name + " listens to the critique and smiles.");
    }
    
    public static void main(String[] args) {

        Musician[] arrayOfMusicians = new Musician[]{
                new Guitarist("Kirk", 15),
                new Bagpipist(),
                new Vocalist("Scooby Doo"),
                new Drummer()};
        
        for (Musician m : arrayOfMusicians) {
            m.compete();
        }
    }
}
