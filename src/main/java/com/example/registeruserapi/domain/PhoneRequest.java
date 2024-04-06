package com.example.registeruserapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PhoneRequest {
    @JsonProperty(value = "number")
    private String number;
    @JsonProperty(value = "citycode")
    private String citycode;
    @JsonProperty(value = "contrycode")
    private String contrycode;

}
