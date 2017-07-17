package main

object Constructoring {
  def main(args: Array[String]){
    var mike = new Maths(3,8)
    mike.add()
    mike.sub()
    mike.mul()
    mike.div()
    Maths.sayThings()
  }
}
object Maths{
  def sayThings(){
    println("Hello")
  }
}
class Maths(x:Int,y:Int){
  var a:Int=x
  var b:Int=y
  
  def add(){
    println(a+b) 
  }
  def sub(){
    println(a-b)
  }
  def mul(){
    println(a*b)
  }
  def div(){
    println(a/b)
  }
  
}