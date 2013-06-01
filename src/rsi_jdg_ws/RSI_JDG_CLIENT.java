/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsi_jdg_ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author drgeek
 */
public class RSI_JDG_CLIENT {

    public static RSI_JDG_WS getHandle() throws MalformedURLException {
        QName qname = new QName("http://rsi_jdg_ws/", "RSI_JDG_WSService");
        Service proxy = Service.create(new URL("http://localhost:8081/axis2/services/RSI/RSI_JDG_WSService?wsdl"), qname);
        RSI_JDG_WS port = proxy.getPort(RSI_JDG_WS.class);
        return port;
    }

    public static void main(String[] args) throws MalformedURLException, SQLException {

        RSI_JDG_WS port = getHandle();
        int c;
        Scanner s = new Scanner(System.in);
        System.out.println("JEDNOOSOBOWA DZIALALNOSC GOSPODARCZA");
        for (;;) {

            System.out.println("1. Dodaj JDG");
            System.out.println("2. Pokaż");
            System.out.println("3. Usuń");
            System.out.println("4. Edytuj");
            System.out.println("0. Wyjście");
            c = s.nextInt();
            String nip;
            switch (c) {
                case 1:
                    System.out.println("Podaj NIP: ");
                    nip = s.next();
                    System.out.println(port.dodajObj(new JDG(nip)));
                    //case 2:
                    break;
                case 2:
                    System.out.println("LISTA JDG");
                    System.out.println(port.pokaz());
                    break;
                case 3:
                    System.out.println("Podaj NIP do usunięcia:");
                    nip = s.next();
                    break;
                case 4:
                    System.out.println("Podaj NIP JDG do edycji:");
                    nip = s.next();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}
