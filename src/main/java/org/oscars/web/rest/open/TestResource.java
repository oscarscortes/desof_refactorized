package org.oscars.web.rest.open;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/public/tests")
public class TestResource {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public ResponseEntity<?> test() {
        log.info("************************");
        log.info("ZoneId Default: " + ZoneId.systemDefault());
        log.info("ZonedDateTime Default: " + ZonedDateTime.now());
        log.info("Offset: " + ZonedDateTime.now().getOffset());
        log.info("*************************");
        Map<String, String> response = new HashMap<>();
        response.put("ZoneId", ZoneId.systemDefault().toString());
        response.put("ZonedDateTime", ZonedDateTime.now().toString());
        response.put("Offset", ZonedDateTime.now().getOffset().toString());
        return ResponseEntity.ok(response);

    }

}
