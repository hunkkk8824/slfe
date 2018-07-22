package com.selfwork.intelligence.model.vo;

import com.selfwork.intelligence.model.vo.dateset.LocationDto;

import java.util.List;

public class AirwayDataReq {


    private List<AirwayLocationData> points;

    public List<AirwayLocationData> getPoints() {
        return points;
    }

    public void setPoints(List<AirwayLocationData> points) {
        this.points = points;
    }
}
