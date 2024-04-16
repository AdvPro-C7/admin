package id.ac.ui.cs.advprog.admin;
//peringatan pertama
public class FirstWarningState implements CustomerState {
    public void addWarning(Customer customer) {
        customer.setState(new SecondWarningState());
    }

    public String warnMessage() {
        return null;
    }
}
