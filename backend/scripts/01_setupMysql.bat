set mysql="C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql"
%mysql% --user=root   --password=root < mysqlCreateUser.sql
%mysql% --user=projapp --password=projappPass < mysqlSetupDb.sql
pause
