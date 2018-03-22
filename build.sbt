name := """play-scala-seed"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  guice,
  "net.sf.barcode4j" % "barcode4j" % "2.1",
  "com.adrianhurt" %% "play-bootstrap" % "1.3-P26-B4-SNAPSHOT",
  "org.webjars" % "bootstrap" % "4.0.0-1" exclude("org.webjars", "jquery"),
  "org.webjars" % "bootstrap-datepicker" % "1.4.0" exclude("org.webjars", "bootstrap"),
  "org.scalatest" %% "scalatest" % "3.2.0-SNAP10" % Test,
  "org.mongodb" %% "casbah-core" % "3.1.1",
  "com.github.salat" %% "salat" % "1.11.2",
  "org.slf4j" % "slf4j-api" % "1.7.25"
)

scalacOptions += "-deprecation"


// For stable releases
resolvers += "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases"

// For SNAPSHOT releases
resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"