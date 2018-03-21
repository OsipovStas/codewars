class Bagel {
  final def getValue = 3
}

object BagelSolver {

  class FakedBagel {
    def getValue = 4
  }

  def getBagel: FakedBagel = {
    new FakedBagel
  }
}