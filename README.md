# ideas

Ideas project is a place to explore GitOps using a semi-realistic project that can be built upon over time.

## Useful links and documentatios

[GitOps - KH](https://www.youtube.com/watch?v=yIAa5wHsfw4) \
[GitOps - Weaveworks](https://www.youtube.com/watch?v=Mr_mbwsRDBI) \
[Kubernetes](https://kubernetes.io/) \
[Docker](https://www.docker.com/get-started) \
[SpringBoot](https://spring.io/projects/spring-boot) \
[Kubernetes the hard-way - Kelsey Hightower](https://github.com/kelseyhightower/kubernetes-the-hard-way)

## Building JAR for Docker

Building JAR using Maven, to this run the following command;

`mvn verify`

This will produce a JAR for the service

## Docker

Build Image

`docker build --tag <image-name>:<version>`

Run Image - expose port

`docker run -d -p 81:9090 <image-name>:<version>`

## Advantages of using this method

We can quickly setup automation test suite to run against a particular version, if we have a new version to be deployed we can create a new build and then deploy a new version to run a full regression quickly.

Developers van also use the images to quickly run and test locally.