#!/bin/bash

echo "stop Telegram service"
podman stop parisjug-wanaku-tool-service-telegram-1
podman rm parisjug-wanaku-tool-service-telegram-1


echo "stop Kafka service"
podman stop parisjug-wanaku-tool-service-kafka-1
podman rm parisjug-wanaku-tool-service-kafka-1

echo "stop Tavily service"
podman stop parisjug-wanaku-tool-service-tavily-1
podman rm parisjug-wanaku-tool-service-tavily-1

echo "stop HTTP service"
podman stop parisjug-wanaku-tool-service-http-1
podman rm parisjug-wanaku-tool-service-http-1


echo "stop Wanaku Router"
podman stop parisjug-wanaku-router-1
podman rm parisjug-wanaku-router-1