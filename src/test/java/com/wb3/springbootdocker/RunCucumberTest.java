package com.wb3.springbootdocker;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "com.wb3.springbootdocker" }, features = { "classpath:com/wb3/springbootdocker/Places.feature" })
public class RunCucumberTest {

}