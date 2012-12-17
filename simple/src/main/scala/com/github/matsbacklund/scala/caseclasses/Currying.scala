package com.github.matsbacklund.scala.caseclasses

import java.lang.Math._

/**
 * @author mats, 2012-12-17
 */

case class Point(x: Int, y: Int)
case class Circle(center: Point, radius: Int)

object Currying {
  val radius : Circle => Int = circle => {
    val Circle(_, radius) = circle
    radius
  }

  val center : Circle => Point = circle => {
    val Circle(center, _) = circle
    center
  }

  def main(args: Array[String]) {
    val p = Point(4, 5)
    val c = Circle(p, 8)
    println(radius(c))
    println(center(c))

    val observerViewer = Circle(Point(2, 2), 3)
    println(isWithin(observerViewer, Point(3, 4)))
    println(isWithin(observerViewer, Point(2, 2)))
    println(isWithin(observerViewer, Point(6, 6)))
    println(isWithin(observerViewer, Point(8, 2)))
    val observes: Point => Boolean = isWithin2(observerViewer)
    println(observes(Point(3, 4)))
    println(observes(Point(2, 2)))
    println(observes(Point(6, 6)))
    println(observes(Point(8, 2)))

    val curriedIsWithin: Circle => Point => Boolean = isWithin.curried
    val observes2: Point => Boolean = curriedIsWithin(observerViewer)
    println(observes2(Point(3, 4)))
  }

  val isWithin: (Circle, Point) => Boolean = { (circle, point) =>
    val Point(a, b) = center(circle)
    val Point(x, y) = point

    pow(x-a, 2) + pow(y-b, 2) <= pow(radius(circle), 2)
  }

  val isWithin2: Circle => Point => Boolean = { circle =>
    val radSquare = pow(radius(circle), 2)
    val Point(a, b) = center(circle)

    point => {
      val Point(x, y) = point
      pow(x-a, 2) + pow(y-b, 2) <= radSquare
    }
  }
}