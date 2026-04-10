package com.bytedance.sdk.component.ga.d.e.e;

import android.util.Log;
import com.bytedance.sdk.component.ga.d.e.e.e;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class bf implements com.bytedance.sdk.component.ga.d {
    private e bf;
    private long e;

    public bf(File file, long j, ExecutorService executorService) {
        this.e = j;
        try {
            this.bf = e.e(file, 20210302, 1, j, executorService);
        } catch (IOException e) {
            Log.w("LruCountDiskCache", e.toString());
        }
    }

    @Override // com.bytedance.sdk.component.ga.e
    /* JADX INFO: renamed from: bf, reason: merged with bridge method [inline-methods] */
    public byte[] e(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStreamE;
        e eVar = this.bf;
        InputStream inputStream = null;
        if (eVar == null || str == null) {
            return null;
        }
        try {
            e.d dVarE = eVar.e(str);
            if (dVarE == null) {
                com.bytedance.sdk.component.ga.d.d.bf.e(null);
                com.bytedance.sdk.component.ga.d.d.bf.e(null);
                return null;
            }
            inputStreamE = dVarE.e(0);
            if (inputStreamE != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (IOException e) {
                    e = e;
                    byteArrayOutputStream = null;
                    Log.w("LruCountDiskCache", e.toString());
                    com.bytedance.sdk.component.ga.d.d.bf.e(inputStreamE);
                    com.bytedance.sdk.component.ga.d.d.bf.e(byteArrayOutputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = null;
                    inputStream = inputStreamE;
                    com.bytedance.sdk.component.ga.d.d.bf.e(inputStream);
                    com.bytedance.sdk.component.ga.d.d.bf.e(byteArrayOutputStream);
                    throw th;
                }
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStreamE.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStreamE;
                        com.bytedance.sdk.component.ga.d.d.bf.e(inputStream);
                        com.bytedance.sdk.component.ga.d.d.bf.e(byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    Log.w("LruCountDiskCache", e.toString());
                    com.bytedance.sdk.component.ga.d.d.bf.e(inputStreamE);
                    com.bytedance.sdk.component.ga.d.d.bf.e(byteArrayOutputStream);
                    return null;
                }
            } else {
                byteArrayOutputStream = null;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            com.bytedance.sdk.component.ga.d.d.bf.e(inputStreamE);
            com.bytedance.sdk.component.ga.d.d.bf.e(byteArrayOutputStream);
            return byteArray;
        } catch (IOException e3) {
            e = e3;
            inputStreamE = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            com.bytedance.sdk.component.ga.d.d.bf.e(inputStream);
            com.bytedance.sdk.component.ga.d.d.bf.e(byteArrayOutputStream);
            throw th;
        }
        Log.w("LruCountDiskCache", e.toString());
        com.bytedance.sdk.component.ga.d.d.bf.e(inputStreamE);
        com.bytedance.sdk.component.ga.d.d.bf.e(byteArrayOutputStream);
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.ga.d
    public InputStream e(String str) {
        e eVar = this.bf;
        if (eVar == null) {
            return null;
        }
        try {
            e.d dVarE = eVar.e(str);
            if (dVarE != null) {
                return dVarE.e(0);
            }
        } catch (IOException e) {
            Log.w("LruCountDiskCache", e.getMessage());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.ga.e
    public boolean e(String str, byte[] bArr) throws Throwable {
        Closeable closeable;
        e eVar = this.bf;
        if (eVar == null || bArr == null || str == null) {
            return false;
        }
        Closeable closeable2 = null;
        e.C0100e c0100e = null;
        try {
            try {
                e.C0100e c0100eBf = eVar.bf(str);
                try {
                    if (c0100eBf == null) {
                        Log.w("LruCountDiskCache", "save " + str + " failed for edit null");
                        com.bytedance.sdk.component.ga.d.d.bf.e(null);
                        return false;
                    }
                    OutputStream outputStreamE = c0100eBf.e(0);
                    if (outputStreamE == e.d) {
                        Log.w("LruCountDiskCache", "save " + str + " failed for null OutputStream");
                        com.bytedance.sdk.component.ga.d.d.bf.e(outputStreamE);
                        return false;
                    }
                    outputStreamE.write(bArr);
                    c0100eBf.e();
                    this.bf.e();
                    com.bytedance.sdk.component.ga.d.d.bf.e(outputStreamE);
                    return true;
                } catch (IOException e) {
                    e = e;
                    closeable = null;
                    c0100e = c0100eBf;
                    try {
                        Log.w("LruCountDiskCache", e.toString());
                        if (c0100e != null) {
                            try {
                                c0100e.bf();
                            } catch (IOException unused) {
                            }
                        }
                        com.bytedance.sdk.component.ga.d.d.bf.e(closeable);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        closeable2 = closeable;
                        com.bytedance.sdk.component.ga.d.d.bf.e(closeable2);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.bytedance.sdk.component.ga.d.d.bf.e(closeable2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            closeable = null;
        }
    }
}
