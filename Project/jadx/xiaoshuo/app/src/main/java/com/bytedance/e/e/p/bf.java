package com.bytedance.e.e.p;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.alipay.sdk.m.w.a;
import com.bytedance.e.e.v.m;
import com.bytedance.e.e.v.vn;
import com.bytedance.e.e.zk;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import net.oauth.http.HttpMessageDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bf {
    private static d bf = null;
    public static boolean e = false;

    /* JADX INFO: renamed from: com.bytedance.e.e.p.bf$bf, reason: collision with other inner class name */
    public enum EnumC0073bf {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);

        final int p;

        EnumC0073bf(int i) {
            this.p = i;
        }
    }

    public enum e {
        NONE(0),
        GZIP(1),
        DEFLATER(2);

        final int tg;

        e(int i) {
            this.tg = i;
        }
    }

    public static boolean bf() {
        return true;
    }

    private static ga d(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new ga(203);
        }
        String str = new String(bArr, Charset.forName("utf-8"));
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.length() > 0 ? new ga(0, jSONObject) : new ga(204, str);
        } catch (JSONException unused) {
            return new ga(204, str);
        }
    }

    public static boolean e() {
        return true;
    }

    private static byte[] bf(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                m.bf(th);
                gZIPOutputStream.close();
                return null;
            } catch (Throwable th2) {
                gZIPOutputStream.close();
                throw th2;
            }
        }
    }

    public static ga e(long j, String str, byte[] bArr, e eVar, String str2, boolean z) throws IOException {
        String str3;
        if (str == null) {
            return new ga(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        if (e.GZIP == eVar && length > 128) {
            bArr = bf(bArr);
            str3 = "gzip";
        } else if (e.DEFLATER != eVar || length <= 128) {
            str3 = null;
        } else {
            bArr = e(bArr);
            str3 = HttpMessageDecoder.DEFLATE;
        }
        String str4 = str3;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return new ga(202);
        }
        if (!z) {
            return e(str, bArr2, str2, str4, "POST", true, false);
        }
        byte[] bArrA = TTEncryptUtils.a(bArr2, bArr2.length);
        if (bArrA != null) {
            if (TextUtils.isEmpty(new URL(str).getQuery())) {
                if (!str.endsWith("?")) {
                    str = str + "?";
                }
            } else if (!str.endsWith(a.p)) {
                str = str + a.p;
            }
            str = str + "tt_data=a";
            str2 = "application/octet-stream;tt-data=a";
            bArr2 = bArrA;
        }
        return e(str, bArr2, str2, str4, "POST", true, true);
    }

    private static byte[] e(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0057 A[Catch: all -> 0x004e, TryCatch #10 {all -> 0x004e, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:20:0x0042, B:24:0x0057, B:27:0x0062, B:29:0x0069, B:30:0x006e, B:32:0x0075, B:34:0x007a, B:38:0x008c, B:43:0x0094, B:44:0x0097, B:45:0x0098, B:47:0x00a0, B:65:0x00d6, B:69:0x00f5, B:70:0x00fc, B:25:0x005c), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005c A[Catch: all -> 0x004e, TryCatch #10 {all -> 0x004e, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:20:0x0042, B:24:0x0057, B:27:0x0062, B:29:0x0069, B:30:0x006e, B:32:0x0075, B:34:0x007a, B:38:0x008c, B:43:0x0094, B:44:0x0097, B:45:0x0098, B:47:0x00a0, B:65:0x00d6, B:69:0x00f5, B:70:0x00fc, B:25:0x005c), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0062 A[Catch: all -> 0x004e, TryCatch #10 {all -> 0x004e, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:20:0x0042, B:24:0x0057, B:27:0x0062, B:29:0x0069, B:30:0x006e, B:32:0x0075, B:34:0x007a, B:38:0x008c, B:43:0x0094, B:44:0x0097, B:45:0x0098, B:47:0x00a0, B:65:0x00d6, B:69:0x00f5, B:70:0x00fc, B:25:0x005c), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069 A[Catch: all -> 0x004e, TryCatch #10 {all -> 0x004e, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:20:0x0042, B:24:0x0057, B:27:0x0062, B:29:0x0069, B:30:0x006e, B:32:0x0075, B:34:0x007a, B:38:0x008c, B:43:0x0094, B:44:0x0097, B:45:0x0098, B:47:0x00a0, B:65:0x00d6, B:69:0x00f5, B:70:0x00fc, B:25:0x005c), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0075 A[Catch: all -> 0x004e, TryCatch #10 {all -> 0x004e, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:20:0x0042, B:24:0x0057, B:27:0x0062, B:29:0x0069, B:30:0x006e, B:32:0x0075, B:34:0x007a, B:38:0x008c, B:43:0x0094, B:44:0x0097, B:45:0x0098, B:47:0x00a0, B:65:0x00d6, B:69:0x00f5, B:70:0x00fc, B:25:0x005c), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f5 A[Catch: all -> 0x004e, TRY_ENTER, TryCatch #10 {all -> 0x004e, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:20:0x0042, B:24:0x0057, B:27:0x0062, B:29:0x0069, B:30:0x006e, B:32:0x0075, B:34:0x007a, B:38:0x008c, B:43:0x0094, B:44:0x0097, B:45:0x0098, B:47:0x00a0, B:65:0x00d6, B:69:0x00f5, B:70:0x00fc, B:25:0x005c), top: B:106:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.bytedance.e.e.p.ga e(java.lang.String r5, byte[] r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, boolean r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.e.e.p.bf.e(java.lang.String, byte[], java.lang.String, java.lang.String, java.lang.String, boolean, boolean):com.bytedance.e.e.p.ga");
    }

    public static ga e(String str, String str2) {
        return e(str, str2, e());
    }

    public static String e(Map map) {
        return zk.ga().e();
    }

    public static ga e(String str, String str2, boolean z) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                return e(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, str, str2.getBytes(), e.GZIP, "application/json; charset=utf-8", z);
            }
            return new ga(201);
        } catch (Throwable th) {
            m.bf(th);
            return new ga(207, th);
        }
    }

    private static byte[] e(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 != i) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    vn.e(byteArrayOutputStream);
                }
            }
        }
    }
}
