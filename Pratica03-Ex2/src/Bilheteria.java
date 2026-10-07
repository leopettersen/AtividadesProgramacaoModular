import java.util.ArrayList;
import java.util.List;

public class Bilheteria {

    private List<Ingresso> ingressos;

    public Bilheteria() {
        ingressos = new ArrayList<>();
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public boolean adicionarIngresso(Ingresso ingresso) {
        if (ingresso == null) {
            return false;
        }
        if (buscarIngresso(ingresso.getCodigo()) != null) {
            return false;
        }
        return ingressos.add(ingresso);
    }

    public boolean removerIngresso(int codigo) {
        Ingresso ingresso = buscarIngresso(codigo);
        if (ingresso == null) {
            return false;
        }
        return ingressos.remove(ingresso);
    }

    public Ingresso buscarIngresso(int codigo) {
        for (Ingresso i : ingressos) {
            if (i.getCodigo() == codigo) {
                return i;
            }
        }
        return null;
    }

    public void listarIngressos() {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado.");
            return;
        }
        for (Ingresso i : ingressos) {
            System.out.println(i.exibirInformacoesBasicas()
                    + " - Valor final: R$ " + String.format("%.2f", i.calcularValorFinal())
                    + " - Tipo: " + i.getClass().getSimpleName());
        }
    }

    public double calcularArrecadacaoTotal() {
        double total = 0;
        for (Ingresso i : ingressos) {
            total += i.calcularValorFinal();
        }
        return total;
    }

    public void listarBeneficios() {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado.");
            return;
        }
        for (Ingresso i : ingressos) {
            System.out.println("Ingresso " + i.getCodigo() + " (" + i.getNomeEvento() + "): " + i.obterBeneficios());
        }
    }
}
