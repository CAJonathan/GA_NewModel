import Scenario.FolderNames
import Scenario.Scenarios.Scenario1
import Tools.{SensorAreaDrawer, SensorDataGenerator}
import com.hust.msolab.newmodel.GA.Utilities.Factors

object GenerateDataByScenario {
  def main(args: Array[String]): Unit = {
    val scenario = new Scenario1()
    val properties = scenario.getProperties()

    val generator = new SensorDataGenerator(properties)
    generator.generate()
    val location = generator.getSensorLocation()

    val drawer = new SensorAreaDrawer(scenario.name, location._1, location._2)

    val filesPath = FolderNames.determineDataAndImageFilePath(properties)
    generator.save(filesPath._1)
    drawer.save(filesPath._2)
  }
}
