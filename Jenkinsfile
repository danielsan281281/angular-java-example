pipeline { 
    agent any  
    stages { 
        stage('Build') { 
            steps { 
				echo 'Init Build state'
				sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
        }
    }
}