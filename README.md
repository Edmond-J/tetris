# <font color=mediumaquamarine>Tetris </font>
## Introduction:
This is a simple Tetris game I built for fun. Just to practice the use of KeyFrame, TimeLine and enum class in JavaFX.  
It's incomplete, blocks can not be cleared and no collision detection.  

Find the executable application (tetris.exe) from Google Drive:  
[Edmond's Java Program Collection.zip (Windows)](https://drive.google.com/drive/folders/1ovLlyHeENMtQDsT5b9hJBcHwKPCrC6Mg?usp=sharing)

## Snapshot
<img src="screenshot/ui-1.png" width="200px"> 

## Hot Keys
**Left/Right**: move left or right  
**Space**: rotate  
**Down**: drop instantly

## Features
- Blocks rotate in clockwise


## Tech Stack 
| Type | Name |
| ----------- | ----------- 
| Programming Language | Java |
| GUI Library | Java FX |
| GUI Tool | Scene Builder|

## Run Instruction
### Requirement:
- Java Runtime Environment
- Java FX
### Steps:   
To run the source code in development environment, please follow the steps below:
1. Clone the repository from the GitHub  
2. Add JavaFX to Build Path
3. Add the VM arguments to the run configure:  
`--module-path "<PATH TO YOUR JavaFX/lib>" --add-modules javafx.controls,javafx.fxml`
4. Run the *TetrisFx_Main.java* in the default package.

## License
MIT