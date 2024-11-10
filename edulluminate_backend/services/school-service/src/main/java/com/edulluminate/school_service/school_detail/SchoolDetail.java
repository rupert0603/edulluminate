package com.edulluminate.school_service.school_detail;

import jakarta.persistence.*;

@Entity
@Table(name = "school_detail")
public class SchoolDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String taxonomy;

    private String municipality;

    private String country;

    public SchoolDetail() {
    }

    public SchoolDetail(String name, String taxonomy, String municipality, String country) {
        this.name = name;
        this.taxonomy = taxonomy;
        this.municipality = municipality;
        this.country = country;
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

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "SchoolDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taxonomy='" + taxonomy + '\'' +
                ", municipality='" + municipality + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
