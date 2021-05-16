rmdir out /s /q
mkdir out
cd src/main
javac -d ../../out com/imc/paperrockscissors/*.java
cd ../../out
jar cvfe PRSGame.jar com.imc.paperrockscissors.PaperRockScissors com/imc/paperrockscissors/*
java -jar PRSGame.jar
cd ../