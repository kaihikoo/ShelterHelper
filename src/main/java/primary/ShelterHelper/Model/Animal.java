package primary.ShelterHelper.Model;


import java.time.LocalDate;
import java.util.Date;


public  class  Animal {
    private String name;
    private int idBox;
    private String sex;
    private String chip;
    private int age;
    private String color;
    private String bread;
    private LocalDate date;


    public Animal()
    {
        this.name= "";
        this.age=0;
        this.idBox=0;
        this.chip="";
        this.color="";
        this.bread="";
        this.date= LocalDate.ofEpochDay(2020-01-01);
    }
    public Animal(String name, int idBox, String sex, String chip, int age, String color, String bread, LocalDate date) {
        this.name = name;
        this.idBox = idBox;
        this.sex = sex;
        this.chip = chip;
        this.age = age;
        this.color = color;
        this.bread = bread;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdBox() {
        return idBox;
    }

    public void setIdBox(int idBox) {
        this.idBox = idBox;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
