package dev.jhordycg.vg.hackaton21.backend.controller;

import dev.jhordycg.vg.hackaton21.backend.model.BeeGenus;
import dev.jhordycg.vg.hackaton21.backend.service.GenusService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jhordycg
 */
@RestController
@RequestMapping("genus")
@CrossOrigin("*")
public class GenusController {

    GenusService service;

    public GenusController(GenusService service) {
        this.service = service;
    }

    @PostMapping
    public BeeGenus predict(@RequestBody String url) {
        return service.getPrediction(url);
    }

}