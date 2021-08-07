FROM openjdk:8

MAINTAINER Piotr Ziecina <pziecin@gmail.com>

COPY out/production/RPSgame/ /tmp

WORKDIR /tmp

EXPOSE 8001

CMD java com.pziecin.Main