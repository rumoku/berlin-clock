package org.rumoku.bc

import org.rumoku.bc.BerlinClockBuilder._
import org.scalatest.{FlatSpec, Matchers}

class BCDrawTest extends FlatSpec with Matchers {

  "BC" should "be properly drawn" in {
    val drawer: DrawBC[String] = new DrawBCStringSimple
    val img = drawer.draw(getBerlinClockTime(16, 21, 19))
    img.length should be(56)
    val lines = img.split("\n")
    lines(0).trim should be("o")
    lines(1).trim should be("# # # o")
    lines(2).trim should be("# o o o")
    lines(3).trim should be("++#+ooooooo")
    lines(4).trim should be("+ o o o")
  }

}
