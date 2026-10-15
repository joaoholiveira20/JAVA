package controle;

import java.util.ArrayList;

import dao.ProdutoDao;
import modelo.Produto;

public class ProdutoControle {
    
    private ProdutoDao dao;

    public ProdutoControle(){
        dao = new ProdutoDao();
    }

    //cria um produto e envia para o Dao cadastrar
    public  void cadastrar(int codigo, String nome, double preco){

        Produto produto = new Produto(codigo, nome, preco);
        dao.cadastrar(produto);
    }

    //Solicitar ao dao a lista
    public ArrayList<Produto> listar(){
        return dao.listar();
    }

    public Produto buscar(int codigo){
        return dao.buscar(codigo);
    }

    public boolean alterar(int codigo, String nome, double preco){
        return dao.alterar(codigo, nome, preco);
    }

    public boolean remover(int codigo){
        return dao.remover(codigo);
    }
    
}
