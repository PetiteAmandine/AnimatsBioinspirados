/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author velasam
 */
public class Tablero extends javax.swing.JFrame {
    private int tiempo;
    private int bombs[][];
    private Animat ani[];
    private JTextField grid[][];

    /**
     * Creates new form Tablerox
     */
    public Tablero(int r, int c, int anis, int maxT) {
        tiempo = 0;
        ani = new Animat[anis];
        grid = new JTextField[r][c];
        double ancho, alto;
        int posx, posy;
        ancho = 200/c;
        alto = 200/r;
        posx = 25;
        posy = 25;
        JPanel myPanel = (JPanel)this.getContentPane();
        myPanel.setLayout(null);
        Dimension d = new Dimension();
        initComponents();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = new JTextField("");
                grid[i][j].setEditable(false);
                d.setSize(ancho, alto);
                grid[i][j].setBounds((int)(j*ancho)+25, (int)(i*alto)+35, (int)ancho, (int)alto);
                myPanel.add(grid[i][j]);
                if (i%2 != 0 && j%2 != 0)
                    grid[i][j].setBackground(Color.BLACK);
            }
        }
        Random rand = new Random();
        int numbombs = rand.nextInt((int)Math.floor(0.3*r*c));
        bombs = new int[numbombs][2];
        for (int i = 0; i < numbombs; i++) {
            bombs[i][0] = rand.nextInt(r);
            bombs[i][1] = rand.nextInt(c);
            while (bombs[i][0]%2 != 0 && bombs[i][1]%2 != 0) {
                bombs[i][0] = rand.nextInt(r);
                bombs[i][1] = rand.nextInt(c);
        }
            grid[bombs[i][0]][bombs[i][1]].setText("X");
        }
        for (int i = 0; i < anis; i++) {
            Animat a = new Animat(r, c);
            while (grid[a.getPosx()][a.getPosy()].getText().equals("@") || grid[a.getPosx()][a.getPosy()].getText().equals("X")) {
                a = new Animat(r,c);
            }
            grid[a.getPosx()][a.getPosy()].setText("@");
            ani[i] = a;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscabombas");
        setPreferredSize(new java.awt.Dimension(450, 450));
        setSize(new java.awt.Dimension(450, 450));

        jLabel1.setText("Movimientos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(425, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}