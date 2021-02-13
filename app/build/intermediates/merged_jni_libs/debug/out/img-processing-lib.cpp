//
// Created by MURODJON ABDUKHOLIKOV on 2021/02/03.
//
#include <cstring>
#include "img-processing.h"
#include "jni.h"

#include <opencv2/imgproc/imgproc.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/core/core.hpp>

using namespace cv;
ImageProcessing imgProcessing;

extern "C"{

    JNIEXPORT void JNICALL Java_uz_techtalk_android_ndk_ImageProcessing_applyEdgeDetection(JNIEnv *env, jobject instance, jobject callback, jstring input, jstring output){
        /**
         * To cache the references to a virtual machine efficiently, we also save the reference to the object. We get a global reference for it.
         */
        jweak store_Wlistener = env->NewWeakGlobalRef(callback);
        jclass clazz = env->GetObjectClass(store_Wlistener);

         jmethodID failedMethod = env->GetMethodID(clazz, "onFailed", "()V");
         jmethodID succeedMethod = env->GetMethodID(clazz, "onSuccess", "(Ljava/lang/String;)V");

         const char *inputFilePath = env->GetStringUTFChars(input, 0);
         const char *outputDirName = env->GetStringUTFChars(output, 0);

         if (strlen(inputFilePath)==0){
             env->CallVoidMethod(callback, failedMethod);
             return;
         }

         /**
          * Read image from url
          */
          Mat srcImg = imread(inputFilePath);
          if (srcImg.empty()){
              env->CallVoidMethod(callback, failedMethod);
              return;
          }

         const char* outputFilePath = imgProcessing.detectEdges(srcImg, outputDirName);
         env->CallVoidMethod(callback, succeedMethod, env->NewStringUTF(outputFilePath));

         env->ReleaseStringUTFChars(input, inputFilePath);
         env->ReleaseStringUTFChars(output, outputDirName);
    }

    JNIEXPORT void JNICALL Java_uz_techtalk_android_ndk_ImageProcessing_applyBlurring(JNIEnv *env, jobject instance, jobject callback,jstring input, jstring output){
        env->NewStringUTF("dfdf");
    }
}