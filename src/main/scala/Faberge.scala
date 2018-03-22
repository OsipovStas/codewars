import java.math.BigInteger
import java.math.BigInteger.ZERO
import java.math.BigInteger.valueOf

import scala.annotation.tailrec

//One man (lets call him Eulampy) has a collection of some almost identical Fabergè eggs. One day his friend Tempter said to him:
//
//  Do you see that skyscraper? And can you tell me a maximal floor that if you drop your egg from will not crack it?
//  No, - said Eulampy.
//But if you give me N eggs, - says Tempter - I'l tell you an answer.
//  Deal - said Eulampy. But I have one requirement before we start this: if I will see more than M falls of egg, my heart will be crushed instead of egg. So you have only M trys to throw eggs. Would you tell me an exact floor with this limitation?
//
//Task
//
//Your task is to help Tempter - write a function
//
//height :: Integer -> Integer -> Integer
//height n m = -- see text
//
//that takes 2 arguments - the number of eggs n and the number of trys m - you should calculate maximum scyscrapper height (in floors), in which it is guaranteed to find an exactly maximal floor from which that an egg won't crack it.
//
//  Which means,
//
//You can throw an egg from a specific floor every try
//  Every egg has the same, certain durability - if they're thrown from a certain floor or below, they won't crack. Otherwise they crack
//You have n eggs and m tries
//What is the maxmimum height, such that you can always determine which floor the target floor is when the target floor can be any floor between 1 to this maximum height?
//
//Examples
//
//height 0 14 = 0
//height 2 0  = 0
//height 2 14 = 105
//height 7 20 = 137979
//
//Data range
//
//n <= 20000
//m <= 20000




object Faberge {
  def height(n: BigInteger, m: BigInteger): BigInteger = {
    val nn = n.intValue()
    val mm = m.intValue()
    val ZERO = BigInt(0)
    val ONE = BigInt(1)
    val matrix = Array.fill[BigInt](nn + 1, mm + 1)(ZERO)

    @tailrec
    def helper(a: Int, b: Int): BigInt = (a, b) match {
      case (x, y) if x == nn && y == mm =>
        matrix(nn)(mm - 1) + matrix(nn - 1)(mm - 1) + 1
      case (x, y) if y < mm =>
        matrix(x)(y) = matrix(x)(y - 1) + matrix(x - 1)(y - 1) + ONE
        helper(x, y + 1)
      case (x, y) if x < nn =>
        matrix(x)(y) = matrix(x)(y - 1) + matrix(x - 1)(y - 1) + ONE
        helper(x + 1, 1)
    }

    helper(1, 1).bigInteger
  }
}