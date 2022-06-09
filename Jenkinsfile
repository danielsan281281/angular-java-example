pipeline { 
    agent any  
    stages { 
        stage('Build') { 
            steps { 
				echo 'Init Build state'
				sh 'mvn clean package' 
            }
        }
    }
}