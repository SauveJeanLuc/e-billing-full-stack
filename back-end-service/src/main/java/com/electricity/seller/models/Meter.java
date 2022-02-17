package com.electricity.seller.models;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "meters")
public class Meter {

    @Id
    @Column(name = "id")
    private Long id;


    @Max(6)
    @Min(6)
    @Column(name = "meter_number", nullable = false, unique = true)
    private Integer meterNumber;

}

