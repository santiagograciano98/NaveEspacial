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

    public void aplicarLocura(int tickMuerte) {
        Desastre desastres1 = new Desastre();
        this.nave = desastres1.aplicarDesastreLocura(nave, tickMuerte);

    }

    public void aplicarColision() {
        System.out.println("colision");
    }

    public void aplicarFuga() {
        //se expulsa de la nave a las tres personas mas viejas
        System.out.println("fuga");
        Desastre desastres1 = new Desastre();
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


}
