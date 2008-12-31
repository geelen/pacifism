package glenmaddern.pacifism

import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Panel

class MyPanel(controller: Controller) extends Panel {
  var protagonist = new Protagonist((Constants.width / 2 - 10, Constants.height / 2 - 10))
  var evilBlues = (1 to 10).map(EvilBlue.randomPlacedNew(Constants.bounds)).toList

  def init() {
    addKeyListener(controller)
    setBackground(Color.BLACK)
  }

  override def paint(g: Graphics) {
    protagonist = Protagonist.animate(controller)(protagonist)
    protagonist.draw()(g)
    evilBlues = evilBlues.map(EvilBlue.animate(protagonist))
    evilBlues.map((b: EvilBlue) => {b.draw()(g)})
  }
}