package br.com.rabbitbank.rabbitbank.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USERS")
public class User extends BaseId {

    @Column(name = "U_NAME", nullable = false)
    private String name;

    @Column(name = "U_PASSWORD", nullable = false)
    private String password;

    @Column(name = "U_EMAIL", nullable = false)
    private String email;

    @Column(name = "U_FULLNAME", nullable = false)
    private String fullName;

    @Column(name = "U_CPF", nullable = false)
    private String cpf;

    @Column(name = "U_BIRTHDATE", nullable = false)
    private LocalDate birthDate;

    @Column(name = "U_CREDITCARD", nullable = false)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.MERGE,  orphanRemoval = true)
    private List<CreditCard> creditCard;

    @Column(name = "U_BALANCE", nullable = false)
    private Double balance;

    @Column(name = "U_ACTIVE", nullable = false)
    private Boolean active;

    @Enumerated(EnumType.STRING)
    @Column(name = "USU_PERMISSION", nullable = false)
    private PermissionType permissionType;



}
