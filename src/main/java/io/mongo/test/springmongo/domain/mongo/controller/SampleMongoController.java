package io.mongo.test.springmongo.domain.mongo.controller;

import io.mongo.test.springmongo.domain.mongo.service.SampleMongoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleMongoController {
    private final SampleMongoService service;
}
