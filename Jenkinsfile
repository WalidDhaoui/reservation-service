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
                sh 'sudo mvn clean verify';
            }
        }
        stage ('Build Package'){
            steps{
                sh 'sudo mvn package';
            }
           
        }
        stage ('Create And Publish Docker Image'){
            steps{
                sh 'sudo mvn package dockerfile:build';
		sh 'sudo mvn dockerfile:push';
            }
        }
	stage ('Run Docker Image'){
        steps{
                sh 'sudo docker run -p 5000:8090 waliddhaoui/reservation-service:0.0.1-SNAPSHOT &';
            }
}
}
}
