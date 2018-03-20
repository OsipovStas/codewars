import scala.annotation.tailrec
//A natural number is called k-prime if it has exactly k prime factors, counted with multiplicity.
//
//  A natural number is thus prime if and only if it is 1-prime.
//
//  Examples:
//  k = 2 -> 4, 6, 9, 10, 14, 15, 21, 22, …
//k = 3 -> 8, 12, 18, 20, 27, 28, 30, …
//k = 5 -> 32, 48, 72, 80, 108, 112, …
//
//#Task:
//
//  Write function count_Kprimes (or countKprimes or count-K-primes or kPrimes) which given parameters k, start, end (or nd) returns an array (or a list or a string depending on the language - see "Solution" and "Sample Tests") of the k-primes between start (inclusive) and end (inclusive).
//
//#Example:
//
//  countKprimes(5, 500, 600) --> [500, 520, 552, 567, 588, 592, 594]
//
//...............................................................................
//
//for all languages except Bash shell
//
//Given positive integers s and a, b, c where a is 1-prime, b 3-prime, c 7-prime find the number of solutions of a + b + c = s. Call this function puzzle(s).
//
//  Examples:
//
//  puzzle(138) --> 1 ([2 + 8 + 128] is solution)
//puzzle(143) --> 2 ([3 + 12 + 128, 7 + 8 + 128] are solutions)
//
//...............................................................................

object KPrimes {

  def nextFactor(n: Long, p: Int): Option[Int] = (2 to math.pow(n, 1.0 / p).round.toInt) find (x => n % x == 0)

  def isPrime(n: Long): Boolean = (2 to math.sqrt(n).toInt) forall (x => n % x != 0)

  def isKPrime(n: Long, k: Int): Boolean = k match {
    case 1 => isPrime(n)
    case _ =>
      nextFactor(n, k).fold(false)(x => isKPrime(n / x, k - 1))
  }

  def countKPrimes(k:  Int, start: Long, nd: Long): String = {
    (start to nd).filter(x => isKPrime(x, k)).mkString(", ")
  }

  def puzzle(s: Int): Int = {
    val solutions = for {
      p1 <- (2 to s).filter(isKPrime(_, 1))
      p3 <- (2 to s).filter(isKPrime(_, 3))
      p7 <- (2 to s).filter(isKPrime(_, 7))
      if p1 + p3 + p7 == s
    } yield (p1,p3,p7)
    solutions.length
  }
}