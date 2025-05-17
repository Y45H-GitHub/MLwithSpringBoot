package com.Yash.MLwithSpring.controller;


import com.Yash.MLwithSpring.dto.PredictionRequest;
import com.Yash.MLwithSpring.service.IrisService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class IrisController {

    private final IrisService irisService;

    public IrisController(IrisService irisService) {
        this.irisService = irisService;
    }

    @PostMapping("/predict")
    public String predict(@RequestBody PredictionRequest request) {
        return irisService.predictFlower(request.getFeatures());
    }
}
