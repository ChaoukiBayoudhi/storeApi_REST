package tn.esb.storeApi.Entities;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter //genere tous les getters pour tous les attributs lors du runtime
@Setter //de meme pour les setters
@NoArgsConstructor //genere un constructeur non parametré lors du runtime
//@AllArgsConstructor //genere un constructeur avec tous les attributs comme paramètres lors du runtime
//@EqualsAndHashCode //permet de redifinir les méthodes de la classe Object : equals( compare deux objets) et  hashCode (gnere un code hashage)
//Deux produits seront identiques s'ils ont une egalité entre tous les champs (deux à deux)
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //dans ce cas la comparaison entre deux produits sera efectuée via
// uniquement les champs marqués avec Include
//@ToString //permet de redefinir la méthode de la classe Object "toStrin()"
//retourne les valeurs de tous les attributs (id, name, ... image)
@ToString(exclude = {"image","description"})//retourne tous les attributs sauf image et description
@Entity //La classe product sera transformée en une table relationnelle par l'ORM
//ORM : Object Relational Mapping
public class Product {
    @Id // l'attribut id est clé primaire
    //@GeneratedValue //la clé primaire est automatiquement generée
    @GeneratedValue(strategy = GenerationType.IDENTITY) // la première valeur de clé
    //attribuée sera 1, la 2ème 2, ....
    private Long id;
    @EqualsAndHashCode.Include
    private String name;
    private BigDecimal price;
    @EqualsAndHashCode.Include
    private LocalDate fabricationDate;
    private LocalDate expirationDate;
    private String description;
    private int stock;
    @Lob
    private byte[] image;

}
