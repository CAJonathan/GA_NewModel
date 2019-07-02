package DataGeneration

import com.hust.msolab.newmodel.GA.Utilities.Factors

object GenerateDataByScenario {

  val sizes = Array(20, 30, 40, 70, 80, 90, 100, 150, 200)

  val energyDistributions = Array((FolderOrganizer.FOLDER_NORMAL_DISTRIBUTION_ENERGY, FolderOrganizer.FOLDER_NORMAL_DISTRIBUTION_ENERGY),
                                 (FolderOrganizer.FOLDER_UNIFORM_DISTRIBUTION_ENERGY, FolderOrganizer.FOLDER_UNIFORM_DISTRIBUTION_ENERGY))

  val energyTypes = Array((FolderOrganizer.FOLDER_NORMAL_DISTRIBUTION_ENERGY_HIGH, (5.0/6.0*Factors.SENSOR_Emax, 1.0/12.0*Factors.SENSOR_Emax)),
                          (FolderOrganizer.FOLDER_NORMAL_DISTRIBUTION_ENERGY_MEDIUM, (1.0/2.0*Factors.SENSOR_Emax, 1.0/12.0*Factors.SENSOR_Emax)),
                          (FolderOrganizer.FOLDER_NORMAL_DISTRIBUTION_ENERGY_LOW, (1.0/6.0*Factors.SENSOR_Emax, 1.0/12.0*Factors.SENSOR_Emax)))

  val locationDistributions = Array((FolderOrganizer.FOLDER_NORMAL_DISTRIBUTION_LOCATION, FolderOrganizer.FOLDER_NORMAL_DISTRIBUTION_LOCATION),
                                    (FolderOrganizer.FOLDER_UNIFORM_DISTRIBUTION_LOCATION, FolderOrganizer.FOLDER_UNIFORM_DISTRIBUTION_LOCATION))

  val locationTypes = Array((FolderOrganizer.FOLDER_NORMAL_DISTRIBUTION_LOCATION_FAR, (Factors.AREA_SIZE/2.0, Factors.AREA_SIZE/8.0)),
                            (FolderOrganizer.FOLDER_NORMAL_DISTRIBUTION_LOCATION_MEDIUM, (Factors.AREA_SIZE/2.0, Factors.AREA_SIZE/4.0)),
                            (FolderOrganizer.FOLDER_NORMAL_DISTRIBUTION_LOCATION_NEAR, (Factors.AREA_SIZE/2.0, 3.0/8.0*Factors.AREA_SIZE)))



  def main(args: Array[String]): Unit = {
    for(size <- sizes){
      for(energyDistribution <- energyDistributions){
        if(energyDistribution._1.equals(FolderOrganizer.FOLDER_NORMAL_DISTRIBUTION_ENERGY)){
          for(energyType <- energyTypes){
            for(locationDistribution <- locationDistributions){
              if(locationDistribution._1.equals(FolderOrganizer.FOLDER_NORMAL_DISTRIBUTION_LOCATION)){
                for(locationType <- locationTypes){
                  val scenario = new Scenario()
                  scenario.createProperties(size, energyDistribution, Some(energyType), locationDistribution, Some(locationType))
                  scenario.run()
                }
              } else{
                val scenario = new Scenario()
                scenario.createProperties(size, energyDistribution, Some(energyType), locationDistribution, None)
                scenario.run()
              }
            }
          }
        } else{
          for(locationDistribution <- locationDistributions){
            if(locationDistribution._1.equals(FolderOrganizer.FOLDER_NORMAL_DISTRIBUTION_LOCATION)){
              for(locationType <- locationTypes){
                val scenario = new Scenario()
                scenario.createProperties(size, energyDistribution, None, locationDistribution, Some(locationType))
                scenario.run()
              }
            } else{
              val scenario = new Scenario()
              scenario.createProperties(size, energyDistribution, None, locationDistribution, None)
              scenario.run()
            }
          }
        }
      }
    }


  }
}
