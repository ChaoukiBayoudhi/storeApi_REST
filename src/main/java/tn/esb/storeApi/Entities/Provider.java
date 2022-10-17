package tn.esb.storeApi.Entities;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

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
}
