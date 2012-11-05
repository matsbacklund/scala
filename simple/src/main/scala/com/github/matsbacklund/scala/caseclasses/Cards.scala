package com.github.matsbacklund.scala.caseclasses

/**
 * @author backlmat, 2012-11-05
 */
object Cards {
  sealed abstract class Suit
  case class Club extends Suit
}
