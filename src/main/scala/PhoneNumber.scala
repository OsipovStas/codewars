//Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the form of a phone number.
//Example:
//
//  Kata.createPhoneNumber(Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)) # => returns "(123) 456-7890"
//
//The returned format must be correct in order to complete this challenge.
//Don't forget the space after the closing parentheses!


object PhoneNumber {

  def createPhoneNumber(numbers: Seq[Int]): String = {
    def str(xs: Seq[Int]): String = xs.mkString("")
    String.format("(%s) %s-%s", str(numbers.take(3)), str(numbers.slice(3, 6)), str(numbers.takeRight(4)))
  }

}