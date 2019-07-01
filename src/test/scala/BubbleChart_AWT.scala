import java.awt.{Color, Dimension}

import Tools.Drawer
import javax.swing.JPanel
import org.jfree.chart.axis.NumberAxis
import org.jfree.chart.plot.{PlotOrientation, XYPlot}
import org.jfree.chart.{ChartFactory, ChartPanel}
import org.jfree.data.xy.{DefaultXYZDataset, XYZDataset}
import org.jfree.ui.ApplicationFrame

class BubbleChart_AWT(s: String) extends ApplicationFrame(s: String){

  val jpanel: JPanel = createDemoPanel
  jpanel.setPreferredSize(new Dimension(560, 370))
  setContentPane(jpanel)

  def createDemoPanel: JPanel = {
    val jfreechart = createChart(createDataset)
    val chartpanel = new ChartPanel(jfreechart)
    chartpanel.setDomainZoomable(true)
    chartpanel.setRangeZoomable(true)
    chartpanel
  }

  def createChart(xyzdataset: XYZDataset) = {
    val jfreechart = ChartFactory.createBubbleChart("AGE vs WEIGHT vs WORK", "Weight", "AGE", xyzdataset, PlotOrientation.HORIZONTAL, true, true, false)
    val xyplot = jfreechart.getPlot.asInstanceOf[XYPlot]
    xyplot.setForegroundAlpha(0.65F)
    val xyitemrenderer = xyplot.getRenderer
    xyitemrenderer.setSeriesPaint(0, Color.blue)
    val numberaxis = xyplot.getDomainAxis.asInstanceOf[NumberAxis]
    numberaxis.setLowerMargin(0.2)
    numberaxis.setUpperMargin(0.5)
    val numberaxis1 = xyplot.getRangeAxis.asInstanceOf[NumberAxis]
    numberaxis1.setLowerMargin(0.8)
    numberaxis1.setUpperMargin(0.9)
    jfreechart
  }

  @throws(classOf[IllegalArgumentException])
  def createDataset(): XYZDataset = {
    val defaultxyzdataset = new DefaultXYZDataset
    val ad = Array(300.0, 400.0, 500.0, 600.0, 700.0, 800.0, 900.0)
    val ad1 = Array(100.0, 200.0, 300.0, 400.0, 500.0, 600.0)
    val ad2 = Array(40.0, 40.0, 40.0, 40.0, 40.0, 40.0)
    val ad3 = Array(ad, ad1, ad2)
    defaultxyzdataset.addSeries("Series 1", ad3)
    defaultxyzdataset
  }

}
