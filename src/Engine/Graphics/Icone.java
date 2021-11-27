package Engine.Graphics;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Icone extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JPanel contentPane;
    JPanel panelCentre = new JPanel();
    JLabel imageLabel = new JLabel();
    JLabel headerLabel = new JLabel("HEADER");

    public Icone() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            contentPane = (JPanel) getContentPane();
            contentPane.setLayout(new BorderLayout());
            setSize(new Dimension(400, 300));
            setTitle("Mousse de canard !");
            contentPane.add(headerLabel, BorderLayout.NORTH);
            ImageIcon ii = new ImageIcon("/Users/ousmanecisse/Desktop/COURS_MASTER1/GL/PROJET2/src/API/ressource/pacman_img/right.gif");
            imageLabel.setIcon(ii);
            imageLabel.setBounds(20,20,ii.getIconWidth(),ii.getIconHeight());
            panelCentre.setLayout(null);
            panelCentre.setBackground(Color.red);
            panelCentre.add(imageLabel);
            contentPane.add(panelCentre,BorderLayout.CENTER);
            this.setLocation(0,0);// position de la fenêtre 
            this.setVisible(true);
            //while (true) this.repaint();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }



    public static void main(String[] args) {
        new Icone();
    }

}