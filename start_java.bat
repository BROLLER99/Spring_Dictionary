rmdir target /S /Q
javac -encoding utf-8 -classpath ./src/main/resources/spring_lib/* -d ./target/classes -sourcepath ./src/main/java/com/dictionary ./src/main/java/com/dictionary/Main.java ./src/main/java/com/dictionary/config/*.java ./src/main/java/com/dictionary/console/*.java ./src/main/java/com/dictionary/console/commands/*.java ./src/main/java/com/dictionary/DAO/*.java ./src/main/java/com/dictionary/exeption/*.java ./src/main/java/com/dictionary/Model/*.java  
xcopy "./src/main/resources" "./target/classes" /E /Y
java -Dfile.encoding=UTF-8 -Ddictionary.type=qwe -cp "./src/main/resources/spring_lib/*";./target/classes com.dictionary.Main
pause