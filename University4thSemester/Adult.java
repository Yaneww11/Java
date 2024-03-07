package adult_and_child;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Adult {
    private final String id;
    private String name;
    private LocalDate dateOfBirth;
    private BigDecimal savings;
    private boolean isOwner;
    private BigDecimal creditAmount;

    public Adult(String name, LocalDate dateOfBirth, BigDecimal savings,
                 BigDecimal creditAmount, boolean isOwner) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.savings = savings;
        this.creditAmount = creditAmount;
        this.isOwner = isOwner;
        this.id = this.name + this.dateOfBirth + 15 + 20;
    }

    public Adult(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.savings = BigDecimal.ZERO;
        this.creditAmount = BigDecimal.ZERO;
        this.isOwner = false;
        this.id = this.name + this.dateOfBirth + 15 + 20;
    }

    public BigDecimal buyouse(BigDecimal price, BigDecimal percentage){
        if (this.savings.compareTo(price) < 0){
            this.creditAmount = price.subtract(price.multiply(percentage));
        }
        else {
            this.savings = this.savings.subtract(price);
        }
        return price.multiply(percentage);
    }


    @Override
    public String toString() {
        return "Adult{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", savings=" + savings +
                ", isOwner=" + isOwner +
                ", creditAmount=" + creditAmount +
                '}';
    }
}
