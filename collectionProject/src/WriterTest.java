public class WriterTest {
    public static void main(String[] args) {
        // Create an instance of SavingsAccount
        SavingsAccount savingsObj = new SavingsAccount(1000);

        // Choose the writing style (Ads or Movies)
        String choice = "Ads"; // Change this to "Movies" for movie script

        Writer writer = WritingAgency.getWriter(choice);
        Writing writing = writer.writeContent(savingsObj);
        writing.displayContent();
    }
}

class WritingAgency {
    public static Writer getWriter(String preference) {
        Writer writer = null;
        if (preference.equalsIgnoreCase("Ads")) {
            writer = new AdWriter();
        } else if (preference.equalsIgnoreCase("Movies")) {
            writer = new MovieWriter();
        }
        return writer;
    }
}

interface Account {
    void withdraw(float amount);
    void deposit(float amount);
}

class SavingsAccount implements Account {
    int balance;

    public SavingsAccount(int balance) {
        super();
        this.balance = balance;
    }

    public void withdraw(float amount) {
        System.out.println("Withdrawing..." + amount);
    }

    public void deposit(float amount) {
        System.out.println("Depositing...." + amount);
    }
}

interface Writer {
    Writing writeContent(Account acc);
}

class AdWriter implements Writer {
    public Writing writeContent(Account accRef) {
        System.out.println("Crafting a persuasive advertising content....");
        Writing writing = new AdContent();
        accRef.deposit(5000);
        return writing;
    }
}

class MovieWriter implements Writer {
    public Writing writeContent(Account accRef) {
        System.out.println("Creating an exciting movie script....");
        Writing writing = new MovieScript();
        accRef.deposit(6000);
        return writing;
    }
}

interface Writing {
    void displayContent();
}

class AdContent implements Writing {
    public void displayContent() {
        System.out.println("Displaying the persuasive advertising content....");
    }
}

class MovieScript implements Writing {
    public void displayContent() {
        System.out.println("Revealing the thrilling movie script....");
    }
}
