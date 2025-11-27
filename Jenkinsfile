pipeline {
    agent any

    stages {

        stage('Build Project') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Publish Reports') {
            steps {
                junit '**/target/surefire-reports/*.xml'
                publishHTML([
                    reportName: 'TestNG HTML Report',
                    reportDir : 'test-output',
                    reportFiles: 'index.html'
                ])
            }
        }
    }
}
