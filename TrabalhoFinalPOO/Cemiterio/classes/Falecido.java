

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Falecido extends Pessoa implements DadosPessoais, Serializable{

    private int id;
    private Jazigo jazigo;
    private int plano;
    private Date dataEnterro;
    private String ocupacao;
    private String religiao;
    private List<Familiar> familiarList = new ArrayList<>();
    public static int numFalecidos = 0;
    public static ArrayList<Falecido> falecidoArrayList = new ArrayList<>();

    public Falecido(String nome, String sobrenome, String cpf, Date dataNasc, char genero, String estadoCivil, String bairro, String rua, int numero, int quadra, String cep, int plano, Date dataEnterro, String ocupacao, String religiao) {
        super(nome, sobrenome, cpf, dataNasc, genero, estadoCivil, bairro, rua, numero, quadra, cep);
        this.id = Falecido.numFalecidos;
        this.plano = plano;
        this.dataEnterro = dataEnterro;
        this.ocupacao = ocupacao;
        this.religiao = religiao;
        Falecido.numFalecidos += 1;
        falecidoArrayList.add(this);
    }

    public void addFamiliar(Familiar familiar){
        if (!this.familiarList.contains(familiar)){
            this.familiarList.add(familiar);
            familiar.addFalecido(this);
        }
    }

    @Override
    public String getReligiao() {
        return "Em vida, " + this.getNome() + "foi adepto do " + this.religiao + "\n";
    }

    @Override
    public String getOcupacao() {
        return "Em vida, " + this.getNome() + "foi " + this.ocupacao + "\n";
    }

    @Override
    public String getIdade() {
        Calendar c = Calendar.getInstance();
        Date dataAgora = c.getTime();

        long diffInMilliesDead = Math.abs(dataAgora.getTime() - this.getDataNasc().getTime());
        long diffDead = TimeUnit.DAYS.convert(diffInMilliesDead, TimeUnit.MILLISECONDS);
        diffDead /= 365;

        long diffInMilliesAlive = Math.abs(this.getDataEnterro().getTime() - this.getDataNasc().getTime());
        long diffAlive = TimeUnit.DAYS.convert(diffInMilliesAlive, TimeUnit.MILLISECONDS);
        diffAlive /= 365;

        return this.getNome() + " foi enterrado aos " + diffAlive + " anos. Hoje, teria " + diffDead + " anos.";
    }

    public List<Familiar> getFamiliarList() {
        return familiarList;
    }

    public int getId() {
        return id;
    }

    public int getPlano() {
        return plano;
    }

    public Date getDataEnterro() {
        return dataEnterro;
    }

    public void setJazigo(Jazigo jazigo) {
        this.jazigo = jazigo;
    }

    public String getJazigo() {
        return this.jazigo.getLocalizacao();
    } 

    public double calculaCustos(){
        if(this.plano == 1){
            return 5000;
        }
        return 18500;
    }
    
    public Object[] getInfo(){
        Object[] arrayInfo = new Object[12];
        Object[] arrayAux = getInfoGeral();

        System.arraycopy(arrayAux, 0, arrayInfo, 0, 7);

        arrayInfo[7] = this.getId();
        arrayInfo[8] = this.getPlano();
        arrayInfo[9] = this.getDataEnterro();
        arrayInfo[10] = this.getOcupacao();
        arrayInfo[11] = this.getReligiao();

        return arrayInfo;
    }

    public double getPagamento () {
        if (this.plano == 1) {
            return 5000;
        }
        else {
            return 18000;
        }
    }
}
