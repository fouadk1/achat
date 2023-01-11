pipeline {
    agent any
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

              
    }
}
