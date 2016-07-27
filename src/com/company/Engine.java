package com.company;

import com.company.interfaces.IEngine;
import com.company.interfaces.IReader;
import com.company.interfaces.IWriter;
import com.company.models.Weapon;
import com.company.enums.GemType;
import com.company.enums.WeaponType;
import com.company.interfaces.IFactory;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Engine implements IEngine {
    private IFactory factory;
    private IReader reader;
    private IWriter writer;
    private List<Weapon>weapons;

    public Engine(IFactory factory,IReader reader, IWriter writer) {
        this.setFactory(factory);
        this.setReader(reader);
        this.setWriter(writer);
        this.setWeapons();
    }

    public void setFactory(IFactory factory) {
        this.factory = factory;
    }

    private void setWeapons() {
        this.weapons  = new LinkedList<>();
    }

    private void setReader(IReader reader) {
        this.reader = reader;
    }

    private void setWriter(IWriter writer) {
        this.writer = writer;
    }

    @Override
    public void run() throws IOException {
        String command = this.reader.readLine();

        while(!command.equals("END")){
            String[] commandArgs =command.split(";");
            switch (commandArgs[0]){
                case"Create":
                    Weapon  weapon = this.factory.createWeapon(WeaponType.valueOf(commandArgs[1]),commandArgs[2]);
                    this.weapons.add(weapon);
                    break;
                case"Add":
                    for (Weapon weapon1 : this.weapons) {
                        if (weapon1.getName().equals(commandArgs[1])){
                            int index = Integer.parseInt(commandArgs[2]);
                            this.factory.addGemsToWeapon(weapon1,index, GemType.valueOf(commandArgs[3]));
                            break;
                        }
                    }
                    break;
                case"Remove":
                    for (Weapon weapon1 : this.weapons) {
                        if (weapon1.getName().equals(commandArgs[1])){
                            int indexToRemove = Integer.parseInt(commandArgs[2]);
                            this.factory.removeGemFromAWeapon(weapon1,indexToRemove);
                            break;
                        }
                    }
                    break;
                case"Print":
                    for (Weapon weapon1 : this.weapons) {
                        if (weapon1.getName().equals(commandArgs[1])){
                            this.writer.write(this.factory.printWeapon(weapon1));
                            break;
                        }
                    }
                    break;
                default:break;
            }
            command=this.reader.readLine();
        }

    }
}
