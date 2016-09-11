# Berlin clock

##  Demo

![Demo](https://github.com/rumoku/berlin-clock/blob/master/berlin-clock.gif)

**Requirements**
Java 1.8+
SBT  0.13+

**Run from SBT**
Execute `sbt run` command from sbt to run demo. It will output some random time sequence to show how Berlin clock works.
Execute `sbt "run -color"` - output Berlin clock time within color support. Note some terminals does not support this option.

**Run from package**
Go to release folder and execute:
for windows: 
    `java -classpath berlin-clock_2.11-0.1.jar;scala-library-2.11.8.jar org.rumoku.bc.BcDemo -color`
linux/macos: 
    `java -classpath berlin-clock_2.11-0.1.jar:scala-library-2.11.8.jar org.rumoku.bc.BcDemo -color`

Note: program can be interrupted by invoking: `Ctrl+C`

## Description

Berlin clock consist of 5 lines.

line 0: 1 yellow lamp in a middle - light every even second
line 1: 4 red lamps - 5 hours each
line 2: 4 red lamps - next 1 hour each
line 3: 5 minutes x 11 yellow and red lamps (3d, 6h, 9th are red)
line 4: 4 yellow lamps - next 1 minute each

### Representation

`#` - red
`+` - yellow
`o` - blank

### Example
```
  23:43:00

     +
  # # # o
  # # # o
++#++#++ooo
  + + + o
```
