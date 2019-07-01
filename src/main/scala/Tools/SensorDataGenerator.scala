package Tools

import java.io.{File, PrintWriter}

import Config.Properties
import Scenario.FolderNames
import Utils.Utils
import com.hust.msolab.newmodel.GA.Utilities.Factors


class SensorDataGenerator(properties: Properties) extends Generator {
  val size: Int = properties.getAsInt("scenario.generator.size")
  val locationDistribution: Properties = properties.getAsProperties("scenario.generator.location.distribution")
  val energyDistribution: Properties = properties.getAsProperties("scenario.generator.energy.distribution")
  val consumptionRateDistribution: Properties = properties.getAsProperties("scenario.generator.consumption_rate")

  var dataGenerated: ((Array[Double], Array[Double]), (Array[Double], Array[Double])) = _

  @throws(classOf[Exception])
  override def generate(): Unit = {
    val energyDistributionName = energyDistribution.getAsString("scenario.generator.energy.distribution.name")
    val locationDistributionName = locationDistribution.getAsString("scenario.generator.location.distribution.name")

    val energyMin = properties.getAsDouble("scenario.generator.energy.min")
    val energyMax = properties.getAsDouble("scenario.generator.energy.max")

    val locationMin = properties.getAsDouble("scenario.generator.location.min")
    val locationMax = properties.getAsDouble("scenario.generator.location.max")

    val minConsumptionRate = consumptionRateDistribution.getAsDouble("scenario.generator.consumption_rate.min")
    val maxConsumptionRate = consumptionRateDistribution.getAsDouble("scenario.generator.consumption_rate.max")
    val meanConsumptionRate = consumptionRateDistribution.getAsDouble("scenario.generator.consumption_rate.mean")
    val standardDeviationConsumptionRate = consumptionRateDistribution.getAsDouble("scenario.generator.consumption_rate.standard_deviation")

    var locationX: Array[Double] = Array()
    var locationY: Array[Double] = Array()
    var energy: Array[Double] = Array()
    var consumptionRate: Array[Double] = Array()

    energyDistributionName match {
      case FolderNames.FOLDER_NORMAL_DISTRIBUTION_ENERGY =>
        val energyMean = energyDistribution.getAsDouble("scenario.generator.energy.distribution.normal.mean")
        val energyStandardDeviation = energyDistribution.getAsDouble("scenario.generator.energy.distribution.normal.standard_deviation")
        energy = Utils.nextArrGaussDouble(energyMean, energyStandardDeviation, energyMin, energyMax, size)

      case FolderNames.FOLDER_UNIFORM_DISTRIBUTION_ENERGY =>
        energy = Utils.nextArrUniformDouble(energyMin, energyMax, size)
    }

    locationDistributionName match {
      case FolderNames.FOLDER_NORMAL_DISTRIBUTION_LOCATION =>
        val energyMean = energyDistribution.getAsDouble("scenario.generator.location.distribution.normal.mean")
        val energyStandardDeviation = energyDistribution.getAsDouble("scenario.generator.location.distribution.normal.standard_deviation")
        locationX = Utils.nextArrGaussDouble(energyMean, energyStandardDeviation, Factors.SENSOR_Emin, Factors.SENSOR_Emax, size)
        locationY = Utils.nextArrGaussDouble(energyMean, energyStandardDeviation, Factors.SENSOR_Emin, Factors.SENSOR_Emax, size)

      case FolderNames.FOLDER_UNIFORM_DISTRIBUTION_LOCATION =>
        locationX = Utils.nextArrUniformDouble(locationMin, locationMax, size)
        locationY = Utils.nextArrUniformDouble(locationMin, locationMax, size)
    }

    consumptionRate = Utils.nextArrGaussDouble(meanConsumptionRate, standardDeviationConsumptionRate, minConsumptionRate, maxConsumptionRate, size)

    dataGenerated = ((locationX, locationY), (energy, consumptionRate))
  }

  override def show(): Unit = {
    val sensorData = Array(dataGenerated._1._1, dataGenerated._1._2, dataGenerated._2._1, dataGenerated._2._2).transpose
    for(p <- sensorData){
      for(i <- p){
        print(i + " ")
      }
      println()
    }
  }

  override def save(filePath: String): Unit = {
    val sensorData = Array(dataGenerated._1._1, dataGenerated._1._2, dataGenerated._2._1, dataGenerated._2._2).transpose
    val file = new File(filePath)
    val writer = new PrintWriter(file)

    for(p <- sensorData){
      for(i <- p){
        writer.write(i + " ")
      }
      writer.write("\n")
    }

    writer.close()
  }

  def getSensorLocation(): (Array[Double], Array[Double]) = {
    dataGenerated._1
  }
}
