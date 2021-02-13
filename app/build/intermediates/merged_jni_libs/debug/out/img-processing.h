//
// Created by MURODJON ABDUKHOLIKOV on 2021/02/05.
//

#ifndef NDK_SAMPLES_IMAGE_PROCESSING_H
#define NDK_SAMPLES_IMAGE_PROCESSING_H

#endif //NDK_SAMPLES_IMAGE_PROCESSING_H

#include "opencv2/core/core.hpp"

using namespace cv;

class ImageProcessing{
public:
    char* blurImage(const char* inputFileName, const char*outDirName);
    const char* detectEdges(Mat srcImg, const char*outDirName);
};
