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
                git branch: 'sofiene',
                url: 'https://github.com/fouadk1/achat.git'
            }
        }
        stage('Build code (Maven)') {
            steps {
                mvn -version
            }
        }
    // stage('Run unit tests (Maven)') {
    //     steps {
    //         sh 'mvn test'
    //     }
    // }
    }
}
