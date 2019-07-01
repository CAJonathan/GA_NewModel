package Scenario
import Scenario.SensorDataScenario.Scenario1
import Tools.{SensorAreaDrawer, SensorDataGenerator}

object GenerateDataByScenario {
  def main(args: Array[String]): Unit = {
    val scenario = new Scenario1()

    val generator = new SensorDataGenerator(scenario.getProperties())
    generator.generate()
    val location = generator.getlocation()

    val drawer = new SensorAreaDrawer(scenario.name, location._1, location._2)

    generator.save()
    drawer.save()
  }
}
