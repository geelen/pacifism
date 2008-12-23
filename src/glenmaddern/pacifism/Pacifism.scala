import java.awt.Dimension
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import java.awt.Frame
import java.awt.Graphics
import java.awt.Graphics2D
import scala.actors.Actor._

object Pacifism {
  def main(args: Array[String]) {
    val f = new Frame("Pacifism")
    f.addWindowListener(new WindowAdapter() {
      override def windowClosing(e : WindowEvent) = { System.exit(0) }
    })
    val p = new MyPanel()
    val a = new MyActor(p)
    f.add(p)
    f.pack()
    f.setSize(new Dimension(Constants.height,Constants.width))
    f.show()
    a.start()
  }
}