pipeline {
    agent any
    stages {
        stage('Build testtttt') {
            steps {
                sh 'echo "Hello World"'
                git 'https://github.com/AnthonyPellizzeri/test.git'
                withSonarQubeEnv(credentialsId: 'f225455e-ea59-40fa-8af7-08176e86507a', installationName: 'My SonarQube Server') { // You can override the credential to be used
      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.6.0.1398:sonar'
    }
            }
        }
        
    }
}
