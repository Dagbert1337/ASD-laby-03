import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class TreeDrawer {

    public static void drawTree(Node root, int nodeCount, File output) throws IOException {
        int depth = treeDepth(root);
        int nodeSpacing = 42;
        int levelSpacing = 54;
        int margin = 32;
        int width = Math.max(300, nodeCount * nodeSpacing + margin * 2);
        int height = Math.max(180, depth * levelSpacing + margin * 2);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();
        try {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setStroke(new BasicStroke(2));

            Map<Node, int[]> positions = new IdentityHashMap<>();
            int[] nextPosition = {0};
            assignPositions(root, 0, nextPosition, positions, nodeSpacing, levelSpacing, margin);
            drawEdges(root, positions, graphics);
            drawNodes(root, positions, graphics);
        } finally {
            graphics.dispose();
        }

        saveImage(image, output);
    }

    private static void saveImage(BufferedImage image, File output) throws IOException {
        if (!ImageIO.write(image, "png", output)) {
            throw new IOException("Nie udalo sie zapisac obrazu PNG.");
        }
        System.out.println("Zapisano wizualizacje drzewa: " + output.getAbsolutePath());
    }

    private static int treeDepth(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(treeDepth(node.getLeft()), treeDepth(node.getRight()));
    }

    private static void assignPositions(
            Node node,
            int level,
            int[] nextPosition,
            Map<Node, int[]> positions,
            int nodeSpacing,
            int levelSpacing,
            int margin
    ) {
        if (node == null) {
            return;
        }
        assignPositions(node.getLeft(), level + 1, nextPosition, positions, nodeSpacing, levelSpacing, margin);
        int x = margin + nextPosition[0] * nodeSpacing + nodeSpacing / 2;
        int y = margin + level * levelSpacing + levelSpacing / 2;
        positions.put(node, new int[]{x, y});
        nextPosition[0]++;
        assignPositions(node.getRight(), level + 1, nextPosition, positions, nodeSpacing, levelSpacing, margin);
    }

    private static void drawEdges(Node node, Map<Node, int[]> positions, Graphics2D graphics) {
        if (node == null) {
            return;
        }
        int[] parent = positions.get(node);
        graphics.setColor(new Color(90, 100, 115));
        for (Node child : new Node[]{node.getLeft(), node.getRight()}) {
            if (child != null) {
                int[] childPosition = positions.get(child);
                graphics.drawLine(parent[0], parent[1], childPosition[0], childPosition[1]);
            }
        }
        drawEdges(node.getLeft(), positions, graphics);
        drawEdges(node.getRight(), positions, graphics);
    }

    private static void drawNodes(Node node, Map<Node, int[]> positions, Graphics2D graphics) {
        if (node == null) {
            return;
        }
        drawValue(node.getValue(), positions.get(node), graphics, 42);
        drawNodes(node.getLeft(), positions, graphics);
        drawNodes(node.getRight(), positions, graphics);
    }

    private static void drawValue(int value, int[] position, Graphics2D graphics, int diameter) {
        graphics.setColor(new Color(65, 125, 210));
        graphics.fillOval(position[0] - diameter / 2, position[1] - diameter / 2, diameter, diameter);
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        String text = Integer.toString(value);
        int textWidth = graphics.getFontMetrics().stringWidth(text);
        graphics.drawString(text, position[0] - textWidth / 2, position[1] + 5);
    }
}
