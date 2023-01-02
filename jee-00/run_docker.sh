#!/bin/bash
set -e

mvn package


# Java EE 7 servers
docker run --rm --name appsvr -p 80:8080 -v $(pwd)/target/jee-00.war:/opt/jboss/wildfly/standalone/deployments/jee-00.war jboss/wildfly:10.1.0.Final /opt/jboss/wildfly/bin/standalone.sh --server-config=standalone-full.xml -b "0.0.0.0"
#docker run --rm --name appsvr -p 80:9080 -p 443:9443 -v $(pwd)/target/app.war:/config/dropins/app.war websphere-liberty:javaee7
#docker run --rm --name appsvr -p 9060:9060 -p 80:9080 -p 7777:7777 -v $(pwd)/target/app.war:/opt/IBM/WebSphere/AppServer/profiles/AppSrv01/monitoredDeployableApps/servers/server1/app.war 38leinad/websphere-9
#docker run --rm --name appsvr -p 80:8080 -v $(pwd)/target/app.war:/usr/local/tomee/webapps/app.war tomee:8-jre-7.0.4-plume

# Java EE 8 servers
#docker run --rm --name appsvr -p 80:8080 -v $(pwd)/target/app.war:/opt/jboss/wildfly/standalone/deployments/app.war jboss/wildfly:13.0.0.Final /opt/jboss/wildfly/bin/standalone.sh --server-config=standalone-full.xml -b "0.0.0.0" -Dee8.preview.mode=true
#docker run --rm --name appsvr -p 80:8080 -v $(pwd)/target/app.war:/glassfish5/glassfish/domains/domain1/autodeploy/app.war oracle/glassfish:5.0
#docker run --rm --name appsvr -p 80:8080 -v $(pwd)/target/app.war:/opt/payara5/glassfish/domains/domain1/autodeploy/app.war payara/server-full:5-SNAPSHOT