import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Familiar extends Pessoa implements DadosPessoais{

    private String telefone;
    private String religiao;
    private String ocupacao;
    private List<Falecido> falecidoList = new ArrayList<>();

    Familiar(String nome, String sobrenome, String cpf, Date dataNasc, char genero, String estadoCivil, String bairro, String rua, int numero, int quadra, String cep, String telefone, String ocupacao, String religiao) {
        super(nome, sobrenome, cpf, dataNasc, genero, estadoCivil, bairro, rua, numero, quadra, cep);
        this.telefone = telefone;
        this.ocupacao = ocupacao;
        this.religiao = religiao;
    }

    public void addFalecido(Falecido falecido){
        if (!this.falecidoList.contains(falecido)){
            this.falecidoList.add(falecido);
            falecido.addFamiliar(this);
        }
    }

    @Override
    public String getIdade() {
        Calendar c = Calendar.getInstance();
        Date dataAgora = c.getTime();
        long diffInMillies = Math.abs(dataAgora.getTime() - this.getDataNasc().getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        diff /= 365;
        return this.getNome() + " tem " + diff + " anos";
    }

    @Override
    public String getReligiao() {
        return religiao;
    }


    @Override
    public String getOcupacao() {
        return ocupacao;
    }

    public List<Falecido> getFalecidoList() {
        return falecidoList;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public void setReligiao(String religiao) {
        this.religiao = religiao;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
