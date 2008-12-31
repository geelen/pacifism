package glenmaddern.pacifism

import java.awt.Graphics
import java.awt.Color

case class EvilBlue(pos: (Int,Int)) {
  def draw(): Graphics => Unit = {
    (g: Graphics) => {
      g.setColor(Color.BLUE)
      g.fillOval(pos._1, pos._2, 10, 10)
    }
  }
}

object EvilBlue {
  val rnd = new Random()

  def animate(pro: Protagonist) : EvilBlue => EvilBlue = {
    (prev: EvilBlue) => {
      val newX = prev.pos._1 + (if (pro.pos._1 > prev.pos._1) 1 else if (pro.pos._1 == prev.pos._1) 0 else -1)
      val newY = prev.pos._2 + (if (pro.pos._2 > prev.pos._2) 1 else if (pro.pos._2 == prev.pos._2) 0 else -1)
      new EvilBlue((newX, newY))
    }
  }

  def randomPlacedNew(bounds: (Int,Int)) : Int => EvilBlue = {
    (ignored: Int) => {
      new EvilBlue((rnd.nextInt(bounds._1), rnd.nextInt(bounds._2)))
    }
  }
}