//Snail Sort
//
//Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.
import scala.annotation.tailrec

object Snail {

  def snail(xs: List[List[Int]]): List[Int] = {
    @tailrec
    def helper(acc: Seq[Int], o: (Int, Int), r: Int): Seq[Int] = r match {
      case 0 => acc.reverse
      case 1 if xs(o._1).nonEmpty => helper(xs(o._1)(o._2) +: acc, o, 0)
      case 1 => acc.reverse
      case n => helper(circle(xs, r, o) ++ acc, (o._1 + 1, o._2 + 1), r - 2)
    }
    helper(Seq(), (0, 0), xs.length).toList
  }


  def circle(xs: Seq[Seq[Int]], radius: Int, origin: (Int, Int) = (0, 0)): Seq[Int] = {
    val top = xs(origin._1).slice(origin._2, origin._2 + radius).reverse
    val right = ((origin._1 + 1) until (origin._1 + radius - 1)).map(xs(_)(origin._2 + radius - 1)).reverse
    val bottom = xs(origin._1 + radius - 1).slice(origin._2, origin._2 + radius)
    val left = ((origin._1 + 1) until (origin._1 + radius - 1)).map(xs(_)(origin._2))
    left ++ bottom ++ right ++ top
  }
}