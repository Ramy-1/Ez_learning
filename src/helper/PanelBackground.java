package helper;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javafx.scene.layout.BorderPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelBackground extends BorderPane {

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
        createImage();
        paint((Graphics) image);
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        setStyle("-fx-border-radius:"+round+";");
    }

    public PanelBackground() {
        setOpacity(0);
        super.setStyle("-fx-background-color:white;");
    }

    public void setBackground(Color color) {
        super.setStyle("-fx-background-color:"+color+";");
        createImage();
    }

    private int round = 15;
    private Icon image;
    private BufferedImage bffImage;

    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        if (bffImage != null) {
            g2.drawImage(bffImage, 0, 0, null);
        } else {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            String nm = null;
            g2.setColor(Color.getColor(nm));
            g2.fillRoundRect(0, 0,(int) getWidth(),(int) getHeight(), round, round);
        }
        g2.dispose();
        this.paint(grphcs);
    }

    private void createImage() {
        if (image != null) {
            int width =(int) getWidth();
            int height =(int) getHeight();
            Rectangle size = getAutoSize(image);
            bffImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2_img = bffImage.createGraphics();
            g2_img.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2_img.fillRoundRect(0, 0, width, height, round, round);
            g2_img.setComposite(AlphaComposite.SrcIn);
            g2_img.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2_img.drawImage(toImage(image), size.x, size.y, size.width, size.height, null);
            g2_img.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.8f));
            //g2_img.setColor(getBackground());
            g2_img.fillRect(0, 0,(int) getWidth(),(int) getHeight());
            g2_img.dispose();
        } else {
            bffImage = null;
        }
    }

    private Rectangle getAutoSize(Icon image) {
        int w = (int)getWidth();
        int h =(int) getHeight();
        if (w > image.getIconWidth()) {
            w = image.getIconWidth();
        }
        if (h > image.getIconHeight()) {
            h = image.getIconHeight();
        }
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        int x =(int) getWidth() / 2 - (width / 2);
        int y =(int) getHeight() / 2 - (height / 2);
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }

    public void setBounds(int i, int i1, int i2, int i3) {
        this.setBounds(i, i1, i2, i3);
        createImage();
    }
}
