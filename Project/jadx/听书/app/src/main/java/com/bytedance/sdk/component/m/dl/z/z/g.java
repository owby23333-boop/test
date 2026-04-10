package com.bytedance.sdk.component.m.dl.z.z;

import com.bytedance.sdk.component.m.dl.z.z.z;
import com.bytedance.sdk.component.utils.wp;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class g implements com.bytedance.sdk.component.m.a {
    private z g;
    private long z;

    public g(File file, long j, ExecutorService executorService) {
        this.z = j;
        try {
            this.g = z.z(file, 20210302, 1, j, executorService);
        } catch (IOException e) {
            wp.g("LruCountDiskCache", e.toString());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.m.a
    public InputStream z(String str) {
        z zVar = this.g;
        if (zVar == null) {
            return null;
        }
        try {
            z.dl dlVarZ = zVar.z(str);
            if (dlVarZ != null) {
                return dlVarZ.z(0);
            }
        } catch (IOException e) {
            wp.g("LruCountDiskCache", e.getMessage());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.m.z
    public boolean z(String str, byte[] bArr) throws Throwable {
        Closeable closeable;
        z zVar = this.g;
        if (zVar == null || bArr == null || str == null) {
            return false;
        }
        Closeable closeable2 = null;
        z.C0139z c0139z = null;
        try {
            try {
                z.C0139z c0139zG = zVar.g(str);
                try {
                    if (c0139zG == null) {
                        wp.g("LruCountDiskCache", "save " + str + " failed for edit null");
                        com.bytedance.sdk.component.m.dl.dl.g.z(null);
                        return false;
                    }
                    OutputStream outputStreamZ = c0139zG.z(0);
                    if (outputStreamZ == z.dl) {
                        wp.g("LruCountDiskCache", "save " + str + " failed for null OutputStream");
                        com.bytedance.sdk.component.m.dl.dl.g.z(outputStreamZ);
                        return false;
                    }
                    outputStreamZ.write(bArr);
                    c0139zG.z();
                    this.g.z();
                    com.bytedance.sdk.component.m.dl.dl.g.z(outputStreamZ);
                    return true;
                } catch (IOException e) {
                    e = e;
                    closeable = null;
                    c0139z = c0139zG;
                    try {
                        wp.g("LruCountDiskCache", e.toString());
                        if (c0139z != null) {
                            try {
                                c0139z.g();
                            } catch (IOException unused) {
                            }
                        }
                        com.bytedance.sdk.component.m.dl.dl.g.z(closeable);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        closeable2 = closeable;
                        com.bytedance.sdk.component.m.dl.dl.g.z(closeable2);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.bytedance.sdk.component.m.dl.dl.g.z(closeable2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            closeable = null;
        }
    }

    @Override // com.bytedance.sdk.component.m.z
    /* JADX INFO: renamed from: g, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] z(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStreamZ;
        z zVar = this.g;
        InputStream inputStream = null;
        if (zVar == null || str == null) {
            return null;
        }
        try {
            z.dl dlVarZ = zVar.z(str);
            if (dlVarZ == null) {
                com.bytedance.sdk.component.m.dl.dl.g.z(null);
                com.bytedance.sdk.component.m.dl.dl.g.z(null);
                return null;
            }
            inputStreamZ = dlVarZ.z(0);
            if (inputStreamZ != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (IOException e) {
                    e = e;
                    byteArrayOutputStream = null;
                    wp.g("LruCountDiskCache", e.toString());
                    com.bytedance.sdk.component.m.dl.dl.g.z(inputStreamZ);
                    com.bytedance.sdk.component.m.dl.dl.g.z(byteArrayOutputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = null;
                    inputStream = inputStreamZ;
                    com.bytedance.sdk.component.m.dl.dl.g.z(inputStream);
                    com.bytedance.sdk.component.m.dl.dl.g.z(byteArrayOutputStream);
                    throw th;
                }
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStreamZ.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStreamZ;
                        com.bytedance.sdk.component.m.dl.dl.g.z(inputStream);
                        com.bytedance.sdk.component.m.dl.dl.g.z(byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    wp.g("LruCountDiskCache", e.toString());
                    com.bytedance.sdk.component.m.dl.dl.g.z(inputStreamZ);
                    com.bytedance.sdk.component.m.dl.dl.g.z(byteArrayOutputStream);
                    return null;
                }
            } else {
                byteArrayOutputStream = null;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            com.bytedance.sdk.component.m.dl.dl.g.z(inputStreamZ);
            com.bytedance.sdk.component.m.dl.dl.g.z(byteArrayOutputStream);
            return byteArray;
        } catch (IOException e3) {
            e = e3;
            inputStreamZ = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            com.bytedance.sdk.component.m.dl.dl.g.z(inputStream);
            com.bytedance.sdk.component.m.dl.dl.g.z(byteArrayOutputStream);
            throw th;
        }
        wp.g("LruCountDiskCache", e.toString());
        com.bytedance.sdk.component.m.dl.dl.g.z(inputStreamZ);
        com.bytedance.sdk.component.m.dl.dl.g.z(byteArrayOutputStream);
        return null;
    }

    @Override // com.bytedance.sdk.component.m.z
    /* JADX INFO: renamed from: dl, reason: merged with bridge method [inline-methods] */
    public boolean g(String str) {
        try {
            try {
                z.dl dlVarZ = this.g.z(str);
                boolean z = dlVarZ != null;
                com.bytedance.sdk.component.m.dl.dl.g.z(dlVarZ);
                return z;
            } catch (IOException e) {
                wp.g("LruCountDiskCache", e.getMessage());
                com.bytedance.sdk.component.m.dl.dl.g.z(null);
                return false;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.m.dl.dl.g.z(null);
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.m.z
    public void z(double d) {
        this.g.z((long) (this.z * d));
    }
}
