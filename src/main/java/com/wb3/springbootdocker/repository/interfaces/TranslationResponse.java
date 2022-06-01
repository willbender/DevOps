package com.wb3.springbootdocker.repository.interfaces;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class TranslationResponse {

	@JsonAlias("detected_source_language")
	private String detectedSourceLanguage;

	private String text;

}