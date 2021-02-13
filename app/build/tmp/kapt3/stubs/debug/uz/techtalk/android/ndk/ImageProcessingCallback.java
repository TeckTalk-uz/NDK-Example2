package uz.techtalk.android.ndk;

import java.lang.System;

/**
 * Created by murodjon on 2021/02/06
 * https://www.hackster.io/user2657268124/a-beginner-s-guide-to-implement-jni-callbacks-in-android-cd8226
 * https://github.com/NickZt/MyJNACallbackTest/blob/master/app/src/main/jni/native-lib.cpp
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Luz/techtalk/android/ndk/ImageProcessingCallback;", "", "onFailed", "", "onSuccess", "output", "", "app_debug"})
public abstract interface ImageProcessingCallback {
    
    public abstract void onFailed();
    
    public abstract void onSuccess(@org.jetbrains.annotations.NotNull()
    java.lang.String output);
}