package com.umeng.message.inapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.MsgConstant;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.proguard.ab;
import com.umeng.message.proguard.c;
import com.umeng.message.proguard.u;
import com.umeng.message.proguard.v;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class InAppMessageManager {
    public static boolean a = false;
    public static int b = 1800000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f20280c = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f20281d = "com.umeng.message.inapp.InAppMessageManager";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static InAppMessageManager f20282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f20283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f20284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private UInAppHandler f20285h = new UmengInAppClickHandler();

    private InAppMessageManager(Context context) {
        this.f20283f = context;
    }

    public static InAppMessageManager getInstance(Context context) {
        if (f20282e == null) {
            synchronized (InAppMessageManager.class) {
                if (f20282e == null) {
                    f20282e = new InAppMessageManager(context.getApplicationContext());
                }
            }
        }
        return f20282e;
    }

    private int i(String str) {
        return Integer.valueOf(a(str, "0")).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public u j(String str) {
        Cursor cursorQuery = this.f20283f.getContentResolver().query(ab.f20374l, null, "MsgId=?", new String[]{str}, null);
        u uVar = cursorQuery.moveToFirst() ? new u(cursorQuery) : null;
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return uVar;
    }

    String[] b() {
        String strA = a(MsgConstant.KEY_PLAIN_TEXT_SIZE, "");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return strA.split(",");
    }

    public void c() {
        b(MsgConstant.KEY_SPLASH_TS, System.currentTimeMillis() + "");
    }

    long d() {
        return Long.valueOf(a(MsgConstant.KEY_SPLASH_TS, "0")).longValue();
    }

    public String e() {
        return a(MsgConstant.KEY_LAST_SPLASH_ID, "");
    }

    public String f() {
        return a(MsgConstant.KEY_CARD_LABEL_LIST, "");
    }

    public String g() {
        return a(MsgConstant.KEY_LAST_VERSION_CODE, "");
    }

    public UInAppHandler getInAppHandler() {
        return this.f20285h;
    }

    void h() {
        b(MsgConstant.KEY_LAST_SHOW_SPLASH_TS, System.currentTimeMillis() + "");
    }

    public void setInAppHandler(UInAppHandler uInAppHandler) {
        this.f20285h = uInAppHandler;
    }

    public void setInAppMsgDebugMode(boolean z2) {
        a = z2;
    }

    public void setMainActivityPath(String str) {
        this.f20284g = str;
    }

    public void setPlainTextSize(int i2, int i3, int i4) {
        if (i2 <= 0 || i3 <= 0 || i4 <= 0) {
            UMLog.mutlInfo(f20281d, 0, "纯文本字体大小不能小于0");
            return;
        }
        b(MsgConstant.KEY_PLAIN_TEXT_SIZE, i2 + "," + i3 + "," + i4);
    }

    public void showCardMessage(Activity activity, String str, IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback) {
        new v(activity, str, iUmengInAppMsgCloseCallback).a();
    }

    public String c(String str) {
        return a("KEY_LAST_CARD_ID_" + str, "");
    }

    public void d(String str) {
        b(MsgConstant.KEY_CARD_LABEL_LIST, str);
    }

    public void e(String str) {
        b(MsgConstant.KEY_LAST_VERSION_CODE, str);
    }

    public void f(String str) {
        b("KEY_LAST_SHOW_CARD_TS_" + str, System.currentTimeMillis() + "");
    }

    public long g(String str) {
        return Long.parseLong(a("KEY_LAST_SHOW_CARD_TS_" + str, "0"));
    }

    public boolean h(String str) {
        return this.f20283f.getContentResolver().delete(ab.f20374l, "MsgId=?", new String[]{str}) == 1;
    }

    long i() {
        return Long.parseLong(a(MsgConstant.KEY_LAST_SHOW_SPLASH_TS, "0"));
    }

    String a() {
        return this.f20284g;
    }

    public boolean c(UInAppMessage uInAppMessage) {
        return uInAppMessage.show_times == 0 || i(uInAppMessage.msg_id) < uInAppMessage.show_times;
    }

    public void a(String str) {
        b("KEY_CARD_TS_" + str, System.currentTimeMillis() + "");
    }

    public long b(String str) {
        return Long.valueOf(a("KEY_CARD_TS_" + str, "0")).longValue();
    }

    public void a(UInAppMessage uInAppMessage) {
        if (uInAppMessage == null) {
            b(MsgConstant.KEY_LAST_SPLASH_ID, "");
        } else if (uInAppMessage.getRaw() != null) {
            b(MsgConstant.KEY_LAST_SPLASH_ID, uInAppMessage.getRaw().toString());
        }
    }

    public boolean b(UInAppMessage uInAppMessage) {
        try {
            return System.currentTimeMillis() < new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(uInAppMessage.expire_time).getTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037 A[PHI: r1
  0x0037: PHI (r1v3 android.database.Cursor) = (r1v2 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:15:0x0035, B:9:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<com.umeng.message.proguard.u> j() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.content.Context r2 = r9.f20283f     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            android.content.ContentResolver r3 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            android.net.Uri r4 = com.umeng.message.proguard.ab.f20374l     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r2 = 0
            if (r1 == 0) goto L1d
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
        L1d:
            if (r2 == 0) goto L2c
            com.umeng.message.proguard.u r2 = new com.umeng.message.proguard.u     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r0.add(r2)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            goto L1d
        L2c:
            if (r1 == 0) goto L3a
            goto L37
        L2f:
            r0 = move-exception
            goto L3b
        L31:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L2f
            if (r1 == 0) goto L3a
        L37:
            r1.close()
        L3a:
            return r0
        L3b:
            if (r1 == 0) goto L40
            r1.close()
        L40:
            goto L42
        L41:
            throw r0
        L42:
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.inapp.InAppMessageManager.j():java.util.ArrayList");
    }

    public void a(UInAppMessage uInAppMessage, String str) {
        if (uInAppMessage == null) {
            b("KEY_LAST_CARD_ID_" + str, "");
            return;
        }
        if (uInAppMessage.getRaw() != null) {
            b("KEY_LAST_CARD_ID_" + str, uInAppMessage.getRaw().toString());
        }
    }

    private void b(final String str, final String str2) {
        c.b(new Runnable() { // from class: com.umeng.message.inapp.InAppMessageManager.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("k", str);
                    contentValues.put("v", str2);
                    InAppMessageManager.this.f20283f.getContentResolver().insert(ab.f20365c, contentValues);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void a(String str, int i2) {
        if (i2 == 0) {
            b(str, "0");
        }
        if (i2 == 1) {
            b(str, (i(str) + 1) + "");
        }
    }

    public void a(final String str, final int i2, final int i3, final int i4, final int i5, final int i6, final int i7, final int i8, final int i9) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c.b(new Runnable() { // from class: com.umeng.message.inapp.InAppMessageManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    u uVarJ = InAppMessageManager.this.j(str);
                    if (uVarJ != null) {
                        InAppMessageManager.this.f20283f.getContentResolver().update(ab.f20374l, new u(str, i2, uVarJ.f20516d + i3, uVarJ.f20517e + i4, uVarJ.f20518f + i5, uVarJ.f20519g + i6, uVarJ.f20520h + i7, uVarJ.f20521i + i8, uVarJ.f20522j).a(), "MsgId=?", new String[]{str});
                    } else {
                        InAppMessageManager.this.f20283f.getContentResolver().insert(ab.f20374l, new u(str, i2, i3, i4, i5, i6, i7, i8, i9).a());
                    }
                    UMLog.mutlInfo(InAppMessageManager.f20281d, 2, "store in app cache log success");
                } catch (Exception e2) {
                    UMLog.mutlInfo(InAppMessageManager.f20281d, 0, "store in app cache log fail");
                    e2.printStackTrace();
                }
            }
        });
    }

    private String a(String str, String str2) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f20283f.getContentResolver().query(ab.f20365c, null, null, new String[]{str}, null);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (0 != 0) {
                }
            }
            if (cursorQuery == null) {
                return str2;
            }
            if (cursorQuery.moveToFirst()) {
                str2 = cursorQuery.getString(cursorQuery.getColumnIndex("v"));
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return str2;
        } finally {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }

    public void a(final File file) {
        c.b(new Runnable() { // from class: com.umeng.message.inapp.InAppMessageManager.3
            @Override // java.lang.Runnable
            public void run() {
                File file2 = file;
                if (file2 != null && file2.exists() && file.canWrite() && file.isDirectory()) {
                    for (File file3 : file.listFiles()) {
                        if (!file3.isDirectory()) {
                            file3.delete();
                        }
                    }
                    file.delete();
                }
            }
        });
    }
}
