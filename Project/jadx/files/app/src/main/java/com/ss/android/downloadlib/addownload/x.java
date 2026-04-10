package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.e;
import com.ss.android.download.api.config.g;
import com.ss.android.download.api.config.io;
import com.ss.android.download.api.config.lc;
import com.ss.android.download.api.config.m;
import com.ss.android.download.api.config.nk;
import com.ss.android.download.api.config.o;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class x {
    private static com.ss.android.download.api.config.ko b;
    private static m df;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static o f18015e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static e f18016g;
    private static com.ss.android.download.api.ox.mb gm;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static com.ss.android.download.api.config.je f18017h;
    private static com.ss.android.download.api.config.b hj;

    /* JADX INFO: renamed from: io, reason: collision with root package name */
    private static g f18018io;
    private static com.ss.android.socialbase.appdownloader.b.ww jb;
    private static com.ss.android.download.api.config.hj je;
    private static com.ss.android.download.api.config.lz ko;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static nk f18019l;
    private static com.ss.android.download.api.config.jb lc;
    private static com.ss.android.download.api.model.mb lz;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static io f18020m;
    public static final JSONObject mb = new JSONObject();
    private static com.ss.android.download.api.config.h nk;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static lc f18021o;
    private static Context ox;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static com.ss.android.download.api.config.ww f18022u;
    private static com.ss.android.download.api.config.x ww;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static com.ss.android.download.api.config.ox f18023x;

    @NonNull
    public static com.ss.android.download.api.config.je b() {
        if (f18017h == null) {
            f18017h = new com.ss.android.download.api.mb.mb();
        }
        return f18017h;
    }

    public static boolean df() {
        return (b == null || f18022u == null || ww == null || f18023x == null || f18016g == null) ? false : true;
    }

    @NonNull
    public static e e() {
        return f18016g;
    }

    public static String g() {
        try {
            int i2 = getContext().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
                return getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + lz().optString("default_save_dir_name", BaseConstants.DOWNLOAD_DIR);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Context getContext() {
        Context context = ox;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    @NonNull
    public static m gm() {
        if (df == null) {
            df = new m() { // from class: com.ss.android.downloadlib.addownload.x.5
                @Override // com.ss.android.download.api.config.m
                public void mb(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, int i2) {
                }
            };
        }
        return df;
    }

    @NonNull
    public static com.ss.android.download.api.config.lz h() {
        if (ko == null) {
            ko = new com.ss.android.download.api.mb.ox();
        }
        return ko;
    }

    public static com.ss.android.download.api.config.ww hj() {
        return f18022u;
    }

    public static com.ss.android.download.api.config.jb io() {
        return lc;
    }

    @Nullable
    public static com.ss.android.download.api.config.ox jb() {
        return f18023x;
    }

    @Nullable
    public static o je() {
        return f18015e;
    }

    public static lc ko() {
        return f18021o;
    }

    public static g l() {
        return f18018io;
    }

    public static com.ss.android.download.api.config.h lc() {
        return nk;
    }

    @NonNull
    public static JSONObject lz() {
        com.ss.android.download.api.config.x xVar = ww;
        return (xVar == null || xVar.mb() == null) ? mb : ww.mb();
    }

    @NonNull
    public static com.ss.android.download.api.ox.mb m() {
        if (gm == null) {
            gm = new com.ss.android.download.api.ox.mb() { // from class: com.ss.android.downloadlib.addownload.x.4
                @Override // com.ss.android.download.api.ox.mb
                public void mb(Throwable th, String str) {
                }
            };
        }
        return gm;
    }

    public static com.ss.android.download.api.config.ko mb() {
        return b;
    }

    public static void mb(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        ox = context.getApplicationContext();
    }

    public static void mb(e eVar) {
        f18016g = eVar;
    }

    public static void mb(@NonNull com.ss.android.download.api.config.je jeVar) {
        f18017h = jeVar;
    }

    public static void mb(@NonNull com.ss.android.download.api.config.ko koVar) {
        b = koVar;
    }

    public static void mb(@NonNull com.ss.android.download.api.config.lz lzVar) {
        ko = lzVar;
    }

    public static void mb(@NonNull com.ss.android.download.api.config.ox oxVar) {
        f18023x = oxVar;
    }

    public static void mb(@NonNull com.ss.android.download.api.config.ww wwVar) {
        f18022u = wwVar;
    }

    public static void mb(@NonNull com.ss.android.download.api.config.x xVar) {
        ww = xVar;
    }

    public static void mb(@NonNull com.ss.android.download.api.model.mb mbVar) {
        lz = mbVar;
    }

    public static void mb(com.ss.android.download.api.ox.mb mbVar) {
        gm = mbVar;
    }

    public static void mb(String str) {
        com.ss.android.socialbase.appdownloader.hj.x().mb(str);
    }

    public static String nk() {
        return "1.7.0";
    }

    public static com.ss.android.download.api.config.hj o() {
        return je;
    }

    @NonNull
    public static com.ss.android.download.api.config.b ox() {
        if (hj == null) {
            hj = new com.ss.android.download.api.config.b() { // from class: com.ss.android.downloadlib.addownload.x.1
                @Override // com.ss.android.download.api.config.b
                public void mb(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
                }

                @Override // com.ss.android.download.api.config.b
                public void mb(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, @NonNull String str2) {
                }
            };
        }
        return hj;
    }

    public static void ox(Context context) {
        if (ox != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        ox = context.getApplicationContext();
    }

    public static com.ss.android.socialbase.appdownloader.b.ww u() {
        if (jb == null) {
            jb = new com.ss.android.socialbase.appdownloader.b.ww() { // from class: com.ss.android.downloadlib.addownload.x.2
                @Override // com.ss.android.socialbase.appdownloader.b.ww
                public void mb(DownloadInfo downloadInfo, BaseException baseException, int i2) {
                }
            };
        }
        return jb;
    }

    @NonNull
    public static io ww() {
        if (f18020m == null) {
            f18020m = new io() { // from class: com.ss.android.downloadlib.addownload.x.3
                @Override // com.ss.android.download.api.config.io
                public void mb(String str, int i2, JSONObject jSONObject) {
                }
            };
        }
        return f18020m;
    }

    public static nk x() {
        return f18019l;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0013. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0009. Please report as an issue. */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public static java.lang.String x1672829046072dc(java.lang.String r4) {
        /*
        L0:
            r0 = 73
            r1 = 96
        L4:
            r2 = 0
            switch(r0) {
                case 72: goto L55;
                case 73: goto L9;
                case 74: goto Lc;
                default: goto L8;
            }
        L8:
            goto L5a
        L9:
            switch(r1) {
                case 94: goto L0;
                case 95: goto L10;
                case 96: goto L55;
                default: goto Lc;
            }
        Lc:
            switch(r1) {
                case 55: goto L3f;
                case 56: goto L55;
                case 57: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L0
        L10:
            r0 = 18
            r1 = 1
            switch(r1) {
                case 60: goto L17;
                case 61: goto L25;
                case 62: goto L34;
                default: goto L16;
            }
        L16:
            goto L55
        L17:
            int r3 = 0 - r1
            int r3 = r3 * 0
            r2 = 0
            int r2 = r2 * 2
            int r2 = r2 - r1
            int r3 = r3 * r2
            int r3 = r3 % 6
            if (r3 == 0) goto L0
        L25:
            int r2 = 18 - r1
            int r2 = r2 * 18
            r3 = 18
            int r3 = r3 * 2
            int r3 = r3 - r1
            int r2 = r2 * r3
            int r2 = r2 % 6
            if (r2 == 0) goto L55
        L34:
            r1 = 99
            int r1 = r1 * r1
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r1 = r1 - r0
            r0 = -1
            goto L0
        L3f:
            char[] r4 = r4.toCharArray()
        L43:
            int r0 = r4.length
            if (r2 >= r0) goto L4f
            char r0 = r4[r2]
            r0 = r0 ^ r2
            char r0 = (char) r0
            r4[r2] = r0
            int r2 = r2 + 1
            goto L43
        L4f:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            return r0
        L55:
            r0 = 74
            r1 = 55
            goto L4
        L5a:
            r0 = 72
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.x.x1672829046072dc(java.lang.String):java.lang.String");
    }
}
