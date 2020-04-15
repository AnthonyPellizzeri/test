node {
   stage('testtttt') {
        sh 'echo "Hello World"'
   }
   stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
}
