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
                sh 'mvn clean verify -DskipTests sonar:sonar -Dsonar.projectKey=fouad_achat -Dsonar.host.url=http://192.168.0.11:9000 -Dsonar.login=311d4bf1a2ee143843a922533048832dd3487f39'
            }
        }   
        stage('Nexus') {
            steps {
                sh 'mvn -DskipTests deploy'
            }
        }

    }
}
