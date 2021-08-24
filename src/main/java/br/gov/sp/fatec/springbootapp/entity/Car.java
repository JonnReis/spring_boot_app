package br.gov.sp.fatec.springbootapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "car_car")
public class Car {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;

    @Column(name = "car_model")
    private String model;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }    
    
}
