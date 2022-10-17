package tn.esb.storeApi.Entities;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Provider {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @EqualsAndHashCode.Include
    @Size(max=100)
    private String name;
    @EqualsAndHashCode.Include
    @Email
    private String email;
    private String telephoneNumber;
    private String urlWebSite;

    //relation entre Provider et Product (1-*)
    @OneToMany(mappedBy = "productProvider",cascade = CascadeType.ALL)
    private Set<Product> products=new HashSet<>();
}
