package Modelo.Juego.ElementosPrincipales;

public class EstadoDelJuego {
    private boolean esTurnoDelJ1;
    private boolean esTurnoDelJ2;
    private boolean barcosJ1Posicionados;
    private boolean barcosJ2Posicionados;
    private boolean ganoJ1;
    private boolean ganoJ2;
    private boolean colocandoBarcos;
    private boolean disparando;
    private static int[][] jugadorN1;
    private static int[][] jugadorN2;

    public EstadoDelJuego(){
        barcosJ1Posicionados=false;
        barcosJ2Posicionados=false;
        colocandoBarcos=true;
        disparando=false;
        ganoJ1=false;
        ganoJ2=false;
        esTurnoDelJ1=false;
        esTurnoDelJ2=false;
    }

    private void crearMatrizJugadorN1(int filas,int columnas) {
        jugadorN1 = new int[filas][columnas];
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                jugadorN1[i][j]=0;
            }
        }
    }
    private void crearMatrizJugadorN2(int filas,int columnas) {
        jugadorN2 = new int[filas][columnas];
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                jugadorN2[i][j]=0;
            }
        }
    }
    public int[][] getMatrizJugadorN1(){
        return jugadorN1;
    }

    public int[][] getMatrizJugadorN2(){
        return jugadorN2;
    }

    public void setMatrizJugadorN1(int[][] matrizJugadorN1){
        this.jugadorN1=matrizJugadorN1;
    }
    public void setMatrizJugadorN2(int[][] matrizJugadorN2){
        this.jugadorN2=matrizJugadorN2;
    }

    public boolean isColocandoBarcos() {
        return colocandoBarcos;
    }

    public boolean isDisparando() {
        return disparando;
    }
    public boolean todosPosicionados(){
        return (barcosJ1Posicionados && barcosJ2Posicionados);
    }
    public boolean hayGanador(){
        return (ganoJ1||ganoJ2);
    }
    public boolean isEsTurnoDelJ1() {
        return esTurnoDelJ1;
    }

    public boolean isEsTurnoDelJ2() {
        return esTurnoDelJ2;
    }
    public void setEsTurnoDelJ1(boolean esTurnoDelJ1) {
        this.esTurnoDelJ1 = esTurnoDelJ1;
    }

    public void setEsTurnoDelJ2(boolean esTurnoDelJ2) {
        this.esTurnoDelJ2 = esTurnoDelJ2;
    }
    public void setBarcosJ1Posicionados(boolean barcosJ1Posicionados) {
        this.barcosJ1Posicionados = barcosJ1Posicionados;
    }

    public void setBarcosJ2Posicionados(boolean barcosJ2Posicionados) {
        this.barcosJ2Posicionados = barcosJ2Posicionados;
    }

    public void setColocandoBarcos(boolean colocandoBarcos) {
        this.colocandoBarcos = colocandoBarcos;
    }

    public void setDisparando(boolean disparando) {
        this.disparando = disparando;
    }

}