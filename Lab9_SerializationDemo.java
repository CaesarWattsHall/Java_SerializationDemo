package lab9_serializationdemo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Lab9_SerializationDemo implements Serializable{
 public static void main(String[] args) {
        serialize();
        deserialize();
        
    }
    
    public static char getInputFromA(){
       return letterA; 
    }
    
    public static char getInputFromB(){
        return letterB; 
    }
    
    public static char getInputFromC(){
        return letterC; 
    }
    
    public static char getInputFromD(){
        return letterD; 
    }
    
    static char letterA = 'A', letterB = 'B', letterC = 'C', letterD = 'D';
    
    public static void serialize(){
        try{
            Keyboard aKeyboard = new Keyboard();
            FileOutputStream fileOStream = new FileOutputStream("KeyboardKeys.ser");
            ObjectOutputStream objectStream = new ObjectOutputStream(fileOStream);
            objectStream.writeObject(aKeyboard);
            
            objectStream.close();
            fileOStream.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void deserialize(){
        try{
            FileInputStream inputStream = new FileInputStream("KeyboardKeys.ser");
            ObjectInputStream objectInput = new ObjectInputStream(inputStream);
            Keyboard myKeyboard = (Keyboard) objectInput.readObject();
            System.out.println("First key: " + myKeyboard.letterA);
            System.out.println("Second key: " + myKeyboard.letterB);
            System.out.println("Third key: " + myKeyboard.letterC);
            System.out.println("Fourth key: " + myKeyboard.letterD);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    private static class Keyboard {

        private String letterA;
        private String letterB;
        private String letterD;
        private String letterC;

        public Keyboard() {
        }
    }
    
}
