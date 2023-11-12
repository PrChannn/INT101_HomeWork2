package work03;
import java.util.Objects;
import work01.Utilitor;
import work02.Person;

public class Account {
    private static long nextNo = 100000000;
    private final long no;
    private Person owner;
    private double balance;
    
    public Account(Person owner) {
        this.owner = Utilitor.testPerson(owner);
        int result = Utilitor.computeIsbn10(nextNo);
        while(result == 10) {
            nextNo++;
            result = Utilitor.computeIsbn10(nextNo);
        }
        
        this.no = 10 * nextNo + result;
        nextNo++;
        
        this.balance = 0.0;
    }

    public long getNo() {
        return no;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }
    
    public double deposit(double amount) {
        return this.balance += Utilitor.testPositive(amount);                
    }
    
    public double withdraw(double amount) {
        double newBalance = this.balance - Utilitor.testPositive(amount);
        this.balance = Utilitor.testPositive(newBalance);
        return balance;
    }
    
    public void transfer(double amount, Account account) {
        if(account == null || balance < withdraw(amount)) throw new IllegalArgumentException();
        this.balance -= withdraw(amount);
        account.deposit(amount);
    }

    @Override
    public String toString() {
        return "Account(" + no + ", " + balance + ')';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (this.no != other.no) {
            return false;
        }
        if (Double.doubleToLongBits(this.balance) != Double.doubleToLongBits(other.balance)) {
            return false;
        }
        return Objects.equals(this.owner, other.owner);
    }

    
    
}
