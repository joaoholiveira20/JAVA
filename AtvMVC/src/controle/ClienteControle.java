package controle;

import java.util.ArrayList;

import dao.ClienteDao;
import modelo.Cliente;

public class ClienteControle {
    
    private ClienteDao dao;

    public ClienteControle(){
        dao = new ClienteDao();
    }

    //Criar um produto e envia para o Dao cadastrar
    public void cadastrar(int codigo, String nome, String telefone, String Email){
        
        Cliente cliente = new Cliente(codigo, nome, telefone, Email);
        dao.cadastrar(cliente);
    }

    //Solicitar ao dao a lista
    public ArrayList<Cliente> listar(){
        return dao.listar();
    }

    public Cliente buscar(int codigo){
        return dao.buscar(codigo);
    }

    public boolean alterar(int codigo, String nome, String telefone, String Email){
        return dao.alterar(codigo, nome, telefone, Email);
    }

    public boolean remover(int codigo){
        return dao.remover(codigo);
    }
    
}
