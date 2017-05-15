package com.dreamworks.corps.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by mmonti on 5/14/17.
 */
@RestController
public class ServiceTwo {

    @RequestMapping(value = "/service/two/{name}", method = RequestMethod.GET)
    public ResponseEntity sample(@PathVariable String name) {
        return ResponseEntity.ok(new HashMap(){{
            put("name", name);
        }});
    }

}
