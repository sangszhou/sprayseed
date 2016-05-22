name := "SprayStarter"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += "Typesafe Maven Repository" at "http://repo.typesafe.com/typesafe/maven-releases/"

resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/releases"

libraryDependencies ++= {

  val akkaV = "2.4.2"
  val sprayV = "1.3.3"
  val jacksonV = "2.4.1"
  val kamonVersion = "0.6.0"

  Seq(
      "io.spray"                         %%  "spray-routing"            %   sprayV
    , "io.spray"                         %%  "spray-can"                %   sprayV
    , "io.spray"                         %%  "spray-client"             %   sprayV
    , "io.spray"                         %%  "spray-http"               %   sprayV
    , "io.spray"                         %%  "spray-testkit"            %   sprayV                    % "test"
    , "io.spray"                         %%  "spray-json"               %   "1.3.1"
    , "io.spray"                         %%  "spray-caching"            %   "1.3.1"
    , "org.scalatest"                    %%  "scalatest"                %   "2.2.1"                   % "test"

    , "com.typesafe.akka"                %%  "akka-actor"               %   akkaV
    , "com.typesafe.akka"                %%  "akka-slf4j"               %   akkaV
    , "com.typesafe.akka"                %%  "akka-testkit"             %   akkaV                     % "test"

    , "com.fasterxml.jackson.core"       %   "jackson-core"             %   jacksonV
    , "com.fasterxml.jackson.core"       %   "jackson-annotations"      %   jacksonV
    , "com.fasterxml.jackson.core"       %   "jackson-databind"         %   jacksonV
    , "com.fasterxml.jackson.dataformat" %   "jackson-dataformat-yaml"  %   jacksonV
    , "com.fasterxml.jackson.datatype"   %   "jackson-datatype-joda"    %   jacksonV
    , "ch.qos.logback"                   %   "logback-classic"          %   "1.1.7"

    , "io.kamon" % "kamon-core_2.11" % kamonVersion
    , "io.kamon" % "kamon-spray_2.11" % kamonVersion
    , "io.kamon" %% "kamon-log-reporter" % kamonVersion
    , "io.kamon" % "kamon-statsd_2.11" % "0.6.0"
    , "com.gettyimages" %% "spray-swagger" % "0.5.1"


  )
}
aspectjSettings

javaOptions in run <++= AspectjKeys.weaverOptions in Aspectj

fork in run := true

