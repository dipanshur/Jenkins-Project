pipeline {
    agent any
      
               
       stages {
            stage('SCM checkout') {
                  steps {
                        git branch: "main", credentialsId: 'ec9d1622-c58d-48ad-aeec-153dab51626e', url: 'https://github.com/dipanshur/Jenkins-Project.git'
                        }
             }
             
              
              stage('transfer artifacts') {
                    steps {
                          sshPublisher(publishers: [sshPublisherDesc(configName: 'webserver', transfers: [sshTransfer(excludes: '', execCommand: '', execTimeout: 120000, flatten: true, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/www/html', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '**/*')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: true)])
                          }
              }
       }
}