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
        stage('Deploying to staging env') {
            when { branch 'feature/new-feature' } // Only run on main branch
            steps {
                retry(3) { // Retry up to 3 times
                    sh 'cp target/myapp-1.0-SNAPSHOT.jar /var/jenkins_home/stageDeploymentArea/myapp/' // Example deployment to a server
                }
            }
        }
        stage('Deploying to production env') {
            when { branch 'main' } // Only run on main branch
            steps {
                retry(3) { // Retry up to 3 times
                    sh 'cp target/myapp-1.0-SNAPSHOT.jar /var/jenkins_home/prodDeploymentArea/myapp/' // Example deployment to a server
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