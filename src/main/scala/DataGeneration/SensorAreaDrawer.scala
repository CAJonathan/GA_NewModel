package DataGeneration

import java.awt.{Color, Dimension}
import java.io.File

import Abstract.Drawer
import com.hust.msolab.newmodel.GA.Utilities.Factors
import org.jfree.chart.axis.NumberAxis
import org.jfree.chart.plot.{PlotOrientation, XYPlot}
import org.jfree.chart.{ChartFactory, ChartPanel, ChartUtilities, JFreeChart}
import org.jfree.data.general.Dataset
import org.jfree.data.xy.{DefaultXYZDataset, XYZDataset}
import org.jfree.ui.{ApplicationFrame, RefineryUtilities}

/**
  *   Class drawer của data generation. Sau khi Dữ liệu về các sensor được sinh ra,
  * drawer sẽ sử dụng tọa độ của các sensor để vẽ hình ảnh minh họa về khu vực mục
  * tiêu
  *
  * @author sondn on 26/06/2019
  */

class SensorAreaDrawer(name: String, X: Array[Double], Y: Array[Double]) extends ApplicationFrame(name: String) with Drawer {

  //=========================================constructor========================================
  val dataset: DefaultXYZDataset = new DefaultXYZDataset
  dataset.addSeries("location", Array(X, Y, Array.fill(X.length)(Factors.DOT_SIZE)))
  val chart: JFreeChart = createChart(dataset)
  //============================================================================================

  override def draw(): Unit = {
    val chartPanel = new ChartPanel(chart)
    chartPanel.setDomainZoomable(true)
    chartPanel.setRangeZoomable(true)
    chartPanel.setPreferredSize(new Dimension(Factors.CHART_PANEL_WIDTH, Factors.CHART_PANEL_HEIGHT))
    setContentPane(chartPanel)
    try{
      pack()
      RefineryUtilities.centerFrameOnScreen(this)
      setVisible(true)
    }catch{
      case ex: IllegalArgumentException => {
        ex.printStackTrace()
        println("end.")
      }
    }
  }

  override def save(filePath: String): Unit = {
    ChartUtilities.saveChartAsPNG(new File(filePath), chart, Factors.CHART_IMAGE_WIDTH, Factors.CHART_IMAGE_HEIGHT)
  }

  def createChart(dataset: Dataset): JFreeChart = {
    val jFreeChart = ChartFactory.createBubbleChart("SENSORS LOCATION", "Width", "Height", dataset.asInstanceOf[XYZDataset], PlotOrientation.HORIZONTAL, true, true, false)

    val xyPlot = jFreeChart.getPlot.asInstanceOf[XYPlot]
    xyPlot.setForegroundAlpha(0.65F)

    val xyItemRenderer = xyPlot.getRenderer
    xyItemRenderer.setSeriesPaint(0, Color.blue)

    val numberAxis = xyPlot.getDomainAxis.asInstanceOf[NumberAxis]
    numberAxis.setLowerMargin(0.2)
    numberAxis.setUpperMargin(0.5)

    val numberaxis1 = xyPlot.getRangeAxis.asInstanceOf[NumberAxis]
    numberaxis1.setLowerMargin(0.8)
    numberaxis1.setUpperMargin(0.9)

    jFreeChart
  }
}
