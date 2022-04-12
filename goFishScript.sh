#!/bin/bash

cd ./src
javac -d ./bin ./playGame/Game.java
java -cp bin playGame.Game
