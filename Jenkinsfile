pipeline {
    agent any
    stages{
              stage('checkout GIT'){
                  steps{
                      echo 'pulling...'
                       git branch: 'Amani',
                       url : 'https://github.com/fouadk1/achat'
                  }
              }
              stage('MVN CLEAN'){
                  steps{
                      echo "Maven Clean"
                      sh 'mvn clean'
                  }
              }
         stage('MVN COMPILE'){
                  steps{
                      echo "Maven Compile"
                      sh 'mvn compile'
                  }
              } 
        stage('MVN Package'){
                  steps{
                      echo "Maven Package"
                      sh 'mvn Package'
                  }
              }
         stage('MVN Test'){
                  steps{
                      echo "Maven Test Junit"
                      sh 'mvn test'
                  }
              }
        stage('MVN SONARQUBE'){
                  steps{
                      echo "Maven SONARQUBE"
                      sh 'mvn sonar:sonar'
                  }
              }
        
        
                      
    }
}
