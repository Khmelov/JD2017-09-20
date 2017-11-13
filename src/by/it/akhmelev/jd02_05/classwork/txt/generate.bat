FOR %%I In (*.txt) DO (

"C:\Program Files\Java\jdk1.7.0_80\bin\native2ascii.exe"
  -encoding utf-8 %%I ..\res\%%~nI.properties

)