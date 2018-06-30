# java-tomcat-maven-example

This is an example ready-to-deploy java web application built for Tomcat using Maven and webapp-runner.

## Running Locally

(need maven and java installed)

```
mvn package
java -jar target/dependency/webapp-runner.jar target/*.war
```

The application will be available on `http://localhost:8080`.

## How This Was Built

1. Generate the project using a Maven archetype:

   ```
   mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp
   ```

2. Add the webapp-runner plugin into the `pom.xml`:

   ```
   <build>
     <!-- ... -->
     <plugins>
       <!-- ... -->
       <plugin>
         <groupId>org.apache.maven.plugins</groupId>
         <artifactId>maven-dependency-plugin</artifactId>
         <version>2.3</version>
         <executions>
           <execution>
             <phase>package</phase>
             <goals><goal>copy</goal></goals>
             <configuration>
               <artifactItems>
                 <artifactItem>
                   <groupId>com.github.jsimone</groupId>
                   <artifactId>webapp-runner</artifactId>
                   <version>8.5.11.3</version>
                   <destFileName>webapp-runner.jar</destFileName>
                 </artifactItem>
               </artifactItems>
             </configuration>
           </execution>
         </executions>
       </plugin>
     </plugins>
   </build>
   ```
   
3. For static code analysis add the settings.xml file to ~/.m2, for setting the plugin prefix
  ```
  <settings>
    <pluginGroups>
    	<pluginGroup>org.sonarsource.scanner.maven</pluginGroup>
    </pluginGroups>
	<profiles>
        <profile>
            <id>sonar</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <!-- 
            Optional URL to server. 
            Default value is http://localhost:9000 if not specified below            
            <properties>                
                <sonar.host.url>
                  http://myserver:9000
                </sonar.host.url>
            </properties>
            -->
        </profile>
     </profiles>
   </settings>
   ```
