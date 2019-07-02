package Abstract

trait Generator {
  def generate(): Any
  def show(): Unit
  def save(filePath: String): Unit
}
