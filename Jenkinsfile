pipeline { 
    agent any  
    stages {
		stage('SCM') {
			git 'https://github.com/danielsan281281/angular-java-example.git'
		}
        stage('Build') { 
            steps { 
				echo 'Init Build state'
				sh 'mvn clean package' 
            }
        }
    }
}