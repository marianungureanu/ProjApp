@echo off

set GF_DIR=D:\practicaDeVara\glassfish4.1.2

set FRONT_DOMAIN=projapp_front
set /a FRONT_PORTBASE=1000
set /a FRONT_ADMINPORT=%FRONT_PORTBASE% + 48

set BACK_DOMAIN=projapp_back
set /a BACK_PORTBASE=2000
set /a BACK_ADMINPORT=%BACK_PORTBASE% + 48
set MYSQL_USER=projapp
set MYSQL_PASS=projappPass
set MYSQL_DB=projappdb

@echo on
@call %GF_DIR%\bin\asadmin.bat --port %BACK_ADMINPORT% --user admin list-jvm-options -Dcom.sun.jersey.server.impl.cdi.lookupExtensionInBeanManager=true

pause