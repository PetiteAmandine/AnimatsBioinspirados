package proyecto;


import java.util.Random;

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
    private int posx, posy;

    public Animat(int m, int n) {
        Random r = new Random();
        posx = 0;
        posy = 0;
        while (posx%2 != 0 && posy%2 != 0) {
            posx = r.nextInt(m);
            posy = r.nextInt(n);
        }
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
    
    public void sexyMovimiento() {
        if (posx%4 == 0 && posy%4 == 0) {
            
        }
        if (posx%4 == 0 && posy%4 == 2) {
            
        }
        if (posx%4 == 2 && posy%4 == 0) {
            
        }
        if (posx%4 == 2 && posy%4 == 2) {
            
        }
        if (posx%4 == 0) {
            posy++;
        }
        if (posy%4 == 0) {
            posx++;
        }
        if (posx%4 == 2) {
            
        }
        if (posy%4 == 2) {
            
        }
        else
            return;
    }
    
    
    
}
