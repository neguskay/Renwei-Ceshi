package main;

import parts.three.PartThree;

import java.io.IOException;
import java.sql.SQLException;

public class TestMain {

    public static void main (String[] args) throws IOException, SQLException, ClassNotFoundException {


        Object[][] lol = {
                {"Sidney", "Love",},
                {1, 2}
        };

        for (int i = 0; i <lol.length ; i++) {
            System.out.println(i + " || ");
            for (int j = 0; j <lol[i].length ; j++) {
                System.out.print(lol[i][j]+ " || ");
            }
        }


        new PartThree();
    }


}
