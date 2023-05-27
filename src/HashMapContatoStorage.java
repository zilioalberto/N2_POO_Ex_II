import java.io.*;
import java.util.HashMap;

public class HashMapContatoStorage implements ContatoStorage , Serializable {

    private static final long serialVersionUID = 1L;

    private HashMap<String, Contato> contatos;
    private static final String ArquivoContatos = "contatos.ser";


    public HashMapContatoStorage() {

        contatos = new HashMap<>();
        carregarContatos();         //Carregamento dos contatos
    }

    @Override
    public void adicionarContato(String nome, String telefone) {
        Contato contato = new Contato(nome, telefone);
        if (contatos.containsKey(nome)) {
        System.out.println("Contato já existente: "+contato);
            salvarContatos();
        } else {
            contatos.put(nome, contato);
            System.out.println("Contato adicionado: Nome: " + contato.getNome() +" Telefone: " + contato.getTelefone());
        }
    }
       @Override
    public void removerContato(String nome) {
        if (contatos.containsKey(nome)) {
            System.out.println("Contato removido: Nome: "+ nome );
            contatos.remove(nome);
            salvarContatos();
            } else {
            System.out.println("Contato não encontrado: " + nome);
        }
    }


    @Override
    public void buscarContato(String nome) {
        if (contatos.containsKey(nome)) {
            String dados = String.valueOf(contatos.get(nome));

            System.out.println("Contato encontrado: " +dados);

        } else {
            System.out.println("Contato não encontrado: " + nome );

        }
    }

    @Override
    public HashMap<String, Contato> listarContato() {
        if (contatos.isEmpty()) {
            System.out.println("Lista de contatos vazia.");
            return null;
        } else {
            System.out.println("Lista de contatos:");
            for (String nome : contatos.keySet()) {
                String dados = String.valueOf(contatos.get(nome));
                System.out.println(dados);
            }
            return contatos;
        }
    }


    private void salvarContatos() {
        try (FileOutputStream fileOut = new FileOutputStream(ArquivoContatos)) {
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(contatos);
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar contatos: " + e.getMessage());
        }
    }

    private void carregarContatos() {
        try (FileInputStream fileIn = new FileInputStream(ArquivoContatos);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            contatos = (HashMap<String, Contato>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de contatos não encontrado. Será criado um novo arquivo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar contatos: " + e.getMessage());
        }
    }

}
