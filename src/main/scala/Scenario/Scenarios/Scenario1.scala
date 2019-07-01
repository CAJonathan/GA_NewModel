package Scenario.Scenarios

import Config.Properties
import Scenario.Abstract.Scenario
import _root_.Scenario.FolderNames
import com.hust.msolab.newmodel.GA.Utilities.Factors

class Scenario1 extends Scenario{
  val properties: Properties = new Properties
  val name = "scenario1"

  createProperties()

  def getProperties(): Properties = {
    properties
  }

  def createProperties(): Unit = {
    properties.addProperties("scenario.generator.size", 20)

    properties.addProperties("scenario.generator.energy.min", Factors.SENSOR_Emin)
    properties.addProperties("scenario.generator.energy.max", Factors.SENSOR_Emax)
    val energyProps = new Properties
    energyProps.addProperties("scenario.generator.energy.distribution.name", FolderNames.FOLDER_UNIFORM_DISTRIBUTION_ENERGY)
    properties.addProperties("scenario.generator.energy.distribution", energyProps)

    properties.addProperties("scenario.generator.location.min", 0.0)
    properties.addProperties("scenario.generator.location.max", Factors.AREA_SIZE)
    val locationProps = new Properties
    locationProps.addProperties("scenario.generator.location.distribution.name", FolderNames.FOLDER_UNIFORM_DISTRIBUTION_LOCATION)
    properties.addProperties("scenario.generator.location.distribution", locationProps)

    val energyConsumptionRate = new Properties
    energyConsumptionRate.addProperties("scenario.generator.consumption_rate.min", 0.0)
    energyConsumptionRate.addProperties("scenario.generator.consumption_rate.max", 1.0)
    energyConsumptionRate.addProperties("scenario.generator.consumption_rate.mean", 0.4)
    energyConsumptionRate.addProperties("scenario.generator.consumption_rate.standard_deviation", 0.1)
    properties.addProperties("scenario.generator.consumption_rate", energyConsumptionRate)
  }
}
