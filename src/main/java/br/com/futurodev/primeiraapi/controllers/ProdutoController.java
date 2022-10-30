package br.com.futurodev.primeiraapi.controllers;


import br.com.futurodev.primeiraapi.Dto.ProdutoRepresentationModel;
import br.com.futurodev.primeiraapi.input.ProdutoInput;
import br.com.futurodev.primeiraapi.model.Produto;
import br.com.futurodev.primeiraapi.services.CadastroProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private CadastroProdutoService cadastroProdutoService;

    @PostMapping
    public ResponseEntity<ProdutoRepresentationModel> cadastrar(@RequestBody ProdutoInput produtoInput) {
        Produto produto = toDomainObject(produtoInput);
        cadastroProdutoService.salvar(produto);
        return new ResponseEntity<ProdutoRepresentationModel>(toModel(produto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProdutoRepresentationModel> atualizar(@RequestBody ProdutoInput produtoInput) {
        Produto produto = cadastroProdutoService.salvar(toDomainObject(produtoInput));
        return new ResponseEntity<ProdutoRepresentationModel>(toModel(produto), HttpStatus.OK);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idProduto) {
        cadastroProdutoService.deleteById(idProduto);
        return new ResponseEntity<String>("Produto ID " + idProduto + " deletado com sucesso!", HttpStatus.OK);
    }

    @GetMapping(value = "/{idProduto}")
    public ResponseEntity<ProdutoRepresentationModel> getProdutoById(@PathVariable(value = "idProduto") Long idProduto) {
        ProdutoRepresentationModel produtoRepresentationModel = toModel(cadastroProdutoService.getProdutoById(idProduto));
        return new ResponseEntity<ProdutoRepresentationModel>(produtoRepresentationModel, HttpStatus.OK);
    }

    @GetMapping(value = "/{descricao}")
    public ResponseEntity<List<ProdutoRepresentationModel>> getProdutosByName(@PathVariable(name = "descricao") String descricao) {
        List<Produto> produtos = cadastroProdutoService.getProdutosByDescricao(descricao);
        List<ProdutoRepresentationModel> produtosRepresentationModel = toCollectionModel(produtos);
        return new ResponseEntity<List<ProdutoRepresentationModel>>(produtosRepresentationModel,HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ProdutoRepresentationModel>> getProdutos(){
        List<Produto> produtos = cadastroProdutoService.getProdutos();
        List<ProdutoRepresentationModel> produtosRepresentationModel = toCollectionModel(produtos);
        return new ResponseEntity<List<ProdutoRepresentationModel>>(produtosRepresentationModel, HttpStatus.OK);
    }

    private Produto toDomainObject(ProdutoInput produtoInput) {
        Produto produto = new Produto();
        produto.setId(produtoInput.getIdProduto());
        produto.setDescricao(produto.getDescricao());
        produto.setPrecoCompra(produto.getPrecoCompra());
        produto.setPrecoVenda(produto.getPrecoVenda());
        return produto;
    }

    private ProdutoRepresentationModel toModel(Produto produto) {
        ProdutoRepresentationModel produtoRepresentationModel = new ProdutoRepresentationModel();
        produtoRepresentationModel.setId(produto.getId());
        produtoRepresentationModel.setDescricao(produto.getDescricao());
        produtoRepresentationModel.setPrecoCompra(produto.getPrecoCompra());
        produtoRepresentationModel.setPrecoVenda(produto.getPrecoVenda());
        return produtoRepresentationModel;
    }

    private List<ProdutoRepresentationModel> toCollectionModel(List<Produto> produtos){
        return produtos.stream().map(Produto ->toModel(Produto)).collect(Collectors.toList());
}

}
