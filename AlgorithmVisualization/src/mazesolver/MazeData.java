package mazesolver;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class MazeData {

    public static final char ROAD = ' ';
    public static final char WALL = '#';

    private int entranceX, entranceY;
    private int exitX, exitY;

    private int H, W;
    private char[][] maze;

    public boolean[][] visited;
    public boolean[][] path;

    public MazeData(String filename) {

        if (filename == null)
            throw new IllegalArgumentException("Filename can not be null!");

        Scanner scanner = null;
        try {
            File file = new File(filename);
            if(!file.exists())
                throw new IllegalArgumentException("File " + filename + " doesn't exist");

            FileInputStream fis = new FileInputStream(file);
            scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");

            // 读取第一行
            String nmline = scanner.nextLine();
            String[] nm = nmline.trim().split("\\s+");

            H = Integer.parseInt(nm[0]);
            W = Integer.parseInt(nm[1]);

            // 读取后续的N行
            maze = new char[W][H];
            visited = new boolean[W][H];
            path = new boolean[W][H];
            for(int i = 0 ; i < H; i ++){
                String line = scanner.nextLine();

                // 每行保证有M个字符
                if(line.length() != W)
                    throw new IllegalArgumentException("Maze file " + filename + " is invalid");
                for(int j = 0 ; j < W; j ++) {
                    maze[j][i] = line.charAt(j);
                    visited[j][i] = false;
                    path[j][i] = false;
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally {
            if(scanner != null)
                scanner.close();
        }

        entranceX = 0;
        entranceY = 1;
        exitX = W - 2;
        exitY = H - 1;
    }

    public int W(){ return W; }
    public int H(){ return H; }
    public int getEntranceX(){ return entranceX; }
    public int getEntranceY(){ return entranceY; }
    public int getExitX(){ return exitX; }
    public int getExitY(){ return exitY; }
    public char getMaze(int x, int y){
        if(!inArea(x,y))
            throw new IllegalArgumentException("i or j is out of index in getMaze!");

        return maze[x][y];
    }

    public boolean inArea(int x, int y){
        return x >= 0 && x < W && y >= 0 && y < H;
    }

    public void print(){
        System.out.println(H + " " + W);
        for(int i = 0 ; i < H ; i ++){
            for(int j = 0 ; j < W ; j ++)
                System.out.print(maze[j][i]);
            System.out.println();
        }
        return;
    }
    public static void main(String[] args) {
        String mazeFile = "src/mazesolver/maze_101_101.txt";

        MazeData maze = new MazeData(mazeFile);
        maze.print();
    }
}
