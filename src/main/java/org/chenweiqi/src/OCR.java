package org.chenweiqi.src;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class OCR {
    public static String recognizeText(Mat image) {
        Tesseract tesseract = new Tesseract();
        try {
            tesseract.setDatapath("path_to_tesseract_data");  // 设置Tesseract数据路径
            tesseract.setLanguage("eng");  // 设置识别语言，可根据需求调整
            return tesseract.doOCR(MatToBufferedImage(image));
        } catch (TesseractException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static BufferedImage MatToBufferedImage(Mat mat) {
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (mat.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = mat.channels() * mat.cols() * mat.rows();
        byte[] buffer = new byte[bufferSize];
        mat.get(0, 0, buffer);
        BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);
        return image;
    }
}