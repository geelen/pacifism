package glenmaddern.pacifism

object Constants {
  def width = 800
  def height = 600

  def max(x: Int, y: Int): Int = if (x < y) y else x
  def min(x: Int, y: Int): Int = if (x > y) y else x

  def unitBound(v: Int) = {
    max(min(v, 1), -1)
  }
}