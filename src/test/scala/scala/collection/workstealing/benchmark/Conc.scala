package scala.collection.workstealing
package benchmark






object ConcUtils {

  def create(sz: Int): Conc[Int] = sz match {
    case 0 => Conc.Nil
    case 1 => Conc.Single(1)
    case _ => create(sz / 2) || create(sz - sz / 2)
  }

}


object ConcSum extends StatisticsBenchmark {

  val size = sys.props("size").toInt
  val conc = ConcUtils.create(size)

  def run() {
    conc.fold(0)(_ + _)
  }

}


object ConcSumGeneric extends StatisticsBenchmark {

  val size = sys.props("size").toInt
  val conc: ParIterable[Int] = ConcUtils.create(size)

  def run() {
    conc.fold(0)(_ + _)
  }

}


object ListSum extends StatisticsBenchmark {

  val size = sys.props("size").toInt
  val list = (0 until size).toList

  def run() {
    list.fold(0)(_ + _)
  }

}

