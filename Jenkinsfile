pipeline {
    environment {
        repoUrl = 'https://github.com/fouadk1/achat.git'
        branchName = 'sofiene'
        dockerImageName = 'sofiene/achat'
        registry = 'sofiene/achatproject'
        registryCredential = credentials('dc110c28-ee22-45a3-b997-a1495b66c44d')
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
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Run unit tests (Maven)') {
            steps {
                sh 'mvn test -Dtest=StockServiceTest'
            }
        }
        stage('Run code quality test (SonarQube)') {
            steps {
                sh 'mvn clean verify -DskipTests sonar:sonar -Dsonar.projectKey=SofieneAchat -Dsonar.host.url=http://0.0.0.0:9000 -Dsonar.login=fc0c69f06c9ed9e7b35cdc27b3954a484bf44fc2'
            }
        }

        // stage('Package and deploy to Nexus') {
        //     steps {
        //         sh 'mvn clean package -DskipTests deploy:deploy-file -DgroupId=tn.esprit.rh -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://0.0.0.0:8081/repository/maven-releases/ -Dfile=target/achat-1.0.jar'
        //     }
        // }
        stage('Build and deploy image to DockerHub (Docker)') {
            steps {
                script {
                    dockerImage = docker.build registry
                    docker.withRegistry('', registryCredential) {
                        dockerImage.push()
                    }
                }
            }
        }

    // stage('Run Spring app and MySQL images (Docker-compose)') {
    //     steps {
    //         sh 'docker-compose down --remove-orphans'
    //         sh 'docker-compose up'
    //     }
    // }
    }
}
