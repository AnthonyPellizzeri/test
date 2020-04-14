pipeline {
    agent any
    stages {
        stage('Build testtttt') {
            steps {
                sh 'echo "Hello World"'
                git 'https://github.com/AnthonyPellizzeri/test.git'
                sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.6.0.1398:sonar'
                
            }
        }
        
    }
}
