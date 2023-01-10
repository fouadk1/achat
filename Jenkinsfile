pipeline{
    environment {
        repoUrl = "https://github.com/fouadk1/achat.git"
        branchName = "sofiene"
    }
    agent any
    stages{
        stage('GIT'){
            steps{
                echo "Cloning Project from GitHub";
                  git branch: "master",
                  url: "https://github.com/fouadk1/achat.git";
            }            
        }
    }
}