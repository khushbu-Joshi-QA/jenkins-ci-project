pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                echo "Cloning GitHub repository..."
                git 'https://github.com/khushbu-Joshi-QA/jenkins-ci-project'
            }
        }

        stage('Build Project') {
            steps {
                echo "Running Maven build..."
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                echo "Running Selenium Tests on Docker Grid..."
                sh 'mvn test'
            }
        }

        stage('Publish Reports') {
            steps {
                echo "Publishing Test Reports..."
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}
