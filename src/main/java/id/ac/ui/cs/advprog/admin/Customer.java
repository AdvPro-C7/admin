package id.ac.ui.cs.advprog.admin;

public class Customer {
    private CustomerState state = new NormalState();

    public void setState(CustomerState state) {
        this.state = state;
    }

    public CustomerState getState() {
        return this.state;
    }

    public void addWarning() {
        state.addWarning(this);
    }

    public String getWarningMessage() {
        return state.warnMessage();
    }
}

