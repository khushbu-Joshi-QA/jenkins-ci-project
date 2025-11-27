pipeline {
    agent any

    stages {

        stage('Build Project') {
            steps {
                sh 'docker run --rm -v $PWD:/app -w /app maven:3.9.6-eclipse-temurin-17 mvn clean install -DskipTests'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                sh 'docker run --rm -v $PWD:/app -w /app maven:3.9.6-eclipse-temurin-17 mvn test'
            }
        }

        stage('Publish Reports') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}
