package rsi_jdg_ws;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.jws.WebService;

@WebService(
        name = "RSI_JDG_WS",
        targetNamespace = "http://rsi_jdg_ws/")
public interface RSI_JDG_WS {

    public String dodajObj(JDG jdg);

    public String dodaj(String nip);

    //public ResultSet pokaz() throws SQLException; ResultSet is an interface and JAXB makes the problem
    public String pokaz();
//    public String modyfikuj(JDG jdg);
//
//    public String usun(String nip);
//
//    public String pobierz(String nip);
}
