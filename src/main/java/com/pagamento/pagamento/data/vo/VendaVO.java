/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagamento.pagamento.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pagamento.pagamento.entity.ProdutoVenda;
import com.pagamento.pagamento.entity.Venda;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

/**
 *
 * @author Mateus
 */
@JsonPropertyOrder({"id", "data", "valorTotal"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VendaVO extends RepresentationModel<VendaVO> implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("data")
    private Date data;
    @JsonProperty("produtos")
    private List<ProdutoVendaVO> produtos;
    @JsonProperty("valorTotal")
    private Double valorTotal;
    
    public static VendaVO create(Venda venda){
        return new ModelMapper().map(venda, VendaVO.class);
    }
}
