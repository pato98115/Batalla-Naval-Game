
package Controlador;

import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.Juego.FactoryBarcos.TipoDeBarco;
import Modelo.Juego.StrategyDisparo.Disparo;
import Modelo.*;
import Vistas.vistas.VistaConfig;
import Vistas.vistas.VistaInicio;
import Vistas.vistas.VistaJuego;
import Vistas.vistas.VistaLogin;

import java.awt.*;
import java.util.ArrayList;

public class Controlador implements Observer {
    private Modelo modelo;
    private VistaConfig vistaConfig;
    private VistaInicio vistaInicio;
    private VistaLogin vistaLogin;
    private VistaJuego vistaJuego;

    private char ultimaOrientacion;
    private Avatar avatarJ1;
    private String nombreJ1;
    private Color colorFondo;


    public Controlador(Modelo modelo) {
        setModelo(modelo);
        vistaInicio = new VistaInicio(this, modelo);
        vistaConfig = new VistaConfig(this, modelo);
        vistaLogin = new VistaLogin(this, modelo);

        vistaInicio.ubicarAlMedio();
        vistaConfig.ubicarAlMedio();
        vistaLogin.ubicarAlMedio();


        vistaInicio.hacerVisible(true);
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
        modelo.addObserver(this);
    }

    public void dispararEnTablero(int fila, int columna) throws InvalidDisparoException {
        modelo.dispararEn(fila,columna);
    }
    public void elegirDisparo(String disparo){
        modelo.setDisparo(toDisparo(disparo));
    }
    public void pausar(){
        modelo.pausar(true);
    }
    public void continuar(){
        modelo.pausar(false);
    }
    public void elegirBarco(String tipoDeBarco){
        modelo.selecBarco(toBarco(tipoDeBarco));
    }

    public void setOrientacionBarco(char orientacionBarco){
        this.ultimaOrientacion = orientacionBarco;
    }
    public char getUltimaOrientacion() {
        return ultimaOrientacion;
    }

    public void ponerBarco(int fila, int columna)throws InvalidPosicionBarco {
        modelo.setBarcoActual(this.ultimaOrientacion,fila,columna);
    }
    public void irLogIn(){
        /*
        se apaga la vista de inicio
        se enciende la vista de LogIn
         */

        vistaInicio.hacerVisible(false);
        vistaLogin.hacerVisible(true);

    }
    public void volverInicio(){

        /*
        se apaga la vista de login, configuracion o juego,
        se enciende la vista de inicio
         */
        if(vistaJuego!=null){
            vistaJuego.hacerVisible(false);
        }

        vistaLogin.hacerVisible(false);
        vistaConfig.hacerVisible(false);
        vistaInicio.hacerVisible(true);
    }
    public void irConfigAyuda(){

        /*
        se apaga la vista de inicio
        se enciende la vista de configuracion y ayuda
         */

        vistaInicio.hacerVisible(false);
        vistaConfig.hacerVisible(true);
    }
    public void irJuego(){
        if(modelo.estaRegistrado()){

            /*
            se apaga la vista de inicio
            se enciende la vista de juego
             */

            this.vistaJuego = new VistaJuego(this, this.modelo);
            vistaJuego.ubicarAlMedio();
            if(colorFondo!=null){
                vistaJuego.cambiarFondo(colorFondo);
            }

            vistaInicio.hacerVisible(false);
            vistaJuego.hacerVisible(true);
            modelo.crearJuego();
            modelo.puedePonerBarcos(true);
            modelo.puedeDisparar(false);

        }else vistaInicio.mensajeError();
    }

    public void revancha(){
        this.vistaJuego.hacerVisible(false);
        this.vistaJuego = new VistaJuego(this, this.modelo);
        vistaJuego.ubicarAlMedio();
        if(colorFondo!=null){
            vistaJuego.cambiarFondo(colorFondo);
        }
        vistaJuego.hacerVisible(true);
        modelo.crearJuego();
        modelo.puedePonerBarcos(true);
        modelo.puedeDisparar(false);

    }
    public void terminarJuego(){
        this.vistaJuego.hacerVisible(false);
        this.vistaJuego = null;
    }

    public void start(){
        if(modelo.estaListoParaJugar()){
            modelo.puedeDisparar(true);
            modelo.puedePonerBarcos(false);
            modelo.runJuego();

        }

    }

    public void registrarJugador(){
        if(this.nombreJ1 != null && this.avatarJ1 !=null) {
            modelo.registrarJugador1(avatarJ1, nombreJ1);

        }
    }

    public void setAvatarJ1(String avatar){
        this.avatarJ1 = toAvatar(avatar);
    }

    public void setNombreJ1(String nombre){
        this.nombreJ1 = nombre;
    }


    /**
     * setear el mismo color a las vistas menos la de inicio
     * @param color
     */

    public void selecColor(Color color){
        this.colorFondo = color;
        vistaConfig.cambiarFondo(color);
        vistaLogin.cambiarFondo(color);

        if(vistaJuego!=null){
            vistaJuego.cambiarFondo(color);
        }


    }

    public void mute(){
    }
    public void unmute(){
    }


    private Disparo toDisparo(String s) {
        s = s.toUpperCase();
        switch (s){
            case "ALEATORIO": return Disparo.ALEATORIO;
            case "COMUN": return Disparo.COMUN;
            case "CORTADO": return Disparo.CORTADO;
            case "CRUZ": return Disparo.CRUZ;
            case "TERMODIRIGIDO": return Disparo.TERMODIRIGIDO;
            default: throw new IllegalStateException("Unexpected value: " + s);
        }
    }

    private TipoDeBarco toBarco(String s) {
        s = s.toUpperCase();
        switch (s){
            case "CANIONERO": return TipoDeBarco.CANIONERO;
            case "DESTRUCTOR": return TipoDeBarco.DESTRUCTOR;
            case "FRAGATA": return TipoDeBarco.FRAGATA;
            case "PORTAAVIONES": return TipoDeBarco.PORTAAVIONES;
            case "SUBMARINO": return TipoDeBarco.SUBMARINO;
            default: throw new IllegalStateException("Unexpected value: " + s);
        }
    }

    private Avatar toAvatar(String s) {
        s = s.toUpperCase();
        switch (s){
            case "FLASH": return Avatar.FLASH;
            case "SPIDERMAN": return Avatar.SPIDERMAN;
            case "BATMAN": return Avatar.BATMAN;
            default: throw new IllegalStateException("Unexpected value: " + s);
        }
    }

    public String getNombreJ1() {
        return nombreJ1;
    }

    public boolean barcoParaPonerDisponible(String tipoBarco){
        return modelo.getJuegoBatallaNaval().getJugador1().barcoParaPonerDisponible(toBarco(tipoBarco));
    }

    public boolean disparoDisponible(String tipoDisparo){
        return modelo.getJuegoBatallaNaval().getJugador1().disparoDisponible(toDisparo(tipoDisparo));
    }

    @Override
    public void update() {

    }

}
