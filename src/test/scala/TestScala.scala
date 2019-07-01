import Utils.Utils

object TestScala {
  def main(args: Array[String]): Unit = {
    val k = Array(Array(1, 4),Array(1, 4),Array(1, 4),Array(1, 4),Array(1, 4),Array(1, 4),Array(1, 4))
    val t = k.transpose
    for(p <- t){
      for(o <- p){
        print(o)
      }
      println()
    }
    println("===============")

    for(p <- k){
      for(o <- p){
        print(o)
      }
      println()
    }
  }
}
