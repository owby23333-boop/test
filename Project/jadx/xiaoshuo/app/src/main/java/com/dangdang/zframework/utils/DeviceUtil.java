package com.dangdang.zframework.utils;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.DisplayMetrics;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes10.dex */
public class DeviceUtil {
    private static DeviceUtil mUtil;
    private Context mContext;
    private int mWidth = 0;
    private int mHeight = 0;
    private float mDensity = 0.0f;

    private DeviceUtil() {
    }

    public static long getAvailaSizeAtSdCard() {
        return -1L;
    }

    public static int getCPUCoreCounts() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.dangdang.zframework.utils.DeviceUtil.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    public static synchronized DeviceUtil getInstance(Context context) {
        if (mUtil == null) {
            DeviceUtil deviceUtil = new DeviceUtil();
            mUtil = deviceUtil;
            deviceUtil.init(context);
        }
        return mUtil;
    }

    public static boolean getPadScreenIsLarge() {
        return false;
    }

    public static long getTotalExternalMemorySize() {
        return -1L;
    }

    private void init(Context context) {
        if (context == null) {
            throw new RuntimeException("context is null");
        }
        if (this.mContext != null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        DisplayMetrics displayMetrics = ((Application) applicationContext).getResources().getDisplayMetrics();
        this.mWidth = displayMetrics.widthPixels;
        this.mHeight = displayMetrics.heightPixels;
        this.mDensity = displayMetrics.density;
    }

    public static boolean isHasSdcard() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public float getDensity() {
        float f = this.mDensity;
        if (f < 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public int getDisplayDPI() {
        return (int) (this.mDensity * 160.0f);
    }

    public int getDisplayHeight() {
        return this.mHeight;
    }

    public int getDisplayWidth() {
        return this.mWidth;
    }

    public String getPhoneModel() {
        return Build.MODEL;
    }

    public int getStatusHeight() {
        if (this.mContext != null) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                return this.mContext.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
