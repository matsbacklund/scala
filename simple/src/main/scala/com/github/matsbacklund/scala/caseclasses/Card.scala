package com.github.matsbacklund.scala.caseclasses

/**
 * @author backlmat, 2012-11-05
 */
case class Card(value: Int) {
}

object TestCard extends Application {
  def name(c: Card) = c match {
    case Card(1) => "Ace"
    case Card(11) => "Jack"
    case Card(12) => "Queen"
    case Card(13) => "King"
    case Card(x:Int) => x.toString
  }
  val t = new Card(1)
  println(name(t))
  println(name(new Card(11)))
  println(name(new Card(12)))
  println(name(new Card(7)))

}
