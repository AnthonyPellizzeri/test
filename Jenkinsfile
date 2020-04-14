pipeline {
    agent any
    stages {
        stage('Build testtttt') {
            steps {
                sh 'echo "Hello World"'
            }
        }
        stage('SCM') {
            git 'https://github.com/foo/bar.git'
        }
    }
}
