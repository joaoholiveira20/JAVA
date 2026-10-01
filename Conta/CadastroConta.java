package Conta;
import java.util.ArrayList;

import Conta;

public class CadastroConta {
    private final ArrayList<Conta> contas;
    private static final int LIMITE_MAXIMO = 100;

    public CadastroConta() {
        this.contas = new ArrayList<>();
    }

    public void inserir(Conta conta) throws ExcecaoRepositorio, ExcecaoElementoJaExistente {
        if (contas.size() >= LIMITE_MAXIMO) {
            throw new ExcecaoRepositorio("Limite máximo de 100 contas atingido.");
        }

        if (buscarSilencioso(conta.getNumero()) != null) {
            throw new ExcecaoElementoJaExistente("Já existe uma conta cadastrada com o número: " + conta.getNumero());
        }

        contas.add(conta);
    }

    public Conta buscar(String numero) throws ExcecaoElementoInexistente {
        Conta conta = buscarSilencioso(numero);
        if (conta == null) {
            throw new ExcecaoElementoInexistente("Conta número '" + numero + "' não foi encontrada.");
        }
        return conta;
    }

    public void remover(String numero) throws ExcecaoElementoInexistente {
        Conta conta = buscar(numero); // Lança ExcecaoElementoInexistente se não existir
        contas.remove(conta);
    }

    // Busca auxiliar interna
    private Conta buscarSilencioso(String numero) {
        if (numero == null) return null;
        for (Conta c : contas) {
            if (c.getNumero().equalsIgnoreCase(numero.trim())) {
                return c;
            }
        }
        return null;
    }
}