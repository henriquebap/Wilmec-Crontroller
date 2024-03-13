package br.com.wilmeccontroller.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Categoria{

    @Id
    private Long id;
    private String nome_prod;
    private String descricao_prod;
    private String cat_prod;
    private String prateleira;
    private int qnt_prod; 
}
