package com.bytedance.sdk.openadsdk.core.ls.z;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.m.g;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private JSONObject z;

    public String toString() {
        JSONObject jSONObject = this.z;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public boolean z() {
        JSONObject jSONObject = this.z;
        if (jSONObject != null && jSONObject.optInt("type") > 0) {
            return g.z((float) this.z.optDouble("rate"), false);
        }
        return false;
    }

    public static z z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return z(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static z z(JSONObject jSONObject) {
        z zVar = new z();
        zVar.z = jSONObject;
        return zVar;
    }

    public void z(WebView webView, final na naVar) {
        View view;
        if (z() && webView != null) {
            try {
                System.currentTimeMillis();
                if (Build.VERSION.SDK_INT >= 28 && webView.getLayerType() == 2 && (view = (View) webView.getParent()) != null) {
                    int measuredWidth = (int) (((double) view.getMeasuredWidth()) * 0.6d);
                    int measuredHeight = (int) (((double) view.getMeasuredHeight()) * 0.6d);
                    if (z(zw.getContext(), measuredWidth, measuredHeight)) {
                        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.RGB_565);
                        view.draw(new Canvas(bitmapCreateBitmap));
                        System.currentTimeMillis();
                        e.g(new fo("") { // from class: com.bytedance.sdk.openadsdk.core.ls.z.z.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    System.currentTimeMillis();
                                    z.this.z(bitmapCreateBitmap, naVar);
                                    System.currentTimeMillis();
                                } catch (Throwable th) {
                                    try {
                                        th.getMessage();
                                        try {
                                            if (bitmapCreateBitmap.isRecycled()) {
                                                return;
                                            }
                                            bitmapCreateBitmap.recycle();
                                        } catch (Throwable unused) {
                                        }
                                    } finally {
                                        try {
                                            if (!bitmapCreateBitmap.isRecycled()) {
                                                bitmapCreateBitmap.recycle();
                                            }
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Bitmap bitmap, na naVar) throws JSONException {
        Matrix matrix = new Matrix();
        matrix.setScale(0.4f, 0.4f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        try {
            bitmap.recycle();
        } catch (Throwable th) {
            th.getMessage();
        }
        float width = bitmapCreateBitmap.getWidth() * bitmapCreateBitmap.getHeight();
        float f = 0.0f;
        for (int i = 0; i < bitmapCreateBitmap.getWidth(); i++) {
            for (int i2 = 0; i2 < bitmapCreateBitmap.getHeight(); i2++) {
                if (bitmapCreateBitmap.getPixel(i, i2) == -1) {
                    f += 1.0f;
                }
            }
        }
        try {
            bitmapCreateBitmap.recycle();
        } catch (Throwable th2) {
            th2.getMessage();
        }
        if ((f / width) * 100.0f > 95.0d) {
            JSONObject jSONObject = new JSONObject();
            if (naVar != null) {
                jSONObject.put("url", naVar.fp());
                jSONObject.put(MediationConstant.EXTRA_ADID, naVar.mk());
                jSONObject.put(CmcdConfiguration.KEY_CONTENT_ID, naVar.mj());
            }
            v.z().m(jSONObject);
        }
    }

    public boolean z(Context context, int i, int i2) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            if (memoryInfo.lowMemory) {
                return false;
            }
            if (memoryInfo.availMem > Math.max((long) Math.max(memoryInfo.totalMem * 0.02d, 5.24288E7d), (long) (i * i2 * 2 * 2.0f))) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
