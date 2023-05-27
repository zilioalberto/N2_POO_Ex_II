import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeContatos {

private ContatoStorage storage;         //Variavel storage do tipo ContatoStorage;


    // Construtor da Classe
    public GerenciadorDeContatos(ContatoStorage storage) {
        this.storage = storage;
    }

    //Chamada do Metodo para adicionar Contatos
    public void adicionarContato(String nome, String telefone){
        storage.adicionarContato(nome, telefone);
    }

    //Chamada do Metodo para remover Contatos
    public void  removerContato(String nome){
        storage.removerContato(nome);
    }

    //Chamada do Metodo para buscar Contatos
    public void buscarContato(String nome){
        storage.buscarContato(nome);
    }

    //Chamada do Metodo para listar Contatos
     public HashMap<String, String> listarContatos() {
        storage.listarContato();
        return null;
    }
}