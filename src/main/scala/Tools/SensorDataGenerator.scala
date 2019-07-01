package Tools

import java.io.{File, PrintWriter}

import Config.Properties
import Utils.Utils
import com.hust.msolab.newmodel.GA.Utilities.Factors


class SensorDataGenerator(properties: Properties) extends Generator {
  val size: Int = properties.getAsInt("scenario.generator.size")
  val locationDistribution: Properties = properties.getAsProperties("scenario.generator.location.distribution")
  val energyDistribution: Properties = properties.getAsProperties("scenario.generator.energy.distribution")
  val consumptionRateDistribution: Properties = properties.getAsProperties("scenario.generator.consumption_rate")
  val utils = new Utils

  var dataGenerated: ((Array[Double], Array[Double]), (Array[Double], Array[Double])) = _

  @throws(classOf[Exception])
  override def generate(): Unit = {
    val energyDistributionType = energyDistribution.getAsString("scenario.generator.energy.distribution.name")
    val locationDistributionType = locationDistribution.getAsString("scenario.generator.location.distribution.name")

    val energyMin = energyDistribution.getAsDouble("scenario.generator.energy.min")
    val energyMax = energyDistribution.getAsDouble("scenario.generator.energy.max")

    val locationMin = energyDistribution.getAsDouble("scenario.generator.location.min")
    val locationMax = energyDistribution.getAsDouble("scenario.generator.location.max")

    val minConsumptionRate = consumptionRateDistribution.getAsDouble("scenario.generator.consumption_rate.min")
    val maxConsumptionRate = consumptionRateDistribution.getAsDouble("scenario.generator.consumption_rate.max")
    val meanConsumptionRate = consumptionRateDistribution.getAsDouble("scenario.generator.consumption_rate.mean")
    val standardDeviationConsumptionRate = consumptionRateDistribution.getAsDouble("scenario.generator.consumption_rate.standard_deviation")

    var locationX: Array[Double] = Array()
    var locationY: Array[Double] = Array()
    var energy: Array[Double] = Array()
    var consumptionRate: Array[Double] = Array()

    energyDistributionType match {
      case "normal" =>
        val energyMean = energyDistribution.getAsDouble("scenario.generator.energy.distribution.normal.mean")
        val energyStandardDeviation = energyDistribution.getAsDouble("scenario.generator.energy.distribution.normal.standard_deviation")
        energy = utils.nextArrGaussDouble(energyMean, energyStandardDeviation, energyMin, energyMax, size)

      case "uniform" =>
        energy = utils.nextArrUniformDouble(energyMin, energyMax, size)
    }

    locationDistributionType match {
      case "normal" =>
        val energyMean = energyDistribution.getAsDouble("scenario.generator.location.distribution.normal.mean")
        val energyStandardDeviation = energyDistribution.getAsDouble("scenario.generator.location.distribution.normal.standard_deviation")
        locationX = utils.nextArrGaussDouble(energyMean, energyStandardDeviation, Factors.SENSOR_Emin, Factors.SENSOR_Emax, size)
        locationY = utils.nextArrGaussDouble(energyMean, energyStandardDeviation, Factors.SENSOR_Emin, Factors.SENSOR_Emax, size)

      case "uniform" =>
        locationX = utils.nextArrUniformDouble(locationMin, locationMax, size)
        locationY = utils.nextArrUniformDouble(locationMin, locationMax, size)
    }

    consumptionRate = utils.nextArrGaussDouble(meanConsumptionRate, standardDeviationConsumptionRate, minConsumptionRate, maxConsumptionRate, size)

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
    if(!file.exists()) file.mkdirs()
    val writer = new PrintWriter(file)

    for(p <- sensorData){
      for(i <- p){
        writer.write(i + " ")
      }
      writer.write("\n")
    }

    writer.close()
  }

  def getlocation(): (Array[Double], Array[Double]) = {
    dataGenerated._1
  }
}
