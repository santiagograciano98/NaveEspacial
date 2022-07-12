package co.edu.udea.naveespacial;

public class Nave {

    private Familia[][] nave;
    private Desastre desastres;

    public Nave() {
        this.nave = new Familia[5][5];
    }

    public Nave(Familia[][] nave) {
        this.nave = nave;
    }

    public Familia[][] getNave() {
        return nave;
    }

    public void setNave(Familia[][] nave) {
        this.nave = nave;
    }

    public void agregarFamiliaEnNave(Familia familia, int fila, int columna) {
        this.nave[fila][columna] = familia;
    }

    public void aplicarLocura() {
        boolean validacion = true;
        do {
            int posicionFila = this.obtenerRandomFamilia();
            int posicionColumna = this.obtenerRandomFamilia();
            boolean estadoFamilia = this.nave[posicionFila][posicionColumna].isEstado();
            if (estadoFamilia) {
                for (int i = 0; i < this.nave[posicionFila][posicionColumna].getFamilia().size(); i++) {
                    this.nave[posicionFila][posicionColumna].getFamilia().get(i).setEstado(false);
                }
                this.nave[posicionFila][posicionColumna].setEstado(false);
                validacion = false;
            }

        } while (validacion == true);

    }

    public void aplicarColision() {
        System.out.println("colision");
    }

    public void aplicarFuga() {
        //se expulsa de la nave a las tres personas mas viejas
        System.out.println("fuga");
        this.nave = this.desastres.fugaDeAire(nave);
        
    }

    public void consultarMatriz() {
        System.out.println(this.nave[0][0]);
        System.out.println(this.nave[4][4]);

    }

    public double probabilidadCatastrofe() {
        double probabilidad = Math.random();
        return probabilidad;
    }

    public int obtenerRandomFamilia() {
        int min = 0;
        int max = 4;

        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

}
