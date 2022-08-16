import java.util.Date;

public abstract class Pessoa {
    private String nome;
    private String sobrenome;
    private String cpf;
    private Date dataNasc;
    private char genero;
    private String estadoCivil;
    private Endereco endereco;

    Pessoa(String nome, String sobrenome, String cpf, Date dataNasc, char genero, String estadoCivil, String bairro, String rua, int numero, int quadra, String cep){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.endereco = new Endereco(bairro, rua, numero, quadra, cep);
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setEndereco(String bairro, String rua, int numero, int quadra, String cep) {
        this.endereco = new Endereco(bairro, rua, numero, quadra, cep);
    }

    @Override
    public String toString() {
        return "Nome completo: " + nome + ' ' + sobrenome + "\n" +
                "CPF: " + cpf + "\n" +
                "Data de Nascimento: " + dataNasc + "\n" +
                "Gênero: " + genero + "\n" +
                "Estado Civil: " + estadoCivil + "\n";
    }
}

