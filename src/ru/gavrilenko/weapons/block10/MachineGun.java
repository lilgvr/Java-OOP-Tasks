package ru.gavrilenko.weapons.block10;

public class MachineGun extends Weapon{
    private int rate, max;

    public MachineGun() {
        super(0);
        this.max = 30;
        this.rate = 30;
    }

    public MachineGun(int max){
        super(0);
        if(max <= 0) throw new IllegalArgumentException();
        this.max = max;
        this.rate = max / 2;
    }

    public MachineGun(int max, int rate){
        super(0);
        if(max <= 0 || rate <= 0) throw new IllegalArgumentException();
        this.max = max;
        this.rate = rate;
    }

    public int reload(int n){
        if(n < 0) throw new IllegalArgumentException("ammo < 0 ");
        int extra = 0;
        if(n > max){
            extra = n - max;
            this.ammo = max;
        }else{
            this.ammo = ammo;
        }

        return extra;
    }

    public void shoot(int n){
        if(n <= 0) throw new IllegalArgumentException();

//        if(n / rate > max) n = max;

        for(int i = 0; i < n; i++){
            shoot();
        }
    }

    public int getRate() {
        return rate;
    }

    public int getMax() {
        return max;
    }

    public void shoot() {

        for(int i = 0; i < rate; i++){

            if(this.ammo > 0){
                System.out.println("BANG!");
                this.ammo--;
            }else{
                System.out.println("*CLICK*");
            }
        }
    }
}
