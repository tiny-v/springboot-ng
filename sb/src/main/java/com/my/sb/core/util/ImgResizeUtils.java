package com.my.sb.core.util;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImgResizeUtils {

    private static byte[] resize(InputStream in, int targetWidth, float quality, boolean square) throws IOException {
        BufferedImage srcBufferedImage = ImageIO.read(in);
        if (square) {
            int width = srcBufferedImage.getWidth();
            int height = srcBufferedImage.getHeight();
            if (width > height) {
                int x = (width - height) / 2;
                srcBufferedImage = srcBufferedImage.getSubimage(x, 0, height,
                        height);
            } else if (width < height) {
                int y = (height - width) / 2;
                srcBufferedImage = srcBufferedImage.getSubimage(0, y, width,
                        width);
            }
        }
        Image resizedImage = null;
        int iWidth = srcBufferedImage.getWidth();
        int iHeight = srcBufferedImage.getHeight();

        if (iWidth > iHeight) {
            resizedImage = srcBufferedImage.getScaledInstance(targetWidth,
                    (targetWidth * iHeight) / iWidth, Image.SCALE_SMOOTH);
        } else {
            resizedImage = srcBufferedImage.getScaledInstance(
                    (targetWidth * iWidth) / iHeight, targetWidth,
                    Image.SCALE_SMOOTH);
        }
        Image temp = new ImageIcon(resizedImage).getImage();
        BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null),
                temp.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
        g.drawImage(temp, 0, 0, null);
        g.dispose();
        float softenFactor = 0.05f;
        float[] softenArray = {0, softenFactor, 0, softenFactor,
                1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0};
        Kernel kernel = new Kernel(3, 3, softenArray);
        ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        bufferedImage = cOp.filter(bufferedImage, null);

        ImageWriter writer = ImageIO.getImageWritersByFormatName("jpeg").next();
        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(quality);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(byteArrayOutputStream);
        writer.setOutput(imageOutputStream);
        writer.write(null, new IIOImage(bufferedImage, null, null), param);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] resize(InputStream in, int width) throws IOException {
        return resize(in, width, 1f, false);
    }

}