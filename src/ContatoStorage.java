import java.util.HashMap;

public interface ContatoStorage {

    void adicionarContato(String nome, String telefone);

    default void removerContato(String nome) {
    }

    void buscarContato(String nome);


    HashMap<String, Contato> listarContato();
}

