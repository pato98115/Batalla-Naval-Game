package Vistas.paneles;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.util.ArrayList;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class PanelInicio extends JPanel {

    ArrayList<JButton> listaBotones;
    /**
     * Create the panel.
     */
    public PanelInicio() {
        this.setSize(500,500);

        JButton btnSalir = new JButton("Salir");
        JButton btnIniciarPartida = new JButton("Iniciar Partida");
        JButton btnRegistrarse = new JButton("Registrarse");
        JButton btnConfiguracionAyuda = new JButton("Configuraci\u00F3n - Ayuda");

        listaBotones = new ArrayList<JButton>();
        listaBotones.add(btnSalir);
        listaBotones.add(btnIniciarPartida);
        listaBotones.add(btnRegistrarse);
        listaBotones.add(btnConfiguracionAyuda);

       //JPanel logo = new PanelAvatar(new ImageIcon("C:\\Users\\alejandro\\Documents\\GitHub\\Ing-de-Software\\src\\main\\java\\Vistas\\imagenesAvatar\\logoBatallaNaval.jpg"));
      //JPanel logo = new PanelAvatar(new ImageIcon(getClass().getResource("C:\\Users\\alejandro\\Documents\\GitHub\\Ing-de-Software\\src\\main\\java\\Vistas\\imagenesAvatar\\logoBatallaNaval.jpg")));
        JPanel logo = new PanelAvatar(new ImageIcon("src\\main\\java\\Vistas\\imagenesAvatar\\logoBatallaNaval.jpg"));

        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(211)
                                .addComponent(btnRegistrarse, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addGap(192))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(406)
                                .addComponent(btnSalir, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                .addGap(31))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(188)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnIniciarPartida, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                        .addComponent(btnConfiguracionAyuda, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(173))
                        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                                .addContainerGap(122, Short.MAX_VALUE)
                                .addComponent(logo, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                                .addGap(157))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(63)
                                .addComponent(logo, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                                .addGap(45)
                                .addComponent(btnIniciarPartida)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnRegistrarse)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnConfiguracionAyuda)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(48, Short.MAX_VALUE))
        );
        setLayout(groupLayout);

    }
    @Override
    public void paintComponent(Graphics g) {
        Dimension tamanio=getSize();

        //ImageIcon imagen=new ImageIcon("C:\\Users\\alejandro\\Documents\\GitHub\\Ing-de-Software\\src\\main\\java\\Vistas\\imagenesFondo\\batallaNaval.jpg");
        ImageIcon imagen=new ImageIcon("src\\main\\java\\Vistas\\imagenesFondo\\batallaNavalrecortada.jpg");
        g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
    public ArrayList<JButton> getBotones(){
        return listaBotones;
    }
}

