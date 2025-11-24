pipeline {
    agent any
environment {
        JAVA_HOME = "/var/jenkins_home/tools/hudson.model.JDK/JDK17"
        PATH = "${JAVA_HOME}/bin:${PATH}"
    }

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn -B clean package'
            }
        }

        stage('Run Selenium Tests (TestNG)') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Run Postman Tests (Newman)') {
            steps {
                sh '''
                    newman run postman/reqres-login-collection.json \
                    --reporters cli,junit \
                    --reporter-junit-export newman-results.xml
                '''
            }
            post {
                always {
                    junit 'newman-results.xml'
                }
            }
        }

    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/**/*.xml, newman-results.xml', fingerprint: true
        }
        success {
            echo 'Pipeline SUCCESS!'
        }
        failure {
            echo 'Pipeline FAILED!'
        }
    }
}
