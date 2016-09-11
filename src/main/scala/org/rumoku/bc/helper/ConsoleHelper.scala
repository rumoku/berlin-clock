package org.rumoku.bc.helper

object ConsoleHelper {

  def clearConsole() = clearWithUnicode()

  private def clearWithUnicode() = print("\033[H\033[2J")

  // val OS = System.getProperty("os.name")
  // val ClearCommand = if (OS.contains("Windows")) "cmd /C cls" else "clear"
  // private def clearWithProcess = Runtime.getRuntime.exec(ClearCommand)

}
