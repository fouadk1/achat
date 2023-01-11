pipeline {
  environment {
        localost = "192.168.0.11"
    }
    agent any
    stages {
        stage('Clone source code from Git') {
            steps {
                echo "Cloning Project from GitHub; Branch : fouad"
                git branch: 'fouad',
                url: 'https://github.com/fouadk1/achat.git'
            }
        }
        stage('MVN CLEAN') {
            steps {
                sh 'mvn -version'
                sh 'mvn clean'
            }
        }
          stage('MVN COMPILE') {
            steps {
                sh 'mvn compile -DskipTests'
            }
        }
            stage('MVN SONARQUBE') {
            steps {
                sh 'mvn package -B -DskipTests sonar:sonar -Dsonar.host.url=${localost}:9000'
            }
        }   stage('Nexus') {
            steps {
                sh 'mvn deploy'
            }
        }

    }
}
