import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Accountnumbergenerator {

    private static List<Integer> usedAccountNumbers = new ArrayList<>();
    private static Random random = new Random();

    public Accountnumbergenerator() {
    }

    public static int generateAccountNumber() {
        int accountNumber;
        do {
            accountNumber = random.nextInt(9000) + 1000;
        } while (usedAccountNumbers.contains(accountNumber));
        usedAccountNumbers.add(accountNumber);
        return accountNumber;
    }
    double random2 = Math.floor(Math.random() * 10000);
    int accountNumber = ((Random) random).nextInt();

}
