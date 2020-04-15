node {
   stage('testtttt') {
        sh 'echo "Hello World"'
   }
   stage('git') {
      git 'https://github.com/AnthonyPellizzeri/test.git'                
   }
   stage('sonar') {
      def mvnHome = tool name: 'maven3', type: 'maven'
      git 'https://github.com/AnthonyPellizzeri/test.git'                
   }
}
