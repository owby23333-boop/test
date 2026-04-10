package com.yuewen;

import com.xiaomi.verificationsdk.internal.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes3.dex */
public class r50 implements e41 {
    public static final String h = "GBK";
    public static final String i = "UTF-16LE";
    public static final String j = "UTF-16BE";
    public static final String k = "UTF-8";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RandomAccessFile f16948a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16949b = 0;
    public y20 c = null;
    public int d = 4096;
    public byte[] e = null;
    public byte[] f = null;
    public String g = null;

    @Override // com.yuewen.e41
    public boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return str.equals("GBK") || str.equals("UTF-16LE") || str.equals("UTF-16BE") || str.equals("UTF-8");
    }

    @Override // com.yuewen.e41
    public boolean b() {
        return "UTF-16LE".equals(this.g);
    }

    @Override // com.yuewen.e41
    public int c() {
        return "UTF-8".equals(this.g) ? 5 : 2;
    }

    @Override // com.yuewen.e41
    public boolean d() {
        return "UTF-16BE".equals(this.g);
    }

    @Override // com.yuewen.e41
    public String e(File file) throws IOException {
        this.f16948a = new RandomAccessFile(file, Constants.RANDOM_LONG);
        String strH = h();
        if (strH.length() != 0) {
            this.f16948a.close();
            this.g = strH;
            return strH;
        }
        this.f16949b = 0;
        String strG = g();
        this.f16948a.close();
        this.g = strG;
        return strG;
    }

    @Override // com.yuewen.e41
    public int f() {
        return this.f16949b;
    }

    public final String g() {
        if (this.c == null) {
            this.c = new y20();
        }
        if (this.e == null) {
            this.e = new byte[this.d];
        }
        try {
            int i2 = this.f16948a.read(this.e);
            if (i2 <= 0) {
                return "GBK";
            }
            byte[] bArr = this.e;
            if (i2 < bArr.length) {
                byte[] bArr2 = new byte[i2];
                this.f = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, i2);
            } else {
                this.f = bArr;
            }
            y20 y20Var = this.c;
            return y20Var.b(y20Var.i(this.f));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public final String h() throws IOException {
        byte[] bArr = new byte[2];
        int i2 = this.f16948a.read(bArr, 0, 2);
        if (i2 == 0) {
            this.f16949b = 0;
            return "GBK";
        }
        if (i2 != 2) {
            return "";
        }
        byte b2 = bArr[0];
        if (b2 == -1 && bArr[1] == -2) {
            this.f16949b = 2;
            return "UTF-16LE";
        }
        if (b2 == -2 && bArr[1] == -1) {
            this.f16949b = 2;
            return "UTF-16BE";
        }
        if (b2 == -17 && bArr[1] == -69) {
            byte[] bArr2 = new byte[1];
            if (this.f16948a.read(bArr2, 0, 1) == 1 && bArr2[0] == -65) {
                this.f16949b = 3;
                return "UTF-8";
            }
        }
        return "";
    }
}
