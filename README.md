# ProjApp
Aplicatie pentru identificarea aplicatiilor si dezvoltatorilor

DB: projapp
Tabele:
    level (id, name)
    role (id, name) 
    technology (id,name)
    employee (id, name)
	employeetechnology (id, idemployee, idtechnology)
    application (id ,name, description )
	applicationrole (id, idapplication, idrole)
	applicationrolestechonologies (id, idapplicationrole, idtechonology, idlevelmin)
	subscription (id, status, idemployee, idapplicationrole)

Tools: 
  https://download.java.net/glassfish/4.1.2/release/glassfish-4.1.2.zip
  https://download.netbeans.org/netbeans/8.2/final/bundles/netbeans-8.2-windows.exe
  https://cdn.mysql.com//Downloads/MySQL-8.0/mysql-8.0.16-winx64.zip
  http://mirrors.hostingromania.ro/apache.org/maven/maven-3/3.6.1/binaries/apache-maven-3.6.1-bin.tar.gz
  
Issue: 
  java.lang.ClassNotFoundException: javax.xml.parsers.ParserConfigurationException not found by org.eclipse.persistence.moxy 
  https://bugs.eclipse.org/bugs/show_bug.cgi?id=463169
  Solution: update moxy in glassfish

