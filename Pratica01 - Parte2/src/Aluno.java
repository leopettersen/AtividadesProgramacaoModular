import java.text.Normalizer;
import java.time.LocalDate;
import java.time.Period;

public class Aluno {
    String nome;
    int idade;
    int coragem;
    int inteligencia;
    int ambicao;
    int lealdade;
    int estrategia;
    int criatividade;
    String casa;
    LocalDate dataNascimento;
    String codigoMatricula;

    public Aluno() {
        this.nome = "";
        this.idade = 0;
        this.coragem = 0;
        this.inteligencia = 0;
        this.ambicao = 0;
        this.lealdade = 0;
        this.estrategia = 0;
        this.criatividade = 0;
        this.casa = "";
        this.dataNascimento = null;
        this.codigoMatricula = "";
    }

    public Aluno(String nome, int idade, int coragem, int inteligencia, int ambicao, int lealdade, int estrategia, int criatividade) {
        this.nome = nome;
        this.idade = idade;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.estrategia = estrategia;
        this.criatividade = criatividade;
        this.casa = "";
        this.dataNascimento = null;
        this.codigoMatricula = "";
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = capitalizarNome(nome);
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCoragem() {
        return coragem;
    }
    public void setCoragem(int coragem) {
        this.coragem = coragem;
    }

    public int getInteligencia() {
        return inteligencia;
    }
    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getAmbicao() {
        return ambicao;
    }
    public void setAmbicao(int ambicao) {
        this.ambicao = ambicao;
    }

    public int getLealdade() {
        return lealdade;
    }
    public void setLealdade(int lealdade) {
        this.lealdade = lealdade;
    }

    public int getCriatividade() {
        return criatividade;
    }
    public void setCriatividade(int criatividade) {
        this.criatividade = criatividade;
    }

    public int getEstrategia() {
        return estrategia;
    }
    public void setEstrategia(int estrategia) {
        this.estrategia = estrategia;
    }

    public String getCasa() {
        return casa;
    }
    public void setCasa(String casa) {
        this.casa = casa;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCodigoMatricula() {
        return codigoMatricula;
    }
    public void setCodigoMatricula(String codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public static String capitalizarNome(String nome) {
        String[] partes = nome.trim().toLowerCase().split("\\s+");
        StringBuilder resultado = new StringBuilder();
        for (String parte : partes) {
            resultado.append(Character.toUpperCase(parte.charAt(0)))
                    .append(parte.substring(1))
                    .append(" ");
        }
        return resultado.toString().trim();
    }

    public static String removerAcentos(String texto) {
        String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return normalizado.replaceAll("\\p{InCombiningDiacriticalMarks}", "");
    }

    public String getSobrenome() {
        String[] partes = this.nome.trim().split("\\s+");
        if (partes.length == 1) {
            return "";
        }
        StringBuilder sobrenome = new StringBuilder();
        for (int i = 1; i < partes.length; i++) {
            sobrenome.append(partes[i]);
            if (i != partes.length - 1) {
                sobrenome.append(" ");
            }
        }
        return sobrenome.toString();
    }

    public int calcularIdade() {
        if (this.dataNascimento == null) {
            return 0;
        }
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    public boolean verificarMaioridadeMagica() {
        return calcularIdade() >= 17;
    }

    public String formatarCasa() {
        return this.casa.toUpperCase();
    }

    public String gerarNomeUsuario() {
        String[] partes = this.nome.trim().split("\\s+");
        String primeiraLetra = String.valueOf(Character.toLowerCase(partes[0].charAt(0)));
        String sobrenome = getSobrenome().replaceAll("\\s+", "").toLowerCase();
        return primeiraLetra + sobrenome;
    }

    public String gerarCodigoMatricula(int posicao) {
        String[] partes = this.nome.trim().split("\\s+");
        String iniciais = String.valueOf(Character.toUpperCase(partes[0].charAt(0)));
        if (partes.length > 1) {
            String ultimoNome = partes[partes.length - 1];
            iniciais += Character.toUpperCase(ultimoNome.charAt(0));
        }
        int ano = LocalDate.now().getYear();
        return String.format("%s-%d-%02d", iniciais, ano, posicao);
    }

    public boolean verificarCasa(String casaInformada) {
        return removerAcentos(this.casa.trim().toLowerCase())
                .equals(removerAcentos(casaInformada.trim().toLowerCase()));
    }

    public boolean verificarPresencaPalavra(String palavra) {
        return removerAcentos(getSobrenome().toLowerCase())
                .contains(removerAcentos(palavra.trim().toLowerCase()));
    }

    public String exibirInformacoes() {
        return "\nNome: " + this.nome +
                "\nIdade: " + this.idade + " anos" +
                "\nCasa: " + formatarCasa() +
                "\nMatricula: " + this.codigoMatricula +
                "\nUsuario: " + gerarNomeUsuario() +
                "\nMaior de idade magica: " + (verificarMaioridadeMagica() ? "Sim" : "Nao") + "\n";
    }

    public String calcularCasa() {
        double grifinoria, sonserina, corvinal, lufaLufa;
        grifinoria = this.coragem * 2 + this.lealdade;
        sonserina = this.ambicao * 2 + this.estrategia;
        corvinal = this.inteligencia * 2 + this.criatividade;
        lufaLufa = (double) (this.lealdade * 2 + this.coragem) / 3;

        double maior = Math.max(Math.max(grifinoria, sonserina), Math.max(corvinal, lufaLufa));

        if (maior == grifinoria) return "Grifinoria";
        if (maior == sonserina) return "Sonserina";
        if (maior == corvinal) return "Corvinal";
        return "Lufa-Lufa";
    }
}