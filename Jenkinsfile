pipeline {
    agent any
    environment {
             NEXUS_VERSION = "nexus3"
             NEXUS_PROTOCOL = "http"
             NEXUS_URL = "http://192.168.1.126:8081/repository/Nexus-Repository/"
             NEXUS_REPOSITORY = "Nexus-Repository"
             NEXUS_CREDENTIAL_ID = "admin"
               }
    stages{
              stage('checkout GIT'){
                  steps{
                      echo 'Pulling'
                       git branch: 'Amani',
                       url : 'https://github.com/fouadk1/achat'
                  }
              }
              stage('Build code (Maven)') {
                  steps {
                      echo 'Build Code'
                      sh 'mvn clean install -DskipTests'
                    }
                }
              stage('MVN SONARQUBE'){
                   steps{
                       echo "Maven SONARQUBE"
                       sh 'mvn sonar:sonar -Dsonar.projectKey=Amani -Dsonar.host.url=http://192.168.1.126:9000 -Dsonar.login=admin -Dsonar.password=AS@vaxi@##21'
                      }
                  }
              stage('MVN Test'){
                   steps{
                       echo "Maven Test Junit + Mockito"
                       sh 'mvn test -Dtest=ReglementServiceTest'
                      }
                  }      
              stage('Nexus') {
                  steps {
                      echo "Nexus"
                      sh 'mvn clean package  deploy:deploy-file  -DgroupId=tn.esprit.rh -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=war -DrepositoryId= NEXUS_CREDENTIAL_ID -Durl= NEXUS_URL -Dfile=target/Achat-1.0.war'
            }
        }

              
    }
}
