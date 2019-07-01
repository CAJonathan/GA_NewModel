import Tools.SensorAreaDrawer

object testdraw {
  def main(args: Array[String]): Unit={
    val X = Array(400.0, 500.0, 600.0, 700.0, 800.0)
    val Y = Array(400.0, 500.0, 600.0, 700.0, 800.0)
    val dr = new SensorAreaDrawer("location-chart", X, Y)
    dr.draw()
    dr.save("/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/pig1.png")
    val dr2 = new SensorAreaDrawer("location-chart", X, Y)
    dr2.draw()
    dr2.save("/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/pig2.png")
  }
}
