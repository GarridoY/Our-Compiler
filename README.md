# Our Compiler
A programming language for arduino controllers, using UPPAAL for time verification.

## Running the compiler:
If the first argument doesn't start with a "-", it will be used as the input file path.

|Flag|Arguments|Description|
|---------|-----|-----------|
| `-i` `-input`        |path| Specify an input .our file.|
| `-o` `-output`       |path| Specify an output .ino file.|
| `-u` `-up` `-uppaal` |path| Specify the UPPAAL directory.|
| `-pp` `-prettyprint` |-   | Print out the parsed Our code.|
| `-check` `-verify`   |-   | Verify the generated UPPAAL model.|
| `-p` `-print`        |-   | Print the generated arduino code.|
| `-h` `-help`         |-   | Display help.|