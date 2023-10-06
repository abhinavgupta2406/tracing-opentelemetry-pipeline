# Tracing Pipeline with OpenTelemetry

## Helm Charts
1. [Zipkin](https://github.com/openzipkin/zipkin/tree/2.24.3/charts/zipkin)
2. [OpenTelemetry Collector](https://github.com/open-telemetry/opentelemetry-helm-charts/tree/opentelemetry-collector-0.69.2)

## Steps
1. Zipkin
    1. Go to the folder: `./helm-charts/vendor/zipkin`
    1. Run `helm install zipkin .`
    1. Port forward `kubectl port-forward svc/zipkin 9411:9411`
2. OpenTelemetry Collector - Gateway
    1. Create namespace `tracing`
    1. Go to the folder: `./helm-charts`
    1. Setup `opentelemetry-collector`: `helm install opentelemetry-collector ./vendor/opentelemetry-collector -f ./otelcol-collector-values.yaml`
3. OpenTelemetry Collector - LoadBalancer
    1. Go to the folder: `./helm-charts`
    1. Setup `opentelemetry-loadbalancer`: `helm install opentelemetry-loadbalancer ./vendor/opentelemetry-collector -f ./otelcol-loadbalancer-values.yaml`
4. Microservice A
    1. Go to the folder: `./helm-charts`
    1. Run `helm install microservice-a ./custom/microservice -f ./microserviceA-values.yaml`
5. Microservice B
   1. Go to the folder: `./helm-charts`
   1. Run `helm install microservice-b ./custom/microservice -f ./microserviceB-values.yaml`
6. Microservice C
   1. Go to the folder: `./helm-charts`
   1. Run `helm install microservice-c ./custom/microservice -f ./microserviceC-values.yaml`