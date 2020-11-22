package ru.gavrilenko.weapons.block10;

public abstract class Weapon {
    protected int ammo;

    public Weapon(int ammo) {
        if (ammo < 0) throw new RuntimeException();
        this.ammo = ammo;
    }

    public abstract void shoot();

    public abstract int reload(int n);

    public int ammo() {
        return ammo;
    }

    public boolean getAmmo() {
        if (ammo == 0) return false;
        ammo--;
        return true;
    }

    public void load(int ammo) {
        if (ammo < 0) throw new RuntimeException();
        this.ammo += ammo;
    }
}
