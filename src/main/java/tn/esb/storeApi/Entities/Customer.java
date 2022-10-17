package tn.esb.storeApi.Entities;

import lombok.*;
import org.springframework.lang.NonNull;
import tn.esb.storeApi.Enumerations.CustomerType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
