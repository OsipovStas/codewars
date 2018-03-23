import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest._
import org.scalatest.Assertions._

@RunWith(classOf[JUnitRunner])
class SnailTest extends FlatSpec {

  import Snail.snail

  "First example" should "work" in {
    val input = List(
      List(1, 2, 3),
      List(4, 5, 6),
      List(7, 8, 9))
    val res = List(1, 2, 3, 6, 9, 8, 7, 4, 5)
    assert(snail(input) == res)
  }

  "Second example" should "work" in {
    val input = List(
      List(1, 2, 3),
      List(8, 9, 4),
      List(7, 6, 5))
    val res = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    assert(snail(input) == res)
  }
}