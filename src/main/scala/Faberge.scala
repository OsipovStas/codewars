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

import java.math.BigInteger
import scala.annotation.tailrec

object Faberge {
  def height(n: BigInteger, m: BigInteger): BigInteger = {
    val nn = n.intValue()
    val mm = m.intValue()
    val _1 = BigInt(1)
    val _2 = BigInt(2)

    @tailrec
    def helper(calculations: List[(Int, Int)], values: Map[(Int, Int), BigInt]): Map[(Int, Int), BigInt] = calculations match {
      case Nil =>
        values
      case (i, j) :: xs if values.contains((i, j)) =>
        helper(xs, values)
      case (1, j) :: xs =>
        helper(xs, values + ((1, j) -> j))
      case (i, j) :: xs if i >= j =>
        helper(xs, values + ((i, j) -> (_2.pow(j) - _1)))
      case (i, j) :: _ if !values.contains((i - 1, j - 1)) || !values.contains((i, j - 1)) =>
        helper((i - 1, j - 1) :: (i, j - 1) :: calculations, values)
      case (i, j) :: xs =>
        helper(xs, values + ((i,j) -> (values((i - 1, j - 1)) + values((i, j - 1)) + _1)))
    }

    helper((nn, mm) :: Nil, Map())(nn, mm).bigInteger
  }
}