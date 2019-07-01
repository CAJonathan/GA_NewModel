package Scenario.SensorDataScenario

import Config.Properties

trait Scenario {
  def getProperties(): Properties
  def createProperties(): Unit
}
