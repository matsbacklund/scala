package com.github.matsbacklund.scala.caseclasses

/**
 * http://www.naildrivin5.com/scalatour/wiki_pages/CaseClasses
 *
 * @author backlmat, 2012-11-05
 */
class Logger {
  def debug(l: LogMessage) = log(10, l)
  def info(l: LogMessage) = log(5, l)
  def error(l: LogMessage) = log(1, l)

  def log(level: Int, l: LogMessage): Unit = l match {
    case StringMessage(msg) => println(msg)
    case ExceptionMessage(ex: Error) => ex.printStackTrace
    case ExceptionMessage(ex) if level < 5 => ex.printStackTrace
    case ExceptionMessage(ex) => println(ex.toString)
    case BothMessage(msg, ex) => {
      log(level, StringMessage(msg + "with exception:"))
      log(level, ExceptionMessage(ex))
    }
  }
}
