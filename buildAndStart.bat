@echo off
rem This will build a docker image
docker build -t "archunit:1.0" .
rem This will run the image
docker run -p 8080:8080 -d "archunit:1.0" > containerhash.txt
for /f "tokens=* delims=" %%i in ('docker run -p 8080:8080 -d "archunit:1.0"') do set "value=%%i"
echo %value% > containerhash.txt
echo %value%