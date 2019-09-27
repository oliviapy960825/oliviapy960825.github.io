import java.io.*;
import com.tedneward.*;

public class Serialize
{
    public static void main(String[] args)
        throws Exception
    {
        Person ted = new Person("Ted", "Neward", 39);
        Person charl = new Person("Charlotte", "Neward", 38);
        ted.setSpouse(charl); charl.setSpouse(ted);
        
        System.out.println(ted);
        
        FileOutputStream fos = new FileOutputStream(args[0]);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ted);
        oos.close();
    }
}