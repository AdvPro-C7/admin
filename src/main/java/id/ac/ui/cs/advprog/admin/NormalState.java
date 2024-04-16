package id.ac.ui.cs.advprog.admin;

public class NormalState implements CustomerState {
    public void addWarning(Customer customer) {
        customer.setState(new FirstWarningState());
    }

    public String warnMessage() {
        return null;
    }
}

