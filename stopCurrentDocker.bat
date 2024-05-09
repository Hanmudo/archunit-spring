@echo off
rem This will read the content of containerhash.txt into a variable
for /f "tokens=* delims=" %%i in (containerhash.txt) do set "value=%%i"
echo %value%
rem This will stop a runner docker container
docker stop %value%
rem This will remove the docker container
docker container rm %value%
rem This will remove containerhash.txt
del containerhash.txt