package primary.ShelterHelper.Model;


import java.time.LocalDate;
import java.util.Date;


public abstract class  Animal {
    private String name;
    private String idBox;
    public enum Sex {MALE, FEMALE};
    private Sex sex;
    private String chip;
    private int age;
    private LocalDate date;
}
