package mazesolver;

import javax.swing.*;
import java.awt.*;

public class AlgoFrame extends JFrame {

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {

        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack(); // 自动布局整理

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public AlgoFrame(String title) {
        this(title, 1024, 768);
    }

    public int getCanvasWidth() { return canvasWidth; }
    public int getCanvasHeight() { return canvasHeight; }

    // TODO: 设置自己的数据
    private MazeData data;
    public void render(MazeData data) {
        this.data = data;
        repaint();
    }

    private class AlgoCanvas extends JPanel {

        public AlgoCanvas() {
            // 双缓存
            super(true);
        }

        // g为绘制的上下文环境
        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);

            // 具体绘制
            int w = canvasWidth / data.W();
            int h = canvasHeight / data.H();

            for(int i = 0; i < data.H(); i ++)
                for(int j = 0; j < data.W(); j ++) {
                    if (data.getMaze(j, i) == MazeData.WALL)
                        AlgoVisHelper.setColor(g2d, AlgoVisHelper.LightBlue);
                    else
                        AlgoVisHelper.setColor(g2d, AlgoVisHelper.White);

                    if (data.path[j][i])
                        AlgoVisHelper.setColor(g2d, AlgoVisHelper.Yellow);

                    AlgoVisHelper.fillRectangle(g2d, j*w, i*h, w, h);
                }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
