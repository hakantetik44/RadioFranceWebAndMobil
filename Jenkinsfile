pipeline {
    agent any

    stages {
        stage('Install Dependencies') {
            steps {
                script {
                    echo 'Installing dependencies...'
                    sh 'brew update'
                    sh 'brew install maven'
                    sh 'brew install openjdk@21'
                    sh 'npm install -g appium'
                }
            }
        }
        stage('Repo Cloning') {
            steps {
                script {
                    echo 'Cloning repository...'
                    git branch: 'main', credentialsId: '8578b7c2-17bc-4a05-bfdf-cefe81539245', url: 'https://gitlab.com/somfyconnected/qa/qa-somfy/e2e_overkiz.git'
                }
            }
        }
        stage('Start Appium Server') {
            steps {
                script {
                    echo 'Starting Appium server...'
                    sh 'appium &'
                    sleep 10
                }
            }
        }
        stage('Run Cucumber Tests') {
            steps {
                script {
                    echo 'Running Cucumber tests...'
                    sh 'mvn test'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    echo 'Deploying...'
                }
            }
        }
    }

    post {
        always {
            script {
                echo 'Cleaning up...'

            }
        }
    }
}
