import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class illusion {
	int boxesPerSide = 0;
	int boxSize = 0;
	int boxSpacing = 0;
	int border = 0;

	public static void main(String[] args) {
		new illusion().run();
	}

	private void run() {
		// TODO Auto-generated method stub
		border = 3;
		boxesPerSide = 4;
		boxSize = 20;
		boxSpacing = 3;
		JFrame f = new JFrame();
		BufferedImage image = new BufferedImage(getWindowWidth(border,
				boxesPerSide, boxSize, boxSpacing), getWindowWidth(border,
				boxesPerSide, boxSize, boxSpacing), BufferedImage.TYPE_INT_ARGB);
		Graphics2D boxGraphic = image.createGraphics();
		boxGraphic.setPaint(Color.BLACK);
		boxGraphic = fillBoxes(boxGraphic, boxesPerSide, boxSize, boxSpacing,
				border);
		ImageIcon icon = new ImageIcon(image);
		JLabel boxLabel = new JLabel(icon);
		f.setContentPane(boxLabel);
		f.getContentPane();
		f.pack();
		f.requestFocusInWindow();
		f.setResizable(false);
		f.setVisible(true);
	}

	private Graphics2D fillBoxes(Graphics2D boxGraphic, int boxesPerSide2,
			int boxSize2, int boxSpacing2, int border2) {
		// TODO Auto-generated method stub
		for (int y = 0; y < boxesPerSide; y++) {
			for (int x = 0; x < boxesPerSide; x++) {
				boxGraphic.fill(new Rectangle2D.Double(border + (x * boxSize)
						+ (x * boxSpacing), border + (y * boxSize)
						+ (y * boxSpacing), boxSize, boxSize));
			}
		}
		return boxGraphic;
	}

	private int getWindowWidth(int border2, int boxesPerSide2, int boxSize2,
			int boxSpacing2) {
		// TODO Auto-generated method stub
		return (border2 * 2) + (boxesPerSide2 * boxSize2)
				+ (boxSpacing2 * (boxesPerSide2 - 1));
	}

}
