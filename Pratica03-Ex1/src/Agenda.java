import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Contato> contatos;
    private int quantidadeContatos;

    public Agenda() {
        contatos = new ArrayList<>();
        quantidadeContatos = 0;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public int getQuantidadeContatos() {
        return quantidadeContatos;
    }

    public void setQuantidadeContatos(int quantidadeContatos) {
        this.quantidadeContatos = quantidadeContatos;
    }

    public void adicionarContato(Contato contato) {
        if (contato != null) {
            contatos.add(contato);
            quantidadeContatos += 1;
        }
    }

    public String removeContato(Contato contato) {
        for (Contato c : contatos) {
            if (c == contato) {
                contatos.remove(contato);
                quantidadeContatos -= 1;
                return "Exclusão bem sucedida!";
            }
        }
        return "Contato não encontrado!";
    }

    public Contato buscarContatoPorNome(String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    public Contato buscarContatoPorEmail(String email) {
        for (Contato c : contatos) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                return c;
            }
        }
        return null;
    }

    public Contato buscarContatoPorTelefone(String telefone) {
        for (Contato c : contatos) {
            if (c.getTelefone().equalsIgnoreCase(telefone)) {
                return c;
            }
        }
        return null;
    }
}