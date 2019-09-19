#!/bin/bash

mvn clean package
rm -rf $WILDFLY17/standalone/deployments/transacoes.war
cp target/transacoes.war $WILDFLY17/standalone/deployments/
/$WILDFLY17/bin/./standalone.sh &
