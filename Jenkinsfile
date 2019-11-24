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
}
