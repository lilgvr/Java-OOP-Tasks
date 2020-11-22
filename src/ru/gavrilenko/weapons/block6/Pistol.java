package ru.gavrilenko.weapons.block6;

public class Pistol {
    private final int max;
    private int ammo;

    public Pistol(int ammo, int max) {
        if (ammo < 0 || max <= 0) throw new IllegalArgumentException();
        this.ammo = ammo;
        this.max = max;
    }

    public int getAmmo() {
        return ammo;
    }

    public int getMax() {
        return max;
    }

    public boolean isCharged() {
        return ammo == 0;
    }


    public void shoot() {
        if (ammo > 0) {
            System.out.println("Bang!");
            ammo--;
        } else {
            System.out.println("*Click*");
        }
    }

    public int reload(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Невозможно зарядить пистолет отрицательным количеством патронов");

        int t;
        if (n > max) {
            t = n - max;
            ammo = max;
            return t;
        }

        if (n == 0) return 0;
        ammo = n;

        return 0;

    }

    public int discharge() {
        int tmp = ammo;

        ammo = 0;

        return tmp;
    }

}
