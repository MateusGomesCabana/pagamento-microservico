/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagamento.pagamento.services;

import com.pagamento.pagamento.data.vo.VendaVO;
import com.pagamento.pagamento.entity.ProdutoVenda;
import com.pagamento.pagamento.entity.Venda;
import com.pagamento.pagamento.exception.ResourceNotFoundException;
import com.pagamento.pagamento.repository.ProdutoRepository;
import com.pagamento.pagamento.repository.ProdutoVendaRepository;
import com.pagamento.pagamento.repository.VendaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateus
 */
@Service
public class VendaService {
    
    @Autowired
    VendaRepository vendaRepository;
    @Autowired
    ProdutoVendaRepository produtoVendaRepository;

    public VendaVO create(VendaVO vendaVO) {
        Venda venda = vendaRepository.save(Venda.create(vendaVO));
        List<ProdutoVenda> produtosSalvos = new ArrayList<>();
        vendaVO.getProdutos().forEach( p ->{
            ProdutoVenda pv = ProdutoVenda.create(p);
            pv.setVenda(venda);
            produtosSalvos.add(produtoVendaRepository.save(pv));
        });
        venda.setProdutos(produtosSalvos);
        return VendaVO.create(venda);
    }

    public Page<VendaVO> findAll(Pageable pageable) {
        Page<Venda> page = vendaRepository.findAll(pageable);
        return page.map(this::convertToVendaVO);
    }

    private VendaVO convertToVendaVO(Venda venda) {
        return VendaVO.create(venda);
    }
    
     public VendaVO findById(Long id) {
        Venda venda = vendaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Records"));
        return VendaVO.create(venda);
    }
    
}
