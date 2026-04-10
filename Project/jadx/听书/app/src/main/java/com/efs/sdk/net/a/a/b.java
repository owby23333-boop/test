package com.efs.sdk.net.a.a;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.net.a.a.f;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<String, Long> f1606a = new HashMap();

    static long a(f.a aVar) {
        try {
            if (aVar.d() != null) {
                return r2.length;
            }
            return 0L;
        } catch (IOException | OutOfMemoryError e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static InputStream a(String str, String str2, String str3, InputStream inputStream) {
        Log.i("NetTrace-Interceptor", "save interpret response stream");
        com.efs.sdk.net.a.b bVarA = com.efs.sdk.net.a.a.a().a(str);
        bVarA.h = str2;
        if (str2 != null) {
            if (str2.contains("text") || str2.contains("json")) {
                ByteArrayOutputStream byteArrayOutputStreamA = a(inputStream, bVarA, str3);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStreamA.toByteArray());
                try {
                    byteArrayOutputStreamA.close();
                } catch (IOException e) {
                    Log.e("NetTrace-Interceptor", "save interpret response stream, e is ".concat(String.valueOf(e)));
                }
                return byteArrayInputStream;
            }
        }
        bVarA.i = 0L;
        return inputStream;
    }

    private static ByteArrayOutputStream a(InputStream inputStream, com.efs.sdk.net.a.b bVar, String str) {
        BufferedReader bufferedReader;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            } catch (IOException e) {
                Log.e("NetTrace-Interceptor", "parse and save body, e is ".concat(String.valueOf(e)));
            }
            return byteArrayOutputStream;
        }
        byteArrayOutputStream.flush();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        if (Constants.CP_GZIP.equals(str)) {
            bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(byteArrayInputStream)));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream));
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line + '\n');
            return byteArrayOutputStream;
        }
        bVar.i = sb.toString().getBytes().length;
        return byteArrayOutputStream;
    }
}
