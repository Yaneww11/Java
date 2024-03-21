package shop;

public abstract class RegisterProvider implements Provider{
    private String regNumber;

    public RegisterProvider(String regNumber) {
        this.regNumber = regNumber;
    }

    public String toString() {
        return "RegisterProvider{" +
                "regNumber='" + regNumber + '\'' +
                '}';
    }
}
