package Vistas.vistas;
import Controlador.Controlador;
import Modelo.Modelo;
import Modelo.Observer;
import Vistas.paneles.PanelInicio;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class VistaInicio implements ActionListener, Observer {
    private JFrame frame;
    private PanelInicio panel;
    private ArrayList<JButton> botones;
    private Controlador controlador;
    private Modelo modelo;

    public VistaInicio(Controlador controlador, Modelo modelo) {
        frame=new JFrame("Inicio");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,500,500);
        panel = new PanelInicio();
        frame.add(panel,BorderLayout.CENTER);
        botones=panel.getBotones();
        setObserver();
        this.controlador = controlador;
        this.modelo = modelo;
        this.modelo.addObserver(this);


    }
    public void hacerVisible(boolean b) {
        frame.setVisible(b);
    }
    public void ubicarAlMedio() {
        frame.setLocationRelativeTo(null);
    }
    private void setObserver() {
        for(JButton boton: botones) {
            boton.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {  //toma el evento desde la interfaz
        // TODO Auto-generated method stub
        if(e.getSource()==botones.get(0)) {
            System.exit(0);
        }else if(e.getSource()==botones.get(1)) {
            System.out.println("boton Iniciar Partida");
            this.controlador.irJuego();

        }else if(e.getSource()==botones.get(2)) {
            System.out.println("boton Registrarse");
            this.controlador.irLogIn();

        }else if(e.getSource()==botones.get(3)) {
            System.out.println("boton Configuracion-Ayuda");
            this.controlador.irConfigAyuda();

        }

    }

    public void mensajeError(){
        JOptionPane.showMessageDialog(null, "Debes registrarte antes de iniciar la partida!","Error", JOptionPane.ERROR_MESSAGE);
    }
    public void update() {

    }



}
