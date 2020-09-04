package com.enda.android.comment;

import android.util.Log;

import com.enda.android.comment.lib.ZipStream;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

import java.io.File;
import java.io.RandomAccessFile;

public class ReactNativeAndroidCommentModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    private String mComment;

    public ReactNativeAndroidCommentModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "ReactNativeAndroidComment";
    }

    @ReactMethod
    public void getComment(final Promise promise) {
        String path = reactContext.getApplicationContext().getPackageResourcePath();
        Log.d("getComment", path);

        try {
            File file = new File(path);
            RandomAccessFile apkFile = new RandomAccessFile(file, "r");
            ZipStream zipStream = new ZipStream(apkFile);
            mComment = zipStream.getComment();

            Log.d("getComment", mComment);
        } catch (Exception e) {
            Log.d("getComment", e.toString());
            promise.reject("400", e.toString());
        }

        promise.resolve(mComment);
    }
}
