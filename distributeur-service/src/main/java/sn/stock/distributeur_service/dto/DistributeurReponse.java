package sn.stock.distributeur_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistributeurReponse {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String adress;
    private String mail;
    private int tel;
    private Categorie categorie;
}
