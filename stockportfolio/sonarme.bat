call mvn clean install -DskipTests=true
call mvn sonar:sonar
call mvn org.codehaus.sonar-plugins.pdf-report:maven-pdfreport-plugin:1.3:generate

