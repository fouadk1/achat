pipeline {
    agent any
    stages{
              stage('checkout GIT'){
                  steps{
                      echo 'Pulling'
                       git branch: 'Amani',
                       url : 'https://github.com/fouadk1/achat'
                  }
              }
              stage('Build code (Maven)') {
                  steps {
                      echo 'Build Code'
                      sh 'mvn clean install -DskipTests'
                    }
                }
              stage('MVN SONARQUBE'){
                   steps{
                       echo "Maven SONARQUBE"
                       sh 'mvn sonar:sonar -Dsonar.projectKey=Amani -Dsonar.host.url=http://192.168.1.126:9000 -Dsonar.login=admin -Dsonar.password=AS@vaxi@##21'
                      }
                  }      
              stage("Publish to Nexus Repository Manager") {
                  steps {
                      nexusArtifactUploader artifacts: [
                          [
                              artifactId: 'achat',
                              classifier: '',
                              file: 'target/achat-1.0.0.war',
                              type: 'war'
                          ]
                      ],
                          credentialsId: 'nexus3',
                          groupId: 'tn.esprit.rh',
                          nexusUrl: '192.168.1.126:8081',
                          nexusVersion: 'nexus3',
                          protocol: 'http',
                          repository: 'http://192.168.1.126:8081/repository/Nexus-Repository/',
                          version: '1.0.0'
                  }
              }
    }     
}
