pipeline {
    environment {
        repo = 'https://github.com/fouadk1/achat.git'
        branch = 'firas-operateur'
        dockerImage = 'imageFirasDocker'
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
        stage('Test Unitaire Pour l entité Operateur') {
            steps {
                sh 'mvn test -Dtest=OperateurServiceTest'
            }
        }
        stage('SonarQube') {
            steps {
                    sh 'mvn sonar:sonar \
                         -Dsonar.projectKey=firasOperateur \
                         -Dsonar.host.url=http://192.168.3.18:9000 \
                         -Dsonar.login=aa5ec4a0c47a4bb91c51bdc7d68a27e65cc711f6'
            }
        }
        stage('Nexus') {
            steps {
                /* groovylint-disable-next-line LineLength */
                sh 'mvn clean package  deploy:deploy-file  -DgroupId=tn.esprit.rh -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Achat-1.0.war'
            }
        }
    }
}
