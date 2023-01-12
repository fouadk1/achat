pipeline {
    agent any
    stages {
        stage('Clone source code from Git') {
            steps {
                echo "Cloning Project from GitHub; Branch : fouad"
                git branch: 'Amani',
                url: 'https://github.com/fouadk1/achat.git'
            }
        }
        stage('MVN CLEAN') {
            steps {
                sh 'mvn -version'
                sh 'mvn clean'
            }
        }
              
             
    }     
}
