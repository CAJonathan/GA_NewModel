package Tools

trait Generator {
  def generate(): Unit
  def show(): Unit
  def save(filePath: String): Unit
}
