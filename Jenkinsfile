pipeline {
    agent any

    stages {

        stage('Build Project') {
            agent {
                docker { image 'maven:3.9.6-eclipse-temurin-17' }
            }
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Selenium Tests') {
            agent {
                docker { image 'maven:3.9.6-eclipse-temurin-17' }
            }
            steps {
                sh 'mvn test'
            }
        }

        stage('Publish Reports') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}
