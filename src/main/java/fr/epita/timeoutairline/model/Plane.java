package fr.epita.timeoutairline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "planes")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlane;

    private String brand;
    private String model;
    private int manufacturingYear;

    // Default constructor (required by JPA)
    public Plane() {
    }

    // Constructor with fields
    public Plane(String brand, String model, int manufacturingYear) {
        this.brand = brand;
        this.model = model;
        this.manufacturingYear = manufacturingYear;
    }

    // Getters and Setters
    public Long getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(Long idPlane) {
        this.idPlane = idPlane;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    } }
