package com.github.matsbacklund.scala.caseclasses

/**
 * @author backlmat, 2012-11-05
 */
abstract class LogMessage
case class StringMessage(message: String) extends LogMessage
case class ExceptionMessage(ex: Throwable) extends LogMessage
case class BothMessage(message: String, ex: Throwable) extends LogMessage