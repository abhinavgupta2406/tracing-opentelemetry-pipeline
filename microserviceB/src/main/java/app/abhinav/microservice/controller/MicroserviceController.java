package app.abhinav.microservice.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MicroserviceController {
    private static final Logger LOG = LogManager.getLogger(MicroserviceController.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${serviceC.url}")
    private String serviceCUrl;

    @GetMapping(value="/")
    public ResponseEntity<List> callC() {
        LOG.info("Inside callC()");
        return restTemplate.getForEntity(serviceCUrl, List.class);
    }
}
