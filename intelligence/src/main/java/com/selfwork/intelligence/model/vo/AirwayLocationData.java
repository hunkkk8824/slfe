package com.selfwork.intelligence.model.vo;

import com.selfwork.intelligence.model.vo.dateset.LocationDto;

import java.math.BigDecimal;
import java.util.List;

public class AirwayLocationData {

    private BigDecimal longitude;
    private BigDecimal latitude;

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
}
