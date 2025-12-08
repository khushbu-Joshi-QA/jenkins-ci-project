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

        stage('Publish JUnit Reports') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {
    always {
        publishHTML([
            allowMissing: true,
            alwaysLinkToLastBuild: true,
            keepAll: true,
            reportDir: 'target/surefire-reports',
            reportFiles: 'index.html',
            reportName: 'TestNG HTML Report'
        ])
    }
}
}
