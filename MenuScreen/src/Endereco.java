package MenuScreen.src;

import java.io.Serializable;

public class Endereco implements Serializable{
    private String bairro;
    private String rua;
    private int numero;
    private int quadra;
    private String cep;

    public Endereco(String bairro, String rua, int numero, int quadra, String cep){
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.quadra = quadra;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "bairro='" + bairro + '\'' +
                ", rua='" + rua + '\'' +
                ", numero=" + numero +
                ", quadra=" + quadra +
                ", cep='" + cep + '\'' +
                '}';
    }
}
