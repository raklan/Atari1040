package player;

import java.io.*;

/**
 * Made by Jake
 */

public class highScorePong {

    int previousScore;

    public int readPongHighScore(){
        try {
            //Create an object that opens a file for writing data
            //FileInputStream fileIn = new FileInputStream("info.txt");
            //Create a stream object that connects to the file
            DataInputStream dataIn = new DataInputStream(new FileInputStream("highScoresPong.txt"));
            previousScore = dataIn.readInt();
            dataIn.close();

        }catch(IOException e){
            e.printStackTrace();
        }
        return previousScore;
    }

    public void writePongInvaders(int n){
        try{
            //Create an object that opens a file for writing data
            //FileOutputStream fileOut = new FileOutputStream("info.txt");
            //Create a stream object that connects to the file
            DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("highScoresPong.txt"));
            if(n>previousScore){
                dataOut.writeInt(n);
                dataOut.close();
            }
            else{
                dataOut.close();
            }

        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
