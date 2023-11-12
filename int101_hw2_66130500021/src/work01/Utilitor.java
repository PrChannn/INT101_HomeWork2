package work01;
import work02.Person;

public class Utilitor {
    public static String testString(String value) {
        if(value == null) throw new NullPointerException("Value cannot be null");
        if(value.isEmpty()) throw new IllegalArgumentException("Value is empty");
        return value;
    }
    
    public static double testPositive(double value) {
        if(value > 0) return value;
        throw new IllegalArgumentException();
    }
    
    public static int computeIsbn10(long isbn10) {
        int sum = 0;
        for (int i = 2; i <= 10; i++) {
           int digit = (int)isbn10 % 10;
           sum += (digit*i);
           isbn10/=10;
        }
        return (11 - (sum % 11)) % 11;
    }
    
    public static Person testPerson(Person owner) {
        if(owner == null) throw new NullPointerException();
        return owner;
    }
    
}
