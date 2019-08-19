# endpoints-json-schemas-macros

[![Maven Central](https://img.shields.io/maven-central/v/io.scalaland/endpoints-json-schema-macros_2.12.svg)](http://search.maven.org/#search%7Cga%7C1%7Cendpoints-json-schema-macros)
[![License](http://img.shields.io/:license-Apache%202-green.svg)](http://www.apache.org/licenses/LICENSE-2.0.txt)

Generic derivation based macros for JsonSchema type class of Scala [endpoints library](https://github.com/julienrf/endpoints).

Endpoints have [generic derivation of json schemas](http://julienrf.github.io/endpoints/algebras/json-schemas.html#generic-derivation-of-json-schemas)
based on [Shapeless](https://github.com/milessabin/shapeless) library.

This project provides fully compatible, drop-in replacement that doesn't use Shapeless, but Scala macros directly.
This approach has several advantages:

- immediate compilation-time performance improvements
- more descriptive error messages
- no runtime overhead as materialization to `HList`/`Coproduct` is not required
- avoided runtime dependency on Shapeless

However, be noticed that this is **experimental** project.

## Getting started

To get started, first add project dependency to your `build.sbt`:

```scala
libraryDependencies += "io.scalaland" %% "endpoints-json-schema-macros" % "0.10.0"
```

