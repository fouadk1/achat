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
         stage('MVN Test'){
                  steps{
                      echo "Maven Test Junit"
                      sh 'mvn test'
                  }
              }
        
                      
    }
}
