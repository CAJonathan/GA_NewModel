package DataGeneration.Utils

import vegas._
import vegas.render.WindowRenderer._

class Draw {

  def drawGraph(): Unit = {
    val plot = Vegas("Country Pop").
      withData(
        Seq(
          Map("country" -> "USA", "population" -> 314),
          Map("country" -> "UK", "population" -> 64),
          Map("country" -> "DK", "population" -> 80)
        )
      ).
      encodeX("country", Nom).
      encodeY("population", Quant).
      mark(Bar)

    plot.show
  }
}
