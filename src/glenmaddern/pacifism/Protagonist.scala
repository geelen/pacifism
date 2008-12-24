package glenmaddern.pacifism

import java.awt.Graphics

case class Protagonist(pos: (Int,Int))

object Protagonist {
  def draw(prev: Protagonist, controller: Controller) : Graphics => Protagonist = {
    (g:Graphics) => Protagonist {
      val newPosition = (prev.pos._1 + controller.getAcceleractionX, prev.pos._2 + controller.getAcceleractionY)
      g.fillOval(newPosition._1, newPosition._2,10,10)
      //todo: why a tuple here, not a Protagonist?
      newPosition
    }
  }
}

