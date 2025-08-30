@ECHO OFF

SET code=%1
SET tcPath=""

IF "%code%" == "" (
	SET tcPath=%cd%
) ELSE (
	for /f "delims=" %%a in ('where %code%') do (
	    SET tcPath=%%a
	)
)

TOTALCMD64.EXE /O /T /R="%tcPath%"
