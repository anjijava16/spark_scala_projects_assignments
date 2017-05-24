package assignment_module_3

/**
  * Created by Mukut on 5/21/2017.
  */

trait flyable{
  def fly():String;
}

trait superPower{
  def superPower():String;

  def attack()="Super Hero is Attacking";
}

class SuperHero(name: String) extends flyable with superPower{

  def fly() = s"$name is flying";

  def superPower() = s"$name has superpowers"
}
object Main {
  def main(args: Array[String]): Unit = {
    var superHero = new SuperHero("Superman");
    println(superHero.fly());
    println(superHero.superPower());
    println(superHero.attack());


  }
}
