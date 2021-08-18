package br.com.rabbitbank.rabbitbank.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "TRANSACTION")
public class Transaction extends BaseId{

    @Column(name = "T_CODE", nullable = false)
    private String code;

    @ManyToOne(cascade = { CascadeType.MERGE } )
    @JoinColumn(name = "T_ORIGIN", nullable = false)
    private User origin;

    @ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER )
    @JoinColumn(name = "T_DESTINY", nullable = false)
    private User destiny;

    @Column(name = "T_TIME", nullable = false)
    private LocalDate time;

    @Column(name = "T_VALUE", nullable = false)
    private Double value;
}
