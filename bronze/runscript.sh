
#!bin/bash
echo File: 
read filename
javac -d bin src/$filename.java

if [ -f "bin/$filename.class" ]; then
    cp "bin/$filename.class" $filename.class
    java $filename
    rm $filename.class
fi
