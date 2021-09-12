package br.com.rabbitbank.rabbitbank.model;

import br.com.rabbitbank.rabbitbank.enums.PermissionType;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USERS")
public class User extends BaseId implements UserDetails {

    @Column(name = "U_NAME", nullable = false)
    private String login;

    @Column(name = "U_PASSWORD", nullable = false)
    private String password_db;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> permissionTypeList = Arrays.asList(new SimpleGrantedAuthority(permissionType.getCode()));
        return permissionTypeList;
    }

    @Override
    public String getPassword() {
        return password_db;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
