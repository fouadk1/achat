pipeline {
    environment {
        repoUrl = 'https://github.com/fouadk1/achat.git'
        branchName = 'sofiene'
        dockerImageName = 'sofiene/achat'
        registry = 'sofiene/achatproject'
        registryCredential = credentials('dockerhub-sofiene')
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
                sh "mvn sonar:sonar -Dsonar.projectKey=SofieneAchat -Dsonar.host.url=http://${hostIP}:9000 -Dsonar.login=fc0c69f06c9ed9e7b35cdc27b3954a484bf44fc2"
            }
        }

        // stage('Package and deploy to Nexus') {
        //     steps {
        //         sh "mvn clean package -DskipTests deploy:deploy-file -DgroupId=tn.esprit -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://${hostIP}:8081/repository/maven-releases/ -Dfile=target/achat-1.0.jar"
        //     }
        // }
        stage('Build and deploy image to DockerHub (Docker)') {
            steps {
                    sh "docker build -t $dockerImageName:v1.$build_number ."
                    sh "docker image tag $dockerImageName:v1.$build_number $registry/$dockerImageName:v1.$build_number"
                    sh "docker image tag $dockerImageName:v1.$build_number $registry/$dockerImageName:latest"
            }
        }

        stage('Push image to DockerHub (Docker)') {
            steps {
            // script {
            //     dockerImage = docker.build registry
            //     docker.withRegistry('', registryCredential) {
            //         dockerImage.push()
            //     }
            // }
                withCredentials([gitUsernamePassword(credentialsId: 'dockerhub_password', gitToolName: 'Default'), string(credentialsId: 'dock_creds', variable: 'dockerhub_cred')]) {
                    // some block
                    sh "docker login -u sofienembk -p ${dockerhub_cred}"
                    sh "docker image push $registry/$dockerImageName:v1.$build_number"
                    sh "docker image push $registry/$dockerImageName:latest"
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
