package main
/* Small program to convert a number given in digits to the same number in words. Will work for any whole number
 * between 1 and 99 Million */
object NumbertoWords {
/*Initialise 'global' variables that hold the translations*/
var unitList:Array[String] = Array("","One","Two","Three","Four","Five","Six","Seven","Eight","Nine")
var teensList = Array("Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen") 
var tensList = Array("Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety") 

def main(args: Array[String]){
  /*number represents the current number to convert
   * The length of this number is passed into a match statement to determine
   * which function will handle the number
   */
  var number:Int=66666666
    number.toString().length()  match {
  case 1  => println(unit(number))
  case 2  => println(tens(number))
  case 3  => println(hundreds(number))
  case 4  => println(thousands(number))
  case 5  => println(thousands(number))
  case 6 => println(thousands(number))
  case 7 => println(millions(number))
  case 8 => println(millions(number))
  }
   
  }
/*Millions deals with 7 and 8 digit numbers
 * after doing its processing, millions passes the rest of the numbers to thousands()
 * Answer is a string that is steadily filled up and passed back as returns from the methods 
 * before finally being printed
 */
def millions(a:Int):String={
   var answer = ""
  if(a.toString().length().toInt>7){
    
    answer= tens(a.toString().substring(0, 2).toInt) + " Million "
    answer+= thousands(a.toString().substring(2,8).toInt)
  }else{
  answer= unitList(a.toString().substring(0,1).toInt)+" Million "
    
    answer+= thousands(a.toString().substring(1,7).toInt)
  }   
        return answer
}
/*
 * Thousands deals with numbers between 3 and 6 digits long.
 * After doing its section, thousands passes the other digits to hundreds()
 * If less than 3 digits is recieved(number like 0040 becomes 4 etc), the number is instead sent down the line.
 */
  def thousands(a:Int):String={
    var answer=""
    if(a.toString().length()<4){
      answer=hundreds(a)
    }else{
      
    
    if(a.toString().length()>4){
      if(a.toString().length()>5){
        answer=hundreds(a.toString().substring(0,3).toInt)+ " Thousand "
        answer+=hundreds(a.toString().substring(3,6).toInt)
      }else{
      answer= tens(a.toString().substring(0, 2).toInt)+" Thousand "
      answer+=hundreds(a.toString().substring(2,5).toInt)
      }
      
    }else{
    answer= unitList(a.toString().substring(0,1).toInt)+" Thousand "
    
    answer+=hundreds(a.toString().substring(1,4).toInt)
    }
    }
    return answer
  }
  
  /*
   * hundreds deals with 3 digit numbers.
   * After getting the hundreds digit, the last two digits are passed to tens()
   * 
   * If less than 3 digits is recieved(number like 004 becomes 4 etc), the number is instead sent down the line.
   */
  def hundreds(a:Int):String={
    if(a.toString().length()<3){
      return("and " + tens(a))
    }else{
    var answer= unitList(a.toString().substring(0,1).toInt)+" Hundred"
    if(a.toString().substring(1,3).toInt >0){
      answer+=" and "
      answer+=tens(a.toString().substring(1,3).toInt)
    }
    return answer
    }
  }
  /*
   * Tens deals with two digit numbers
   * First checks to see if the number is a teen or not(begins with 1)
   * Looks up the appropriate words, then if necessary, appends the result from unit()
   */
  def tens(a:Int):String = {
   if(a.toString().length()<2){
     return(unit(a))
   }else{
    if(a.toString().substring(0, 1).toInt == 1){
      return teens(a)
    }else{
      var output:String = tensList(a.toString().substring(0, 1).toInt-2)
      var unit:String = unitList(a.toString().substring(1,2).toInt)
     output = (output + " ".toString() + unit).toString()
      return output
    }
   }
  }
 /*
  * teens works out the teen word using the rightmost digit
  */
  def teens(a:Int):String = {
    return teensList((a.toString().substring(1, 2)).toInt)
  }
  /*
   * Unit returns the word that belongs to a single digit number
   */
  def unit(a:Int):String = {
    return unitList(a)
   
  }
}