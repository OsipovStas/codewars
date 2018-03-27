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
  val _1 = BigInt(1)
  val _2 = BigInt(2)

  def combination(n: Int, k: Int): BigInt = {
    @tailrec
    def helper(i: Int, cur: BigInt): BigInt = i match {
      case _ if i == k => cur
      case _ => helper(i + 1, (cur * (n - i)) / (i + _1))
    }
    helper(0, 1)
  }

  def combinations(n: Int, m: Int): List[BigInt] = {
    @tailrec
    def helper(i: Int, acc: List[BigInt]): List[BigInt] =  i match {
      case _ if i == 0 => (acc.head * (m - i - 1)) / (n - i) :: acc
      case _ => helper(i - 1, (acc.head * (m - i - 1)) / (n - i) :: acc)
    }
    helper(n - 1, _1 :: Nil)
  }

  def height(n: BigInteger, m: BigInteger): BigInteger = {
    ((n.intValue(), m.intValue()) match {
      case (1, j) =>
        BigInt(j)
      case (i, j) if i >= j =>
        _2.pow(j) - _1
      case (i, j) =>
        val cnk = combinations(i, j)
        val psi = cnk.slice(1, i).sum
        val ksi = cnk.zipWithIndex.drop(2).map(t => (_2.pow(t._2) - _2) * t._1).sum
        combination(j, i) + psi + ksi
    }).bigInteger
  }

}