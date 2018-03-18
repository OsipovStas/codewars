import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest._
import scala.util.Random
import DuplicateEncoder._

@RunWith(classOf[JUnitRunner])
class duplicateEncodeSuite extends FunSpec {

  val basicExamples = Seq(
    ("din", "((("),
    ("recede", "()()()"),
    ("Success", ")())())"),
    ("(( @", "))((")
  )

  basicExamples.foreach { case (decoded, encoded) =>
    it(s"should return $encoded for input $decoded") {
      assert(duplicateEncode(decoded) == encoded)
    }
  }
}