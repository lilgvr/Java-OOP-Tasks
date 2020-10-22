package ru.gavrilenko.weapons.block5;

public class Pistol {
    private int ammo;

    public Pistol(){
        this.ammo = 5;
    }

    public Pistol(int ammo){
        if(ammo <= 0) this.ammo = 0;
        else this.ammo = ammo;
    }

    public void shoot(){
        if(ammo > 0) {
            System.out.println("Bang!");
            ammo--;
        }
        else System.out.println("*Click*");
    }
}
