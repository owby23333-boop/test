package com.ss.android.socialbase.appdownloader.gc;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.appdownloader.gc;

/* JADX INFO: loaded from: classes4.dex */
public class z extends com.ss.android.socialbase.downloader.notification.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2036a;
    private final Resources dl;
    private final Context g;
    private String gc;
    private String m;

    public z(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.gc = str2;
        this.f2036a = str3;
        this.m = str4;
        Context applicationContext = context.getApplicationContext();
        this.g = applicationContext;
        this.dl = applicationContext.getResources();
    }

    @Override // com.ss.android.socialbase.downloader.notification.z
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        super.z(dlVar);
        this.gc = dlVar.kb();
        this.f2036a = dlVar.gz();
        this.m = dlVar.gk();
    }

    @Override // com.ss.android.socialbase.downloader.notification.z
    public void z(com.ss.android.socialbase.downloader.gc.z zVar, boolean z) {
        if (this.g == null) {
            return;
        }
        try {
            com.ss.android.socialbase.appdownloader.dl.dl dlVarZ = com.ss.android.socialbase.appdownloader.a.kb().z();
            if (dlVarZ != null) {
                this.z = z(dlVarZ, zVar, z);
            } else {
                this.z = g(zVar, z);
            }
            z(this.z);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x020b A[PHI: r6 r19 r20
  0x020b: PHI (r6v17 com.ss.android.socialbase.downloader.gc.z) = 
  (r6v10 com.ss.android.socialbase.downloader.gc.z)
  (r6v10 com.ss.android.socialbase.downloader.gc.z)
  (r6v10 com.ss.android.socialbase.downloader.gc.z)
  (r6v27 com.ss.android.socialbase.downloader.gc.z)
 binds: [B:93:0x029c, B:95:0x029f, B:96:0x02a1, B:66:0x01fe] A[DONT_GENERATE, DONT_INLINE]
  0x020b: PHI (r19v8 com.ss.android.socialbase.downloader.i.z) = 
  (r19v6 com.ss.android.socialbase.downloader.i.z)
  (r19v6 com.ss.android.socialbase.downloader.i.z)
  (r19v6 com.ss.android.socialbase.downloader.i.z)
  (r19v12 com.ss.android.socialbase.downloader.i.z)
 binds: [B:93:0x029c, B:95:0x029f, B:96:0x02a1, B:66:0x01fe] A[DONT_GENERATE, DONT_INLINE]
  0x020b: PHI (r20v5 java.lang.Object) = (r20v2 java.lang.Object), (r20v2 java.lang.Object), (r20v2 java.lang.Object), (r20v7 java.lang.Object) binds: [B:93:0x029c, B:95:0x029f, B:96:0x02a1, B:66:0x01fe] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.app.Notification z(com.ss.android.socialbase.appdownloader.dl.dl r23, com.ss.android.socialbase.downloader.gc.z r24, boolean r25) {
        /*
            Method dump skipped, instruction units count: 939
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.gc.z.z(com.ss.android.socialbase.appdownloader.dl.dl, com.ss.android.socialbase.downloader.gc.z, boolean):android.app.Notification");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:158:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x023e  */
    /* JADX WARN: Type inference failed for: r13v33, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v38 */
    /* JADX WARN: Type inference failed for: r13v44 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.app.Notification g(com.ss.android.socialbase.downloader.gc.z r25, boolean r26) {
        /*
            Method dump skipped, instruction units count: 1454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.gc.z.g(com.ss.android.socialbase.downloader.gc.z, boolean):android.app.Notification");
    }

    private boolean z(com.ss.android.socialbase.downloader.gc.z zVar, com.ss.android.socialbase.downloader.i.z zVar2, com.ss.android.socialbase.downloader.e.dl dlVar) {
        return zVar != null && (zVar.z() == 1013 || zVar.z() == 1049) && dlVar != null && "application/vnd.android.package-archive".contains(dlVar.yt()) && zVar2.z("notification_text_opt", 0) == 1;
    }

    private RemoteViews fo() {
        RemoteViews remoteViews = new RemoteViews(this.g.getPackageName(), gc.z());
        try {
            if (com.ss.android.socialbase.appdownloader.dl.z(this.g)) {
                remoteViews.setInt(gc.m(), "setBackgroundColor", this.g.getResources().getColor(gc.fv()));
            }
        } catch (Throwable unused) {
        }
        return remoteViews;
    }

    private int z(int i, int i2) {
        if (com.ss.android.socialbase.downloader.i.z.z(i2).g("notification_opt_2") == 1) {
            return gc.iq();
        }
        if (i == 1 || i == 4) {
            return gc.tb();
        }
        if (i == 2) {
            return gc.q();
        }
        if (i == 3) {
            return gc.iq();
        }
        return 0;
    }

    private PendingIntent z(String str, int i, int i2) {
        Pair<Intent, Boolean> pairG = com.ss.android.socialbase.appdownloader.a.g(this.g, i2);
        Intent intent = (Intent) pairG.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        return com.ss.android.socialbase.appdownloader.a.z(this.g, pairG, i2);
    }

    private NotificationCompat.Builder uy() {
        String strUy = com.ss.android.socialbase.appdownloader.a.kb().uy();
        if (TextUtils.isEmpty(strUy)) {
            strUy = com.ss.android.socialbase.appdownloader.dl.g(this.g);
        }
        try {
            if (com.ss.android.socialbase.appdownloader.a.kb().v() != null) {
                return com.ss.android.socialbase.appdownloader.a.kb().v().z(this.g, strUy);
            }
            return new NotificationCompat.Builder(this.g, strUy);
        } catch (NoSuchMethodError unused) {
            return new NotificationCompat.Builder(this.g);
        }
    }

    private int z(int i) {
        if (com.ss.android.socialbase.downloader.i.z.z(i).g("enable_notification_ui") > 0) {
            return gc.gz();
        }
        return gc.e();
    }
}
