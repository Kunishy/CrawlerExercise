package com.example.Crawler.controller;

import com.example.Crawler.model.KeelungSightsCrawler;
import com.example.Crawler.model.Sight;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/SightAPI")
public class CrawlerController {

    @GetMapping
    public ResponseEntity<List<Sight>> byQuery(@RequestParam("zone") String zone) {
        Sight[] sights = new KeelungSightsCrawler().getItems(zone);
        if (sights.length == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Arrays.asList(sights));
    }
}
