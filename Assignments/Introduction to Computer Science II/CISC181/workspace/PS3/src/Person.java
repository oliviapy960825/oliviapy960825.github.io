

public class Person {
    private String realName;
    
    public Person(String realName) {
        this.realName = realName;
    }
    
    public String getRealName() {
        return realName;
    }
    
    public boolean isAfraidOf(String thing) {
        return true;
    }
    
    public String toString() {
        return getRealName();
    }
}
