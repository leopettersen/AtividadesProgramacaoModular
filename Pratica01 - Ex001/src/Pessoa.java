public class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade; // anos
    private double altura; // m
    private double peso; // Kg
    private double imc;

    public Pessoa() {
        this.nome = "";
        this.sobrenome = "";
        this.idade = 0;
        this.altura = 0.0;
        this.peso = 0.0;
    }
    public Pessoa(String nome, String sobrenome, int idade, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double calculaIMC() {
        return this.peso / (this.altura * this.altura);
    }

    public String informaObesidade() {
        if (this.imc >= 40) {
            return "Obesidade grau 3";
        } else if (this.imc >= 35) {
            return "Obesidade grau 2";
        } else if (this.imc >= 30) {
            return "Obesidade grau 1";
        } else if (this.imc >= 25) {
            return "Sobrepeso";
        } else if (this.imc >= 18.5) {
            return "Peso normal";
        }
        return "Abaixo do peso";
    }
}