import KPrimesTest._
import org.junit.Assert._
import org.junit.Test

object KPrimesTest {

  private def testing(act: String, exp: String): Unit = {
    assertEquals(exp, act)
  }

}

class KPrimesTest {

  @Test
  def test1(): Unit = {
    println("Basic Tests")
    testing(KPrimes.countKPrimes(2, 0, 10),
      "4, 6, 9, 10")
    testing(KPrimes.countKPrimes(2, 0, 100),
      "4, 6, 9, 10, 14, 15, 21, 22, 25, 26, 33, 34, 35, 38, 39, 46, 49, 51, 55, 57, 58, 62, 65, 69, 74, 77, 82, 85, 86, 87, 91, 93, 94, 95")
    testing(KPrimes.countKPrimes(12, 100000, 100100), "")
    testing(KPrimes.countKPrimes(1, 2, 30), "2, 3, 5, 7, 11, 13, 17, 19, 23, 29")
    testing(KPrimes.countKPrimes(8, 10000000, 10000200), "10000096, 10000152, 10000165, 10000200")


  }

}
