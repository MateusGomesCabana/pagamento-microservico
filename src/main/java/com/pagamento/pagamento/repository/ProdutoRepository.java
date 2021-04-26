/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagamento.pagamento.repository;

import com.pagamento.pagamento.entity.Produto;
import com.pagamento.pagamento.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mateus
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
