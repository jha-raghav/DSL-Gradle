job ('Gradle Dsl Job'){
   description('This job is created for building the Gradle sample Project')
   scm{
     git ('https://github.com/jha-raghav/DSL-Gradle')
   }
   label('msbuild')
   triggers{
      scm('H/15 * * * *')
    }
   steps{
   	gradle 'assemble'
   }
   publishers{
      archiveArtifacts {
            pattern('build/libs/*.jar')
            onlyIfSuccessful(true)
        }
   }
}
