package org.rumoku.bc

import org.rumoku.bc.BerlinClockBuilder._
import org.rumoku.bc.Helper._
import org.scalatest.{FlatSpec, Matchers}

class BerlinClockBuilderTest extends FlatSpec with Matchers {

  "BC" should " support all time range " in {
    val r = withTime {
      (0 to 23).foreach { hh =>
        (0 to 59).foreach { mm =>
          (0 to 59).foreach { ss =>
            val time = getBerlinClockTime(hh, mm, ss)
            time.line1 * 5 + time.line2 should be(hh)
            time.line3 * 5 + time.line4 should be(mm)
          }
        }
      }
    }
    println(s"${24 * 60 * 60} builtTimes in ${r._2}ms")
  }

  List(-1, 24, 25).foreach { hh =>
    "BC" should s"throw exception in case of hour: $hh input " in {
      intercept[IllegalArgumentException] {
        getBerlinClockTime(hh, 20, 20)
      }
    }
  }

  List(-1, 60, 61).foreach { mm =>
    "BC" should s"throw exception in case of mins/seconds: $mm input " in {
      intercept[IllegalArgumentException] {
        getBerlinClockTime(19, mm, 20)
      }
    }
    intercept[IllegalArgumentException] {
      getBerlinClockTime(19, 20, mm)
    }
  }

}
