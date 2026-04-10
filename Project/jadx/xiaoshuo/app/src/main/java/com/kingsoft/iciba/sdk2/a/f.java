package com.kingsoft.iciba.sdk2.a;

import android.util.Log;
import com.iflytek.aikit.utils.DataUtil;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes7.dex */
public class f extends c {
    private static final String g = "f";
    private File ak;
    private ZipFile al;

    public f(String str) {
        super(str.substring(0, str.length() - 4) + File.separator);
        this.ak = new File(str);
        init();
    }

    private void init() {
        a(false);
        if (!this.ak.exists()) {
            a(false);
            return;
        }
        try {
            this.al = new ZipFile(this.ak);
            byte[] bArrR = r(j());
            byte[] bArrR2 = r(k());
            String strS = s(l());
            if (bArrR == null || bArrR2 == null || strS == null) {
                a(false);
                if (this.ak.exists()) {
                    this.ak.delete();
                    return;
                }
                return;
            }
            o(com.kingsoft.iciba.sdk2.d.a(bArrR, bArrR.length, 0, 2));
            this.V = new int[bArrR2.length / 4];
            for (int i = 0; i < bArrR2.length / 4; i++) {
                this.V[i] = com.kingsoft.iciba.sdk2.d.a(bArrR2, i << 2, 4);
            }
            this.U = strS.split(",");
            a(true);
            String strS2 = s(t());
            if (strS2 != null) {
                c(true);
                c(true);
                this.ad = strS2.split(",");
                byte[] bArrR3 = r(s());
                if (bArrR3 != null) {
                    c(true);
                    this.ae = new int[bArrR3.length / 4];
                    for (int i2 = 0; i2 < bArrR3.length / 4; i2++) {
                        this.ae[i2] = com.kingsoft.iciba.sdk2.d.a(bArrR3, i2 << 2, 4);
                    }
                    return;
                }
            }
            c(false);
        } catch (Exception unused) {
            this.ak.delete();
            a(false);
            Log.e(g, "Create zipFile failed");
        }
    }

    private byte[] r(String str) {
        try {
            ZipEntry entry = this.al.getEntry(str.substring(i().length()));
            if (entry != null) {
                try {
                    InputStream inputStream = this.al.getInputStream(entry);
                    try {
                        bArrSaveAsBytes = entry.getSize() > 0 ? StreamUtils.saveAsBytes(inputStream) : null;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } finally {
                    }
                } catch (Exception e) {
                    Log.e(g, "Read file failed", e);
                }
            }
        } catch (Exception e2) {
            Log.e(g, "Read bytes failed", e2);
        }
        return bArrSaveAsBytes;
    }

    private String s(String str) {
        try {
            ZipEntry entry = this.al.getEntry(str.substring(i().length()));
            if (entry != null) {
                try {
                    InputStream inputStream = this.al.getInputStream(entry);
                    try {
                        str = entry.getSize() > 0 ? new String(StreamUtils.saveAsBytes(inputStream), DataUtil.UNICODE) : null;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } finally {
                    }
                } catch (Exception e) {
                    Log.e(g, "Read file failed", e);
                }
            }
        } catch (Exception e2) {
            Log.e(g, "Read bytes failed", e2);
        }
        return str;
    }

    private char[] t(String str) {
        try {
            ZipEntry entry = this.al.getEntry(str.substring(i().length()));
            if (entry != null) {
                try {
                    InputStream inputStream = this.al.getInputStream(entry);
                    try {
                        charArray = entry.getSize() > 0 ? new String(StreamUtils.saveAsBytes(inputStream), DataUtil.UNICODE).toCharArray() : null;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } finally {
                    }
                } catch (Exception e) {
                    Log.e(g, "Read file failed", e);
                }
            }
        } catch (Exception e2) {
            Log.e(g, "Read chars failed", e2);
        }
        return charArray;
    }

    @Override // com.kingsoft.iciba.sdk2.a.c
    public final int a(int i) {
        if (i < 0) {
            b(false);
            return -1;
        }
        byte[] bArrR = r(n());
        if (bArrR == null) {
            b(false);
            return -1;
        }
        this.X = new Integer[bArrR.length / 2];
        int i2 = 0;
        while (true) {
            Integer[] numArr = this.X;
            if (i2 >= numArr.length) {
                break;
            }
            numArr[i2] = com.kingsoft.iciba.sdk2.d.b(bArrR, i2 << 1, 2);
            i2++;
        }
        char[] cArrT = t(m());
        this.Y = cArrT;
        if (cArrT == null) {
            b(false);
            return -1;
        }
        String strS = s(p());
        if (strS == null) {
            b(false);
            return -1;
        }
        this.W = strS.split(",");
        b(true);
        return 0;
    }

    @Override // com.kingsoft.iciba.sdk2.a.c
    public final int b(int i) {
        if (i < 0) {
            b(false);
            return -1;
        }
        byte[] bArrR = r(q());
        if (bArrR == null) {
            b(false);
            return -1;
        }
        this.X = new Integer[bArrR.length / 2];
        int i2 = 0;
        while (true) {
            Integer[] numArr = this.X;
            if (i2 >= numArr.length) {
                break;
            }
            numArr[i2] = com.kingsoft.iciba.sdk2.d.b(bArrR, i2 << 1, 2);
            i2++;
        }
        char[] cArrT = t(o());
        this.Y = cArrT;
        if (cArrT == null) {
            b(false);
            return -1;
        }
        String strS = s(r());
        if (strS == null) {
            b(false);
            return -1;
        }
        this.W = strS.split(",");
        b(true);
        return 0;
    }
}
