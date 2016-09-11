package org.rumoku.bc


object BCConsts {
  val Line1Len, Line2Len, Line4Len = 4
  val Line3Len = 11
}

case class BerlinClock(line0: Boolean,
               line1: Int,
               line2: Int,
               line3: Int,
               line4: Int) {
  // extra validation
  require(line1 >= 0 && line1 <= 4, s"l1:$line1")
  require(line2 >= 0 && line2 <= 4, s"l2:$line2")
  require(line3 >= 0 && line3 <= 11, s"l3:$line3")
  require(line4 >= 0 && line4 <= 4, s"l4:$line4")
}

object BerlinClockBuilder {

  private def divMod(x: Int, divisor: Int) = (x / divisor, x % divisor)

  def getBerlinClockTime(hh: Int, mm: Int, ss: Int) = {
    require(hh >= 0 && hh < 24, s"hh:$hh")
    require(mm >= 0 && mm < 60, s"mm:$mm")
    require(ss >= 0 && ss < 60, s"ss:$ss")

    val (line1, line2) = divMod(hh, 5)
    val (line3, line4) = divMod(mm, 5)
    val line0 = ss % 2 == 0

    BerlinClock(line0, line1, line2, line3, line4)
  }

}