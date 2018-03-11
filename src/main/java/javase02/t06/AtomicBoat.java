package javase02.t06;

import java.awt.*;

public class AtomicBoat
{
    private EngineOfAtomicBoat engine;
    private WeaponSystemOfAtomicBoat weaponsystem;


    AtomicBoat()
    {
        engine = new EngineOfAtomicBoat();
        weaponsystem = new WeaponSystemOfAtomicBoat();
    }

    public void activateWeaponSystem()
    {
        weaponsystem.activateWeaponSystem();
    }

    public void deactivateWeaponSystem()
    {
        weaponsystem.deactivateWeaponSystem();
    }

    public void startEngine()
    {
        engine.startEngine();
    }

    public void stopEngine()
    {
        engine.stopEngine();
    }

    public void statusOfBoat()
    {
        System.out.println(String.format("Engine - %s\nWeapon System - %s",engine.isEngineWorking(),
                weaponsystem.isWeaponSystemWorking()));



    }

    private class WeaponSystemOfAtomicBoat
    {
         boolean isWeaponSystemWorking() {
            return weaponSystemWorking;
        }

        private boolean weaponSystemWorking;

        WeaponSystemOfAtomicBoat()
        {
            weaponSystemWorking = false;
        }

         void activateWeaponSystem()
        {
            if (weaponSystemWorking)
            {
                System.out.println("Weapon system already ON...");
            }
            else
            {
                weaponSystemWorking = true;
                System.out.println("Weapon system - ON");
            }
        }

         void deactivateWeaponSystem()
        {
            if (weaponSystemWorking)
            {
                weaponSystemWorking = false;
                System.out.println("Weapon system - OFF...");
            }
            else
            {
                System.out.println("Weapon system already OFF...");
            }
        }



    }

    private class EngineOfAtomicBoat
    {
         boolean isEngineWorking() {
            return engineWorking;
        }

        private boolean engineWorking;

        EngineOfAtomicBoat()
        {
            engineWorking = false;
        }

         void startEngine()
        {
            if (engineWorking)
            {
                System.out.println("Engine already ON...");
            }
            else
            {
                engineWorking = true;
                System.out.println("Engine - ON");
            }
        }


         void stopEngine()
        {
            if(engineWorking)
            {
                engineWorking = false;
                System.out.println("Engine - OFF");
            }
            else
            {
                System.out.println("Engine already OFF...");
            }
        }



    }

}
