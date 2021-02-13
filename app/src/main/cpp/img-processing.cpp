//
// Created by MURODJON ABDUKHOLIKOV on 2021/02/05.
//
#include "img-processing.h"
#include "opencv2/imgproc/imgproc.hpp"
#include "opencv2/highgui/highgui.hpp"
#include "opencv2/core/core.hpp"

using namespace cv;

char * ImageProcessing::blurImage(const char *inputFileName, const char *outputFileName) {

}

const char * ImageProcessing::detectEdges(Mat src, const char *outputDirName) {

    Mat src_img;
    // Remove noise by blurring with a gaussian filter(kernel size = 3)
    GaussianBlur(src, src_img, Size(3, 3), 0, 0, BORDER_DEFAULT);


    Mat src_gray;
    // convert the image to grayscale
    cvtColor(src_img, src_gray, COLOR_BGR2GRAY);

    Mat grad_x, grad_y;

    Sobel(src_gray, grad_x, CV_32F, 1, 0);
    Sobel(src_gray, grad_y, CV_32F, 0, 1);

    Mat abs_grad_x, abs_grad_y;
    // converting back to CV_8U
    convertScaleAbs(grad_x, abs_grad_x);
    convertScaleAbs(grad_y, abs_grad_y);

    Mat result;
    addWeighted(abs_grad_x, 0.5, abs_grad_y, 0.5, 0, result);

    imwrite(outputDirName, result);

    return outputDirName;
}