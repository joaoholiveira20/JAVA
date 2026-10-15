package dao;

import java.util.ArrayList;

import modelo.Cliente;

public class ClienteDao {
    
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void cadastrar(Cliente cliente){
        clientes.add(cliente);
    }

    public ArrayList<Cliente> listar(){
        return clientes;
    }

    public Cliente buscar(int codigo){
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo() == codigo) {
                return cliente;
            }
        }
        return null;
    }

    public boolean alterar(int codigo, String nome, String telefone, String Email){
        Cliente cliente = buscar(codigo);
        if (cliente !=null) {
            cliente.setNome(nome);
            cliente.setTelefone(telefone);
            cliente.setEmail(Email);
            return true;
        }
        return false;
    }

    public boolean remover(int codigo){
        Cliente cliente = buscar(codigo);

        if (cliente !=null) {
            clientes.remove(cliente);
            return true;
        }
        return false;
    }
}
