import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
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
        Falecido falecido = new Falecido("Jamal", "Jimin", "04931490844", dataNascFal, 'M', "Casado", "Alphaville", "RX 9", 12, 12, "74424090", 1, dataEnterroFal, "Policial", "Cristianismo");
        familiar.addFalecido(falecido);
        System.out.println("familiar.getIdade\n" + familiar.getIdade());
        System.out.println("familiar.getFalecidoList\n" + familiar.getFalecidoList());
        System.out.println("falecido.getFamiliarList\n" + falecido.getFamiliarList());

        familiar.setOcupacao("Programador");
        familiar.setReligiao("Ateísmo");
        familiar.setTelefone("62995278700");

        assertEquals(familiar.getOcupacao(), "Programador");
        assertEquals(familiar.getReligiao(), "Ateísmo");
        assertEquals(familiar.getTelefone(), "62995278700");

    }

    @Test
    public void testFalecido() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascFam = sdf.parse("27/11/2003");
        Date dataNascFal = sdf.parse("25/11/1967");
        Date dataEnterroFal = sdf.parse("13/11/2009");
        Familiar familiar = new Familiar("Kauã", "Júnio", "04931390821", dataNascFam, 'M', "Solteiro", "Alphaville", "RX 9", 12, 12, "74424090", "62999999999", "Estudante", "Cristianismo");
        Falecido falecido = new Falecido("Jamal", "Jimin", "04931490844", dataNascFal, 'M', "Casado", "Alphaville", "RX 9", 12, 12, "74424090", 1, dataEnterroFal, "Policial", "Cristianismo");
        falecido.addFamiliar(familiar);
        System.out.println(falecido.getIdade());

        Falecido falecido2 = new Falecido("Jamal", "Jungkook", "04931490845", dataNascFal, 'M', "Casado", "Alphaville", "RX 9", 12, 12, "74424090", 1, dataEnterroFal, "Policial", "Cristianismo");
        Falecido falecido3 = new Falecido("Jamal", "Jin", "04931490846", dataNascFal, 'M', "Casado", "Alphaville", "RX 9", 12, 12, "74424090", 1, dataEnterroFal, "Policial", "Cristianismo");

        assertEquals(Falecido.numFalecidos, 3);
        assertEquals(falecido.calculaCustos(), 5000, 0);

    }

    @Test
    public void testFuncionario() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascFunc = sdf.parse("09/03/2000");
        Funcionario funcionario = new Funcionario("Gabriel", "Mesquita", "050212388567", dataNascFunc, 'M', "Solteiro", "Laranjeiras II", "33", 1, 12, "74444444", "Coveiro", 3500);

        funcionario.setFuncao("Assistente Administrativo");
        funcionario.setRemuneracao(6000.0);

        Funcionario funcionario2 = new Funcionario("Gabriel", "Borges", "050212388567", dataNascFunc, 'M', "Solteiro", "Laranjeiras II", "33", 1, 12, "74444444", "Coveiro", 3500);

        assertEquals(Funcionario.calculaCusto(), 9500, 0);
    }

    @Test
    public void testGetInfo() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascFal = sdf.parse("09/03/2000");
        Date dataEnterroFal = sdf.parse("27/11/2020");
        Falecido falecido = new Falecido("Jamal", "Fuleco", "04931490844", dataNascFal, 'M', "Casado", "Alphaville", "RX 9", 12, 12, "74424090", 1, dataEnterroFal, "Policial", "Cristianismo");

        Object[] arrayObject = falecido.getInfo();
        System.out.println(arrayObject[9]);
    }

}