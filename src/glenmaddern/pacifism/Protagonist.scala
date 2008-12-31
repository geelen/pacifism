package glenmaddern.pacifism

import java.awt.Graphics
import java.awt.Color

case class Protagonist(pos: (Int, Int)) {
  def draw(): Graphics => Unit = {
    (g: Graphics) => {
      g.setColor(Color.YELLOW)
      g.fillOval(pos._1, pos._2, 10, 10)
    }
  }
}

object Protagonist {
  def animate(controller: Controller): Protagonist => Protagonist = {
    (prev: Protagonist) => {
      val newX = prev.pos._1 + 3 * controller.getAcceleractionX
      val newY = prev.pos._2 + 3 * controller.getAcceleractionY
      new Protagonist(newX, newY)
    }
  }
}

