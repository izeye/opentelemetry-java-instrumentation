# Library Instrumentation for Ktor version 2.0 and higher

This package contains libraries to help instrument Ktor. Currently, only server instrumentation is supported.

## Quickstart

### Add these dependencies to your project:

Replace `OPENTELEMETRY_VERSION` with the [latest
release](https://search.maven.org/search?q=g:io.opentelemetry.instrumentation%20AND%20a:opentelemetry-ktor-2.0).

For Maven, add to your `pom.xml` dependencies:

```xml
<dependencies>
  <dependency>
    <groupId>io.opentelemetry.instrumentation</groupId>
    <artifactId>opentelemetry-ktor-2.0</artifactId>
    <version>OPENTELEMETRY_VERSION</version>
  </dependency>
</dependencies>
```

For Gradle, add to your dependencies:

```groovy
implementation("io.opentelemetry.instrumentation:opentelemetry-ktor-2.0:OPENTELEMETRY_VERSION")
```

## Usage

## Initializing server instrumentation

Initialize instrumentation by installing the `KtorServerTracing` feature. You must set the `OpenTelemetry` to use with
the feature.

```kotlin
OpenTelemetry openTelemetry = initializeOpenTelemetryForMe()

embeddedServer(Netty, 8080) {
  install(KtorServerTracing) {
    setOpenTelemetry(openTelemetry)
  }
}
```
