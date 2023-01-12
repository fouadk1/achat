pipeline {
    agent any
    environment {
             NEXUS_VERSION = "nexus3"
             NEXUS_PROTOCOL = "http"
             NEXUS_URL = "http://192.168.1.126:8081/repository/Nexus-Repository/"
             NEXUS_REPOSITORY = "Nexus-Repository"
             NEXUS_CREDENTIAL_ID = "nexus-user-credentials"
               }
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
                     script {
                         pom = readMavenPom file: "pom.xml";
                         filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                         echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                         artifactPath = filesByGlob[0].path;
                         artifactExists = fileExists artifactPath;
                         if(artifactExists) {
                             echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                             nexusArtifactUploader(
                                 nexusVersion: NEXUS_VERSION,
                                 protocol: NEXUS_PROTOCOL,
                                 nexusUrl: NEXUS_URL,
                                 groupId: pom.groupId,
                                 version: pom.version,
                                 repository: NEXUS_REPOSITORY,
                                 credentialsId: NEXUS_CREDENTIAL_ID,
                                 artifacts: [
                                     [artifactId: pom.artifactId,
                                      classifier: '',
                                      file: artifactPath,
                                      type: pom.packaging],
                                     [artifactId: pom.artifactId,
                                      classifier: '',
                                      file: "pom.xml",type: "pom"]
                                 ]
                             );
                         } else {
                             error "*** File: ${artifactPath}, could not be found";
                         }
                     }
                  }
              }

              
    }
}
