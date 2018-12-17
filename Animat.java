package proyecto;


import java.util.Random;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author velasam
 */
public class Animat {
    private int posx; //posición vertical
    private int posy; //posición horizontal
    private int limr; //número de renglones
    private int limc; //número de columnas
    private String nombre;
    private JTextField grid[][];

    public Animat(int m, int n, JTextField[][] grid) {
        limr = m-1;
        limc = n-1;
        this.grid = grid;
        Random r = new Random();
        posx = 1;
        posy = 1;
        while (posx%2 != 0 && posy%2 != 0) {
            posx = r.nextInt(m);
            posy = r.nextInt(n);
        }
        nombre = "@" + r.nextInt(101);
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void sexyMovimiento() {
        //En vertical y horizontal es múltiplo de 4
        if (posx%4 == 0 && posy%4 == 0) {
            //Hacia arriba o a la derecha
            int difx, dify;
            difx = posx;
            dify = limc - posy;
            //Hay bomba a la derecha
            if (posy < limc && grid[posx][posy+1].getText().equals("X"))
                posy++;
            //Hay bomba arriba
            else if (posx > 0 && grid[posx-1][posy].getText().equals("X"))
                posx--;
            //Puedo explorar más arriba
            else if (difx >= dify && posx > 0)
                posx--;
            //Puedo explorar más a la derecha
            else if (difx < dify && posy < limc)
                posy++;
            return;
        }
        
        //En vertical es par y horizontal es múltiplo de 4
        if (posx%4 == 2 && posy%4 == 0) {
            //Hacia arriba o a la izquierda
            //Hay bomba a la izquierda
            if (posy > 0 && grid[posx][posy-1].getText().equals("X"))
                posy--;
            //Hay bomba arriba
            else if (posx > 0 && grid[posx-1][posy].getText().equals("X"))
                posx--;
            //Puedo explorar más arriba
            else if (posx >= posy && posx > 0)
                posx--;
            //Puedo explorar más a la izquierda
            else if (posx < posy && posy > 0)
                posy--;
            return;
        }
        
        //En vertical es múltiplo de 4 y en horizontal es par
        if (posx%4 == 0 && posy%4 == 2) {
            //Hacia abajo o a la derecha
            int difx = limr - posx;
            int dify = limc - posy;
            //Hay bomba a la derecha
            if (posy < limc && grid[posx][posy+1].getText().equals("X"))
                posy++;
            //Hay bomba abajo
            else if (posx < limr && grid[posx+1][posy].getText().equals("X"))
                posx++;
            //Puedo explorar más abajo
            else if (difx >= dify && posx < limr)
                posx++;
            //Puedo explorar más a la derecha
            else if (difx < dify && posy < limc)
                posy++;
            return;
        }
        
        //En vertical y en horizontal es par
        if (posx%4 == 2 && posy%4 == 2) {
            //Hacia abajo o a la izquierda
            int difx = posx;
            int dify = limc - posy;
            //Hay bomba abajo
            if (posx < limr && grid[posx+1][posy].getText().equals("X"))
                posx++;
            //Hay bomba a la izquierda
            else if (posy > 0 && grid[posx][posy-1].getText().equals("X"))
                posy--;
            //Puedo explorar más abajo
            else if (difx >= dify && posx < limr)
                posx++;
            //Puedo explorar más a la izquierda
            else if (difx < dify && posy > 0)
                posy--;
            return;
        }
        
        //En vertical es múltiplo de 4
        if (posx%4 == 0) {
            //A la derecha
            if (posy < limc)
                posy++;
            return;
        }
        
        //En horizontal es múltiplo de 4
        if (posy%4 == 0) {
            //Hacia arriba
            if (posx > 0)    
                posx--;
            return;
        }
        
        //En vertical es par
        if (posx%4 == 2) {
            //A la izquierda
            if (posy > 0)
                posy--;
            return;
        }
        
        //En horizontal es par
        if (posy%4 == 2) {
            //Hacia abajo
            if (posx < limr)
                posx++;
        }
    }
    
}
