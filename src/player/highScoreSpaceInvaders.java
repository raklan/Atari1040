package player;

import java.io.*;

public class highScoreSpaceInvaders {

    public static void readSpaceInvadersHighScore(){
        int previousScore;
        try {
            //Create an object that opens a file for writing data
            //FileInputStream fileIn = new FileInputStream("info.txt");
            //Create a stream object that connects to the file
            DataInputStream dataIn = new DataInputStream(new FileInputStream("highScoreSpaceInvaders.txt"));
            previousScore = dataIn.readInt();
            dataIn.close();

        }catch(IOException e){
            e.printStackTrace();
        }
        //return previousScore;
    }

    public void writeHighScoreSpaceInvaders(int n){
        int previousScore;
        try{
            //Create an object that opens a file for writing data
            //FileOutputStream fileOut = new FileOutputStream("info.txt");
            //Create a stream object that connects to the file
            DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("highScoreSpaceInvaders.txt"));
            if(n>0){//this is where previous score is gonna go
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

    public static void main(String[]args){

    }
}
