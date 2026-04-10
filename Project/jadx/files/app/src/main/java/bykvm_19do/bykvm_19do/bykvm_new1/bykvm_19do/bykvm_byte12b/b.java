package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.f;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i;
import com.bytedance.mapplog.util.TTEncryptUtils;
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

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static boolean a;
    private static c b;

    public enum a {
        NONE(0),
        GZIP(1),
        DEFLATER(2);

        a(int i2) {
        }
    }

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b$b, reason: collision with other inner class name */
    public enum EnumC0061b {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);

        EnumC0061b(int i2) {
        }
    }

    public static e a(long j2, String str, byte[] bArr, a aVar, String str2, boolean z2) throws IOException {
        String str3;
        String str4;
        byte[] bArr2;
        String str5;
        StringBuilder sb;
        if (str == null) {
            return new e(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        String str6 = null;
        if (a.GZIP == aVar && length > 128) {
            bArr = c(bArr);
            str6 = "gzip";
        } else if (a.DEFLATER == aVar && length > 128) {
            bArr = b(bArr);
            str6 = "deflate";
        }
        byte[] bArr3 = bArr;
        String str7 = str6;
        if (bArr3 == null) {
            return new e(202);
        }
        if (!z2) {
            return a(str, bArr3, str2, str7, "POST", true, false);
        }
        byte[] bArrA = TTEncryptUtils.a(bArr3, bArr3.length);
        if (bArrA == null) {
            str3 = str;
            str4 = str2;
            bArr2 = bArr3;
        } else if (TextUtils.isEmpty(new URL(str).getQuery())) {
            str5 = "?";
            if (!str.endsWith("?")) {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(str5);
                str = sb.toString();
            }
            bArr2 = bArrA;
            str3 = str + "tt_data=a";
            str4 = "application/octet-stream;tt-data=a";
        } else {
            str5 = DispatchConstants.SIGN_SPLIT_SYMBOL;
            if (!str.endsWith(DispatchConstants.SIGN_SPLIT_SYMBOL)) {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(str5);
                str = sb.toString();
            }
            bArr2 = bArrA;
            str3 = str + "tt_data=a";
            str4 = "application/octet-stream;tt-data=a";
        }
        return a(str3, bArr2, str4, str7, "POST", true, true);
    }

    public static e a(String str, String str2) {
        return a(str, str2, a());
    }

    public static e a(String str, String str2, boolean z2) {
        try {
            return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) ? new e(201) : a(2097152L, str, str2.getBytes(), a.GZIP, "application/json; charset=utf-8", z2);
        } catch (Throwable th) {
            j.b(th);
            return new e(207, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0055 A[Catch: all -> 0x004f, TryCatch #11 {all -> 0x004f, blocks: (B:12:0x002b, B:14:0x0031, B:15:0x0035, B:17:0x003b, B:19:0x0043, B:23:0x0055, B:26:0x0060, B:28:0x0067, B:29:0x006c, B:31:0x0073, B:33:0x0078, B:37:0x008a, B:42:0x0092, B:43:0x0095, B:44:0x0096, B:46:0x009e, B:65:0x00d7, B:69:0x00f9, B:70:0x0100, B:24:0x005a), top: B:109:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a A[Catch: all -> 0x004f, TryCatch #11 {all -> 0x004f, blocks: (B:12:0x002b, B:14:0x0031, B:15:0x0035, B:17:0x003b, B:19:0x0043, B:23:0x0055, B:26:0x0060, B:28:0x0067, B:29:0x006c, B:31:0x0073, B:33:0x0078, B:37:0x008a, B:42:0x0092, B:43:0x0095, B:44:0x0096, B:46:0x009e, B:65:0x00d7, B:69:0x00f9, B:70:0x0100, B:24:0x005a), top: B:109:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060 A[Catch: all -> 0x004f, TryCatch #11 {all -> 0x004f, blocks: (B:12:0x002b, B:14:0x0031, B:15:0x0035, B:17:0x003b, B:19:0x0043, B:23:0x0055, B:26:0x0060, B:28:0x0067, B:29:0x006c, B:31:0x0073, B:33:0x0078, B:37:0x008a, B:42:0x0092, B:43:0x0095, B:44:0x0096, B:46:0x009e, B:65:0x00d7, B:69:0x00f9, B:70:0x0100, B:24:0x005a), top: B:109:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067 A[Catch: all -> 0x004f, TryCatch #11 {all -> 0x004f, blocks: (B:12:0x002b, B:14:0x0031, B:15:0x0035, B:17:0x003b, B:19:0x0043, B:23:0x0055, B:26:0x0060, B:28:0x0067, B:29:0x006c, B:31:0x0073, B:33:0x0078, B:37:0x008a, B:42:0x0092, B:43:0x0095, B:44:0x0096, B:46:0x009e, B:65:0x00d7, B:69:0x00f9, B:70:0x0100, B:24:0x005a), top: B:109:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0073 A[Catch: all -> 0x004f, TryCatch #11 {all -> 0x004f, blocks: (B:12:0x002b, B:14:0x0031, B:15:0x0035, B:17:0x003b, B:19:0x0043, B:23:0x0055, B:26:0x0060, B:28:0x0067, B:29:0x006c, B:31:0x0073, B:33:0x0078, B:37:0x008a, B:42:0x0092, B:43:0x0095, B:44:0x0096, B:46:0x009e, B:65:0x00d7, B:69:0x00f9, B:70:0x0100, B:24:0x005a), top: B:109:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f9 A[Catch: all -> 0x004f, TRY_ENTER, TryCatch #11 {all -> 0x004f, blocks: (B:12:0x002b, B:14:0x0031, B:15:0x0035, B:17:0x003b, B:19:0x0043, B:23:0x0055, B:26:0x0060, B:28:0x0067, B:29:0x006c, B:31:0x0073, B:33:0x0078, B:37:0x008a, B:42:0x0092, B:43:0x0095, B:44:0x0096, B:46:0x009e, B:65:0x00d7, B:69:0x00f9, B:70:0x0100, B:24:0x005a), top: B:109:0x002b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.e a(java.lang.String r4, byte[] r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b.a(java.lang.String, byte[], java.lang.String, java.lang.String, java.lang.String, boolean, boolean):bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.e");
    }

    private static e a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new e(203);
        }
        String str = new String(bArr, Charset.forName(com.anythink.expressad.foundation.g.a.bN));
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.length() > 0 ? new e(0, jSONObject) : new e(204, str);
        } catch (JSONException unused) {
            return new e(204, str);
        }
    }

    public static String a(Map map) {
        return i.f().a();
    }

    public static boolean a() {
        return true;
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (-1 == i2) {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    f.a(byteArrayOutputStream);
                }
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    public static boolean b() {
        return true;
    }

    private static byte[] b(byte[] bArr) {
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

    private static byte[] c(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                j.b(th);
                gZIPOutputStream.close();
                return null;
            } catch (Throwable th2) {
                gZIPOutputStream.close();
                throw th2;
            }
        }
    }
}
