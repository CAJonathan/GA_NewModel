package Scenario.Abstract

import Config.Properties

trait FolderOrganizer {
  def determineDataAndImageFilePath(properties: Properties): (String, String)
}
