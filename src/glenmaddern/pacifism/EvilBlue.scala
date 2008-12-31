package glenmaddern.pacifism

import java.awt.Graphics
import java.awt.Color

case class EvilBlue(pos: (Double,Double)) {
  def draw(): Graphics => Unit = {
    (g: Graphics) => {
      g.setColor(Color.BLUE)
      g.drawOval(pos._1.toInt, pos._2.toInt, 10, 10)
    }
  }
}

object EvilBlue {
  val rnd = new Random()

  def animate(pro: Protagonist) : EvilBlue => EvilBlue = {
    (prev: EvilBlue) => {
      val angle = Math.atan2(pro.pos._1 - prev.pos._1, pro.pos._2 - prev.pos._2)
      val newX = prev.pos._1 + Math.sin(angle)
      val newY = prev.pos._2 + Math.cos(angle)
      new EvilBlue((newX, newY))
    }
  }

  def randomPlacedNew(bounds: (Int,Int)) : Int => EvilBlue = {
    (ignored: Int) => {
      new EvilBlue((rnd.nextInt(bounds._1), rnd.nextInt(bounds._2)))
    }
  }
}