package glenmaddern.pacifism

import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import java.awt.{Frame, Graphics2D, Dimension, Graphics}
import scala.actors.Actor._

object Pacifism {
  def main(args: Array[String]) {
    val f = new Frame("Pacifism")
    val controller = new Controller    
    f.addWindowListener(new WindowAdapter() {
      override def windowClosing(e : WindowEvent) = { System.exit(0) }
    })
    val p = new MyPanel(controller)
    p.init()
    val a = new MyActor(p)
    f.add(p)
    f.pack()
    f.addKeyListener(controller)
    f.setSize(new Dimension(Constants.width,Constants.height))
    f.show()
    a.start()
  }
}