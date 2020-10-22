package ru.gavrilenko.weapons.block10;

public class Pistol extends Weapon{
    private int max;

    public Pistol(int ammo, int max) {
        super(ammo);

        if(max <= 0 || ammo < 0) throw new IllegalArgumentException();
        this.max = max;
        if(ammo >= max) {
            super.ammo = max;
        }
    }

    public void shoot() {
        if(this.ammo > 0){
            System.out.println("BANG!");
            this.ammo--;
        }else{
            System.out.println("*CLICK*");
        }
    }

    public int reload(int ammo){
        if(ammo < 0) throw new IllegalArgumentException("ammo < 0 ");
        int extra = 0;
        if(ammo > max){
            extra = ammo - max;
            this.ammo = max;
        }else{
            this.ammo = ammo;
        }
        
        return extra;
    }

    public int discharge(){
        int t = this.ammo;
        this.ammo = 0;
        return t;
    }

    public void load(int n){
        this.reload(n);
    }

}
