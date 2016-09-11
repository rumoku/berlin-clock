lazy val root = (project in file(".")).
	settings(
		name := "berlin-clock",
		organization  := "rumoku",
		scalaVersion  := "2.11.8",
		version := "0.1",
		libraryDependencies ++= Seq( ) ++ Seq(
			"org.scalatest" %% "scalatest" % "2.2.6"
		).map { _ % "test" }
)
