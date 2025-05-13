#!/bin/bash
echo "Start a tool for Tavily search"
wanaku tools add -n "tavily-search" --description "Search on the internet using Tavily" --uri "tavily://search" --type tavily --host http://localhost:8085

echo "Configure Kafka - request topic"
wanaku targets tools configure --service=kafka --option=requestTopic --value=wanaku-request-topic --host http://localhost:8085
echo "Configure  Kafka - response topic"
wanaku targets tools configure --service=kafka --option=replyToTopic --value=wanaku-response-topic --host http://localhost:8085
echo "Configure Kafka - bootstrapHost host"
wanaku targets tools configure --service=kafka --option=bootstrapHost --value=localhost:9092 --host http://localhost:8085
echo "start a tool for kafka"
wanaku tools add --name sushi-request --uri "kafka://sushi"  --description 'Orders the delivery of a an authentic Japanese sushi' --property 'wanaku_body:string,All the items you want in your sushi, written in plain text ' --required wanaku_body --type kafka --host http://localhost:8085

echo "start an HTTP tool"
wanaku tools add --name http --uri "http://hello"  --description 'Calls an HTTP endpoint' --property 'link:string,the http link' --required link --type http --host http://localhost:8085


echo "********** List targets *********"
wanaku targets tools list --host http://localhost:8085

echo "********** List tools *********"
wanaku tools list --host http://localhost:8085

