# Microservice B

## Steps

1. Build microservice application: `mvn clean package`
2. Build Docker image: `docker build --tag=localhost:5000/service-b .`
3. Push Docker image: `docker push localhost:5000/service-b`