lazy val root = project.in(new File("."))
  .aggregate(code, bench)

val code = project.in(new File("code"))

val bench = project.in(new File("bench"))
  .dependsOn(code)
  .enablePlugins(JmhPlugin)
  .settings(mainClass := Some("org.openjdk.jmh.Main"))
