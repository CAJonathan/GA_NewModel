package Abstract

import org.jfree.chart.JFreeChart
import org.jfree.data.general.Dataset

trait Drawer {
  def draw(): Unit
  def createChart(dataset: Dataset): JFreeChart
  def save(filePath: String): Unit
}
