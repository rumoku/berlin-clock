package org.rumoku.bc

import org.rumoku.bc.BCConsts._

trait DrawBC[T] {
  def draw(bc: BerlinClock): T
}

trait DrawBCAsString extends DrawBC[String] {

  def red: String

  def yellow: String

  def blank: String

  protected def buildString(bc: BerlinClock) = {
    (List(skip(5), if (bc.line0) yellow else blank, Eol) ++
      build4Lights(Line1Len, bc.line1, red) ++
      build4Lights(Line2Len, bc.line2, red) ++
      List((1 to bc.line3).map(x => if (x % 3 == 0) red else yellow).mkString, fill(Line3Len - bc.line3, blank), Eol) ++
      build4Lights(Line4Len, bc.line4, yellow)
      ).mkString
  }

  // extra spaces added to align center
  private def build4Lights(maxSize: Int, lSize: Int, color: String) =
  List(skip(2), fill(lSize, color + Space), fill(maxSize - lSize, blank + Space), Eol)

  def skip(x: Int) = Space * x

  def fill(size: Int, content: String) = content * size

}

class DrawBCStringSimple extends DrawBCAsString {

  override val red: String = "#"
  override val yellow: String = "+"
  override val blank: String = "o"

  override def draw(bc: BerlinClock): String = {
    buildString(bc)
  }
}

// note: this implementation will not work on terminals without colors support.
class DrawBCStringColor extends DrawBCAsString {

  override val red: String = Console.RED + "#" + Console.RESET
  override val yellow: String = Console.YELLOW + "+" + Console.RESET
  override val blank: String = "o"

  override def draw(bc: BerlinClock): String = {
    buildString(bc)
  }
}