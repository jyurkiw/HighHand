# HighHand
    EA Coding Test by Jeffrey Yurkiw
    jyurkiw@yahoo.com
    510-925-9623

## Poker Rules
* Ace is high.
* Ace low straight is not legal.
* Broken straights are not legal (Q-K-A-2-3 is not a legal straight).
* Jokers can be used to complete Straights, Flushes, and 5-of-a-kind.
* Jokers are not wild except in Straights, Flushes, and 5-of-a-kind.
* Jokers are otherwise a low card below a 2.

This program was written using IntelliJ Idea, and that is probably the easiest way to run the program and the tests. However...

## Compiling the Program from the Command Line:

* Navigate into the HighHand directory
* Create a class directory under HighHand
* Run: javac -d class src/com/jyurkiw/highhand/*.java src/com/jyurkiw/highhand/hands/*.java

## Running the Program from the Command Line:

* Navigate into the HighHand directory
* Run: java -cp class com.jyurkiw.highhand.Main [handCode #1] [handCode #2]

## Hand Codes

A hand code is a collection of five card codes delimited by colons (':').

An example of a hand code would be...
`5H:5C:4C:4H:4D` would be a full-house.

## Compiling the Tests from the Command Line:

* Navigate into the HighHand directory
* run javac -d class -cp 'lib/junit-jupiter-api-5.3.0-M1.jar;lib/junit-platform-commons-1.3.0-M1.jar;class' src/com/jyurkiw/test/highhand/*.java

## Running the Tests from the Command Line:

* Navigate into the HighHand directory
* Run: java -jar junit-platform-console-standalone-1.2.0.jar -cp class -p com.jyurkiw.test.highhand
