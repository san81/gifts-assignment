
set WORKING_DIR=.

IF "%1" == "GUI" set PROGRAM_EXECUTE="giftsmaker.latest.StartGUI"

IF NOT "%1" == "GUI" set PROGRAM_EXECUTE="giftsmaker.latest.StartMenu"

cd bin

java %PROGRAM_EXECUTE%

cd ..