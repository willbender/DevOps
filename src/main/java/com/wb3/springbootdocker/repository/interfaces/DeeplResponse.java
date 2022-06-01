package com.wb3.springbootdocker.repository.interfaces;

import java.util.List;

import lombok.Data;

@Data
public class DeeplResponse {

	private List<TranslationResponse> translations;

}