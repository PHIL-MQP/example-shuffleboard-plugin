# How to use

  - build this plugin and copy (or use symlink) the jar file to ~/Shuffleboard/plugins

    ./gradlew build
    cp build/libs/example-shuffleboard-plugin-1.0-SNAPSHOT.jar ~/Shuffleboard/plugins

  - run OutlineViewer in server mode (default params)

    java -jar ~/wpilib/tools/OutlineViewer.jar

  - run phil_main

    cd cpp/build
    make phil_main
    ./phil_main

  - run shuffleboard and see our plugin!

    java -jar ~/wpilib/tools/Shuffleboard.jar

