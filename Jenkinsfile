pipeline {
    environment {
        repo = 'https://github.com/fouadk1/achat.git'
        branch = 'firas-operateur'
        dockerImage = 'imageFirasDocker'
        registry = 'firasar/achat'
        localhost = '192.168.1.100'
        dockerCreds = 'dockerHub'
    }
    agent any
    stages {
        stage('Git clone (cloner le projet sur la VM)') {
            steps {
                echo 'Git Clone'
                git branch: "$branch",
                url: "$repo"
            }
        }
        stage('Build code (Maven)') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test Unitaire') {
            steps {
                sh 'mvn test -Dtest=OperateurServiceTest'
            }
        }
        stage('SonarQube') {
            steps {
                    sh 'mvn sonar:sonar \
                         -Dsonar.projectKey=firasOperateur \
                         -Dsonar.host.url=http://${localhost}:9000 \
                         -Dsonar.login=aa5ec4a0c47a4bb91c51bdc7d68a27e65cc711f6'
            }
        }
        stage('Nexus') {
            steps {
                /* groovylint-disable-next-line GStringExpressionWithinString, LineLength */
                sh 'mvn clean package deploy:deploy-file -DgroupId=tn.esprit -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://${localhost}:8081/repository/maven-releases/ -Dfile=target/achat-1.0.war'
            }
        }
        stage('Image Docker') {
            steps {
                script {
                    timestamps {
                        dockerImage = docker.build registry + ":$BUILD_NUMBER"
                    }
                }
            }
        }
        stage('Dockerhub image push') { 
            steps { 
                script {
                        timestamps {
						  docker.withRegistry ('', dockerCreds ) {
							  dockerImage.push()
                        }
                    } 
                }
            } 
            
        }
         stage('Docker-compose') {
      steps {
          
            sh "docker-compose up -d"
      }
      }
    }
}
