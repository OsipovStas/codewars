import java.math.BigInteger
import java.util.Random
import java.math.BigInteger.ZERO
import java.math.BigInteger.valueOf
import org.junit.Assert._


object FabergeTest {

  private def test(a: Int, b: Int, shouldBe: Int): Unit = {
    assertEquals(valueOf(shouldBe), Faberge.height(valueOf(a), valueOf(b)))
  }

  private def test(a: String, b: String, shouldBe: String): Unit = {
    assertEquals(new BigInteger(shouldBe), Faberge.height(new BigInteger(a), new BigInteger(b)))
  }
}

class FabergeTest {
  @org.junit.Test
  def basicTests(): Unit = {
    FabergeTest.test(1, 51, 51)
    FabergeTest.test(2, 1, 1)
    FabergeTest.test(4, 17, 3213)
    FabergeTest.test(16, 19, 524096)
    FabergeTest.test(23, 19, 524287)
  }

  @org.junit.Test
  def advancedTests(): Unit = {
    FabergeTest.test("13", "550", "60113767426276772744951355")
    FabergeTest.test("271", "550", "1410385042520538326622498273346382708200418583791594039531058458108130216985983794998105636900856496701928202738750818606797013840207721579523618137220278767326000095")
    FabergeTest.test("531", "550", "3685510180489786476798393145496356338786055879312930105836138965083617346086082863365358130056307390177215209990980317284932211552658342317904346433026688858140133147")
  }

}