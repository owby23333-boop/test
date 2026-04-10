package com.mibi.sdk.pay.ui.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.mibi.sdk.common.utils.MibiLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes15.dex */
public class IImageLoaderImpl implements IImageLoader {
    private static final String IMAGE_CLASS_NAME = "com.mipay.imageloadhelper.Image";
    private static final String TAG = "IImageLoaderImpl";
    private Method mAntiShakeDurationMethod;
    private Method mFadeDurationMethod;
    private Method mGetMethod;
    private Object mImage;
    private Class<?> mImageClass;
    private Method mIntoMethod;
    private Method mLoadMethod;
    private Method mPlaceholderMethodDrawable;
    private Method mPlaceholderMethodInt;

    private Method getAntiShakeDurationMethod() throws NoSuchMethodException, ClassNotFoundException {
        if (this.mAntiShakeDurationMethod == null) {
            this.mAntiShakeDurationMethod = getImageClass().getMethod("antiShakeDuration", Integer.TYPE);
        }
        return this.mAntiShakeDurationMethod;
    }

    private Method getFadeDurationMethod() throws NoSuchMethodException, ClassNotFoundException {
        if (this.mFadeDurationMethod == null) {
            this.mFadeDurationMethod = getImageClass().getMethod("fadeDuration", Long.TYPE);
        }
        return this.mFadeDurationMethod;
    }

    private Method getGetMethod() throws NoSuchMethodException, ClassNotFoundException {
        if (this.mGetMethod == null) {
            this.mGetMethod = getImageClass().getMethod("get", Context.class);
        }
        return this.mGetMethod;
    }

    private Object getImage(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Object objInvoke = getGetMethod().invoke(getImageClass(), context);
        this.mImage = objInvoke;
        return objInvoke;
    }

    private Class<?> getImageClass() throws ClassNotFoundException {
        if (this.mImageClass == null) {
            this.mImageClass = Class.forName(IMAGE_CLASS_NAME);
        }
        return this.mImageClass;
    }

    private Method getIntoMethod() throws NoSuchMethodException, ClassNotFoundException {
        if (this.mIntoMethod == null) {
            this.mIntoMethod = getImageClass().getMethod("into", ImageView.class);
        }
        return this.mIntoMethod;
    }

    private Method getLoadMethod() throws NoSuchMethodException, ClassNotFoundException {
        if (this.mLoadMethod == null) {
            this.mLoadMethod = getImageClass().getMethod("load", String.class);
        }
        return this.mLoadMethod;
    }

    private Method getPlaceholderMethodDrawable() throws NoSuchMethodException, ClassNotFoundException {
        if (this.mPlaceholderMethodDrawable == null) {
            this.mPlaceholderMethodDrawable = getImageClass().getMethod("placeholder", Drawable.class);
        }
        return this.mPlaceholderMethodDrawable;
    }

    private Method getPlaceholderMethodInt() throws NoSuchMethodException, ClassNotFoundException {
        if (this.mPlaceholderMethodInt == null) {
            this.mPlaceholderMethodInt = getImageClass().getMethod("placeholder", Integer.TYPE);
        }
        return this.mPlaceholderMethodInt;
    }

    @Override // com.mibi.sdk.pay.ui.imageloader.IImageLoader
    public IImageLoader get(Context context) {
        try {
            this.mImage = getImage(context);
        } catch (Exception e) {
            MibiLog.d(TAG, e.getMessage());
        }
        return this;
    }

    @Override // com.mibi.sdk.pay.ui.imageloader.IImageLoader
    public void into(ImageView imageView) {
        try {
            getFadeDurationMethod().invoke(this.mImage, 200);
            getAntiShakeDurationMethod().invoke(this.mImage, 0);
            getIntoMethod().invoke(this.mImage, imageView);
        } catch (Exception e) {
            MibiLog.d(TAG, e.getMessage());
        }
    }

    @Override // com.mibi.sdk.pay.ui.imageloader.IImageLoader
    public IImageLoader load(String str) {
        try {
            getLoadMethod().invoke(this.mImage, str);
        } catch (Exception e) {
            MibiLog.d(TAG, e.getMessage());
        }
        return this;
    }

    @Override // com.mibi.sdk.pay.ui.imageloader.IImageLoader
    public IImageLoader placeholder(int i) {
        try {
            getPlaceholderMethodInt().invoke(this.mImage, Integer.valueOf(i));
        } catch (Exception e) {
            MibiLog.d(TAG, e.getMessage());
        }
        return this;
    }

    @Override // com.mibi.sdk.pay.ui.imageloader.IImageLoader
    public IImageLoader placeholder(Drawable drawable2) {
        try {
            getPlaceholderMethodDrawable().invoke(drawable2, new Object[0]);
        } catch (Exception e) {
            MibiLog.d(TAG, e.getMessage());
        }
        return this;
    }
}
