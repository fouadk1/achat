pipeline {
    environment {
        repoUrl = 'https://github.com/fouadk1/achat.git'
        branchName = 'sofiene'
        dockerImageName = 'sofiene/achat'
        registry = 'sofiene/achatproject'
        registryCredential = credentials('dockerhub-auth')
        hostIP = '192.168.122.1'
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
                sh 'mvn clean compile -DskipTests'
            }
        }
        stage('Run unit tests (Maven)') {
            steps {
                sh 'mvn test -Dtest=StockServiceTest'
            }
        }
        stage('Run code quality test (SonarQube)') {
            steps {
                sh "mvn sonar:sonar -Dsonar.projectKey=achat -Dsonar.host.url=http://${hostIP}:9000 -Dsonar.login=8fd22cd6db87d831668a80f01ade2d6a874f8208"
            }
        }
        stage('Package and deploy to Nexus') {
            steps {
                sh "mvn clean package -DskipTests deploy:deploy-file -DgroupId=tn.esprit -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://${hostIP}:8081/repository/maven-releases/ -Dfile=target/achat-1.0.jar"
            }
        }
        stage('Push image to DockerHub (Docker)') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                    docker.withRegistry('https://hub.docker.com/', registryCredential) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Remove Unused docker image') {
            steps {
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }
        stage('Run Spring app and MySQL images (Docker-compose)') {
            steps {
                sh 'docker-compose down --remove-orphans'
                sh 'docker-compose up'
            }
        }
    }
}
