package co.edu.udea.naveespacial;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Nave nave = new Nave();
        LeerArchivo.crearNave(nave);

        double probabilidad;

        for (int i = 0; i <= 10; i++) {
            if (i != 10) {
                probabilidad = nave.probabilidadCatastrofe();
                if (probabilidad <= 0.4) {
                    probabilidad = nave.probabilidadCatastrofe();
                    if (probabilidad <= 0.1) {
                        //nave.aplicarColision(i);
                        continue;
                    } else if (probabilidad > 0.1 && probabilidad <= 0.5) {
                        //nave.aplicarLocura(i);
                        continue;
                    } else if (probabilidad > 0.5) {
                        nave.aplicarFuga();
                    }
                }
            }
            if (i == 10) {
                System.out.println("Llego a Marte");
            }

        }
        nave.consultarMatriz();

    }

}
