package com.edulluminate.school_service.country;

import jakarta.persistence.*;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(name = "alpha_2")
    private String alpha2;
    @Column(name = "alpha_3")
    private String alpha3;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "iso_3166_2")
    private String iso31662;
    private String region;

    @Column(name = "sub_region")
    private String subRegion;

    @Column(name = "intermediate_region")
    private String intermediateRegion;

    @Column(name = "region_code")
    private String regionCode;

    @Column(name = "sub_region_code")
    private String subRegionCode;

    @Column(name = "intermediate_region_code")
    private String intermediateRegionCode;

    public Country() {
    }

    public Country(Integer id, String name, String alpha2, String alpha3, String countryCode, String iso31662, String region, String subRegion, String intermediateRegion, String regionCode, String subRegionCode, String intermediateRegionCode) {
        this.id = id;
        this.name = name;
        this.alpha2 = alpha2;
        this.alpha3 = alpha3;
        this.countryCode = countryCode;
        this.iso31662 = iso31662;
        this.region = region;
        this.subRegion = subRegion;
        this.intermediateRegion = intermediateRegion;
        this.regionCode = regionCode;
        this.subRegionCode = subRegionCode;
        this.intermediateRegionCode = intermediateRegionCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    public String getAlpha3() {
        return alpha3;
    }

    public void setAlpha3(String alpha3) {
        this.alpha3 = alpha3;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getIso31662() {
        return iso31662;
    }

    public void setIso31662(String iso31662) {
        this.iso31662 = iso31662;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubRegion() {
        return subRegion;
    }

    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion;
    }

    public String getIntermediateRegion() {
        return intermediateRegion;
    }

    public void setIntermediateRegion(String intermediateRegion) {
        this.intermediateRegion = intermediateRegion;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getSubRegionCode() {
        return subRegionCode;
    }

    public void setSubRegionCode(String subRegionCode) {
        this.subRegionCode = subRegionCode;
    }

    public String getIntermediateRegionCode() {
        return intermediateRegionCode;
    }

    public void setIntermediateRegionCode(String intermediateRegionCode) {
        this.intermediateRegionCode = intermediateRegionCode;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alpha2='" + alpha2 + '\'' +
                ", alpha3='" + alpha3 + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", iso31662='" + iso31662 + '\'' +
                ", region='" + region + '\'' +
                ", subRegion='" + subRegion + '\'' +
                ", intermediateRegion='" + intermediateRegion + '\'' +
                ", regionCode='" + regionCode + '\'' +
                ", subRegionCode='" + subRegionCode + '\'' +
                ", intermediateRegionCode='" + intermediateRegionCode + '\'' +
                '}';
    }
}
