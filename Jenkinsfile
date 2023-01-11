pipeline {
  environment {
        localhost = "192.168.0.11"
        registry = "fouadk1/project" 
        dockerImage = "achat"
        dockerUser = "fouadk1"
        dockerRepo = "project"
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
        stage('MVN UnitTEST (Mockito)') {
            steps {
                sh 'mvn test'
            }
        }
        stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.projectKey=fouad_achat -Dsonar.host.url=http://${localhost}:9000 -Dsonar.login=311d4bf1a2ee143843a922533048832dd3487f39'
            }
        }   
        stage('MVN DEPLOY') {
            steps {
                sh 'mvn clean package deploy:deploy-file -DgroupId=tn.esprit -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://${localhost}:8081/repository/maven-releases/ -Dfile=target/achat-1.0.jar'
            }
        }
        stage('Building our image') { 
            steps { 
                script { 
                    sh "docker build -t $dockerImage:$build_number ."
                }
            } 
        }
        stage('Deploy image to Docker Hub') { 
            steps { 
                script {
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        sh "docker login -u $dockerUser -p ${dockerhubpwd}"
                        sh "docker tag $dockerImage $dockerUser/project:second"
                        sh "docker push $dockerUser/$dockerRepo:second"
                        }
                } 
            } 

    }
}
