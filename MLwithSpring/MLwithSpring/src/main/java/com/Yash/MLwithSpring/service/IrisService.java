package com.Yash.MLwithSpring.service;


import com.Yash.MLwithSpring.dto.PredictionRequest;
import com.Yash.MLwithSpring.dto.PredictionResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IrisService {

    // Replace this with your actual Flask URL
    private final String FLASK_URL = "https://mlwithspringboot.onrender.com/predict";

    public String predictFlower(double[] features) {
        // Build request
        PredictionRequest request = new PredictionRequest();
        request.setFeatures(features);

        // Setup headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PredictionRequest> entity = new HttpEntity<>(request, headers);

        // Call Flask API
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PredictionResponse> response = restTemplate.postForEntity(
                FLASK_URL, entity, PredictionResponse.class
        );

        int clazz = response.getBody().getClazz();

        return switch (clazz) {
            case 0 -> "Setosa";
            case 1 -> "Versicolor";
            case 2 -> "Virginica";
            default -> "Unknown";
        };
    }
}

