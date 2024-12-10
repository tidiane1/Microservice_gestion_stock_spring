package sn.stock.distributeur_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@AllArgsConstructor
@Document(collection = "distributeurs")
public class Distributeur {
    @Id
    private String id;
    private String name;
    private int age;
    private String gender;
    private String adress;
    private String mail;
    private int tel;
    private Integer categorieId;
}
