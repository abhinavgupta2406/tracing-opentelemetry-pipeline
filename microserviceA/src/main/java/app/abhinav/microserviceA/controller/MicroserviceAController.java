package app.abhinav.microserviceA.controller;

import brave.sampler.Sampler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MicroserviceAController {
    private static final Logger LOG = LogManager.getLogger(MicroserviceAController.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${serviceB.url}")
    private String serviceBUrl;

    @GetMapping(value="/")
    public ResponseEntity<List> callB() {
        LOG.info("Inside callB()");

        return restTemplate.getForEntity(serviceBUrl, List.class);
    }
}
