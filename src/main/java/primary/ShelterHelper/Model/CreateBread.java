package primary.ShelterHelper.Model;

import com.github.javafaker.Faker;

import java.util.ArrayList;

public class CreateBread {
  private  ArrayList<String> Breads=createBreadDog();

  public ArrayList<String> createBreadDog(){
    ArrayList<String> bread=new ArrayList<>();
    Faker faker=new Faker();
    for (int i=0;i<80;i++) {
      bread.add(faker.dog().breed());
    }

    return bread;
  }
  private  ArrayList<String> BreadsCat=createBreadCat();

  public ArrayList<String> createBreadCat(){
    ArrayList<String> bread=new ArrayList<>();
    Faker faker=new Faker();
    for (int i=0;i<80;i++) {
      bread.add(faker.cat().breed());
    }
    return bread;
  }

}
