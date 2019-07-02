set GF_DIR=D:\practicaDeVara\glassfish4.1.2
set FRONT_DOMAIN=projapp_front
set BACK_DOMAIN=projapp_back

@call %GF_DIR%\bin\asadmin.bat stop-domain %FRONT_DOMAIN%

pause