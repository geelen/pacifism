import java.awt.Graphics

case class Protagonist(pos: (Int,Int))

object Protagonist {
  def draw(prev: Protagonist) : Graphics => Protagonist = {
    (g:Graphics) => Protagonist {
      g.fillOval(prev.pos._1, prev.pos._2,10,10)
      //todo: why a tuple here?
      (prev.pos._1 + 1, prev.pos._2 - 1)
    }
  }
}

