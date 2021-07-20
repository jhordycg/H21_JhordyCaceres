package dev.jhordycg.vg.hackaton21.backend.service;

import dev.jhordycg.vg.hackaton21.backend.model.BeeGenus;
import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author jhordycg
 */
@Service
public class GenusService {

    private static final String API_KEY = "608b0fc23609457b85ad4b25458b1dca";
    private static final String CONTENT_TYPE = "application/json";

    private static final String API = String.format(
            "https://h21jhorycaceres.cognitiveservices.azure.com/customvision/v3.0/Prediction/b412495d-8f78-4241-9bef-036bb3244002/classify/iterations/H1_JhordyCaceres/url?Content-Type=%s&Prediction-Key=%s",
            CONTENT_TYPE, API_KEY);
    private final RestTemplate template;

    public GenusService(RestTemplate template) {
        this.template = template;
    }

    public BeeGenus getPrediction(String url) {
        Map request = new HashMap<String, String>();
        request.put("url", url);
        
        Map<String,Object> result = template.postForObject(API, request, HashMap.class);
        List predictions = (List) result.get("predictions");
        Map<String,Object> prediction = (Map<String, Object>) predictions.get(0);

        BeeGenus beeGenus = new BeeGenus();
        beeGenus.setTagName((String) prediction.get("tagName"));
        beeGenus.setProbability((Double) prediction.get("probability"));

        return beeGenus;
    }
}