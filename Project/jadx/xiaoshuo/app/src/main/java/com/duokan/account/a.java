package com.duokan.account;

import android.app.Activity;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.duokan.account.b;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.ui.general.DkToast;
import com.google.common.base.Ascii;
import com.xiaomi.micloudsdk.request.Request;
import com.yuewen.bi;
import com.yuewen.cw1;
import com.yuewen.e3;
import com.yuewen.ea4;
import com.yuewen.i3;
import com.yuewen.n81;
import com.yuewen.xt1;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import miuix.security.DigestUtils;
import org.json.JSONException;

/* JADX INFO: loaded from: classes10.dex */
public abstract class a implements bi, n81 {
    public static final String e = "0123456789ABCDEF";
    public static final /* synthetic */ boolean f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f2190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cw1 f2191b;
    public final cw1 c;
    public long d = -1;

    /* JADX INFO: renamed from: com.duokan.account.a$a, reason: collision with other inner class name */
    public static class C0181a implements xt1 {
        @Override // com.yuewen.xt1
        public void c(bi biVar, String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            DkToast.makeText(com.duokan.core.app.b.get(), str, 0).show();
        }

        @Override // com.yuewen.xt1
        public void e(bi biVar) {
        }
    }

    public interface b extends xt1 {
        void b(Bitmap bitmap);

        void d(int i, String str);
    }

    public interface c {
        void a(a aVar, String str);

        void b(a aVar);
    }

    public a(e3 e3Var) {
        this.f2190a = e3Var;
        this.f2191b = e3Var.a();
        this.c = e3Var.f();
    }

    public static byte[] A(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(bArr2);
    }

    public static String B(String str) throws Exception {
        return z(I(ReaderEnv.get().b0()), str);
    }

    public static String C(String str) throws Exception {
        return P(D(H(), str.getBytes()));
    }

    public static byte[] D(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(bArr2);
    }

    public static byte[] H() throws Exception {
        return I(ReaderEnv.get().L());
    }

    public static byte[] I(String str) throws Exception {
        return new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance(DigestUtils.ALGORITHM_SHA_1).digest(str.getBytes("UTF-8")), 16), "AES").getEncoded();
    }

    public static byte[] O(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static String P(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b2 : bArr) {
            w(stringBuffer, b2);
        }
        return stringBuffer.toString();
    }

    public static void w(StringBuffer stringBuffer, byte b2) {
        stringBuffer.append(e.charAt((b2 >> 4) & 15));
        stringBuffer.append(e.charAt(b2 & Ascii.SI));
    }

    public static String y(String str) throws Exception {
        return z(H(), str);
    }

    public static String z(byte[] bArr, String str) throws Exception {
        return new String(A(bArr, O(str)));
    }

    @NonNull
    public abstract String E();

    public abstract Map<String, String> F();

    public Request.RequestEnv G() {
        return null;
    }

    public abstract String J() throws JSONException;

    public final void K() {
        cw1 cw1Var;
        cw1 cw1Var2;
        synchronized (this.f2191b) {
            this.f2191b.o();
            try {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.C0182b.a.f2196b, s().name());
                    contentValues.put(b.C0182b.a.c, j().toString());
                    contentValues.put(b.C0182b.a.d, g());
                    contentValues.put(b.C0182b.a.e, Integer.valueOf(v() ? 1 : 0));
                    this.d = this.f2191b.C("accounts", null, contentValues);
                    this.f2191b.T();
                    cw1Var = this.f2191b;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    cw1Var = this.f2191b;
                }
                cw1Var.v();
                this.c.o();
                try {
                    try {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("account_id", Long.valueOf(this.d));
                        contentValues2.put("tokens", C(J()));
                        this.c.C("tokens", null, contentValues2);
                        this.c.T();
                        cw1Var2 = this.c;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        cw1Var2 = this.c;
                    }
                    cw1Var2.v();
                } catch (Throwable th) {
                    this.c.v();
                    throw th;
                }
            } catch (Throwable th2) {
                this.f2191b.v();
                throw th2;
            }
        }
    }

    public abstract void L(Activity activity, c cVar);

    public void M() {
        Q();
        this.f2190a.e(this);
    }

    public abstract void N(String str, String str2, String str3, boolean z);

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052 A[Catch: all -> 0x0144, DONT_GENERATE, PHI: r1
  0x0052: PHI (r1v5 android.database.Cursor) = (r1v4 android.database.Cursor), (r1v7 android.database.Cursor) binds: [B:21:0x005b, B:15:0x0050] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:16:0x0052, B:25:0x0061, B:26:0x0064, B:27:0x0065, B:29:0x006b, B:30:0x006e, B:32:0x0070, B:38:0x00cd, B:39:0x00cf, B:46:0x00dc, B:51:0x0127, B:52:0x0129, B:59:0x0136, B:61:0x0138, B:62:0x013d, B:58:0x0133, B:63:0x013e, B:64:0x0143, B:45:0x00d9, B:47:0x00e1, B:49:0x011b, B:50:0x0122, B:33:0x0075, B:37:0x00a7, B:44:0x00d6, B:57:0x0130, B:20:0x0058), top: B:72:0x0003, inners: #0, #1, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006b A[Catch: all -> 0x0144, TryCatch #2 {, blocks: (B:4:0x0003, B:16:0x0052, B:25:0x0061, B:26:0x0064, B:27:0x0065, B:29:0x006b, B:30:0x006e, B:32:0x0070, B:38:0x00cd, B:39:0x00cf, B:46:0x00dc, B:51:0x0127, B:52:0x0129, B:59:0x0136, B:61:0x0138, B:62:0x013d, B:58:0x0133, B:63:0x013e, B:64:0x0143, B:45:0x00d9, B:47:0x00e1, B:49:0x011b, B:50:0x0122, B:33:0x0075, B:37:0x00a7, B:44:0x00d6, B:57:0x0130, B:20:0x0058), top: B:72:0x0003, inners: #0, #1, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0070 A[Catch: all -> 0x0144, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:16:0x0052, B:25:0x0061, B:26:0x0064, B:27:0x0065, B:29:0x006b, B:30:0x006e, B:32:0x0070, B:38:0x00cd, B:39:0x00cf, B:46:0x00dc, B:51:0x0127, B:52:0x0129, B:59:0x0136, B:61:0x0138, B:62:0x013d, B:58:0x0133, B:63:0x013e, B:64:0x0143, B:45:0x00d9, B:47:0x00e1, B:49:0x011b, B:50:0x0122, B:33:0x0075, B:37:0x00a7, B:44:0x00d6, B:57:0x0130, B:20:0x0058), top: B:72:0x0003, inners: #0, #1, #5, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Q() {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.account.a.Q():void");
    }

    @Override // com.yuewen.bi
    public abstract ea4 d();

    @Override // com.yuewen.bi
    public abstract String g();

    @Override // com.yuewen.bi
    public abstract boolean isEmpty();

    @Override // com.yuewen.bi
    public abstract i3 j();

    @Override // com.yuewen.bi
    public abstract String k();

    /* JADX WARN: Removed duplicated region for block: B:27:0x00bc A[Catch: all -> 0x00d3, TRY_ENTER, TryCatch #1 {all -> 0x00d3, blocks: (B:27:0x00bc, B:29:0x00c1, B:42:0x00da, B:46:0x00df, B:48:0x00e4, B:49:0x00e7, B:37:0x00cf, B:41:0x00d7), top: B:53:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c1 A[Catch: all -> 0x00d3, TRY_LEAVE, TryCatch #1 {all -> 0x00d3, blocks: (B:27:0x00bc, B:29:0x00c1, B:42:0x00da, B:46:0x00df, B:48:0x00e4, B:49:0x00e7, B:37:0x00cf, B:41:0x00d7), top: B:53:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00df A[Catch: all -> 0x00d3, TryCatch #1 {all -> 0x00d3, blocks: (B:27:0x00bc, B:29:0x00c1, B:42:0x00da, B:46:0x00df, B:48:0x00e4, B:49:0x00e7, B:37:0x00cf, B:41:0x00d7), top: B:53:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e4 A[Catch: all -> 0x00d3, TryCatch #1 {all -> 0x00d3, blocks: (B:27:0x00bc, B:29:0x00c1, B:42:0x00da, B:46:0x00df, B:48:0x00e4, B:49:0x00e7, B:37:0x00cf, B:41:0x00d7), top: B:53:0x0004 }] */
    @Override // com.yuewen.bi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void l() {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.account.a.l():void");
    }

    @Override // com.yuewen.bi
    public abstract String m();

    @Override // com.yuewen.bi
    public long n() {
        return this.d;
    }

    @Override // com.yuewen.bi
    public abstract AccountType s();

    @Override // com.yuewen.bi
    public abstract Map<String, String> t();

    public boolean x() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
