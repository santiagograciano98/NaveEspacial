package co.edu.udea.naveespacial;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LeerArchivo {

    public void crearFamilia() {
        JSONParser parser = new JSONParser();
        Persona persona;
        Familia familia = null;

        try {

            Object obj = parser.parse(new FileReader("C:\\Users\\Santiago Graciano\\Documents\\NetBeansProjects\\NaveEspacial\\src\\co\\edu\\udea\\naveespacial\\prueba.json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("JSON LEIDO: " + jsonObject);

            JSONArray array = (JSONArray) jsonObject.get("Personas");
            System.out.println(array.size());

            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject1 = (JSONObject) array.get(i);

                System.out.println("DATOS DEL USUARIO: " + i);
                System.out.println("IDFamilia: " + jsonObject1.get("idFamilia"));
                System.out.println("Nombre: " + jsonObject1.get("nombre"));
                System.out.println("edad: " + jsonObject1.get("edad"));

                
                persona = new Persona(jsonObject1.get("nombre").toString(), Integer.parseInt(jsonObject1.get("edad").toString()), true);
                System.out.println("");
            }

        } catch (FileNotFoundException e) {
            System.out.println("hola");
        } catch (IOException e) {
            System.out.println("hola 1");
        } catch (ParseException e) {
            System.out.println("hola 2");
        };
    }

}
