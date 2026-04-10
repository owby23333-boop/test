package com.bytedance.sdk.openadsdk.core.kb;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements a {
    private dl z;

    public gc(dl dlVar) {
        this.z = dlVar;
    }

    private String g(String str, String str2, String str3, int i, String str4, String str5, int i2, String str6, String str7) {
        ApplicationInfo applicationInfo;
        if (!this.z.z()) {
            return "enable_install_notification";
        }
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
        if (aVarP != null && !aVarP.gz()) {
            return "isCanUseMessage";
        }
        if (i2 == 0) {
            return "enable_notification=0";
        }
        Context context = zw.getContext();
        if (context != null && (applicationInfo = context.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && !com.bytedance.sdk.openadsdk.core.uf.gc.z().g(zw.getContext(), "android.permission.POST_NOTIFICATIONS")) {
            return "post_notifications_deny";
        }
        if (z(1440L, this.z.m(), this.z.gc() * 1000)) {
            return null;
        }
        return "max_times_limit";
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a
    public boolean z(final String str, final String str2, final String str3, final int i, final String str4, String str5, int i2, final String str6, final String str7) {
        String strG = g(str, str2, str3, i, str4, str5, i2, str6, str7);
        if (TextUtils.isEmpty(strG)) {
            com.bytedance.sdk.component.utils.gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kb.gc.1
                @Override // java.lang.Runnable
                public void run() {
                    gc.this.z(str, str2, str3, i, str4, str6, str7, "startUnInstallNotification");
                }
            }, this.z.a() * 1000);
            return true;
        }
        z("notification", str7, str4, "install", str3, "othershow", strG, "failure");
        return false;
    }

    private String g(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        ApplicationInfo applicationInfo;
        if (!this.z.g()) {
            return "enable_action_notification=0";
        }
        if (i == 0) {
            return "enable_notification=0";
        }
        Context context = zw.getContext();
        if (context != null && (applicationInfo = context.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && !com.bytedance.sdk.openadsdk.core.uf.gc.z().g(zw.getContext(), "android.permission.POST_NOTIFICATIONS")) {
            return "post_notifications_deny";
        }
        if (z(1440L, this.z.m(), this.z.gc() * 1000)) {
            return null;
        }
        return "max_times_limit";
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a
    public boolean z(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        String strG = g(str, str2, str3, str4, i, str5, str6);
        if (TextUtils.isEmpty(strG)) {
            z(str, str2, str3, str3.hashCode(), str4, str5, str6, "pushUnActiveFromMarketMessage");
            return true;
        }
        z("notification", str6, str4, TtmlNode.TEXT_EMPHASIS_MARK_OPEN, str3, "othershow", strG, "failure");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final String str, final String str2, final String str3, final int i, final String str4, final String str5, final String str6, final String str7) {
        com.bytedance.sdk.openadsdk.gz.g.z(str2).config(Bitmap.Config.ARGB_4444).type(2).to(new io<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.kb.gc.2
            @Override // com.bytedance.sdk.component.m.io
            public void onFailed(int i2, String str8, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.io
            public void onSuccess(ls<Bitmap> lsVar) {
                if (lsVar != null) {
                    Bitmap result = lsVar.getResult();
                    final Bitmap bitmapZ = gc.z(result, 10.0f);
                    if (result != null) {
                        final boolean zDl = eo.dl(zw.getContext(), str3);
                        gc.z("notification", str6, str4, zDl ? TtmlNode.TEXT_EMPHASIS_MARK_OPEN : "install", str3, "othershow", str7 + "_" + str3, "success");
                        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kb.gc.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(str, str2, str4, "com.csj.install", i, zDl ? 1 : 2, bitmapZ, str3, str5, str6);
                            }
                        });
                    }
                }
            }
        }, 4);
    }

    public static void z(String str, String str2, String str3, final String str4, final String str5, String str6, final String str7, final String str8) {
        com.bytedance.sdk.openadsdk.core.i.a.z(str, str6, str2, str3, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.kb.gc.3
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", str4);
                jSONObject2.put("installer_package_name", str5);
                if (!TextUtils.isEmpty(str7)) {
                    jSONObject2.put("detail_info", str7);
                }
                if (!TextUtils.isEmpty(str8)) {
                    jSONObject2.put(NotificationCompat.CATEGORY_STATUS, str8);
                }
                if (jSONObject != null) {
                    jSONObject.put("ad_extra_data", jSONObject2);
                }
            }
        });
    }

    public static Bitmap z(Bitmap bitmap, float f) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    public boolean z(long j, int i, long j2) {
        int i2;
        try {
            Long lValueOf = -1L;
            try {
                lValueOf = Long.valueOf(60 * j * 1000);
                i2 = i;
            } catch (Exception e) {
                wp.g("xgc_notification", "error", e.getMessage());
                i2 = -1;
            }
            if (lValueOf.longValue() >= 0 && i2 >= 0 && lValueOf.longValue() != 0 && i2 != 0) {
                String strZ = z();
                StringBuilder sb = new StringBuilder();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(strZ)) {
                    sb.append(jCurrentTimeMillis);
                    z(sb.toString());
                    return true;
                }
                String[] strArrSplit = strZ.split("_");
                int length = strArrSplit.length;
                if (length < i2) {
                    if (jCurrentTimeMillis - Long.parseLong(strArrSplit[length - 1]) <= j2) {
                        return false;
                    }
                    for (String str : strArrSplit) {
                        sb.append(str).append("_");
                    }
                    sb.append(jCurrentTimeMillis);
                    z(sb.toString());
                    return true;
                }
                int i3 = length - i2;
                if (jCurrentTimeMillis - Long.valueOf(Long.parseLong(strArrSplit[length + (-1)])).longValue() > j2 && jCurrentTimeMillis - Long.valueOf(Long.parseLong(strArrSplit[i3])).longValue() > lValueOf.longValue()) {
                    for (int i4 = i3; i4 < length; i4++) {
                        String str2 = strArrSplit[i4];
                        if (i4 != i3 && !TextUtils.isEmpty(str2)) {
                            sb.append(str2).append("_");
                        }
                    }
                    sb.append(jCurrentTimeMillis);
                    z(sb.toString());
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            wp.z(e2);
            wp.g("xgc_notification", "exception:" + e2.getMessage());
            return false;
        }
    }

    public static String z() {
        return com.bytedance.sdk.openadsdk.core.g.z().get("notification_a", "");
    }

    public static void z(String str) {
        com.bytedance.sdk.openadsdk.core.g.z().put("notification_a", str);
    }
}
