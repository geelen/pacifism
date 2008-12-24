package glenmaddern.pacifism

import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Panel

class MyPanel(controller: Controller) extends Panel {
  var protagonist = new Protagonist((190,190))

  def init() {
    addKeyListener(controller)
    setBackground(Color.BLACK)
  }

  override def paint(g: Graphics) {
//    println("painting")
//    g.setColor(Color.BLACK)
//    g.drawRect(0,0, Constants.height, Constants.width)
    g.setColor(Color.YELLOW)
    protagonist = Protagonist.draw(protagonist, controller)(g)
  }
}