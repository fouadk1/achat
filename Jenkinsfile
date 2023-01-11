pipeline {
    environment {
        repo = 'https://github.com/fouadk1/achat.git'
        branch = 'firas-operateur'
        dockerImage = 'imageFirasDocker'
    }
    agent any
    stages {
        stage('Clone source code from Git') {
            steps {
                echo "Cloning Project from GitHub; Branch : $branch"
                git branch: "$branch",
          url: "$repo"
            }
        }
        stage('Build code (Maven)') {
            steps {
                sh 'mvn -version'
                echo 'test from git '
            }
        }
        stage('SonarQube Analysis') {
            steps {
                    sh 'mvn sonar:sonar \
                         -Dsonar.projectKey=firasOperateur \
                         -Dsonar.host.url=http://192.168.3.18:9000 \
                         -Dsonar.login=aa5ec4a0c47a4bb91c51bdc7d68a27e65cc711f6'
                }
            }
    }
}
