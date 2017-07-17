package main

object Main {
   var phys=0
   var chem=0
   var maths=0
   var total=0
   var percentage:Double=0.0
  def main(args: Array[String]){
     phys = 88
     chem =  10
    maths = 50
    getPercentage()
  }
  def getPercentage(){
    total=phys+chem+maths
    percentage=(total.toDouble/450)*100
    println("Percentage = "+percentage)
    if(percentage>=60){
       print("Pass")
           }else{
             println("Fail")
           }
}
}