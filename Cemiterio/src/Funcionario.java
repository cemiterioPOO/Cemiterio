import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcionario extends Pessoa{

    private String funcao;
    private Double remuneracao;
    private String regimeTrab;
    public static List<Funcionario> funcionarioList = new ArrayList<>();

    Funcionario(String nome, String sobrenome, String cpf, Date dataNasc, char genero, String estadoCivil, String bairro, String rua, int numero, int quadra, String cep, String funcao, double remuneracao, String regimeTrab) {
        super(nome, sobrenome, cpf, dataNasc, genero, estadoCivil, bairro, rua, numero, quadra, cep);
        this.funcao = funcao;
        this.remuneracao = remuneracao;
        this.regimeTrab = regimeTrab;
        funcionarioList.add(this);
    }

    public String getFuncao() {
        return funcao;
    }

    public Double getRemuneracao() {
        return remuneracao;
    }

    public String getRegimeTrab() {
        return regimeTrab;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setRemuneracao(Double remuneracao) {
        this.remuneracao = remuneracao;
    }

    public void setRegimeTrab(String regimeTrab) {
        this.regimeTrab = regimeTrab;
    }

    public double calculaEncargo() {
        return 0;
    }

    public static double calculaCusto(){
        for(Funcionario funcionario : funcionarioList){
            
        }
    }
}
