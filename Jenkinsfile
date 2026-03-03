pipeline {
    agent any

    triggers {
        githubPush()
    }

    environment {
        BUILD_DIR = "built"
        REPO_URL = "https://github.com/MachukaJoy/student-grade-manager.git"
        BRANCH = "main"
        PROJECT_DIR = "student-grade-manager"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: "${BRANCH}",
                    credentialsId: 'jenkins-github-creds',
                    url: "${REPO_URL}"
            }
        }

        stage('Build with Maven') {
            steps {
                dir("${PROJECT_DIR}") {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Create built Directory') {
            steps {
                sh '''
                    mkdir -p ${BUILD_DIR}
                    cp country-name/target/*.jar ${BUILD_DIR}/
                '''
            }
        }
    }

    post {
        success {
            echo "Build successful. .jar stored in built/"
            archiveArtifacts artifacts: 'built/*.jar', fingerprint: true
        }
        failure {
            echo "Build failed"
        }
    }
}