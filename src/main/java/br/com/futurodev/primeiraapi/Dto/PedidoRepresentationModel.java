package br.com.futurodev.primeiraapi.Dto;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepresentationModel {

    private Long id;
    private Long idCliente;
    private String nomeCliente;
    private Long idFormaPagamento;
    private String formaPagamentoDescricao;
    private List<ItemPedidoRepresentationModel> itemPedidoRepresentationModel = new ArrayList<ItemPedidoRepresentationModel>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Long getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(Long idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getFormaPagamentoDescricao() {
        return formaPagamentoDescricao;
    }

    public void setFormaPagamentoDescricao(String formaPagamentoDescricao) {
        this.formaPagamentoDescricao = formaPagamentoDescricao;
    }

    public List<ItemPedidoRepresentationModel> getItemPedidoRepresentationModel() {
        return itemPedidoRepresentationModel;
    }

    public void setItemPedidoRepresentationModel(List<ItemPedidoRepresentationModel> itemPedidoRepresentationModel) {
        this.itemPedidoRepresentationModel = itemPedidoRepresentationModel;
    }
}
