//Snail Sort
//
//Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.

object Snail {

  def snail(xs: List[List[Int]]): List[Int] = {
    def circle(pos: (Int, Int), o: (Int, Int), r: Int, acc: List[Int]): List[Int] = pos match {
      case (x, y) if x == 1 && y == 0 => xs(x)(y) :: acc
      case (0, y) if y < r => circle((0, y + 1), o, r, xs(0)(y) :: acc)
      case (x, y) if x < r && y == r => circle((x + 1, r), o, r, xs(x)(y) :: acc)
      case (x, y) if x == r && y > 0 => circle((r, y - 1), o, r, xs(x)(y) :: acc)
      case (x, 0) if x > 0 => circle((x + 1, 0), o, r, xs(x)(0) :: acc)
    }
    ???
  }

}