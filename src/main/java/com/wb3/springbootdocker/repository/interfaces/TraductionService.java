package com.wb3.springbootdocker.repository.interfaces;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TraductionService {

	public String translateText(String textToTranslate, String targetLanguage) {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> data = new HashMap<>();
		ResponseEntity<DeeplResponse> response = restTemplate.postForEntity(
				"https://api-free.deepl.com/v2/translate?auth_key=replace-deepl-auth-key&text=" + textToTranslate + "&target_lang=" + targetLanguage, data, DeeplResponse.class);
		return response.getBody().getTranslations().get(0).getText();
	}

}