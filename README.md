In order to run the Server side only from Docker follow are the steps:
1) Go to project directory
2) Verify the DockerFile exist  ( java 11)
3) Run command : >docker build -t springio/gs-spring-boot-docker .
4) run docker image ls
5) Verify image named : 'springio/gs-spring-boot-docker' exist
6) Run tomcat from docker as : ' docker run -p 8080:8080 springio/gs-spring-boot-docker'
7) Verify port 8080 is listening by : http://localhost:8080/SecuredTouch/rest/v2/counters