pipeline {
    agent any
    stages{
              stage('checkout GIT'){
                  steps{
                      echo 'Pulling'
                       git branch: 'Amani',
                       url : 'https://github.com/fouadk1/achat.git'
                  }
              }
              stage('Build code (Maven)') {
                  steps {
                      echo 'Build Code'
                      sh 'mvn -clean'
                    }
                }
              
             
    }     
}
