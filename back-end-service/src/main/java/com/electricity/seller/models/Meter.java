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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @Max(999999)
    @Min(100000)
    @Column(name = "meter_number", nullable = false, unique = true)
    private Integer meterNumber;

}

