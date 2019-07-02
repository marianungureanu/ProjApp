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
echo Creating %FRONT_DOMAIN%
rem @call %GF_DIR%\bin\asadmin.bat create-domain --portbase %FRONT_PORTBASE% %FRONT_DOMAIN%
echo Creating %BACK_DOMAIN%
@call %GF_DIR%\bin\asadmin.bat create-domain --portbase %BACK_PORTBASE% %BACK_DOMAIN%
xcopy mysql-connector-java-8.0.11.jar  %GF_DIR%\glassfish\domains\%BACK_DOMAIN%\lib\ext\
if not exist %GF_DIR%\glassfish\domains\%BACK_DOMAIN%\lib\ext\mysql-connector-java*.jar (
    echo "   Error. Mysql connector has to be copied to %BACK_DOMAIN%\lib\ext\"
	exit /b
)

@call %GF_DIR%\bin\asadmin.bat start-domain %BACK_DOMAIN%
@call %GF_DIR%\bin\asadmin.bat --port %BACK_ADMINPORT% --user admin create-jdbc-connection-pool ^
--driverclassname=com.mysql.cj.jdbc.Driver ^
--restype java.sql.Driver ^
--steadypoolsize 18  ^
--maxpoolsize 32  ^
--maxwait 60000 ^
--poolresize 2  ^
--idletimeout 300  ^
--isolationlevel read-committed ^
--isisolationguaranteed  ^
--isconnectvalidatereq=true  ^
--validationmethod auto-commit  ^
--failconnection=true  ^
--description projappConnectionPool  ^
--property user=%MYSQL_USER%:password=%MYSQL_PASS%:URL=jdbc\:mysql\://localhost\:3306/%MYSQL_DB%:useSSL=false ^
projappJdbcPool 

@call %GF_DIR%\bin\asadmin.bat --port %BACK_ADMINPORT% --user admin  create-jdbc-resource  ^
--connectionpoolid projappJdbcPool ^
projappJdbcResource

@call %GF_DIR%\bin\asadmin.bat --port %BACK_ADMINPORT% --user admin  create-jvm-options -Dcom.sun.jersey.server.impl.cdi.lookupExtensionInBeanManager=true
@call %GF_DIR%\bin\asadmin.bat --port %BACK_ADMINPORT% --user admin  list-jvm-options 

@call %GF_DIR%\bin\asadmin.bat stop-domain %BACK_DOMAIN%
pause