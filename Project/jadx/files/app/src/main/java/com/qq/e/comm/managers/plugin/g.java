package com.qq.e.comm.managers.plugin;

import android.text.TextUtils;
import com.qq.e.comm.managers.plugin.c;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes3.dex */
class g {
    private final File a;
    private final File b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f17823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f17824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f17825e;

    public g(File file, File file2) {
        this.a = file;
        this.b = file2;
    }

    private String a(File file) throws Throwable {
        BufferedReader bufferedReader = null;
        if (file != null) {
            try {
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String line = bufferedReader2.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                            }
                            String string = sb.toString();
                            try {
                                bufferedReader2.close();
                            } catch (Exception unused) {
                                GDTLogger.d("Exception while close bufferreader");
                            }
                            return string;
                        } catch (IOException e2) {
                            bufferedReader = bufferedReader2;
                            throw e2;
                        } catch (Throwable th) {
                            bufferedReader = bufferedReader2;
                            th = th;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                    GDTLogger.d("Exception while close bufferreader");
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e3) {
                        throw e3;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    boolean a() {
        int i2;
        try {
            if (this.b.exists() && this.a.exists()) {
                String strA = a(this.b);
                this.f17825e = strA;
                if (TextUtils.isEmpty(strA)) {
                    return false;
                }
                String[] strArrSplit = this.f17825e.split("#####");
                if (strArrSplit.length == 2) {
                    String str = strArrSplit[1];
                    try {
                        i2 = Integer.parseInt(strArrSplit[0]);
                    } catch (Throwable unused) {
                        i2 = 0;
                    }
                    if (c.b.a.a(str, this.a)) {
                        this.f17823c = str;
                        this.f17824d = i2;
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable unused2) {
            GDTLogger.d("Exception while checking plugin");
            return false;
        }
    }

    boolean a(File file, File file2) {
        return (file.equals(this.a) || h.a(this.a, file)) && (file2.equals(this.b) || h.a(this.b, file2));
    }

    String b() {
        return this.f17823c;
    }

    int c() {
        return this.f17824d;
    }

    public String d() {
        return this.f17825e;
    }
}
