package uz.techtalk.android.ndk

/**
 * Created by murodjon on 2021/02/06
 * https://www.hackster.io/user2657268124/a-beginner-s-guide-to-implement-jni-callbacks-in-android-cd8226
 * https://github.com/NickZt/MyJNACallbackTest/blob/master/app/src/main/jni/native-lib.cpp
 */
interface ImageProcessingCallback {
    fun onFailed()
    fun onSuccess(output:String)
}