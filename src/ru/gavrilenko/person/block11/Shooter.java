package ru.gavrilenko.person.block11;

import ru.gavrilenko.weapons.block10.MachineGun;
import ru.gavrilenko.weapons.block10.Pistol;
import ru.gavrilenko.weapons.block10.Weapon;
import ru.gavrilenko.weapons.block10.WeaponType;

public class Shooter {
    private Weapon weapon;
    private String name;

    public Shooter(String name){
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public String getShooterName() {
        return name;
    }

    public void setWeapon(WeaponType weapon) {

        switch (weapon){
            case Pistol:
                this.weapon = new Pistol(0, 20);
            break;

            case MachineGun:
                this.weapon = new MachineGun();
            break;
        }
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void shoot(){
        if(weapon == null){
            System.out.println(name + ": Не могу участвовать в перестрелке");
            return;
        }
        weapon.shoot();
    }

    public int reload(int n){
        return weapon.reload(n);
    }
}
