/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amit.sholoklogistics.model;

/**
 *
 * @author Amit
 */
public class RequestModel {

    private Integer id;
    private String departureCity;
    private String deliveryCity;
    private double weight;
    private String dimensions;
    private String name;
    private String email;
    private String phone;
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RequestModel(Integer id, String departureCity, String deliveryCity, double weight, String dimensions, String name, String email, String phone, String message) {
        this.id = id;
        this.departureCity = departureCity;
        this.deliveryCity = deliveryCity;
        this.weight = weight;
        this.dimensions = dimensions;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.message = message;
    }

    public RequestModel() {
    }

    @Override
    public String toString() {
        return "request{" + "id=" + id + ", departureCity=" + departureCity + ", deliveryCity=" + deliveryCity + ", weight=" + weight + ", dimensions=" + dimensions + ", name=" + name + ", email=" + email + ", phone=" + phone + ", message=" + message + '}';
    }
    
    

}
