package com.bytedance.z.g.e;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.z.g.gz;
import com.bytedance.z.g.gz.uy;
import com.efs.sdk.base.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static dl g;
    public static boolean z;

    public static boolean g() {
        return true;
    }

    public static boolean z() {
        return true;
    }

    public static m z(long j, String str, byte[] bArr, z zVar, String str2, boolean z2) throws IOException {
        String str3;
        if (str == null) {
            return new m(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        if (z.GZIP == zVar && length > 128) {
            bArr = g(bArr);
            str3 = Constants.CP_GZIP;
        } else if (z.DEFLATER != zVar || length <= 128) {
            str3 = null;
        } else {
            bArr = z(bArr);
            str3 = "deflate";
        }
        String str4 = str3;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return new m(202);
        }
        if (z2) {
            byte[] bArrA = TTEncryptUtils.a(bArr2, bArr2.length);
            if (bArrA != null) {
                if (TextUtils.isEmpty(new URL(str).getQuery())) {
                    if (!str.endsWith("?")) {
                        str = str + "?";
                    }
                } else if (!str.endsWith("&")) {
                    str = str + "&";
                }
                str = str + "encrypt=true";
                str2 = "application/octet-stream;tt-data=a";
                bArr2 = bArrA;
            }
            return z(str, bArr2, str2, str4, "POST", true, true);
        }
        return z(str, bArr2, str2, str4, "POST", true, false);
    }

    private static byte[] z(byte[] bArr) {
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

    private static byte[] g(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                uy.g(th);
                gZIPOutputStream.close();
                return null;
            } catch (Throwable th2) {
                gZIPOutputStream.close();
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0056 A[Catch: all -> 0x004d, TryCatch #8 {all -> 0x004d, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:19:0x0041, B:23:0x0056, B:26:0x0061, B:28:0x0068, B:29:0x006d, B:31:0x0074, B:33:0x0079, B:37:0x008b, B:42:0x0093, B:43:0x0096, B:44:0x0097, B:46:0x009f, B:65:0x00d7, B:70:0x00f6, B:71:0x00fd, B:24:0x005b), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b A[Catch: all -> 0x004d, TryCatch #8 {all -> 0x004d, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:19:0x0041, B:23:0x0056, B:26:0x0061, B:28:0x0068, B:29:0x006d, B:31:0x0074, B:33:0x0079, B:37:0x008b, B:42:0x0093, B:43:0x0096, B:44:0x0097, B:46:0x009f, B:65:0x00d7, B:70:0x00f6, B:71:0x00fd, B:24:0x005b), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0061 A[Catch: all -> 0x004d, TryCatch #8 {all -> 0x004d, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:19:0x0041, B:23:0x0056, B:26:0x0061, B:28:0x0068, B:29:0x006d, B:31:0x0074, B:33:0x0079, B:37:0x008b, B:42:0x0093, B:43:0x0096, B:44:0x0097, B:46:0x009f, B:65:0x00d7, B:70:0x00f6, B:71:0x00fd, B:24:0x005b), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0068 A[Catch: all -> 0x004d, TryCatch #8 {all -> 0x004d, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:19:0x0041, B:23:0x0056, B:26:0x0061, B:28:0x0068, B:29:0x006d, B:31:0x0074, B:33:0x0079, B:37:0x008b, B:42:0x0093, B:43:0x0096, B:44:0x0097, B:46:0x009f, B:65:0x00d7, B:70:0x00f6, B:71:0x00fd, B:24:0x005b), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0074 A[Catch: all -> 0x004d, TryCatch #8 {all -> 0x004d, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:19:0x0041, B:23:0x0056, B:26:0x0061, B:28:0x0068, B:29:0x006d, B:31:0x0074, B:33:0x0079, B:37:0x008b, B:42:0x0093, B:43:0x0096, B:44:0x0097, B:46:0x009f, B:65:0x00d7, B:70:0x00f6, B:71:0x00fd, B:24:0x005b), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f6 A[Catch: all -> 0x004d, TRY_ENTER, TryCatch #8 {all -> 0x004d, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:19:0x0041, B:23:0x0056, B:26:0x0061, B:28:0x0068, B:29:0x006d, B:31:0x0074, B:33:0x0079, B:37:0x008b, B:42:0x0093, B:43:0x0096, B:44:0x0097, B:46:0x009f, B:65:0x00d7, B:70:0x00f6, B:71:0x00fd, B:24:0x005b), top: B:103:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.bytedance.z.g.e.m z(java.lang.String r5, byte[] r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, boolean r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.z.g.e.g.z(java.lang.String, byte[], java.lang.String, java.lang.String, java.lang.String, boolean, boolean):com.bytedance.z.g.e.m");
    }

    private static m dl(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new m(203);
        }
        String str = new String(bArr, Charset.forName("utf-8"));
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() > 0) {
                return new m(0, jSONObject);
            }
            return new m(204, str);
        } catch (JSONException unused) {
            return new m(204, str);
        }
    }

    public static m z(String str, String str2) {
        return z(str, str2, z());
    }

    public static String z(Map map) {
        return gz.gc().g();
    }

    public static String g(Map map) {
        return gz.gc().dl();
    }

    public static m z(gc gcVar) {
        if (gcVar == null) {
            return new m(201);
        }
        try {
            return z(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, gcVar.z(), gcVar.dl(), z.GZIP, "application/json; charset=utf-8", gcVar.g());
        } catch (Throwable th) {
            uy.g(th);
            return new m(207, th);
        }
    }

    public static m z(String str, String str2, boolean z2) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                return z(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, str, str2.getBytes(), z.GZIP, "application/json; charset=utf-8", z2);
            }
            return new m(201);
        } catch (Throwable th) {
            uy.g(th);
            return new m(207, th);
        }
    }

    private static byte[] z(InputStream inputStream) throws IOException {
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
                    com.bytedance.z.g.gz.m.z(byteArrayOutputStream);
                }
            }
        }
    }

    public enum z {
        NONE(0),
        GZIP(1),
        DEFLATER(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f1511a;

        z(int i) {
            this.f1511a = i;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.z.g.e.g$g, reason: collision with other inner class name */
    public enum EnumC0229g {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);

        final int e;

        EnumC0229g(int i) {
            this.e = i;
        }
    }
}
