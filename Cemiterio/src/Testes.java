import org.junit.Test;
import org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertNotNull;

public class Testes {

    @Test
    public void criaTerreno(){
        int size = 100;
        for(int i=0; i<size+1; i++){
            Jazigo jazigo = new Jazigo("Simples", "Loc " + i);
        }
        for(Jazigo jazigo : Jazigo.jazigoList){
            assertNotNull(jazigo);
        }
    }

    @Test
    public void testFamiliar() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascFam = sdf.parse("27/11/2002");
        Date dataNascFal = sdf.parse("25/11/1968");
        Date dataEnterroFal = sdf.parse("13/11/2004");
        Familiar familiar = new Familiar("Kauã", "Júnio", "04931390821", dataNascFam, 'M', "Solteiro", "Alphaville", "RX 9", 12, 12, "74424090", "62999999999", "Estudante", "Cristianismo");
        Falecido falecido = new Falecido("Jamal", "Jimin", "04931490844", dataNascFal, 'M', "Casado", "Alphaville", "RX 9", 12, 12, "74424090", 12, dataEnterroFal, "Policial", "Cristianismo");
        familiar.addFalecido(falecido);
        System.out.println("familiar.getIdade" + familiar.getIdade());
        System.out.println("familiar.getFalecidoList\n" + familiar.getFalecidoList());
        System.out.println("falecido.getFamiliarList\n" + falecido.getFamiliarList());
    }

}
