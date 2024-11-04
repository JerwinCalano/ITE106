public class Dog
{
  String name;
  String breed;
  int age;
  String color;

public class Dog(String name, String breed, int color, String color) {
  this.name = name;
  this.breed = breed;
  this.age = age;
  this. color = color;
}

public String getname(){
  return name;
}

public String getbreed(){
  return breed;
}

public int getage(){
  return age;
}

public String getcolor{
  return color;
}
@Override
public Syring toString() {
  return("HI my name is " + this.getname() + "\n My breed, age, color are " + this.getBreed() + ", " + this.getAge() + this.getColor());

  public static void main(String[] args) {
    Dog tuffy = new Dog("Tuffy", "Papillon", 5", "White");
    System.out.println(tuffy.toString());
  }
}
