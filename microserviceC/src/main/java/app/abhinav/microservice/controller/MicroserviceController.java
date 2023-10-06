package app.abhinav.microservice.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class MicroserviceController {
    private static final Logger LOG = LogManager.getLogger(MicroserviceController.class);

    @GetMapping(value="/")
    public ResponseEntity<List<String>> respond() {
        LOG.info("Inside callC()");
        return new ResponseEntity<List<String>>(Arrays.asList("Hello", "World"), HttpStatus.OK);
    }
}
