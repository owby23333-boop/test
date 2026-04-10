package com.bytedance.sdk.openadsdk.ats.z;

import android.text.TextUtils;
import com.bytedance.sdk.component.a.kb;
import com.bytedance.sdk.component.utils.wp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
public class z implements kb {
    @Override // com.bytedance.sdk.component.a.kb
    public void set(String str, String str2) {
    }

    @Override // com.bytedance.sdk.component.a.kb
    public String get(String str) {
        return z(str);
    }

    @Override // com.bytedance.sdk.component.a.kb
    public int getInt(String str) {
        String strZ = z(str);
        if (TextUtils.isEmpty(strZ)) {
            return 0;
        }
        try {
            return Integer.parseInt(strZ);
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.component.a.kb
    public long getLong(String str) {
        String strZ = z(str);
        if (TextUtils.isEmpty(strZ)) {
            return 0L;
        }
        try {
            return Long.parseLong(strZ);
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.a.kb
    public boolean getBoolean(String str) {
        String strZ = z(str);
        if (TextUtils.isEmpty(strZ)) {
            return false;
        }
        try {
            return Boolean.parseBoolean(strZ);
        } catch (Exception unused) {
            return false;
        }
    }

    private String z(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        Process processExec;
        try {
            processExec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
            }
            try {
                String line = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    wp.dl("SystemPropAdb", "Exception while closing InputStream", e);
                }
                if (processExec != null) {
                    try {
                        processExec.destroy();
                    } catch (Throwable unused) {
                    }
                }
                return line;
            } catch (Throwable th3) {
                th = th3;
                try {
                    wp.dl("SystemPropAdb", "Unable to read sysprop ".concat(String.valueOf(str)), th);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            wp.dl("SystemPropAdb", "Exception while closing InputStream", e2);
                        }
                    }
                    if (processExec == null) {
                        return "";
                    }
                    try {
                        processExec.destroy();
                        return "";
                    } catch (Throwable unused2) {
                        return "";
                    }
                } finally {
                }
            }
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            processExec = null;
        }
    }
}
