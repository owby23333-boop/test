package com.bytedance.sdk.component.bf.e.e.bf;

import com.bytedance.sdk.component.bf.e.w;
import com.xiaomi.ad.common.util.SignatureUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
public class p extends w {
    InputStream bf;
    HttpURLConnection e;

    public p(HttpURLConnection httpURLConnection) throws IOException {
        this.e = httpURLConnection;
        this.bf = new ga(httpURLConnection.getInputStream(), httpURLConnection);
    }

    @Override // com.bytedance.sdk.component.bf.e.w
    public String bf() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.bf));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    String string = stringBuffer.toString();
                    close();
                    return string;
                }
                stringBuffer.append(line + SignatureUtils.DELIMITER);
            }
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.bf.e.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.bf.close();
            this.e.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.bf.e.w
    public InputStream d() {
        return this.bf;
    }

    @Override // com.bytedance.sdk.component.bf.e.w
    public long e() {
        try {
            return this.e.getContentLength();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.bf.e.w
    public byte[] tg() {
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i = this.bf.read(bArr);
                if (i == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
