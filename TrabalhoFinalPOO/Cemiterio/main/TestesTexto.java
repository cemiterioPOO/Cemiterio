
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TestesTexto {
    public static void main(String[] args) throws IOException, ParseException {
        ArrayList<Object> pessoas = new ArrayList<>();
        FileOutputStream out = new FileOutputStream(MenuFrame.class.getResource("data.ser").getPath());
        ObjectOutputStream oos = new ObjectOutputStream(out);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        pessoas.add(new Familiar("Kauã", "Júnio", "04931390821", formatter.parse("16/01/2000"), 'M', "Solteiro", "Alphaville", "RX 9", 12, 12, "74424090", "62999999999", "Estudante", "Cristianismo"));
        Falecido lucio = new Falecido("Jamal", "Jimin", "04931490844", formatter.parse("22/10/2000"), 'M', "Casado", "Alphaville", "RX 9", 12, 12, "74424090", 1, formatter.parse("30/01/2020"), "Policial", "Cristianismo");
        lucio.setJazigo(new Jazigo("Permanente", "109"));
        pessoas.add(lucio);
        pessoas.add(new Funcionario("Gabriel", "Mesquita", "050212388567", formatter.parse("10/02/2001"), 'M', "Solteiro", "Laranjeiras II", "33", 1, 12, "74444444", "Coveiro", 3500));
        oos.writeObject(pessoas);
    }
}
