package org.chenweiqi.src;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageBinarization {
    public static Mat binarize(Mat image) {
        Mat grayMat = new Mat();
        Imgproc.cvtColor(image, grayMat, Imgproc.COLOR_BGR2GRAY);
        Mat binaryMat = new Mat();
        Imgproc.threshold(grayMat, binaryMat, 0, 255, Imgproc.THRESH_BINARY + Imgproc.THRESH_OTSU);
        return binaryMat;
    }

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat image = Imgcodecs.imread("your_image_path.jpg");
        Mat binary = binarize(image);
        Imgcodecs.imwrite("binarized_image.jpg", binary);
    }
}
