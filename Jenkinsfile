pipeline {
  environment {
    }
    agent any
    stages {
        stage('Clone source code from Git') {
            steps {
                echo "Cloning Project from GitHub; Branch : khedijaS"
                git branch: 'khedijaS',
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