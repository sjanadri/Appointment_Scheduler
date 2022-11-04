pipeline {
    agent { node { label 'epnm_LinuxDataCenter' } }
    options{timestamps()}    
    tools {
        maven "M3"
        jdk "amazon-corretto-8"
    }
    stages {
        stage('Initialize'){
            steps{
                echo "PATH = ${M2_HOME}/bin:${PATH}"
                echo "M2_HOME = ${M2_HOME}"
                dir("${WORKSPACE}/") {
                    sh 'mvn --version'
                }
                script{
                if(null==env.CHANGE_ID){
                    env.maven_action='deploy'
                    }
                    else{
                    env.maven_action='install'
                    }    
                }
            }
        }
        stage('Build') {
            steps {
                    dir("${WORKSPACE}/") {
                sh 'mvn -B -s ${HOME}/settings/settings.xml -f pom.xml clean $maven_action -U -e'
             //   step( [ $class: 'JacocoPublisher' ])
                }
            }
        }
     }
    post {
       always {
         junit testResults: '**/target/surefire-reports/TEST-*.xml'
         recordIssues(
          enabledForFailure: true, aggregatingResults: true, 
          tools: [java(), checkStyle(pattern: 'checkstyle-result.xml', reportEncoding: 'UTF-8')]
        )
         recordIssues enabledForFailure: true, tool: spotBugs()
         cleanWs()
      }
    } 
}
