package DataGeneration

import java.io.{File, PrintWriter}

import Abstract.Generator
import Utils._
import com.hust.msolab.newmodel.GA.Utilities.Factors

/**
  *   Class generator của data generation, quy định cách thức sinh dữ liệu. Hiện tại, kịch bản được sinh ra
  * theo cách sau:
  *   1. Năng lượng: năng lượng được sinh theo phân phối đều và phân phối chuẩn trong khoảng tử Emin đến Emax.
  * Đối với phân phối chuẩn, năng lượng của các sensor sẽ có 3 mức là cao (High_energy), trung bình (Medium_energy)
  * và thấp (Low_energy) tương ứng với 3 mean cho trước.
  *   2. Vị trí của các sensor được sinh theo phân phối đều và phân phối chuẩn trong khoảng từ 0 đến area_size.
  * Đối với phân phối chuẩn, khoảng các giữa 2 sensor bất kì sẽ có 3 xu hướng là xa (Far_distance), trung bình
  * (Medium_distance) và gần (Low_distance) tương ứng với 3 mean cho trước.
  *   3. Mức độ tiêu thụ năng lượng của mỗi sensor được sinh theo phân phối chuản và chỉ có 1 mean cùng với 1 độ
  * lệch chuẩn cho trước
  *
  * @author sondn on 26/06/2019
  */

class SensorDataGenerator(properties: Properties) extends Generator {
  val size: Int = properties.getAsInt("scenario.generator.size")
  val locationDistribution: Properties = properties.getAsProperties("scenario.generator.location.distribution")
  val energyDistribution: Properties = properties.getAsProperties("scenario.generator.energy.distribution")
  val consumptionRateDistribution: Properties = properties.getAsProperties("scenario.generator.consumption_rate")

  var dataGenerated: ((Array[Double], Array[Double]), (Array[Double], Array[Double])) = _

  @throws(classOf[Exception])
  override def generate(): (Array[Double], Array[Double]) = {
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
      case FolderOrganizer.FOLDER_NORMAL_DISTRIBUTION_ENERGY =>
        val energyMean = energyDistribution.getAsDouble("scenario.generator.energy.distribution.normal.mean")
        val energyStandardDeviation = energyDistribution.getAsDouble("scenario.generator.energy.distribution.normal.standard_deviation")
        energy = Utils.nextArrGaussDouble(energyMean, energyStandardDeviation, energyMin, energyMax, size)

      case FolderOrganizer.FOLDER_UNIFORM_DISTRIBUTION_ENERGY =>
        energy = Utils.nextArrUniformDouble(energyMin, energyMax, size)
    }

    locationDistributionName match {
      case FolderOrganizer.FOLDER_NORMAL_DISTRIBUTION_LOCATION =>
        val energyMean = locationDistribution.getAsDouble("scenario.generator.location.distribution.normal.mean")
        val energyStandardDeviation = locationDistribution.getAsDouble("scenario.generator.location.distribution.normal.standard_deviation")
        locationX = Utils.nextArrGaussDouble(energyMean, energyStandardDeviation, Factors.SENSOR_Emin, Factors.SENSOR_Emax, size)
        locationY = Utils.nextArrGaussDouble(energyMean, energyStandardDeviation, Factors.SENSOR_Emin, Factors.SENSOR_Emax, size)

      case FolderOrganizer.FOLDER_UNIFORM_DISTRIBUTION_LOCATION =>
        locationX = Utils.nextArrUniformDouble(locationMin, locationMax, size)
        locationY = Utils.nextArrUniformDouble(locationMin, locationMax, size)
    }

    consumptionRate = Utils.nextArrGaussDouble(meanConsumptionRate, standardDeviationConsumptionRate, minConsumptionRate, maxConsumptionRate, size)

    dataGenerated = ((locationX, locationY), (energy, consumptionRate))
    (locationX, locationY)
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
        writer.write(String.format("%.2f ", i))
      }
      writer.write("\n")
    }

    writer.close()
  }
}
