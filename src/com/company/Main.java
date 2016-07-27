package com.company;

import com.company.factory.WeaponFactory;
import com.company.interfaces.IEngine;
import com.company.interfaces.IReader;
import com.company.interfaces.IWriter;
import com.company.io.ConsoleReader;
import com.company.io.ConsoleWriter;
import com.company.interfaces.IFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        IFactory factory = new WeaponFactory();
        IWriter consoleWriter= new ConsoleWriter();
        IReader consoleReader = new ConsoleReader();
        IEngine engine = new Engine(factory,consoleReader,consoleWriter);
        engine.run();
    }
}
