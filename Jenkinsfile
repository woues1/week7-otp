pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
        DOCKERHUB_REPO = 'tonihirv/week7-otp'
        DOCKER_IMAGE_TAG = 'ver1'
        PATH = 'C:\\Program Files\\Common Files\\Oracle\\Java\\javapath;C:\\Python312\\Scripts\\;C:\\Python312\\;C:\\Windows\\system32;C:\\Windows;C:\\Windows\\System32\\Wbem;C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\;C:\\Windows\\System32\\OpenSSH\\;C:\\Gradle\\gradle-8.10\\bin;C:\\Program Files\\nodejs\\;C:\\ProgramData\\chocolatey\\bin;C:\\Program Files\\Git\\cmd;C:\\Program Files\\Docker\\Docker\\resources\\bin;C:\\Program Files\\Kubernetes\\Minikube;C:\\Program Files\\apache-maven-3.9.9\\bin;C:\\Users\\tonih\\AppData\\Local\\Programs\\Python\\Python39\\Scripts\\;C:\\Users\\tonih\\AppData\\Local\\Programs\\Python\\Python39\\;C:\\Users\\tonih\\AppData\\Local\\Microsoft\\WindowsApps;C:\\Users\\tonih\\AppData\\Local\\Programs\\Microsoft VS Code\\bin;C:\\Program Files\\JetBrains\\IntelliJ IDEA 2024.2.0.1\\bin;;C:\\Gradle\\gradle-8.10\\bin;C:\\Program Files\\Java\\jre1.8.0_421;C:\\Users\\tonih\\AppData\\Local\\Microsoft\\WinGet\\Packages\\Schniz.fnm_Microsoft.Winget.Source_8wekyb3d8bbwe;C:\\Users\\tonih\\AppData\\Roaming\\npm;C:\\Program Files\\apache-maven-3.9.9\\bin;'
    }


    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/woues1/week7-otp.git'
            }
        }
        stage('Run Tests') {
            steps {
                // Run the tests first to generate data for Jacoco and JUnit
                bat 'mvn clean test' // For Windows agents
                // sh 'mvn clean test' // Uncomment if on a Linux agent
            }
        }
        stage('Code Coverage') {
            steps {
                // Generate Jacoco report after the tests have run
                bat 'mvn jacoco:report'
            }
        }
        stage('Publish Test Results') {
            steps {
                // Publish JUnit test results
                // junit '**/target/surefire-reports/*.xml'
                echo "muista testit"
            }
        }
        stage('Publish Coverage Report') {
            steps {
                // Publish Jacoco coverage report
                jacoco()
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${env.DOCKERHUB_REPO}:${env.DOCKER_IMAGE_TAG}")
                }
            }
        }
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', env.DOCKERHUB_CREDENTIALS_ID) {
                        docker.image("${env.DOCKERHUB_REPO}:${env.DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }
    }
}

