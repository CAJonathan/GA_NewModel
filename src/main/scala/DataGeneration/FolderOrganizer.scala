package DataGeneration

import java.io.File

import Utils.Properties
import com.hust.msolab.newmodel.GA.Utilities.Factors

/**
  *   Object quy định cách đặt tên file được sinh ra theo kịch bản và vị trí
  * của file data trong thư mục data và của file image trong thư mục image.
  * Trong trong bộ dữ liệu hiện tại, cấu trúc thư mục được tổ chức như sau:
  *   ./Data
  *         /Normal_distribution_energy
  *               /High_energy
  *                     /Normal_distribution_location
  *                           /Far_distance
  *                                 [file-format: far-n<size>-high.txt]
  *                           /Medium_distance
  *                                 [file-format: medium-n<size>-high.txt]
  *                           /Near_distance
  *                                 [file-format: near-n<size>-high.txt]
  *                     /Uniform_distribution_location
  *                           [file-format: n<size>-high.txt]
  *               /Medium_energy
  *                     /Normal_distribution_location
  *                           /Far_distance
  *                                 [file-format: far-n<size>-medium.txt]
  *                           /Medium_distance
  *                                 [file-format: medium-n<size>-medium.txt]
  *                           /Near_distance
  *                                 [file-format: near-n<size>-medium.txt]
  *                     /Uniform_distribution_location
  *                           [file-format: n<size>-medium.txt]
  *               /Low_energy
  *                     /Normal_distribution_location
  *                           /Far_distance
  *                                 [file-format: far-n<size>-low.txt]
  *                           /Medium_distance
  *                                 [file-format: medium-n<size>-low.txt]
  *                           /Near_distance
  *                                 [file-format: near-n<size>-low.txt]
  *                     /Uniform_distribution_location
  *                           [file-format: n<size>-low.txt]
  *         /Uniform_distribution_energy
  *               /Normal_distribution_location
  *                     /Far_distance
  *                           [file-format: far-u<size>.txt]
  *                     /Medium_distance
  *                           [file-format: medium-u<size>.txt]
  *                     /Near_distance
  *                           [file-format: near-u<size>.txt]
  *               /Uniform_distribution_energy
  *                     [file-format: n<size>.txt]
  *
  * @author sondn on 26/06/2019
  *
  ***/

object FolderOrganizer {

  val FOLDER_NORMAL_DISTRIBUTION_ENERGY = "Normal_distribution_energy"          // có thể sử dụng cho scenario.generator.energy.distribution.name
  val FOLDER_UNIFORM_DISTRIBUTION_ENERGY = "Uniform_distribution_energy"        // có thể sử dụng cho scenario.generator.energy.distribution.name
  val FOLDER_NORMAL_DISTRIBUTION_ENERGY_HIGH = "High_energy"                    // có thể sử dụng cho scenario.generator.energy.distribution.normal.type
  val FOLDER_NORMAL_DISTRIBUTION_ENERGY_MEDIUM = "Medium_energy"                // có thể sử dụng cho scenario.generator.energy.distribution.normal.type
  val FOLDER_NORMAL_DISTRIBUTION_ENERGY_LOW = "Low_energy"                      // có thể sử dụng cho scenario.generator.energy.distribution.normal.type
  val FOLDER_NORMAL_DISTRIBUTION_LOCATION = "Normal_distribution_location"      // có thể sử dụng cho scenario.generator.location.distribution.name
  val FOLDER_UNIFORM_DISTRIBUTION_LOCATION = "Uniform_distribution_location"    // có thể sử dụng cho scenario.generator.location.distribution.name
  val FOLDER_NORMAL_DISTRIBUTION_LOCATION_FAR = "Far_distance"                  // có thể sử dụng cho scenario.generator.location.distribution.normal.type
  val FOLDER_NORMAL_DISTRIBUTION_LOCATION_MEDIUM = "Medium_distance"            // có thể sử dụng cho scenario.generator.location.distribution.normal.type
  val FOLDER_NORMAL_DISTRIBUTION_LOCATION_NEAR = "Near_distance"                // có thể sử dụng cho scenario.generator.location.distribution.normal.type

  val FILE_NORMAL_DISTRIBUTION_ENERGY = "n"
  val FILE_UNIFORM_DISTRIBUTION_ENERGY = "u"
  val FILE_NORMAL_DISTRIBUTION_ENERGY_HIGH = "high"
  val FILE_NORMAL_DISTRIBUTION_ENERGY_MEDIUM = "medium"
  val FILE_NORMAL_DISTRIBUTION_ENERGY_LOW = "low"
  val FILE_NORMAL_DISTRIBUTION_LOCATION_FAR = "far"
  val FILE_NORMAL_DISTRIBUTION_LOCATION_MEDIUM = "medium"
  val FILE_NORMAL_DISTRIBUTION_LOCATION_NEAR = "near"
  val FILE_DELIMITER_SYNTAX = "-"

  val DATA_FILE_TYPE = ".txt"
  val IMAGE_FILE_TYPE = ".png"

  def determineDataAndImageFilePath(properties: Properties): (String, String) = {
    var locationInFolder = ""

    val size: Int = properties.getAsInt("scenario.generator.size")
    val energyDistribution: Properties = properties.getAsProperties("scenario.generator.energy.distribution")
    val locationDistribution: Properties = properties.getAsProperties("scenario.generator.location.distribution")

    val energyDistributionName = energyDistribution.getAsString("scenario.generator.energy.distribution.name")
    val locationDistributionName = locationDistribution.getAsString("scenario.generator.location.distribution.name")

    var energyDistributionType: Option[String] = None
    var locationDistributionType: Option[String] = None

    energyDistributionName match{
      case FOLDER_NORMAL_DISTRIBUTION_ENERGY =>
        energyDistributionType = Some(energyDistribution.getAsString("scenario.generator.energy.distribution.normal.type"))
        locationInFolder += "/" + FolderOrganizer.FOLDER_NORMAL_DISTRIBUTION_ENERGY + "/" + energyDistributionType.get


      case FOLDER_UNIFORM_DISTRIBUTION_ENERGY =>
        locationInFolder += "/" + FolderOrganizer.FOLDER_UNIFORM_DISTRIBUTION_ENERGY

    }

    locationDistributionName match{
      case FOLDER_NORMAL_DISTRIBUTION_LOCATION =>
        locationDistributionType = Some(locationDistribution.getAsString("scenario.generator.location.distribution.normal.type"))
        locationInFolder += "/" + FolderOrganizer.FOLDER_NORMAL_DISTRIBUTION_LOCATION + "/" + locationDistributionType.get


      case FOLDER_UNIFORM_DISTRIBUTION_LOCATION =>
        locationInFolder += "/" + FolderOrganizer.FOLDER_UNIFORM_DISTRIBUTION_LOCATION

    }

    val dataFolder = new File(Factors.INPUT_FOLDER + locationInFolder)
    val imageFolder = new File(Factors.PICTURE_FOLDER + locationInFolder)

    if(!dataFolder.exists()) {
      dataFolder.mkdirs()
//      Thread.sleep(1000)
    }
    if(!imageFolder.exists()) {
      imageFolder.mkdirs()
//      Thread.sleep(1000)
    }

    val filesName = fileName(energyDistributionName, energyDistributionType, locationDistributionType, size)
    (dataFolder + "/" + filesName._1, imageFolder + "/" + filesName._2)
  }

  def fileName(energyDistributionName: String,
               energyDistributionType: Option[String],
               locationDistributionType: Option[String],
               size: Int): (String, String) = {
    var fileName = ""
    if(locationDistributionType.isDefined){
      locationDistributionType.get match{
        case FOLDER_NORMAL_DISTRIBUTION_LOCATION_FAR =>
          fileName += FILE_NORMAL_DISTRIBUTION_LOCATION_FAR + FILE_DELIMITER_SYNTAX


        case FOLDER_NORMAL_DISTRIBUTION_LOCATION_MEDIUM =>
          fileName += FILE_NORMAL_DISTRIBUTION_LOCATION_MEDIUM + FILE_DELIMITER_SYNTAX


        case FOLDER_NORMAL_DISTRIBUTION_LOCATION_NEAR =>
          fileName += FILE_NORMAL_DISTRIBUTION_LOCATION_NEAR + FILE_DELIMITER_SYNTAX

      }
    }

    energyDistributionName match{
      case FOLDER_NORMAL_DISTRIBUTION_ENERGY =>
        fileName += FILE_NORMAL_DISTRIBUTION_ENERGY + size.toString


      case FOLDER_UNIFORM_DISTRIBUTION_ENERGY =>
        fileName += FILE_UNIFORM_DISTRIBUTION_ENERGY + size.toString

    }

    if(energyDistributionType.isDefined){
      energyDistributionType.get match{
        case FOLDER_NORMAL_DISTRIBUTION_ENERGY_HIGH =>
          fileName += FILE_DELIMITER_SYNTAX + FILE_NORMAL_DISTRIBUTION_ENERGY_HIGH


        case FOLDER_NORMAL_DISTRIBUTION_ENERGY_MEDIUM =>
          fileName += FILE_DELIMITER_SYNTAX + FILE_NORMAL_DISTRIBUTION_ENERGY_MEDIUM


        case FOLDER_NORMAL_DISTRIBUTION_ENERGY_LOW =>
          fileName += FILE_DELIMITER_SYNTAX + FILE_NORMAL_DISTRIBUTION_ENERGY_LOW

      }
    }

    (fileName + DATA_FILE_TYPE, fileName + IMAGE_FILE_TYPE)
  }
}
