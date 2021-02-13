package uz.techtalk.android.ndk;

import java.lang.System;

/**
 * Created by murodjon on 2021/02/05
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0082 J!\u0010\n\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0082 J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Luz/techtalk/android/ndk/ImageProcessing;", "", "callback", "Luz/techtalk/android/ndk/ImageProcessingCallback;", "(Luz/techtalk/android/ndk/ImageProcessingCallback;)V", "applyBlurring", "", "inputFileName", "", "outputFileName", "applyEdgeDetection", "blurImage", "findEdges", "app_debug"})
public final class ImageProcessing {
    private final uz.techtalk.android.ndk.ImageProcessingCallback callback = null;
    
    public final void findEdges(@org.jetbrains.annotations.NotNull()
    java.lang.String inputFileName, @org.jetbrains.annotations.NotNull()
    java.lang.String outputFileName) {
    }
    
    public final void blurImage(@org.jetbrains.annotations.NotNull()
    java.lang.String inputFileName, @org.jetbrains.annotations.NotNull()
    java.lang.String outputFileName) {
    }
    
    private final native void applyEdgeDetection(uz.techtalk.android.ndk.ImageProcessingCallback callback, java.lang.String inputFileName, java.lang.String outputFileName) {
    }
    
    private final native void applyBlurring(uz.techtalk.android.ndk.ImageProcessingCallback callback, java.lang.String inputFileName, java.lang.String outputFileName) {
    }
    
    public ImageProcessing(@org.jetbrains.annotations.NotNull()
    uz.techtalk.android.ndk.ImageProcessingCallback callback) {
        super();
    }
}