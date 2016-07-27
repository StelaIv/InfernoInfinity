package com.company.io;

import com.company.interfaces.IWriter;

public class ConsoleWriter implements IWriter {

    @Override
    public void write(String output) {
        System.out.println(output);
    }
}
