import scala.annotation.tailrec

object Base91 {

  private val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%&()*+,./:;<=>?@[]^_`{|}~\"".toCharArray
  private val revertedAlphabet = alphabet.zipWithIndex.toMap
  private val _8 = 8
  private val _13 = 13
  private val _91 = 91
  private val ZERO = (0, 0)

  def encode(data: String): String = {
    @tailrec
    def helper(xxs: List[(Int, Int)], yys: List[(Int, Int)]): List[(Int, Int)] = (xxs, yys) match {
      case (xs, Nil) => helper(xs, ZERO :: Nil)
      case (Nil, ys) => ys
      case (xs, lst@((13, _) :: _)) => helper(xs, ZERO :: lst)
      case ((0, _) :: xs, ys) => helper(xs, ys)
      case ((i, x) :: xs, (j, y) :: ys) =>
        val h = scala.math.min(i, _13 - j)
        helper((i - h, x >> h) :: xs, (j + h, y + (iBytes(x, h) << j)) :: ys)
    }

    val sourceData = data.toCharArray.map(c => (_8, c.toInt)).toList
    helper(sourceData, Nil).reverse.flatMap {
      case (n, i) if n < _13 && i / _91 == 0 => Seq(alphabet(i % _91))
      case (_, i) => Seq(alphabet(i % _91), alphabet(i / _91))
    }.mkString
  }

  def decode(data: String): String = {
    @tailrec
    def helper(xxs: List[(Int, Int)], yys: List[(Int, Int)]): List[(Int, Int)] = (xxs, yys) match {
      case (xs, Nil) => helper(xs, ZERO :: Nil)
      case (Nil, ys) => ys
      case (xs, lst@((8, _) :: _)) => helper(xs, ZERO :: lst)
      case ((0, _) :: xs, ys) => helper(xs, ys)
      case ((i, x) :: xs, (j, y) :: ys) =>
        val h = scala.math.min(i, _8 - j)
        helper((i - h, x >> h) :: xs, (j + h, y + (iBytes(x, h) << j)) :: ys)
    }

    val encodedData = data.toCharArray.grouped(2).map {
      case Array(b, a) => (_13, _91 * base2int(a) + base2int(b))
      case Array(b) => (_13, base2int(b))
    }.toList
    helper(encodedData, Nil).reverse.filter(_._2 != 0).map(_._2.toChar).mkString
  }

  @inline
  def iBytes(n: Int, i: Int): Int = n & ((1 << i) - 1)

  @inline
  def base2int(c: Char) = revertedAlphabet(c)

}