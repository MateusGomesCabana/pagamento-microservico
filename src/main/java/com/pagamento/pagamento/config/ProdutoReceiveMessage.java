/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagamento.pagamento.config;

import com.pagamento.pagamento.data.vo.ProdutoVO;
import com.pagamento.pagamento.entity.Produto;
import com.pagamento.pagamento.repository.ProdutoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mateus
 */
@Component
public class ProdutoReceiveMessage {
    @Autowired
    ProdutoRepository produtoRepository;
    
    @RabbitListener(queues = {"${crud.rabbitmq.queue}"})
    public void receive (@Payload ProdutoVO produtoVO){
        produtoRepository.save(Produto.create(produtoVO));
    }
}
