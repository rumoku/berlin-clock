package org.rumoku.bc

object Helper {
  def withTime[T](f: => T) = {
    val start = System.currentTimeMillis()
    val res = f
    val end = System.currentTimeMillis()
    (res, end - start)
  }
}
