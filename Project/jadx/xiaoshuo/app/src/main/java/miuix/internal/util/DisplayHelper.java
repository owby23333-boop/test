package miuix.internal.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.yuewen.kl2;

/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public final class DisplayHelper {
    private static final String TAG = "DisplayHelper";
    private float mDensity;
    private int mDensityDpi;
    private DisplayMetrics mDisplayMetrics;
    private int mHeightDps;
    private int mHeightPixels;
    private int mWidthDps;
    private int mWidthPixels;

    public DisplayHelper(Context context) {
        getAndroidScreenProperty(context);
    }

    private void getAndroidScreenProperty(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(kl2.t9);
        this.mDisplayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(this.mDisplayMetrics);
        DisplayMetrics displayMetrics = this.mDisplayMetrics;
        int i = displayMetrics.widthPixels;
        this.mWidthPixels = i;
        int i2 = displayMetrics.heightPixels;
        this.mHeightPixels = i2;
        float f = displayMetrics.density;
        this.mDensity = f;
        this.mDensityDpi = displayMetrics.densityDpi;
        this.mWidthDps = (int) (i / f);
        this.mHeightDps = (int) (i2 / f);
    }

    public float getDensity() {
        return this.mDensity;
    }

    public int getDensityDpi() {
        return this.mDensityDpi;
    }

    public DisplayMetrics getDm() {
        return this.mDisplayMetrics;
    }

    public int getHeightDps() {
        return this.mHeightDps;
    }

    public int getHeightPixels() {
        return this.mHeightPixels;
    }

    public int getWidthDps() {
        return this.mWidthDps;
    }

    public int getWidthPixels() {
        return this.mWidthPixels;
    }

    public void info() {
        Log.d(TAG, "屏幕宽度（像素）：" + this.mWidthPixels);
        Log.d(TAG, "屏幕高度（像素）：" + this.mHeightPixels);
        Log.d(TAG, "屏幕密度：" + this.mDensity);
        Log.d(TAG, "屏幕密度（dpi）：" + this.mDensityDpi);
        Log.d(TAG, "屏幕宽度（dp）：" + this.mWidthDps);
        Log.d(TAG, "屏幕高度（dp）：" + this.mHeightDps);
    }
}
