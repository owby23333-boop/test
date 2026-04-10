package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.m;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final class dl implements Function<SparseArray<Object>, Object> {
    private static volatile dl z;
    private Function<SparseArray<Object>, Object> dl;
    private final Context g;

    private dl(Context context) {
        this.g = context;
    }

    public static dl z() {
        return z;
    }

    public static dl z(Context context) {
        if (z == null) {
            synchronized (dl.class) {
                if (z == null) {
                    z = new dl(context);
                }
            }
        }
        return z;
    }

    public <T> T z(Class<T> cls, int i, Map<String, Object> map) {
        m.g("xgc_dl", "api:".concat(String.valueOf(i)));
        if (i == 0) {
            if (this.dl != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 0);
                sparseArray.put(0, map);
                return (T) this.dl.apply(sparseArray);
            }
            return (T) Boolean.FALSE;
        }
        if (i == 159) {
            if (map != null) {
                Object obj = map.get(t.h);
                if (obj instanceof Function) {
                    this.dl = (Function) obj;
                }
            }
            return null;
        }
        if (i == 161) {
            return (T) g(map);
        }
        if (i == 155) {
            return (T) z((String) map.get("custom_authority"), (String) map.get("custom_file_path"));
        }
        if (i != 156) {
            return null;
        }
        return (T) z(map);
    }

    protected void z(Map<String, Object> map, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, Integer.valueOf(i));
        sparseArray.put(0, map);
        Function<SparseArray<Object>, Object> function = this.dl;
        if (function != null) {
            function.apply(sparseArray);
        }
    }

    private NotificationCompat.Builder z(String str) {
        try {
            return new NotificationCompat.Builder(this.g, str);
        } catch (NoSuchMethodError unused) {
            return new NotificationCompat.Builder(this.g);
        }
    }

    private Map<String, Object> z(Map<String, Object> map) {
        Map<String, Object> map2;
        if (map == null || (map2 = (Map) map.get("params")) == null) {
            return null;
        }
        Map<String, Object> mapDl = dl(map2);
        Object obj = mapDl.get("remote_views");
        Object obj2 = mapDl.get("builder_content_type");
        int iIntValue = ((Integer) map2.get("notification_type")).intValue();
        String str = (String) map2.get("channel_id");
        int iIntValue2 = ((Integer) map2.get("download_status")).intValue();
        NotificationCompat.Builder builderZ = z(str);
        builderZ.setWhen(((Long) map2.get("first_time")).longValue());
        Object obj3 = map2.get("notification_group");
        if (obj3 != null && (obj3 instanceof String)) {
            builderZ.setGroup((String) obj3);
            builderZ.setGroupSummary(false);
        }
        builderZ.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        if (iIntValue == 1 || iIntValue == 4 || iIntValue == 2) {
            builderZ.setContentIntent((PendingIntent) mapDl.get("apa_click_content_intent"));
            builderZ.setAutoCancel(false);
        } else if (iIntValue == 3) {
            builderZ.setAutoCancel(true);
            if (iIntValue2 == -3) {
                Object obj4 = map2.get("auto_cancel");
                if ((obj4 instanceof Boolean) && ((Boolean) obj4).booleanValue()) {
                    builderZ.setAutoCancel(false);
                }
            }
            builderZ.setContentIntent((PendingIntent) mapDl.get("complete_click_content_intent"));
            builderZ.setDeleteIntent((PendingIntent) mapDl.get("hide_click_content_intent"));
        }
        if (iIntValue == 3 && iIntValue2 == -3 && (obj2 instanceof String)) {
            builderZ.setContentText((String) obj2);
        }
        Object obj5 = mapDl.get("builder_small_icon");
        if (obj5 instanceof Integer) {
            builderZ.setSmallIcon(((Integer) obj5).intValue());
        }
        Notification notificationBuild = builderZ.build();
        notificationBuild.contentView = (RemoteViews) obj;
        mapDl.put("notification", notificationBuild);
        return mapDl;
    }

    private Map<String, Object> g(Map<String, Object> map) {
        String strConcat;
        String str;
        String str2;
        String str3;
        NotificationChannel notificationChannel;
        if (map == null) {
            return null;
        }
        HashMap map2 = new HashMap();
        String str4 = (String) map.get("install_app_name");
        Bitmap bitmap = (Bitmap) map.get("install_icon_bitmap");
        String str5 = (String) map.get("install_action_type");
        Object obj = map.get("install_click_type");
        String str6 = (String) map.get("install_package_name");
        String str7 = (String) map.get("install_tag");
        String str8 = (String) map.get("install_value");
        String str9 = (String) map.get("install_log_extra");
        int iIntValue = obj != null ? ((Integer) obj).intValue() : -1;
        Object obj2 = map.get("install_download_id");
        int iIntValue2 = obj2 != null ? ((Integer) obj2).intValue() : -1;
        Object obj3 = map.get("install_enable_target_34");
        boolean zBooleanValue = obj3 != null ? ((Boolean) obj3).booleanValue() : false;
        RemoteViews remoteViews = new RemoteViews(this.g.getPackageName(), this.g.getResources().getIdentifier("tt_install_notification_layout", TtmlNode.TAG_LAYOUT, this.g.getPackageName()));
        int i = z.i();
        int iWp = z.wp();
        int iV = z.v();
        int iPf = z.pf();
        int iLs = z.ls();
        if (iIntValue == 1) {
            strConcat = "打开".concat(String.valueOf(str4));
            str = "应用已安装完成";
            str2 = "去打开";
        } else {
            strConcat = "安装".concat(String.valueOf(str4));
            str = "应用已下载完成";
            str2 = "去安装";
        }
        String str10 = str;
        String str11 = strConcat;
        remoteViews.setTextViewText(iWp, str10);
        remoteViews.setTextViewText(iV, str11);
        remoteViews.setTextViewText(iPf, str2);
        int iUf = z.uf();
        if (iUf == 0) {
            iUf = z.io();
        }
        int i2 = iUf;
        remoteViews.setImageViewIcon(i, Icon.createWithBitmap(bitmap));
        PendingIntent pendingIntentZ = z(str5, iIntValue, iIntValue2, zBooleanValue, str6, str7, str8, str9);
        remoteViews.setOnClickPendingIntent(iLs, pendingIntentZ);
        remoteViews.setOnClickPendingIntent(iPf, pendingIntentZ);
        String str12 = "csj_" + this.g.getPackageName();
        try {
            notificationChannel = new NotificationChannel(str12, "csj_install", 4);
            notificationChannel.setShowBadge(true);
            notificationChannel.setBypassDnd(true);
            str3 = "notification";
        } catch (Throwable th) {
            th = th;
            str3 = "notification";
        }
        try {
            ((NotificationManager) this.g.getSystemService(str3)).createNotificationChannel(notificationChannel);
        } catch (Throwable th2) {
            th = th2;
            m.z(th);
        }
        NotificationCompat.Builder builderZ = z(str12);
        builderZ.setStyle(new NotificationCompat.DecoratedCustomViewStyle()).setContentIntent(pendingIntentZ).setSmallIcon(i2).setContentTitle(str10).setContentText(str11).setPriority(1).setDefaults(-1).setVisibility(1).setAutoCancel(true);
        Notification notificationBuild = builderZ.build();
        notificationBuild.contentView = remoteViews;
        map2.put(str3, notificationBuild);
        return map2;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x04ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Map<java.lang.String, java.lang.Object> dl(java.util.Map<java.lang.String, java.lang.Object> r29) {
        /*
            Method dump skipped, instruction units count: 1346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.downloadnew.dl.dl(java.util.Map):java.util.Map");
    }

    private Pair<Intent, Boolean> z(Context context, long j, boolean z2) {
        if (z2) {
            return new Pair<>(new Intent(context, (Class<?>) ApiDownloadHandleNotificationActivity.class), Boolean.TRUE);
        }
        return new Pair<>(new Intent(context, (Class<?>) ApiDownloadHandlerService.class), Boolean.FALSE);
    }

    private PendingIntent z(String str, int i, int i2, boolean z2, String str2) {
        Pair<Intent, Boolean> pairZ = z(this.g, i2, z2);
        Intent intent = (Intent) pairZ.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        intent.putExtra("extra_package_name", str2);
        return z(this.g, pairZ, i2);
    }

    private PendingIntent z(String str, int i, int i2, boolean z2, String str2, String str3, String str4, String str5) {
        Pair<Intent, Boolean> pairZ = z(this.g, i2, z2);
        Intent intent = (Intent) pairZ.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        intent.putExtra("extra_package_name", str2);
        intent.putExtra("extra_tag", str3);
        intent.putExtra("extra_value", str4);
        intent.putExtra("extra_log_extra", str5);
        return z(this.g, pairZ, i2);
    }

    private PendingIntent z(Context context, Pair<Intent, Boolean> pair, int i) {
        if (((Boolean) pair.second).booleanValue()) {
            return PendingIntent.getActivity(context, i, (Intent) pair.first, 201326592);
        }
        return PendingIntent.getService(context, i, (Intent) pair.first, 201326592);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x002d A[EXC_TOP_SPLITTER, PHI: r4
  0x002d: PHI (r4v3 android.content.res.TypedArray) = (r4v2 android.content.res.TypedArray), (r4v4 android.content.res.TypedArray) binds: [B:16:0x0032, B:12:0x002b] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean g(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = "#7f0b0198"
            int r1 = android.graphics.Color.parseColor(r1)     // Catch: java.lang.Throwable -> L31
            int r2 = com.bytedance.sdk.openadsdk.downloadnew.z.z()     // Catch: java.lang.Throwable -> L31
            int r3 = com.bytedance.sdk.openadsdk.downloadnew.z.g()     // Catch: java.lang.Throwable -> L31
            int[] r2 = new int[]{r2, r3}     // Catch: java.lang.Throwable -> L31
            int r3 = com.bytedance.sdk.openadsdk.downloadnew.z.dl()     // Catch: java.lang.Throwable -> L31
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r3, r2)     // Catch: java.lang.Throwable -> L31
            int r2 = r4.getColor(r0, r0)     // Catch: java.lang.Throwable -> L32
            if (r1 != r2) goto L2b
            if (r4 == 0) goto L29
            r4.recycle()     // Catch: java.lang.Throwable -> L29
        L29:
            r4 = 1
            return r4
        L2b:
            if (r4 == 0) goto L35
        L2d:
            r4.recycle()     // Catch: java.lang.Throwable -> L35
            goto L35
        L31:
            r4 = 0
        L32:
            if (r4 == 0) goto L35
            goto L2d
        L35:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.downloadnew.dl.g(android.content.Context):boolean");
    }

    private boolean z(Object obj) {
        return (obj instanceof Integer) && ((Integer) obj).intValue() > 0;
    }

    private boolean g(Object obj) {
        return (obj instanceof Integer) && ((Integer) obj).intValue() >= 2;
    }

    private int z(int i, boolean z2) {
        if (z2) {
            return z.io();
        }
        if (i == 1 || i == 4) {
            return z.iq();
        }
        if (i == 2) {
            return z.zw();
        }
        if (i == 3) {
            return z.io();
        }
        return 0;
    }

    public Uri z(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            return FileProvider.getUriForFile(this.g, str, new File(str2));
        }
        return Uri.fromFile(new File(str2));
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Map<String, Object> map;
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetG = com.bykv.z.z.z.z.dl.z(sparseArray).g();
        int iIntValue = valueSetG.intValue(-99999987);
        Class cls = (Class) valueSetG.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return com.bykv.z.z.z.z.dl.z().z(10000, 3).g().sparseArray();
        }
        if (valueSetG.objectValue(0, Map.class) != null) {
            map = (Map) valueSetG.objectValue(0, Map.class);
        } else {
            map = new HashMap<>();
        }
        return z(cls, iIntValue, map);
    }
}
