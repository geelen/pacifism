package glenmaddern.pacifism

import java.awt.Graphics
import java.awt.Color

case class EvilBlue(pos: (Double, Double), pulse: Double)

object EvilBlue {
  val rnd = new Random()

  def animate(pro: Protagonist): EvilBlue => EvilBlue = {
    (prev: EvilBlue) => {
      val angle = Math.atan2(pro.pos._1 - prev.pos._1, pro.pos._2 - prev.pos._2)
      val newX = prev.pos._1 + Math.sin(angle)
      val newY = prev.pos._2 + Math.cos(angle)
      new EvilBlue((newX, newY), (prev.pulse + 0.01) % 1.0)
    }
  }

  def randomPlacedNew(bounds: (Int, Int)): Int => EvilBlue = {
    (ignored: Int) => {
      new EvilBlue((rnd.nextInt(bounds._1), rnd.nextInt(bounds._2)), rnd.nextDouble)
    }
  }

  def draw(g: Graphics): EvilBlue => Unit = {
    (evilBlue: EvilBlue) => {
      drawPulse(g, evilBlue)
      drawMain(g, evilBlue)
    }
  }

  private def drawPulse(g: Graphics, evilBlue: EvilBlue) {
    g.setColor(Color.GREEN)
    val pulseSize = evilBlue.pulse * Constants.evilBlueSize
    g.drawOval((evilBlue.pos._1 - pulseSize / 2.0).toInt, (evilBlue.pos._2 - pulseSize / 2.0).toInt, pulseSize.toInt, pulseSize.toInt)
  }

  private def drawMain(g: Graphics, evilBlue: EvilBlue) {
    g.setColor(Color.BLUE)
    val halfSize = Constants.evilBlueSize / 2.0
    val intSize = Constants.evilBlueSize.toInt
    g.drawOval((evilBlue.pos._1 - halfSize).toInt, (evilBlue.pos._2 - halfSize).toInt, intSize, intSize)
  }
}