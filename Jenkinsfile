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
        //
    }
}
