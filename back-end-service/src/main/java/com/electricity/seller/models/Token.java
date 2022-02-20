package com.electricity.seller.models;

import com.electricity.seller.enums.ETokenStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Max(99999999)
    @Min(10000000)
    @Column(name = "value", nullable = false, unique = true)
    private Integer value;

    @Column(name = "duration", nullable = false, unique = true)
    private Integer duration;

    @Column(name = "amount_payed", nullable = false, unique = true)
    private Integer amountPayed;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ETokenStatus status = ETokenStatus.USED;

    @ManyToOne
    @JoinColumn(name = "meter_id")
    private Meter meter;

}