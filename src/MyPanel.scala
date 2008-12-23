import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Panel

class MyPanel extends Panel {
  override def paint(g: Graphics) {
    g.setColor(Color.BLUE)
    g.fillOval(190,190,10,10)
  }
}