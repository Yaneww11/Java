package adult_and_child;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Child {
    private  String name;
    private LocalDate dateOfBirth;
    private Adult adult;

    public Child(String name, LocalDate dateOfBirth, Adult adult) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.adult = adult;
    }

    public Adult grownChild(){
        if (ChronoUnit.YEARS.between(this.dateOfBirth, LocalDate.now()) >= 18){
            return new Adult(this.name, this.dateOfBirth);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", adult=" + adult +
                '}';
    }
}

