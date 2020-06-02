package com.example.coursework;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SatellitePosition {

    @SerializedName("satlatitude")
    @Expose
    private Double satlatitude;
    @SerializedName("satlongitude")
    @Expose
    private Double satlongitude;
    @SerializedName("sataltitude")
    @Expose
    private Double sataltitude;
    @SerializedName("azimuth")
    @Expose
    private Double azimuth;
    @SerializedName("elevation")
    @Expose
    private Double elevation;
    @SerializedName("ra")
    @Expose
    private Double ra;
    @SerializedName("dec")
    @Expose
    private Double dec;
    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;

    public Double getSatlatitude() {
        return satlatitude;
    }

    public void setSatlatitude(Double satlatitude) {
        this.satlatitude = satlatitude;
    }

    public Double getSatlongitude() {
        return satlongitude;
    }

    public void setSatlongitude(Double satlongitude) {
        this.satlongitude = satlongitude;
    }

    public Double getSataltitude() {
        return sataltitude;
    }

    public void setSataltitude(Double sataltitude) {
        this.sataltitude = sataltitude;
    }

    public Double getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(Double azimuth) {
        this.azimuth = azimuth;
    }

    public Double getElevation() {
        return elevation;
    }

    public void setElevation(Double elevation) {
        this.elevation = elevation;
    }

    public Double getRa() {
        return ra;
    }

    public void setRa(Double ra) {
        this.ra = ra;
    }

    public Double getDec() {
        return dec;
    }

    public void setDec(Double dec) {
        this.dec = dec;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

}