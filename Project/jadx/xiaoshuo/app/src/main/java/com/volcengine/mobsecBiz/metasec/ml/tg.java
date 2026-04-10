package com.volcengine.mobsecBiz.metasec.ml;

import android.app.Application;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.WindowManager;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.pblb;
import ms.bz.bd.c.Pgl.pblk;
import ms.bz.bd.c.Pgl.pbly;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public class tg {
    private final List<String> ga = new ArrayList();
    private boolean m = false;
    private e p;
    private final Point tg;
    private final HandlerThread v;
    private e vn;
    private boolean wu;
    private Context zk;
    private static final String[] e = {(String) pblk.a(16777217, 0, 0, "6aed97", new byte[]{Ascii.CAN, 103, Ascii.ETB, 4, 7}), (String) pblk.a(16777217, 0, 0, "5aa1f2", new byte[]{32, 98, 6, 64, 77, 36, Base64.padSymbol, 69, 62})};
    private static final String[] bf = {(String) pblk.a(16777217, 0, 0, "253e32", new byte[]{Ascii.FS, 51, 65, 5, Ascii.CR}), (String) pblk.a(16777217, 0, 0, "0da034", new byte[]{37, 103, 6, 65, Ascii.CAN, 34, 56, 64, 62}), (String) pblk.a(16777217, 0, 0, "0538ab", new byte[]{54, 62, 68, 88, 86}), (String) pblk.a(16777217, 0, 0, "2e3336", new byte[]{43, 98, 73, 64, 4, 53})};
    private static final String[] d = {(String) pblk.a(16777217, 0, 0, "950d66", new byte[]{59, 52, 81, Ascii.NAK, Ascii.FF, 47, 41, Ascii.FS, 110, 32}), (String) pblk.a(16777217, 0, 0, "1b9a48", new byte[]{51, 99, 88, 16, Ascii.SO, 33, Ascii.CR, 80, 96, 62, 52}), (String) pblk.a(16777217, 0, 0, "c61b53", new byte[]{97, 55, 80, 19, Ascii.SI, 42, 45, 4, 104, Base64.padSymbol, 102}), (String) pblk.a(16777217, 0, 0, "218f78", new byte[]{48, 48, 89, Ascii.ETB, Ascii.CR, 33, 113, 3, 97, 57, 55}), (String) pblk.a(16777217, 0, 0, "58f997", new byte[]{55, 57, 7, 72, 3, 46, 53, Ascii.CAN, 39, 125, 49, 40, 16}), (String) pblk.a(16777217, 0, 0, "422611", new byte[]{54, 51, 83, 71, Ascii.VT, 40, 8, 16, 98, 118, 49, 37, 83, 71}), (String) pblk.a(16777217, 0, 0, "1c71cf", new byte[]{51, 98, 86, 64, 89, 127, 127, 65, 103, 113, 52, 116, 86, 64}), (String) pblk.a(16777217, 0, 0, "3d2120", new byte[]{49, 101, 83, 64, 8, 41, 112, 70, 98, 113, 54, 115, 83, 64}), (String) pblk.a(16777217, 0, 0, "ff2e4d", new byte[]{100, 103, 83, Ascii.DC4, Ascii.SO, 125, 102, 70, 115}), (String) pblk.a(16777217, 0, 0, "625a6c", new byte[]{52, 51, 84, 16, Ascii.FF, 122, 10, 16, 101, 33}), (String) pblk.a(16777217, 0, 0, "e17952", new byte[]{103, 48, 86, 72, Ascii.SI, 43, 43, 19, 103, 121}), (String) pblk.a(16777217, 0, 0, "c53cc5", new byte[]{97, 52, 82, 18, 89, 44, 32, Ascii.ETB, 99, 35})};

    public class e extends ContentObserver {
        private final Uri bf;

        public e(Uri uri, Handler handler) {
            super(handler);
            this.bf = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            tg.e(tg.this, this.bf);
        }
    }

    public tg(Context context) {
        this.wu = false;
        Context applicationContext = context.getApplicationContext();
        this.zk = applicationContext;
        if (!(applicationContext instanceof Application)) {
            Context contextBf = bf();
            this.zk = contextBf == null ? this.zk : contextBf;
        }
        this.tg = e(context);
        this.v = new HandlerThread((String) pblk.a(16777217, 0, 0L, "08d761", new byte[]{18, 9}));
        this.wu = Build.VERSION.SDK_INT >= 29;
    }

    private Application bf() {
        Application application;
        try {
            application = null;
            try {
                return (Application) Class.forName((String) pblk.a(16777217, 0, 0L, "3ac5c0", new byte[]{35, 109, Ascii.DC4, 83, 83, 46, 52, Ascii.SO, 51, 117, 50, 45, 49, 66, 72, 46, 38, 73, 38, 124, Ascii.SYN, 107, 2, 68, 93, 35})).getMethod((String) pblk.a(16777217, 0, 0L, "7d6697", new byte[]{37, 115, 87, 80, 3, 46, 32, 100, 119, 118, 42, 111, 70, 67, 18, 41, 59, 75}), new Class[0]).invoke(null, null);
            } catch (Throwable unused) {
                return application;
            }
        } catch (Throwable unused2) {
            application = null;
        }
    }

    private Point e(Context context) {
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService((String) pblk.a(16777217, 0, 0L, "69a60d", new byte[]{48, 50, Ascii.FS, 70, 0, 100}));
            if (windowManager == null) {
                return null;
            }
            Point point = new Point();
            try {
                windowManager.getDefaultDisplay().getRealSize(point);
            } catch (Throwable unused) {
            }
            return point;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void finalize() throws Throwable {
        synchronized (this) {
            if (this.vn != null) {
                try {
                    this.zk.getContentResolver().unregisterContentObserver(this.vn);
                } catch (Throwable unused) {
                }
                this.vn = null;
            }
            if (this.p != null) {
                try {
                    this.zk.getContentResolver().unregisterContentObserver(this.p);
                } catch (Throwable unused2) {
                }
                this.p = null;
            }
            HandlerThread handlerThread = this.v;
            if (handlerThread != null) {
                try {
                    handlerThread.quit();
                } catch (Throwable unused3) {
                }
            }
        }
        super.finalize();
    }

    public synchronized void e() {
        if (this.m) {
            return;
        }
        this.m = true;
        try {
            this.v.start();
            Handler handler = new Handler(this.v.getLooper());
            this.vn = new e(MediaStore.Images.Media.INTERNAL_CONTENT_URI, handler);
            this.p = new e(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, handler);
            this.zk.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.wu, this.vn);
            this.zk.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.wu, this.p);
        } catch (Throwable unused) {
        }
    }

    public static void e(tg tgVar, Uri uri) {
        byte b2;
        Cursor cursorQuery;
        int i;
        int i2;
        byte b3;
        byte b4;
        byte b5;
        Point point;
        tgVar.getClass();
        byte b6 = 1;
        try {
            b2 = pbly.e() != null ? (byte) 1 : (byte) 0;
        } catch (Throwable unused) {
            b2 = -1;
        }
        if (b2 != 1) {
            return;
        }
        try {
            cursorQuery = tgVar.zk.getContentResolver().query(uri, bf, null, null, (String) pblk.a(16777217, 0, 0L, "0a1f1e", new byte[]{37, 98, 86, Ascii.ETB, 49, 115, 55, 68, 101, 50, 97, 103, 71, 1, Ascii.CR, 50, Utf8.REPLACEMENT_BYTE, 73, 109, Utf8.REPLACEMENT_BYTE, 53, 35, 19}));
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        int columnIndex = cursorQuery.getColumnIndex((String) pblk.a(16777217, 0, 0L, "ae40f8", new byte[]{79, 99, 70, 80, 88}));
                        int columnIndex2 = cursorQuery.getColumnIndex((String) pblk.a(16777217, 0, 0L, "0bf46e", new byte[]{37, 97, 1, 69, Ascii.GS, 115, 56, 70, 57}));
                        int columnIndex3 = cursorQuery.getColumnIndex((String) pblk.a(16777217, 0, 0L, "fc45b3", new byte[]{96, 104, 67, 85, 85}));
                        int columnIndex4 = cursorQuery.getColumnIndex((String) pblk.a(16777217, 0, 0L, "e1ca49", new byte[]{124, 54, Ascii.EM, 18, 3, 58}));
                        String string = cursorQuery.getString(columnIndex);
                        long j = cursorQuery.getLong(columnIndex2);
                        if (columnIndex3 < 0 || columnIndex4 < 0) {
                            i = -1;
                            i2 = -1;
                        } else {
                            i = cursorQuery.getInt(columnIndex3);
                            i2 = cursorQuery.getInt(columnIndex4);
                        }
                        if (i == -1 || i2 == -1 || (point = tgVar.tg) == null) {
                            b3 = 0;
                        } else {
                            int i3 = point.x;
                            b3 = ((i > i3 || i2 > point.y) && (i2 > i3 || i > point.y)) ? (byte) -1 : (byte) 1;
                        }
                        if (b3 == -1) {
                            if (cursorQuery.isClosed()) {
                                return;
                            }
                        } else if (System.currentTimeMillis() - j <= 10000) {
                            if (!TextUtils.isEmpty(string)) {
                                String lowerCase = string.toLowerCase();
                                for (String str : d) {
                                    if (lowerCase.contains(str)) {
                                        b4 = 1;
                                        break;
                                    }
                                }
                            }
                            b4 = -1;
                            if (b4 == -1) {
                                if (cursorQuery.isClosed()) {
                                    return;
                                }
                            } else {
                                if (TextUtils.isEmpty(string) || tgVar.ga.contains(string)) {
                                    b5 = -1;
                                    b6 = -1;
                                } else {
                                    if (tgVar.ga.size() >= 20) {
                                        tgVar.ga.remove(0);
                                    }
                                    tgVar.ga.add(string);
                                    b5 = -1;
                                }
                                if (b6 != b5) {
                                    pblb.e(268435458);
                                    if (cursorQuery.isClosed()) {
                                        return;
                                    }
                                } else if (cursorQuery.isClosed()) {
                                    return;
                                }
                            }
                        } else if (cursorQuery.isClosed()) {
                            return;
                        }
                    } else if (cursorQuery.isClosed()) {
                        return;
                    }
                } catch (Throwable unused2) {
                    if (cursorQuery == null || cursorQuery.isClosed()) {
                        return;
                    }
                }
            } else if (cursorQuery == null || cursorQuery.isClosed()) {
                return;
            }
        } catch (Throwable unused3) {
            cursorQuery = null;
        }
        cursorQuery.close();
    }
}
