package co.edu.udea.naveespacial;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        Persona persona = null;
        Nave nave = new Nave();

        try {
            Object obj = parser.parse(new FileReader("C:\\Users\\Santiago Graciano\\Documents\\NetBeansProjects\\NaveEspacial\\src\\co\\edu\\udea\\naveespacial\\prueba.json"));
            JSONObject jsonObject = (JSONObject) obj;
            for (int i = 1; i <= 25; i++) {
                ArrayList<Persona> listaFamilia = new ArrayList<>();
                String valorFamilia = "Familia" + Integer.toString(i);
                JSONArray array = (JSONArray) jsonObject.get(valorFamilia);

                for (int j = 0; j < array.size(); j++) {
                    JSONObject jsonObject1 = (JSONObject) array.get(j);
                    persona = new Persona(jsonObject1.get("nombre").toString(), Integer.parseInt(jsonObject1.get("edad").toString()), true);
                    listaFamilia.add(persona);
                }
                Familia familia = new Familia(listaFamilia, true);

                //almacenar datos en la matriz
                int operacionModulo = i % 5;

                if (i <= 5) {
                    if (operacionModulo != 0) {
                        nave.agregarFamiliaEnNave(familia, 0, operacionModulo - 1);
                    } else {
                        nave.agregarFamiliaEnNave(familia, 0, 4);
                    }

                } else if (i > 5 && i <= 10) {
                    if (operacionModulo != 0) {
                        nave.agregarFamiliaEnNave(familia, 1, operacionModulo - 1);
                    } else {
                        nave.agregarFamiliaEnNave(familia, 1, 4);
                    }
                }else if (i > 10 && i <= 15) {
                    if (operacionModulo != 0) {
                        nave.agregarFamiliaEnNave(familia, 2, operacionModulo - 1);
                    } else {
                        nave.agregarFamiliaEnNave(familia, 2, 4);
                    }
                }else if (i > 15 && i <= 20) {
                    if (operacionModulo != 0) {
                        nave.agregarFamiliaEnNave(familia, 3, operacionModulo - 1);
                    } else {
                        nave.agregarFamiliaEnNave(familia, 3, 4);
                    }
                }else if (i > 20 && i <= 25) {
                    if (operacionModulo != 0) {
                        nave.agregarFamiliaEnNave(familia, 4, operacionModulo - 1);
                    } else {
                        nave.agregarFamiliaEnNave(familia, 4, 4);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("hola");
        } catch (IOException e) {
            System.out.println("hola 1");
        } catch (ParseException e) {
            System.out.println("hola 2");
        }
        nave.consultarMatriz();
        //nave.aplicarLocura();
       double probabilidad;
        //System.out.println(nave.obtenerRandomFamilia());
       
       
        for (int i = 0; i <= 10; i++) {
            if(i != 10){
                probabilidad = nave.probabilidadCatastrofe();
                System.out.println("Probabilidad inicial: " + probabilidad);
                if (probabilidad <= 0.4) {
                    probabilidad = nave.probabilidadCatastrofe();
                    if(probabilidad <= 0.1){
                        nave.aplicarColision();
                    }else if(probabilidad > 0.1 && probabilidad <= 0.5){
                        nave.aplicarLocura(i);
                    }else if(probabilidad > 0.5){
                        nave.aplicarFuga();
                    }
                }
            }
            if(i == 10){
                System.out.println("Llego a Marte");
            }
            
        }
        
       

    }

}
