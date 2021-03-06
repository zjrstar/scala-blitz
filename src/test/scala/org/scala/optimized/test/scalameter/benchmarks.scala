package org.scala.optimized.test
package scalameter


import org.scalameter.api._
import org.scalameter.PerformanceTest.OnlineRegressionReport
import org.scala.optimized.test.par.scalameter._
import org.scalameter.reporting.RegressionReporter.Tester


class benchmarks extends OnlineRegressionReport with Serializable {

  override def tester: Tester = new Tester.Accepter

  /* tests */
  include[OptimizedListBench]
  include[ConcBench]
  include[ConcMemory]
  include[ParRangeBench]
  include[ParConcBench]
  include[ParArrayBench]
  include[ParHashMapBench]
  include[ReducibleBench]
  include[ParHashTrieSetBench]
}





