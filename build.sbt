val CatsVersion = "2.4.1"
val Http4sVersion = "0.21.16"
val CirceVersion = "0.13.0"
val MunitVersion = "0.7.20"
val LogbackVersion = "1.2.3"
val MunitCatsEffectVersion = "0.13.0"

val baseDependencies = List(
  "org.http4s"           %% "http4s-blaze-server" % Http4sVersion,
  "org.http4s"           %% "http4s-blaze-client" % Http4sVersion,
  "org.http4s"           %% "http4s-circe"        % Http4sVersion,
  "org.http4s"           %% "http4s-dsl"          % Http4sVersion,
  "io.circe"             %% "circe-generic"       % CirceVersion,
  "io.circe"             %% "circe-yaml"          % "0.13.1",
  "org.scalameta"        %% "munit"               % MunitVersion           % Test,
  "org.typelevel"        %% "munit-cats-effect-2" % MunitCatsEffectVersion % Test,
  "org.scalameta"        %% "svm-subs"            % "20.2.0",
  "org.scalatra.scalate" %% "scalate-core"        % "1.9.6",
  "com.lihaoyi"          %% "scalatags"           % "0.9.3"
)
val catsDependencies = List(
  "org.typelevel"   %% "cats-core"           % CatsVersion,
  "org.typelevel"   %% "cats-effect"         % "2.3.1",
)

val javaDependencies = List(
  "ch.qos.logback"       %  "logback-classic" % LogbackVersion,
  "com.vladsch.flexmark" % "flexmark-all"     % "0.62.2"
)

lazy val root = (project in file("."))
  .settings(
    organization := "hatemogi",
    name := "home21",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.13.4",
    libraryDependencies ++= baseDependencies ++ catsDependencies ++ javaDependencies,
    addCompilerPlugin("org.typelevel" %% "kind-projector"     % "0.10.3"),
    addCompilerPlugin("com.olegpy"    %% "better-monadic-for" % "0.3.1"),
    testFrameworks += new TestFramework("munit.Framework")
  )
