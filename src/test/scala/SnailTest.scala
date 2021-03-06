import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest._
import org.scalatest.Assertions._

@RunWith(classOf[JUnitRunner])
class SnailTest extends FlatSpec {

  import Snail._

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

  "Empty example" should "work" in {
    val input = List(List())
    val res = List()
    assert(snail(input) == res)
  }

  "Circle " should " work with r = 3" in {
    val input = List(
      List(1, 2, 3),
      List(4, 5, 6),
      List(7, 8, 9))
    val res = List(1, 2, 3, 6, 9, 8, 7, 4).reverse
    assert(circle(input, 3) == res)
  }

  "Circle " should " work with r = 2" in {
    val input = List(
      List(1, 2, 3),
      List(4, 5, 6),
      List(7, 8, 9))
    val res = List(4,5,2,1)
    assert(circle(input, 2) == res)
  }

  "Circle " should " work with offset" in {
    val input = List(
      List(1, 2, 3),
      List(4, 5, 6),
      List(7, 8, 9))
    val res = List(8, 9, 6, 5)
    assert(circle(input, 2, (1, 1)) == res)
  }

}