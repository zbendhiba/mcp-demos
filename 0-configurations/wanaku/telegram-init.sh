#!/bin/bash
echo "Configure telegram tool set the Auth Token"
wanaku targets tools configure --service=telegram --option=authorizationToken --value=$TELEGRAM_AUTHORIZATION_TOKEN --host http://localhost:8085
echo "Configure telegram tool set the Telegram ID of the default user"
wanaku targets tools configure --service=telegram  --option=telegramId --value=$TELEGRAM_CHAT_ID --host http://localhost:8085
echo "Start telegram tool"
wanaku tools add  --name telegram --uri "telegram://send-message" --description 'Sends a message to the customer' --property 'message:string, the message to send to the customer'  --required=message --type telegram --host http://localhost:8085


echo "********** List targets *********"
wanaku targets tools list --host http://localhost:8085

echo "********** List tools *********"
wanaku tools list --host http://localhost:8085