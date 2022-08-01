package co.edu.udea.naveespacial;

import java.util.ArrayList;

public class Desastre {

    public Familia[][] fugaDeAire (Familia[][] nave){

        //Guardando ubicación de las tres personas más viejas.
        int[][] tresMasViejos = new int[3][3];
        int edadPrimero = 0, edadSegundo = 0, edadTercero = 0;
        

        //Recorriendo la matriz en búsqueda de las personas. 
        for (int fila = 0; fila < nave.length; fila++){
            for (int columna = 0; columna < nave[0].length; columna++){

                ArrayList<Persona> personas = nave[fila][columna].getFamilia();
                int contador = 0;
                
                for (Persona persona : personas){
                    if (persona.getEdad() > edadPrimero){
                        edadPrimero = persona.getEdad();
                        tresMasViejos[0][0] = fila;
                        tresMasViejos[0][1] = columna;
                        tresMasViejos[0][2] = contador;
                    } else {
                        if (persona.getEdad() > edadSegundo && persona.getEdad() <= edadPrimero){
                            edadSegundo = persona.getEdad();
                            tresMasViejos[1][0] = fila;
                            tresMasViejos[1][1] = columna;
                            tresMasViejos[1][2] = contador;
                        } else{
                            if (persona.getEdad() > edadTercero && persona.getEdad() <= edadSegundo){
                                edadTercero = persona.getEdad();
                                tresMasViejos[2][0] = fila;
                                tresMasViejos[2][1] = columna;
                                tresMasViejos[2][2] = contador;
                            }
                        }
                    }
                    contador++;
                }

                contador = 0;
            }
        }
        
        /*Tres personas más viejas encontradas. Se organizaron así:
            Columna 0: la fila de la matriz familia.
            Columna 1: la columna de la matriz familia.
            Columna 2: el miembro de la familia.
        */

        //Próximo paso: eliminar.

        //Eliminando primera persona:
        ArrayList<Persona> personas = nave[tresMasViejos[0][0]][tresMasViejos[0][1]].getFamilia();
        personas.remove(tresMasViejos[0][2]);
        nave[tresMasViejos[0][0]][tresMasViejos[0][1]] = new Familia(personas, true);


        //Eliminando segunda persona:
        personas = nave[tresMasViejos[1][0]][tresMasViejos[1][1]].getFamilia();
        personas.remove(tresMasViejos[1][2]);
        nave[tresMasViejos[1][0]][tresMasViejos[1][1]] = new Familia(personas, true);


        //Eliminando tercera persona:
        personas = nave[tresMasViejos[2][0]][tresMasViejos[2][1]].getFamilia();
        personas.remove(tresMasViejos[2][2]);
        nave[tresMasViejos[2][0]][tresMasViejos[2][1]] = new Familia(personas, true);

        return nave;
    }
    
     public Familia[][] aplicarDesastreLocura(Familia[][] nave, int tickMuerte){
        
        System.out.println("aplica locura");
        boolean validacion = true;
        do {
            int posicionFila = this.obtenerRandomFamilia();
            int posicionColumna = this.obtenerRandomFamilia();
            
            boolean estadoFamilia = nave[posicionFila][posicionColumna].isEstado();
            if (estadoFamilia) {
                for (int i = 0; i < nave[posicionFila][posicionColumna].getFamilia().size(); i++) {
                    nave[posicionFila][posicionColumna].getFamilia().get(i).setCausaMuerte("Muerte por locura");
                    nave[posicionFila][posicionColumna].getFamilia().get(i).setTickMuerte(tickMuerte);
                    nave[posicionFila][posicionColumna].getFamilia().get(i).setEstado(false);
                }
                nave[posicionFila][posicionColumna].setEstado(false);
                validacion = false;
            }

        } while (validacion == true);
        
        return nave;
    }
     
     public Familia[][] ColisionConAsteroide(Familia[][] familias){
        int cuadrante, fila, columna, muertes;
        ArrayList<Persona> familia;
        Persona persona;

        cuadrante = (int)(Math.random()*4);
        fila = cuadrante;
        columna = cuadrante;
        muertes = 0;

        for (int k = 0; k < 6; k++){
            familia = familias[fila][columna].getFamilia();
            for (int n = 0; n < familia.size(); n++){
                persona = familia.get(n);
                if (persona.getEstado() == true){
                    persona.setEstado(false);
                    muertes++;
                }
            }
            columna++;
            if (columna == 5){
                columna = 0;
                fila++;
            }
        }

        System.out.println(muertes + " personas murieron debido a la colisión de un asteroide en el cuadrante " + cuadrante);

        return familias;
    }
     
     public int obtenerRandomFamilia() {
        int min = 0;
        int max = 4;

        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
    
}
