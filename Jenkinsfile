@Library('ceiba-jenkins-library') _
pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK8_Centos' //Versión preinstalada en la Configuración del Master
  }

  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout scm
      }
    }

    stage('Compile & Unit Tests') {
      steps{
        echo "------------>Compile & Unit Tests<------------"
        sh 'chmod +x ./microservicio/gradlew'
        sh './microservicio/gradlew --b ./microservicio/build.gradle clean'
        sh './microservicio/gradlew --b ./microservicio/build.gradle test'
      }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
        sonarqubeMasQualityGatesP(sonarKey:'co.com.ceiba.adn:darwin.pagos-administracion.galindez',
            sonarName:'CeibaADN-PagosAdministracion-darwin.galindez',
            sonarPathProperties:'./sonar-project.properties')
      }
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
        sh 'chmod +x ./microservicio/gradlew'
        sh './microservicio/gradlew --b ./microservicio/build.gradle clean'
        sh './microservicio/gradlew --b ./microservicio/build.gradle build -x test'
      }
    }
  }

  post {
    success {
      echo 'This will run only if successful'
      // junit 'build/test-results/test/*.xml' //RUTA RELATIVA DE LOS ARCHIVOS .XML
    }
    failure {
      echo 'This will run only if failed'
      mail (to: 'darwin.galindez@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
    }
  }
}
