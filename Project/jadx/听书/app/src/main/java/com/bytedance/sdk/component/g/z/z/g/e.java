package com.bytedance.sdk.component.g.z.z.g;

import com.bytedance.sdk.component.g.z.p;
import com.bytedance.sdk.component.g.z.uy;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes2.dex */
public class e extends p {
    InputStream g;
    HttpURLConnection z;

    e(HttpURLConnection httpURLConnection) throws IOException {
        this.z = httpURLConnection;
        this.g = new gc(httpURLConnection.getInputStream(), httpURLConnection);
    }

    @Override // com.bytedance.sdk.component.g.z.p
    public long z() {
        try {
            return this.z.getContentLength();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.g.z.p
    public String g() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.g));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    stringBuffer.append(line + "\n");
                } else {
                    String string = stringBuffer.toString();
                    close();
                    return string;
                }
            }
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.g.z.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.g.close();
            this.z.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.g.z.p
    public InputStream dl() {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.g.z.p
    public byte[] a() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (true) {
                try {
                    int i = this.g.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream2.write(bArr, 0, i);
                } catch (Exception unused) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return new byte[0];
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th;
                }
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (Throwable unused4) {
            }
            return byteArray;
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.bytedance.sdk.component.g.z.p
    public uy gc() {
        if (this.z.getContentType() != null) {
            return uy.z(this.z.getContentType());
        }
        return null;
    }
}
