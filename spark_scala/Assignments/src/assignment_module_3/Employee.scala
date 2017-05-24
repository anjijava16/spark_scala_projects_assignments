package assignment_module_3

/**
  * Created by Mukut on 5/18/2017.
  */
class Employee () {

  var curSal : Double = 0;

  //auxiliary constructor
  def this(sal: Double){
    this();
    curSal=sal;
  }

  def increment(): Unit ={
    curSal=curSal+50000;
  }

  def currentSal:Double = {
    curSal;
  }

}

object Driver{

  def main(args: Array[String]): Unit = {
    val employee = new Employee(500000);
    println("Current Salary: "+employee.currentSal);

    employee.increment();
    println("Incremented Salary: "+employee.currentSal);

  }
}
