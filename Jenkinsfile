pipeline {
    agent any // Runs on any available agent
    stages {
        stage('Build') {
            steps {
                retry(3) { // Retry up to 3 times
                    sh '/var/jenkins_home/maven/bin/mvn clean package' // Builds the project
                }
            }
        }
        stage('Test') {
            steps {
                retry(3) { // Retry up to 3 times
                    sh '/var/jenkins_home/maven/bin/mvn test' // Runs tests with Maven
                }
            }
        }
        stage('Deploy') {
            steps {
                retry(3) { // Retry up to 3 times
                    sh 'cp target/myapp-1.0-SNAPSHOT.jar /var/jenkins_home/testDeploymentArea/myapp/' // Example deployment to a server
                }
            }
        }
    }
    post {
        failure {
            echo 'Pipeline failed! Sending failure mails...'
            mail to: 'team@example.com', subject: 'Pipeline Failed', body: 'Check Jenkins logs.'
        }
        success {
            echo 'Pipeline succeeded!'
        }
    }
}