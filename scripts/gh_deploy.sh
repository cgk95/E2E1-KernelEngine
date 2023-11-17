#!/bin/bash
PROJECT_NAME="KernelEngine"
JAR_PATH="/home/ubuntu/${PROJECT_NAME}/build/libs"
DEPLOY_PATH="/home/ubuntu/${PROJECT_NAME}"
DEPLOY_LOG_PATH="/home/ubuntu/${PROJECT_NAME}/deploy.log"
DEPLOY_ERR_LOG_PATH="/home/ubuntu/${PROJECT_NAME}/deploy_err.log"
APPLICATION_LOG_PATH="/home/ubuntu/${PROJECT_NAME}/application.log"
BUILD_JAR=$(ls $JAR_PATH | grep 'SNAPSHOT.jar' | tail -n 1)
JAR_NAME=$(basename $BUILD_JAR)

echo "===== 배포 시작 : $(date +%c) =====" >> $DEPLOY_LOG_PATH

echo "> build 파일명: $JAR_NAME" >> $DEPLOY_LOG_PATH
echo "> build 파일 복사" >> $DEPLOY_LOG_PATH
cp $BUILD_JAR $DEPLOY_PATH

echo "> 현재 구동중인 애플리케이션 pid 확인" >> $DEPLOY_LOG_PATH
CURRENT_PID=$(pgrep -f $JAR_NAME)

if [ -z $CURRENT_PID ]
then
  echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다." >> $DEPLOY_LOG_PATH
else
  echo "> 현재 동작중인 어플리케이션이 존재합니다" >> $DEPLOY_LOG_PATH
  echo "> 동작중인 어플리케이션 강제 종료 진행" >> $DEPLOY_LOG_PATH
  echo "> kill -9 $CURRENT_PID" >> $DEPLOY_LOG_PATH
  kill -9 $CURRENT_PID
fi

DEPLOY_JAR=$DEPLOY_PATH$JAR_NAME
echo "> $DEPLOY_JAR 실행" >> $DEPLOY_LOG_PATH
nohup java -jar -Dspring.profiles.active=local $DEPLOY_JAR --server.port=8080 >> $APPLICATION_LOG_PATH 2> $DEPLOY_ERR_LOG_PATH &

sleep 3

echo "> 배포 종료 : $(date +%c) =====" >> $DEPLOY_LOG_PATH

