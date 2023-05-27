import java.io.*;

public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;

    // Declaração das variáveis

    private String nome;
    private String telefone;


    // Construtor da classe Contato

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    // Metodos Getter and Setter

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return nome + " - " + telefone ;
    }




}