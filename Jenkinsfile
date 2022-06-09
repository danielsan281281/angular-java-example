pipeline { 
    agent any  
    stages {
		stage('SCM') {
			steps { 
				git 'https://github.com/danielsan281281/angular-java-example.git'
			}
		}
        stage('Build') { 
            steps { 
				echo 'Init Build state'
				sh 'mvn clean package' 
            }
        }
		stage('SonarQube analysis') {
			withSonarQubeEnv(credentialsId: 'SonarQube', installationName: 'My SonarQube Server') {
				sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
			}
		}
    }
}