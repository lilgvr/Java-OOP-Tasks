package ru.gavrilenko.weapons.block9;

public class Gun {
    private int ammo;
    private int max;

    public Gun(int ammo, int max){
        this.max = max;
        if(ammo >= max) this.ammo = max;
        if(ammo < 0) throw new IllegalArgumentException("У пистолета число патронов не может быть отрицательным");
        this.ammo = ammo;
    }

    public Gun(){
        this.ammo = 5;
    }

    public int reload(int n){
        int extra;
        if(n < 0) throw new IllegalArgumentException("У пистолета число патронов не может быть отрицательным");
        if(n > max){
            extra = n - max;
            this.ammo = max;
            return extra;
        }else{
            this.ammo = n;
        }

        return 0;
    }

    public void shoot(){
        if(this.ammo > 0){
            System.out.println("Бах!");
            this.ammo--;
        }
        else System.out.println("Клац!");
    }

    public int discharge(){
        int tmp = this.ammo;
        this.ammo = 0;
        return tmp;
    }

    public int getAmmo() {
        return ammo;
    }

    public boolean isCharged(){
        return !(ammo == 0);
    }

    public int getMax() {
        return max;
    }
}

class MachineGun extends Gun{
    private int ammo, max, rate;

    public MachineGun(){
        this.rate = 30;
        this.max = 30;
    }

    public MachineGun(int max){
        if(max <=0) throw new IllegalArgumentException();
        this.max = max;
        this.rate = max / 2;
    }

    public MachineGun(int max, int rate){
        if(max <=0 || rate <= 0) throw new IllegalArgumentException();
        this.max = max;
        this.rate = rate;
    }

    public void shoot(){
        for(int i = 0; i < rate; i++){
            if(this.ammo > 0){
                System.out.println("Бах!");
                this.ammo--;
            }
            else System.out.println("Клац!");
        }
    }

    public void shoot(int n){
        if(n <=0) throw new IllegalArgumentException();
        for(int i = 0; i < rate*n; i++){
            if(this.ammo > 0){
                System.out.println("Бах!");
                this.ammo--;
            }
            else System.out.println("Клац!");
        }
    }
}
