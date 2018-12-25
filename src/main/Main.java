package main;

import parts.one.PartOne;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Cogitare");

        PartOne partOne = new PartOne();

        partOne.init();
    }
}
