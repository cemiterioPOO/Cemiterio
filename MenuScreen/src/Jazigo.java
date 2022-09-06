package MenuScreen.src;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Jazigo implements Serializable{
    private final String tipo;
    private final String localizacao;
    private Falecido ocupante;
    public static List<Jazigo> jazigoList = new ArrayList<>();

    public Jazigo(String tipo, String localizacao){
        this.tipo = tipo;
        this.localizacao = localizacao;
        jazigoList.add(this);
    }

    public String getLocalizacao() {
        return this.localizacao;
    }

    public void addCorpo(Falecido ocupante){
        this.ocupante = ocupante;
        ocupante.setJazigo(this);
    }

    public void realocaCorpo(Jazigo novoJazigo){
        if(this.ocupante != null){
            novoJazigo.addCorpo(this.ocupante);
            this.ocupante.setJazigo(novoJazigo);
            this.ocupante = null;
        }
    }
}
