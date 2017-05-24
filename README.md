"# audio_dsp" 

In order to build this, the TarsosDSP jar must be available to Maven.
To install the jar in your local repository, do the following:

mvn install:install-file -Dfile=lib/TarsosDSP-latest.jar -DgroupId=be.tarsos.dsp \
    -DartifactId=tarsosDSP -Dversion=2.4 -Dpackaging=jar
    
Otherwise, stick the file (provided in the lib folder) in nexus or similar.