package glenmaddern.pacifism

object Constants {
  def bounds = (800,600)
  def width = bounds._1
  def height = bounds._2

  def max(x: Int, y: Int): Int = if (x < y) y else x
  def min(x: Int, y: Int): Int = if (x > y) y else x

  def unitBound(v: Int) = {
    max(min(v, 1), -1)
  }
}