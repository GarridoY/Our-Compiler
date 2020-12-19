# Our Compiler
A programming language for arduino controllers, using UPPAAL for time verification.

## Running the compiler:
If the first argument doesn't start with a "-", it will be used as the input file path.

|Flag|Arguments|Description|
|---------|-----|-----------|
| `-i` `-input`        |path| Specify an input .our file.|
| `-o` `-output`       |path| Specify an output .ino file.|
| `-u` `-up` `-uppaal` |path| Specify the UPPAAL directory.|
| `-model`             |path| Specify custom queries .q file.|
| `-query`             |path| Specify custom model of I/O as UPPAAL .xml file.|
| `-check` `-verify`   |-   | Verify the generated UPPAAL model.|
| `-pp` `-prettyprint` |-   | Print out the parsed Our code in the terminal.|
| `-p` `-print`        |-   | Print the generated arduino code in the terminal.|
| `-h` `-help`         |-   | Display help.|