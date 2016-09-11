package org.rumoku.bc

import org.rumoku.bc.BerlinClockBuilder._
import org.rumoku.bc.Helper._
import org.scalatest.{FlatSpec, Matchers}
import org.rumoku.bc.BCImplicits._

class BCDrawTest extends FlatSpec with Matchers {
  implicit val drawer: DrawBC[String] = new DrawBCStringSimple

  "BC" should "be properly drawn" in {
    val img = drawer.draw(getBerlinClockTime(16, 21, 19))
    img.length should be(52)
    val lines = img.split("\n")
    lines(0).trim should be("o")
    lines(1).trim should be("# # # o")
    lines(2).trim should be("# o o o")
    lines(3).trim should be("++#+ooooooo")
    lines(4).trim should be("+ o o o")
  }


  "BC" should " draw all time range in reasonable time " in {
    var x = 0
    val r = withTime {
      (0 to 23).foreach { hh =>
        (0 to 59).foreach { mm =>
          (0 to 59).foreach { ss =>
            val time = getBerlinClockTime(hh, mm, ss)
            time.draw.length should be(52)
            x += 1
          }
        }
      }
    }
    println(s"$x times been drawn in ${r._2}ms")
  }


}
