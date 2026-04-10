package com.dangdang.zframework.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import com.dangdang.zframework.log.LogM;
import com.xiaomi.verificationsdk.internal.Constants;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes10.dex */
public class DRUiUtility {
    public static final String BASE_DIRECTORY = "wallpapers/";
    private static final int LargeScreenSize = 7;
    private static final double LargeScreenSizeForSpeed = 8.0d;
    private static Context mContext = null;
    public static int mCoverHeight = 100;
    public static int mCoverWidth = 80;
    private static DRUiUtility mDRUiUtility;
    private static float mDensity;
    private static int mHeight;
    private static boolean mLargeScreenForSpeed;
    private static boolean mScreenIsLarge;
    private static double mScreenSize;
    private static int mWidth;

    private DRUiUtility() {
    }

    public static float getDensity() {
        float f = mDensity;
        if (f < 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public static int getDisplayDPI() {
        return (int) (mDensity * 160.0f);
    }

    public static boolean getLargeScreenSpeed() {
        return mLargeScreenForSpeed;
    }

    public static boolean getPadScreenIsLarge() {
        return mScreenIsLarge;
    }

    public static String getPhoneManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getPhoneModel() {
        return Build.MODEL;
    }

    public static int getScreenBrightness(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            return isAutoBrightness(contentResolver) ? Settings.System.getInt(contentResolver, Constants.SCREEN_BRIGHTNESS, 1) : Settings.System.getInt(contentResolver, Constants.SCREEN_BRIGHTNESS, 0);
        } catch (Exception unused) {
            return 100;
        }
    }

    public static int getScreenHeight() {
        return mHeight;
    }

    public static double getScreenSize() {
        return mScreenSize;
    }

    public static int getScreenWith() {
        return mWidth;
    }

    public static int getStatusHeight(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static synchronized DRUiUtility getUiUtilityInstance() {
        if (mDRUiUtility == null) {
            mDRUiUtility = new DRUiUtility();
        }
        return mDRUiUtility;
    }

    private void initLargeScreen(double d) {
        mLargeScreenForSpeed = false;
        if (d >= 7.0d) {
            mScreenIsLarge = true;
        } else {
            mScreenIsLarge = false;
        }
        if (d >= LargeScreenSizeForSpeed) {
            mLargeScreenForSpeed = true;
        }
    }

    public static boolean isAutoBrightness(ContentResolver contentResolver) {
        try {
            return Settings.System.getInt(contentResolver, "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void setActivityFullScreenStatus(Activity activity, boolean z) {
        if (z) {
            activity.getWindow().setFlags(1024, 1024);
        } else {
            activity.getWindow().clearFlags(1024);
        }
    }

    public void DontKeepContext(Activity activity) {
        if (activity == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        mWidth = i;
        mHeight = displayMetrics.heightPixels;
        mDensity = displayMetrics.density;
        initLargeScreen(Math.sqrt(Math.pow(i, 2.0d) + Math.pow(mHeight, 2.0d)) / ((double) (mDensity * 160.0f)));
    }

    public Bitmap getBgBitmap(String str) {
        Bitmap bitmapCreateBitmap;
        Throwable th;
        InputStream inputStreamOpen;
        Bitmap bitmapDecodeStream;
        if (str == null || "".equals(str)) {
            return null;
        }
        try {
            try {
                inputStreamOpen = mContext.getAssets().open(BASE_DIRECTORY + str);
                try {
                    bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                    int width = bitmapDecodeStream.getWidth() * 2;
                    int height = bitmapDecodeStream.getHeight() * 2;
                    bitmapCreateBitmap = Bitmap.createBitmap(width, height, bitmapDecodeStream.getConfig());
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    Paint paint = new Paint();
                    Matrix matrix = new Matrix();
                    canvas.drawBitmap(bitmapDecodeStream, matrix, paint);
                    matrix.preScale(-1.0f, 1.0f);
                    matrix.postTranslate(width, 0.0f);
                    canvas.drawBitmap(bitmapDecodeStream, matrix, paint);
                    matrix.preScale(1.0f, -1.0f);
                    matrix.postTranslate(0.0f, height);
                    canvas.drawBitmap(bitmapDecodeStream, matrix, paint);
                    matrix.preScale(-1.0f, 1.0f);
                    matrix.postTranslate(r2 * (-2), 0.0f);
                    canvas.drawBitmap(bitmapDecodeStream, matrix, paint);
                } catch (Throwable th2) {
                    bitmapCreateBitmap = null;
                    th = th2;
                }
            } catch (Throwable th3) {
                bitmapCreateBitmap = null;
                th = th3;
                inputStreamOpen = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BitmapUtil.recycle(bitmapDecodeStream);
        } catch (Throwable th4) {
            th = th4;
            try {
                th.printStackTrace();
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return bitmapCreateBitmap;
            } catch (Throwable th5) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th5;
            }
        }
        if (inputStreamOpen != null) {
            inputStreamOpen.close();
        }
        return bitmapCreateBitmap;
    }

    public Bitmap getBitmapByRsource(int i) {
        try {
            return BitmapFactory.decodeResource(mContext.getResources(), i);
        } catch (Throwable th) {
            LogM.e(getClass().getSimpleName(), " create bmp by resource. error: " + th);
            return null;
        }
    }

    public void setContext(Activity activity) {
        if (activity == null) {
            return;
        }
        mContext = activity.getApplicationContext();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        mWidth = i;
        mHeight = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        mDensity = f;
        mCoverWidth = (int) (mCoverWidth * f);
        mCoverHeight = (int) (mCoverHeight * f);
        double dSqrt = Math.sqrt(Math.pow(i, 2.0d) + Math.pow(mHeight, 2.0d)) / ((double) (mDensity * 160.0f));
        initLargeScreen(dSqrt);
        mScreenSize = dSqrt;
    }
}
