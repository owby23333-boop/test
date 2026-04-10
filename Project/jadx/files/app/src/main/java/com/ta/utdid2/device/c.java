package com.ta.utdid2.device;

import android.content.Context;
import android.text.TextUtils;
import com.ta.utdid2.a.a.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static c a;
    private static final Object b = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f18107i = ".UTSystemConfig" + File.separator + "Global";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.ta.utdid2.b.a.a f154a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private d f155a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private com.ta.utdid2.b.a.a f156b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f18109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f18110h;
    private Context mContext;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f18108f = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Pattern f157b = Pattern.compile("[^0-9a-zA-Z=/+]+");

    private c(Context context) {
        this.mContext = null;
        this.f155a = null;
        this.f18109g = "xx_utdid_key";
        this.f18110h = "xx_utdid_domain";
        this.f154a = null;
        this.f156b = null;
        this.mContext = context;
        this.f156b = new com.ta.utdid2.b.a.a(context, f18107i, "Alvin2", false, true);
        this.f154a = new com.ta.utdid2.b.a.a(context, ".DataStorage", "ContextData", false, true);
        this.f155a = new d();
        this.f18109g = String.format("K_%d", Integer.valueOf(f.a(this.f18109g)));
        this.f18110h = String.format("D_%d", Integer.valueOf(f.a(this.f18110h)));
    }

    public static c a(Context context) {
        if (context != null && a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new c(context);
                    a.b();
                }
            }
        }
        return a;
    }

    private void b() {
        com.ta.utdid2.b.a.a aVar = this.f156b;
        if (aVar != null) {
            if (f.m175a(aVar.getString("UTDID2"))) {
                String string = this.f156b.getString("UTDID");
                if (!f.m175a(string)) {
                    e(string);
                }
            }
            boolean z2 = false;
            if (!f.m175a(this.f156b.getString("DID"))) {
                this.f156b.remove("DID");
                z2 = true;
            }
            if (!f.m175a(this.f156b.getString("EI"))) {
                this.f156b.remove("EI");
                z2 = true;
            }
            if (!f.m175a(this.f156b.getString("SI"))) {
                this.f156b.remove("SI");
                z2 = true;
            }
            if (z2) {
                this.f156b.commit();
            }
        }
    }

    private byte[] c() throws Exception {
        String strA;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNextInt = new Random().nextInt();
        byte[] bytes = com.ta.utdid2.a.a.c.getBytes(iCurrentTimeMillis);
        byte[] bytes2 = com.ta.utdid2.a.a.c.getBytes(iNextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            strA = com.ta.utdid2.a.a.d.a(this.mContext);
        } catch (Exception unused) {
            strA = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(com.ta.utdid2.a.a.c.getBytes(f.a(strA)), 0, 4);
        byteArrayOutputStream.write(com.ta.utdid2.a.a.c.getBytes(f.a(b(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    private void e(String str) {
        com.ta.utdid2.b.a.a aVar;
        if (b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || (aVar = this.f156b) == null) {
                return;
            }
            aVar.putString("UTDID2", str);
            this.f156b.commit();
        }
    }

    private void f(String str) {
        com.ta.utdid2.b.a.a aVar;
        if (str == null || (aVar = this.f154a) == null || str.equals(aVar.getString(this.f18109g))) {
            return;
        }
        this.f154a.putString(this.f18109g, str);
        this.f154a.commit();
    }

    public synchronized String g() {
        this.f18108f = h();
        if (!TextUtils.isEmpty(this.f18108f)) {
            return this.f18108f;
        }
        try {
            byte[] bArrC = c();
            if (bArrC != null) {
                this.f18108f = com.ta.utdid2.a.a.b.encodeToString(bArrC, 2);
                e(this.f18108f);
                String strC = this.f155a.c(bArrC);
                if (strC != null) {
                    f(strC);
                }
                return this.f18108f;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public synchronized String getValue() {
        if (this.f18108f != null) {
            return this.f18108f;
        }
        return g();
    }

    public synchronized String h() {
        String strF = f();
        if (b(strF)) {
            f(this.f155a.c(strF));
            this.f18108f = strF;
            return strF;
        }
        String string = this.f154a.getString(this.f18109g);
        if (!f.m175a(string)) {
            String strD = new e().d(string);
            if (!b(strD)) {
                strD = this.f155a.d(string);
            }
            if (b(strD) && !f.m175a(strD)) {
                this.f18108f = strD;
                e(this.f18108f);
                return this.f18108f;
            }
        }
        return null;
    }

    private String f() {
        com.ta.utdid2.b.a.a aVar = this.f156b;
        if (aVar == null) {
            return null;
        }
        String string = aVar.getString("UTDID2");
        if (f.m175a(string) || this.f155a.c(string) == null) {
            return null;
        }
        return string;
    }

    private boolean b(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.f157b.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    public static String b(byte[] bArr) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(com.ta.utdid2.a.a.e.a(new byte[]{69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, 33, -80, -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93}), mac.getAlgorithm()));
        return com.ta.utdid2.a.a.b.encodeToString(mac.doFinal(bArr), 2);
    }
}
