pipeline {
    agent any // Runs on any available agent
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package' // Builds the project
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test' // Runs tests with Maven
                // Add test commands here
            }
        }
        stage('Deploy') {
            steps {
                sh 'cp target/myapp-1.0-SNAPSHOT.jar /var/jenkins_home/testDeploymentArea/myapp/' // Example deployment to a server
                // Add deploy commands here
            }
        }
    }
}