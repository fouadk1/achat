pipeline {
    environment {
        repo = 'https://github.com/fouadk1/achat.git'
        branch = 'firas-operateur'
        dockerImage = 'imageFirasDocker'
        registry = 'firasar/achat'
        localhost = '192.168.3.18'
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
                sh 'mvn clean install -DskipTests'
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
        stage('PUSH DOCKERHUB') { 
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
         stage('CD single engine mode: docker-compose') {
      steps {
          
            bat "docker-compose up -d"
      }
      }
        /* stage('Creation Image Docker') {
            steps {
                script {
                    dockerImage = docker.build registry
                }
            }
        }
         */
    }
}
