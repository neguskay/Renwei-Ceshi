package main;

public class TestMain {

    public static void main (String[] args){


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
    }


}
