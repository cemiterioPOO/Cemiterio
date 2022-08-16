import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcionario extends Pessoa{

    private String funcao;
    private Double remuneracao;
    public static List<Funcionario> funcionarioList = new ArrayList<>();

    Funcionario(String nome, String sobrenome, String cpf, Date dataNasc, char genero, String estadoCivil, String bairro, String rua, int numero, int quadra, String cep, String funcao, double remuneracao) {
        super(nome, sobrenome, cpf, dataNasc, genero, estadoCivil, bairro, rua, numero, quadra, cep);
        this.funcao = funcao;
        this.remuneracao = remuneracao;
        funcionarioList.add(this);
    }

    public String getFuncao() {
        return funcao;
    }

    public Double getRemuneracao() {
        return remuneracao;
    }


    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setRemuneracao(Double remuneracao) {
        this.remuneracao = remuneracao;
    }


    public static double calculaCusto(){
        double custo = 0;
        for(Funcionario funcionario : funcionarioList){
            custo += funcionario.getRemuneracao();
        }
        return custo;
    }
}
