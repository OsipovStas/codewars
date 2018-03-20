import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest._
import org.scalatest.Assertions._

@RunWith(classOf[JUnitRunner])
class NPointCrossoverTest extends FlatSpec {

  import NPointCrossover.crossover

  it should "work when there is no cross-point index" in {
    assert( crossover(Nil, List(1,1,1,1,1), List(2,2,2,2,2)) === (List(1,1,1,1,1), List(2,2,2,2,2)) )
  }

  it should "work with 1 cross-point index" in {
    assert( crossover(List(1), List(1,1,1,1,1), List(2,2,2,2,2)) === (List(1,2,2,2,2),List(2,1,1,1,1)) )
  }

  it should "work with 1 repeated cross-point index" in {
    assert( crossover(List(1,1), List(1,1,1,1,1), List(2,2,2,2,2)) === (List(1,2,2,2,2),List(2,1,1,1,1)) )
  }

  it should "work for 2 cross-point indices" in {
    assert( crossover(List(1,3), List(1,1,1,1,1), List(2,2,2,2,2)) === (List(1,2,2,1,1),List(2,1,1,2,2)) )
  }

  it should "work for 3 cross-point indices" in {
    assert( crossover(List(1,3,5), List(1,1,1,1,1,1,1), List(2,2,2,2,2,2,2)) === (List(1,2,2,1,1,2,2), List(2,1,1,2,2,1,1)) )
  }

  it should "work for unordered cross-point indices" in {
    assert( crossover(List(3,5,1), List(1,1,1,1,1,1,1), List(2,2,2,2,2,2,2)) === (List(1,2,2,1,1,2,2), List(2,1,1,2,2,1,1)) )
  }
  it should "work for cross-point with zero index" in {
    assert( crossover(List(0,3), List(1,1,1,1,1,1,1), List(2,2,2,2,2,2,2)) === (List(2, 2, 2, 1, 1, 1, 1),List(1, 1, 1, 2, 2, 2, 2)) )
  }

}