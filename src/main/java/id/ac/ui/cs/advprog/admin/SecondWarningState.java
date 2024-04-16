package id.ac.ui.cs.advprog.admin;
//peringatan kedua
public class SecondWarningState implements CustomerState {
    public void addWarning(Customer customer) {
        customer.setState(new BlockedState());
    }

    public String warnMessage() {
        return "Anda sudah mendapatkan 2 peringatan, sekali lagi Anda mendapatkan peringatan maka akun Anda akan diblokir";
    }
}
