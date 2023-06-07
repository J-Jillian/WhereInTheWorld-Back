package com.Final.WhereInTheWorld.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Visited {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cityName;
    private Integer timesVisited;

    @ManyToOne
    private Country country;
}
