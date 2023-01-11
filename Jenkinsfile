pipeline {
    environment {
        repoUrl = 'https://github.com/fouadk1/achat.git'
        branchName = 'sofiene'
        dockerImageName = 'sofiene/achat'
    }
    agent any
    stages {
        stage('Clone source code from Git') {
            steps {
                echo "Cloning Project from GitHub; Branch : $branchName"
                git branch: "$branchName",
                url: "$repoUrl"
            }
        }
        stage('Build code (Maven)') {
            steps {
                sh 'mvn -version'
                sh 'mvn clean package -DskipTests'
            }
        }
        // stage('Run unit tests (Maven)') {
        //     steps {
        //         sh 'mvn test'
        //     }
        // }
        // stage('Launch SonarQube and Nexus') {
        //     steps {
        //         sh 'sudo chmod 666 /var/run/docker.sock'
        //         sh 'docker-compose down --remove-orphans'
        //         sh 'docker-compose up'
        //     }
        // }
        stage('Run code quality test (SonarQube)') {
            steps {
                sh 'mvn clean verify -DskipTests sonar:sonar -Dsonar.projectKey=SofieneAchat -Dsonar.host.url=http://0.0.0.0:9000 -Dsonar.login=fc0c69f06c9ed9e7b35cdc27b3954a484bf44fc2'
            }
        }
        stage('Image build (Docker)') {
            steps {
                sh 'docker build -t sofiene/achat .'
            }
        }
        // stage('Push image to DockerHub (Docker)') {
        //     steps {
        //         sh 'docker build -t sofiene/achat .'
        //     }
        // }

        // stage('Run Spring app and MySQL images (Docker-compose)') {
        //     steps {
        //         sh 'docker-compose down --remove-orphans'
        //         sh 'docker-compose up'
        //     }
        // }
    }
}
