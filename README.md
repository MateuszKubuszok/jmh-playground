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
