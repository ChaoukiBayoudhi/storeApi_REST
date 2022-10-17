package tn.esb.storeApi.Entities;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="customerAddress")
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @EqualsAndHashCode.Include
    private int streetNumber;
    @NonNull
    @EqualsAndHashCode.Include
    private  String streetName;
    @NonNull
    private String province;
    @NonNull
    @EqualsAndHashCode.Include
    private int postalCode;
    @OneToOne(mappedBy = "customerAddress")
    private Customer customer;
}
