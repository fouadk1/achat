pipeline {
    environment {
        repoUrl = 'https://github.com/fouadk1/achat.git'
        branchName = 'sofiene'
    }
    agent any
    stages {
        stage('Clone code (Git) ') {
            steps {
                echo "Cloning Project from GitHub; Branch : $branchName"
                git branch: 'master',
                url: 'https://github.com/fouadk1/achat.git'
            }
        }
        stage('Build code (Maven)') {
            steps {
                sh 'mvn -version'
                sh 'mvn clean install'
            }
        }
    }
}
