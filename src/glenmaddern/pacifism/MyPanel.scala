import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Panel

class MyPanel extends Panel {
  var protagonist = new Protagonist((190,190))

  override def paint(g: Graphics) {
    println("painting")
    g.setColor(Color.BLACK)

    g.setColor(Color.YELLOW)
    protagonist = Protagonist.draw(protagonist)(g)
  }
}