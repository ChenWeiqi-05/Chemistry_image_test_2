package org.chenweiqi.src;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

public class CharacterSegmentation {
    public static List<Mat> segmentCharacters(Mat binaryImage) {
        List<Mat> characterMats = new ArrayList<>();
        Mat hierarchy = new Mat();
        List<MatOfPoint> contours = new ArrayList<>();
        Imgproc.findContours(binaryImage, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

        for (MatOfPoint contour : contours) {
            Rect rect = Imgproc.boundingRect(contour);
            if (rect.width > 5 && rect.height > 5) {  // 简单过滤掉过小的轮廓
                Mat character = binaryImage.submat(rect);
                characterMats.add(character);
            }
        }
        return characterMats;
    }
}