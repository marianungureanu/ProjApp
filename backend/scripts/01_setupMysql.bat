set mysql="C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql"
%mysql% -uroot -pYourPassword < .\mysqlCreateUser.sql
%mysql% -uprojapp -pprojappPass < .\mysqlSetupDb.sql
pause
