package glenmaddern.pacifism

import java.awt.Panel
import scala.actors.Actor
import scala.actors.Actor._

class MyActor(p: Panel) extends Actor {
  def act() {
    loop {
      p.repaint()
      //todo: proper futuring pls
      Thread.sleep(10)
    }
  }
}