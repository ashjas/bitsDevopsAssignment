pipeline {
    agent any // Runs on any available agent
    stages {
        stage('Build') {
            steps {
                sh '/var/jenkins_home/maven/bin/mvn clean package' // Builds the project
            }
        }
        stage('Test') {
            steps {
                sh '/var/jenkins_home/maven/bin/mvn test' // Runs tests with Maven
                // Add test commands here
            }
        }
        stage('Deploy') {
            steps {
                source abc
                sh 'cp target/myapp-1.0-SNAPSHOT.jar /var/jenkins_home/testDeploymentArea/myapp/' // Example deployment to a server
                // Add deploy commands here
            }
        }
    }
    post {
        failure {
            echo 'Pipeline failed! Sending failure mails...'
            mail to: 'team@example.com', subject: 'Build Failed', body: 'Check Jenkins logs.'
        }
        success {
            echo 'Pipeline succeeded!'
        }
    }
}