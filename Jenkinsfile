pipeline {
    environment {
        repoUrl = 'https://github.com/fouadk1/achat.git'
        branchName = 'sofiene'
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
        stage('Run unit tests (Maven)') {
            steps {
                sh 'mvn test'
            }
        }
    // stage('Launch SonarQube and Nexus') {
    //     steps {
    //         sh 'docker-compose down --remove-orphans'
    //         sh 'docker-compose up'
    //     }
    // }
    // stage('Run code quality test (SonarQube)') {
    //     steps {
    //         sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=SofieneAchat -Dsonar.host.url=http://0.0.0.0:9000 -Dsonar.login=ddf4bd755d76dccf822898a9325f22b4bafe8957'
    //     }
    // }
    }
}
