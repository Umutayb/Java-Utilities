# Quickstart Library

### How To Get Started:

First, the library should be exported into an empty automation project. There are two ways of doing this.
### Dependency: 

[![](https://jitpack.io/v/Umutayb/Java-Utilities.svg)](https://jitpack.io/#Umutayb/Java-Utilities)

The dependency can be acquired by adding Jitpack repository into the pom.xml, as well as the dependency for the library as:
```xml
<dependencies>
    <!-- Framework -->
        <dependency>
            <groupId>com.github.Umutayb</groupId>
            <artifactId>Java-Utils</artifactId>
            <version>0.0.1</version>
        </dependency>   
</dependencies>
        
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

#### To create a cucumber project:
Run the following command:
````shell
mvn archetype:generate                      \
"-DarchetypeGroupId=io.cucumber"            \
"-DarchetypeArtifactId=cucumber-archetype"  \
"-DarchetypeVersion=6.10.4"                 \
"-DgroupId=hellocucumber"                   \
"-DartifactId=hellocucumber"                \
"-Dpackage=hellocucumber"                   \
"-Dversion=1.0.0-SNAPSHOT"                  \
"-DinteractiveMode=false"
````
