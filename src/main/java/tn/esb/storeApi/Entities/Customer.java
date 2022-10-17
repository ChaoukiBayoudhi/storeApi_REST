package tn.esb.storeApi.Entities;

import lombok.*;
import org.springframework.lang.NonNull;
import tn.esb.storeApi.Enumerations.CustomerType;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @EqualsAndHashCode.Include
    private String firstName;
    @NonNull
    @EqualsAndHashCode.Include
    private String lastName;
    private CustomerType type;

    //Relatiobn entre Customer et address (une relation 1-1)
    @OneToOne
    @JoinColumn(name = "address_id",referencedColumnName = "id")//permet de specifier la clé étangère address_id provenant
    //de l'entité address.
    private Address customerAddress;
}
