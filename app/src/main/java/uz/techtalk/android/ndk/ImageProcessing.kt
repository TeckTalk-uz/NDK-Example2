package uz.techtalk.android.ndk

/**
 * Created by murodjon on 2021/02/05
 */
class ImageProcessing(private val callback: ImageProcessingCallback) {

    init {
        // load library
        System.loadLibrary("img-processing-lib")
    }

    fun findEdges(inputFileName: String, outputFileName: String) {
        applyEdgeDetection(callback, inputFileName, outputFileName)
    }

    fun blurImage(inputFileName: String, outputFileName: String) {
        applyBlurring(callback, inputFileName, outputFileName)
    }

    private external fun applyEdgeDetection(callback: ImageProcessingCallback, inputFileName: String, outputFileName: String)

    private external fun applyBlurring(callback: ImageProcessingCallback, inputFileName: String, outputFileName: String)
}