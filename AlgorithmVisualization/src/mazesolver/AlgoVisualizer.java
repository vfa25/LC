package mazesolver;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

public class AlgoVisualizer {

    private static int blockSide = 8;
    private static int DELAY = 5;

    private MazeData data;         // 数据
    private AlgoFrame frame;     // 视图

    private static final int d[][] = {{-1,0},{0,1},{1,0},{0,-1}};

    public AlgoVisualizer(String mazeFile) {

        // 初始化数据
        // 构建二维矩阵
        data = new MazeData(mazeFile);

        int sceneWidth = data.N() * blockSide;
        int sceneHeight = data.M() * blockSide;

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("迷宫求解", sceneWidth, sceneHeight);

            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run() {
        setData(-1, -1, false);

        if (!go(data.getEntranceX(), data.getEntranceY()))
            System.out.println("The maze has NO solution.");

        setData(-1, -1, false);
    }

    // 从(x, y)的位置开始求解迷宫，如果求解成功，返回true；否则返回false
    private boolean go(int x, int y) {

        if(!data.inArea(x,y))
            throw new IllegalArgumentException("x,y are out of index in go function!");

        data.visited[x][y] = true;
        setData(x, y, true);

        if (x == data.getExitX() && y == data.getExitY())
            return true;

        for(int i = 0; i < 4; i ++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (data.inArea(newX, newY)
                    && data.getMaze(newX, newY) == MazeData.ROAD
                    && !data.visited[newX][newY])
                if (go(newX, newY))
                    return true;
        }

        setData(x, y, false);

        return false;
    }

    private void setData(int x, int y, boolean isPath) {
        if (data.inArea(x, y)) {
            data.path[x][y] = isPath;
        }
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {

        String mazeFile = "src/mazesolver/maze_101_101.txt";

        AlgoVisualizer vis = new AlgoVisualizer(mazeFile);
    }
}
