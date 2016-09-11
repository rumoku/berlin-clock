package org.rumoku.bc

import org.rumoku.bc.helper.ConsoleHelper._

object BcDemo extends App {

  val drawer = if (args.length > 0 && args.contains("-color")) new DrawBCStringColor else new DrawBCStringSimple

  (16 to 23).foreach { hh =>
    (25 to(59,9)).foreach { mm =>
      (10 to(59,19)).foreach { ss => { // every 19 seconds
        clearConsole()
        println(s"$hh:$mm:$ss")
        println(drawer.draw(BerlinClockBuilder.getBerlinClockTime(hh, mm, ss)))
        Thread.sleep(1000)
      }
      }
    }
  }
}