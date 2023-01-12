pipeline {
    agent any
    stages {
        stage('Pulling') {
            steps {
                echo "Pulling project Achat"
                git branch: 'Amani',
                url: 'https://github.com/fouadk1/achat.git'
            }
        }
        stage('MVN INSTALL') {
            steps {
                sh 'mvn -version'
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('MVN SONARQUBE'){
            steps{
                echo "Maven SONARQUBE"
                sh 'mvn sonar:sonar -Dsonar.projectKey=Amani -Dsonar.host.url=http://192.168.1.126:9000 -Dsonar.login=admin -Dsonar.password=AS@vaxi@##21'
                      }
                  }
        stage('MVN DEPLOY') {
            steps {
                sh 'mvn clean package -DskipTests deploy:deploy-file -DgroupId=tn.esprit -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://192.168.1.126:8081/repository/maven-releases/ -Dfile=target/achat-1.0.jar'
       
            }
        }
    }     
}
