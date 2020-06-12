# sbt-jmh playground

This repository is a collection of snippets used during writing of
[Things you need to know about JVM (that matter in Scala)](https://kubuszok.com/2020/things-you-need-to-know-about-jvm-that-matter-in-scala/)
article.

As stated in the article this is *not* a valid, correct, useful benchmark.

This is an *example* project that you can use to experiment with
Java Microbenchmark Harness, sbt-jmh plugin, generation of Flight Recorder
logs and async profiler visualisations. The numbers you'll receive here
will (most likely) be completelly irrelevant and useless, but if you'll
learn the tools it will be easier to start learning about actual
benchmarking and profiling (because you will focus on methodology
and not on everything at once).

## Suggested setup

Download and build:

 * [JITWatch](https://github.com/AdoptOpenJDK/jitwatch) (requiressetting up `JAVA_HOME` and building)
 * [async-profiler](https://github.com/jvm-profiling-tools/async-profiler) (requires building)
 * [FlameGraph](https://github.com/brendangregg/FlameGraph) (just clone and it's ready to use)
 * [Java Mission Control](https://jdk.java.net/jmc/)

Setup environment variables:

 * `JAVA_HOME` - set it to location of your JDK installation (not `bin` directory but directory that contains `bin` and everything)
 * `ASYNC_PROFILER_DIR` - set to directory where you cloned async-profiler (project's root, not `build` subdirectory)
 * `FLAME_GRAPH_DIR` - set to directory where you cloned FlameGraph

> If you want to use Flight Recorder and play it in Java Mission Control then you have to either use Oracle's JDK
> (which requires enabling paid, commercial features) or at least JMC v7 with OpenJDK 11 if you want to use free
> open sources version.

Then run `sbt` and start experimenting!

### JITWatch

In case you want to set up JITWatch to don't have errors on finding sources and classes
you can reuse my config:

Classes:
```
[test bench directory]/bench/target/scala-2.12/classes
[test bench directory]/code/target/scala-2.12/classes
[your home]/.sbt/boot/scala-2.12.4/lib/scala-library.jar
[your home]/.ivy2/local/pl.project13.scala/sbt-jmh-extras/0.3.7/jars/sbt-jmh-extras.jar
[your home]/.ivy2/cache/org.openjdk.jmh/jmh-core/jars/jmh-core-1.23.jar
[your home]/.ivy2/cache/net.sf.jopt-simple/jopt-simple/jars/jopt-simple-4.6.jar
[your home]/.ivy2/cache/org.apache.commons/commons-math3/jars/commons-math3-3.2.jar
[your home]/.ivy2/cache/org.openjdk.jmh/jmh-generator-bytecode/jars/jmh-generator-bytecode-1.23.jar
[your home]/.ivy2/cache/org.openjdk.jmh/jmh-generator-reflection/jars/jmh-generator-reflection-1.23.jar
[your home]/.ivy2/cache/org.openjdk.jmh/jmh-generator-asm/jars/jmh-generator-asm-1.23.jar
[your home]/.ivy2/cache/org.ow2.asm/asm/jars/asm-5.0.3.jar
```

Sources:
```
[test bench directory]/code/src/main/scala-2.12
[test bench directory]/code/src/main/scala
[test bench directory]/code/src/main/java
[test bench directory]/code/target/scala-2.12/src_managed/main
[test bench directory]/bench/src/main/scala-2.12
[test bench directory]/bench/src/main/scala
[test bench directory]/bench/src/main/java
[test bench directory]/bench/target/scala-2.12/src_managed/main
[your home]/.ivy2/local/pl.project13.scala/sbt-jmh-extras/0.3.7/srcs/sbt-jmh-extras-sources.jar
[your home]/.ivy2/cache/org.openjdk.jmh/jmh-core/srcs/jmh-core-1.23-sources.jar
[your home]/.ivy2/cache/net.sf.jopt-simple/jopt-simple/srcs/jopt-simple-4.6-sources.jar
[your home]/.ivy2/cache/org.apache.commons/commons-math3/srcs/commons-math3-3.2-sources.jar
[your home]/.ivy2/cache/org.openjdk.jmh/jmh-generator-bytecode/srcs/jmh-generator-bytecode-1.23-sources.jar
[your home]/.ivy2/cache/org.openjdk.jmh/jmh-generator-reflection/srcs/jmh-generator-reflection-1.23-sources.jar
[your home]/.ivy2/cache/org.openjdk.jmh/jmh-generator-asm/srcs/jmh-generator-asm-1.23-sources.jar
[your home]/.ivy2/cache/org.ow2.asm/asm/srcs/asm-5.0.3-sources.jar
```
