package com.berduchev.springprogectfirst.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String brend;
    public String model;
    public String fuel;
    public int quantity;

    @JsonIgnore
    @OneToMany(mappedBy = "car")
    private List<Sale> saleList;
}
