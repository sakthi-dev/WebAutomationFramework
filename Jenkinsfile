pipeline {
    
    agent any
    
    stages{
        
        stage("Build"){
            steps{
                echo("Build")
            }
        }
        stage("UTs"){
            steps{
                echo("RUN UTs")
            }
        }
        
        stage("Deploy to QA"){
            steps{
                echo("deploy to qa")
            }
        }
        stage("Run Automation Test"){
            steps{
                echo("running automation test cases")
            }
        }
        stage("Deploy to stage"){
            steps{
                echo("deploy to stage")
            }
        }
        stage("Run Sanity Test"){
            steps{
                echo("run sanity test")
            }
        }
        stage("Deploy to prod"){
            steps{
                echo("deploy to prod")
            }
        }
    }
}