import org.junit.Assert._
import org.junit.Test

class StepInPrimesTest {

  @Test
  def test(): Unit = {
    println("Fixed Tests")
    assertEquals("(101,103)", StepInPrimes.step(2, 100, 110))

    assertEquals("(30109,30113)", StepInPrimes.step(4, 30000, 100000))

    assertEquals("", StepInPrimes.step(11, 30000, 100000))
  }

}
