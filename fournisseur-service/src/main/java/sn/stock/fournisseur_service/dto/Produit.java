package sn.stock.fournisseur_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    private int id;
    private String name;
    private String desc;
    private String qty;
    private Integer price;
}
