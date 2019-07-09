@echo off

set GF_DIR=C:\servers\glassfish4

set FRONT_DOMAIN=projapp_front
set /a FRONT_PORTBASE=5000
set /a FRONT_ADMINPORT=%FRONT_PORTBASE% + 48

set BACK_DOMAIN=projapp_back
set /a BACK_PORTBASE=6000
set /a BACK_ADMINPORT=%BACK_PORTBASE% + 48
set MYSQL_USER=projapp
set MYSQL_PASS=projappPass
set MYSQL_DB=projappdb

@call %GF_DIR%\bin\asadmin.bat --port %BACK_ADMINPORT% --user admin create-jdbc-connection-pool ^
--datasourceclassname com.mysql.cj.jdbc.MysqlDataSource ^
--restype javax.sql.DataSource ^
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
--property user=%MYSQL_USER%:password=%MYSQL_PASS%:URL=jdbc\:mysql\://localhost\:3306/%MYSQL_DB%:useSSL=false:serverTimezone=UTC ^
projappJdbcPool 

@call %GF_DIR%\bin\asadmin.bat --port %BACK_ADMINPORT% --user admin  create-jdbc-resource  ^
--connectionpoolid projappJdbcPool ^
projappJdbcResource

@call %GF_DIR%\bin\asadmin.bat --port %BACK_ADMINPORT% --user admin  create-jvm-options -Dcom.sun.jersey.server.impl.cdi.lookupExtensionInBeanManager=true
@call %GF_DIR%\bin\asadmin.bat --port %BACK_ADMINPORT% --user admin  list-jvm-options 

pause


