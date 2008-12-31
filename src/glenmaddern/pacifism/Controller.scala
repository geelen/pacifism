package glenmaddern.pacifism

import java.awt.event.{KeyListener, KeyEvent}
import Constants.unitBound

class Controller extends KeyListener {
  var accelerationX = 0
  var accelerationY = 0

  def getAcceleractionX = accelerationX
  def getAcceleractionY = accelerationY

  def keyPressed(keyEvent: KeyEvent): Unit = keyEvent.getKeyCode() match {
    case KeyEvent.VK_LEFT => accelerationX = unitBound(accelerationX - 1)
    case KeyEvent.VK_RIGHT => accelerationX = unitBound(accelerationX + 1)
    case KeyEvent.VK_DOWN => accelerationY = unitBound(accelerationY + 1)
    case KeyEvent.VK_UP => accelerationY = unitBound(accelerationY - 1)
    case _ => //println(keyEvent)
  }

  def keyReleased(keyEvent: KeyEvent): Unit = keyEvent.getKeyCode() match {
    case KeyEvent.VK_LEFT => accelerationX = unitBound(accelerationX + 1)
    case KeyEvent.VK_RIGHT => accelerationX = unitBound(accelerationX - 1)
    case KeyEvent.VK_DOWN => accelerationY = unitBound(accelerationY - 1)
    case KeyEvent.VK_UP => accelerationY = unitBound(accelerationY + 1)
    case _ => //println(keyEvent)
  }

  def keyTyped(keyEvent: KeyEvent) {}
}