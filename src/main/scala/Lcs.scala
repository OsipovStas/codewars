import scala.annotation.tailrec

object Lcs {
  case class Part(length: Int, string: String)

  def lcs(a: String, b: String): String = {
    val n = a.length
    val m = b.length
    val values = Array.ofDim[Part](n + 1, m + 1)

    @inline
    def update(i: Int, j: Int, v: Part): Unit = {
      values(i)(j) = v
    }

    @inline
    def isCalculated(i: Int, j: Int) = values(i)(j) != null

    @tailrec
    def run(calculations: List[(Int, Int)]): Unit = calculations match {
      case Nil => ()
      case (i, j) :: xs if isCalculated(i, j) =>
        run(xs)
      case (i, j) :: xs if i == 0 || j == 0 =>
        update(i, j, Part(0, ""))
        run(xs)
      case (i, j) :: xs if a.charAt(i - 1) == b.charAt(j - 1) && !isCalculated(i - 1, j - 1) =>
        run((i - 1, j - 1) :: calculations)
      case (i, j) :: xs if a.charAt(i - 1) == b.charAt(j - 1) && isCalculated(i - 1, j - 1) =>
        val Part(pl, ps) = values(i - 1)(j - 1)
        update(i, j, Part(pl + 1, ps + a.charAt(i - 1)))
        run(xs)
      case (i, j) :: xs if !isCalculated(i - 1, j) || !isCalculated(i, j - 1) =>
        run((i - 1, j) :: (i, j - 1) :: calculations)
      case (i, j) :: xs =>
        val left = values(i - 1)(j)
        val right = values(i)(j - 1)
        update(i, j, if (left.length > right.length) left else right)
        run(xs)
    }

    run((n,m) :: Nil)
    val Part(_, seq) = values(n)(m)
    seq
  }
}