import java.io.FileWriter

import Utils.Utils

import scala.collection.JavaConverters._
import scala.collection.mutable
import java.io.File

object TestScala {
  def main(args: Array[String]): Unit = {
    val k = new FileWriter(new File("/home/dongocson/Documents/Work/Work/Document/LearningProgram/Project2/GA_NewModel/src/main/resources/Image/Image2/Uniform_distribution_energy/Uniform_distribution_location/u20.txt"))
    k.write("lol")
    k.close()
  }
}
