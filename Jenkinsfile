pipeline {
  agent any
  stages {
    stage("Build") {
      steps {
        git url: 'https://github.com/karimkassa/cv24v1.git'
        withMaven {
          sh "mvn clean verify"
        } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
      }
    }
  }
}
