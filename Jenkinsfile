
pipeline {
  environment {
        localhost = "192.168.1.195"
        dockerImage = "achat"
        tagname = "second"
        registry= "fouadk1/achat"
	    registryCredential = "dockerRegPwd"
    }
    agent any
    stages {
        stage('Clone source code from Git') {
            steps {
                echo "Cloning Project from GitHub; Branch : khedijaS"
                git branch: 'khedijaS',
                url: 'https://github.com/fouadk1/achat.git'
            }
        }
        stage('MVN CLEAN') {
            steps {
                sh 'mvn -version'
                sh 'mvn clean'
            }
        }
        stage('MVN TEST (Mockito)') {
           steps {
              sh 'mvn test'
            }
        }
        stage('MVN SONARQUBE') {
           steps {
               sh 'mvn sonar:sonar -Dsonar.projectKey=fouad_achat -Dsonar.host.url=http://192.168.1.195:9000 -Dsonar.login=12400ceaa07a30eebdb65a5f2e3d977eae3658d3'
            }
        }   
        stage('MVN DEPLOY') {
            steps {
                sh 'mvn clean package deploy:deploy-file -DgroupId=tn.esprit -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://${localhost}:8081/repository/maven-releases/ -Dfile=target/achat-1.0.jar'
            }
        }
        /*stage('BUILD') { 
          //  steps { 
            //    script { 
              //      timestamps {
                //    dockerImage = docker.build registry
                  //  }
                }
            } 
        }
        stage('PUSH DOCKERHUB') { 
            steps { 
                script {
                        timestamps {
						  docker.withRegistry ('', registryCredential ) {
							  dockerImage.push()
                        }
                    } 
                }
            } 
            
        }
         stage('RMV IMG') {
            steps {
                sh "docker rmi $registry:latest"
            }
        }
           stage('DOCKER-COMPOSE') {
            steps {
                sh 'docker-compose down --remove-orphans'
                sh 'docker-compose -f docker-compose.yml up -d'
            }
        }*/
        
    }
}