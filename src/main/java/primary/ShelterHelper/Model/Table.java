package primary.ShelterHelper.Model;

public class Table {

    String id, name, chip,age, id_box,sex,bread,color,dateArrival;

    public Table(String id, String name, String chip, String age, String id_box, String sex, String bread, String color, String dateArrival) {
        this.id = id;
        this.name = name;
        this.chip = chip;
        this.age = age;
        this.id_box = id_box;
        this.sex = sex;
        this.bread = bread;
        this.color = color;
        this.dateArrival = dateArrival;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId_box() {
        return id_box;
    }

    public void setId_box(String id_box) {
        this.id_box = id_box;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(String dateArrival) {
        this.dateArrival = dateArrival;
    }
}
