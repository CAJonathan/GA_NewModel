package Tools

trait Drawer {
  def draw(): Unit
  def save(filePath: String): Unit
}
