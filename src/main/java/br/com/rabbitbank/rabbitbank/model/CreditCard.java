package br.com.rabbitbank.rabbitbank.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard extends BaseId {
    @Column(name = "CC_NUMBER")
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "CC_FLAG")
    private CreditCardFlag flag;

    @Column(name = "CC_TOKEN")
    private String tokenNumber;

    @JoinColumn(name = "CC_USER_ID", nullable = false)
    @ManyToOne(cascade = { CascadeType.MERGE} )
    private User user;

}
