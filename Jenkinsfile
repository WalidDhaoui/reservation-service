pipeline {
    agent any
    stages {
        stage('Poll') {
            steps{
                checkout scm
            }
        }
        stage('Clean Package') {
            steps{
                sh 'mvn clean verify';
            }
        }
        stage ('Build Package'){
            steps{
                sh 'mvn package';
            }
           
        }
        stage ('Create And Publish Docker Image'){
            steps{
                sh 'mvn package dockerfile:build';
		            sh 'mvn dockerfile:push';
            }
        }
    post {
        success {
            emailext (
              subject: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
              body: """<p>SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
                <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
              recipientProviders: [[$class: 'DevelopersRecipientProvider']]
            )
        }
        failure {
          emailext (
              subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
              body: """<p>FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
                <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
              recipientProviders: [[$class: 'DevelopersRecipientProvider']]
            )
        }
    }
}
}
