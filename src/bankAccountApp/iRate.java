package bankAccountApp;

// Interest Rate
public interface iRate {

    // Write a method that returns the base rate
    default double getBaseRate(){
        return 2.5;
    }

}
