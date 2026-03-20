package com.myfipe.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DadosDTO {

    @JsonProperty("vehicleType")
    private Integer vhType;
    @JsonProperty("price")
    private String vhPrice;
    @JsonProperty("brand")
    private String vhBrand;
    @JsonProperty("model")
    private String vhModel;
    @JsonProperty("modelYear")
    private String mdYear;
    @JsonProperty("fuel")
    private String fuType;
    @JsonProperty("codeFipe")
    private String cdFipe;
    @JsonProperty("referenceMonth")
    private String reMonth;
    @JsonProperty("fuelAcronym")
    private String fuAcronym;

    public Integer getVhType() {
        return vhType;
    }

    public String getVhPrice() {
        return vhPrice;
    }

    public String getVhBrand() {
        return vhBrand;
    }

    public String getVhModel() {
        return vhModel;
    }

    public String getFuType() {
        return fuType;
    }

    public String getCdFipe() {
        return cdFipe;
    }

    public String getFuAcronym() {
        return fuAcronym;
    }

    public String getReMonth() {
        return reMonth;
    }

    public String getMdYear() {
        return mdYear;
    }
}
