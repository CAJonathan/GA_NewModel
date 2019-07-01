package Scenario.SensorDataScenario

import Config.Properties

class Scenario1 extends Scenario{
  val properties: Properties = new Properties
  val name = "scenario1"

  def getProperties(): Properties = {
    properties
  }

  def createProperties(): Unit = {

  }
}
