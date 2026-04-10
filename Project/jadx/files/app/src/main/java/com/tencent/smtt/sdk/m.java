package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: loaded from: classes3.dex */
class m {
    private static m a;
    private static Context b;

    private m() {
    }

    static m a(Context context) {
        if (a == null) {
            synchronized (m.class) {
                if (a == null) {
                    a = new m();
                }
            }
        }
        b = context.getApplicationContext();
        return a;
    }

    private Properties e() throws Throwable {
        Properties properties;
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                File fileA = a();
                properties = new Properties();
                if (fileA != null) {
                    try {
                        fileInputStream = new FileInputStream(fileA);
                        try {
                            try {
                                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream);
                                try {
                                    properties.load(bufferedInputStream2);
                                    bufferedInputStream = bufferedInputStream2;
                                } catch (Exception e2) {
                                    e = e2;
                                    bufferedInputStream = bufferedInputStream2;
                                    e.printStackTrace();
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    return properties;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedInputStream = bufferedInputStream2;
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    if (fileInputStream == null) {
                                        throw th;
                                    }
                                    try {
                                        fileInputStream.close();
                                        throw th;
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Exception e7) {
                            e = e7;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        fileInputStream = null;
                    }
                } else {
                    fileInputStream = null;
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                return properties;
            } catch (Exception e11) {
                e = e11;
                properties = null;
                fileInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    File a() {
        o.a();
        File file = new File(o.r(b), "tbscoreinstall.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return file;
    }

    void a(int i2) {
        a("dexopt_retry_num", i2);
    }

    void a(int i2, int i3) {
        a("copy_core_ver", i2);
        a("copy_status", i3);
    }

    void a(String str) {
        a("install_apk_path", str);
    }

    void a(String str, int i2) {
        a(str, String.valueOf(i2));
    }

    void a(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    Properties propertiesE = e();
                    if (propertiesE != null) {
                        propertiesE.setProperty(str, str2);
                        File fileA = a();
                        if (fileA != null) {
                            fileOutputStream = new FileOutputStream(fileA);
                            try {
                                propertiesE.store(fileOutputStream, "update " + str + " and status!");
                                fileOutputStream2 = fileOutputStream;
                            } catch (Exception e2) {
                                e = e2;
                                fileOutputStream2 = fileOutputStream;
                                e.printStackTrace();
                                if (fileOutputStream2 == null) {
                                    return;
                                } else {
                                    fileOutputStream2.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    int b() {
        return c("install_core_ver");
    }

    int b(String str) throws Throwable {
        Properties propertiesE = e();
        if (propertiesE != null && propertiesE.getProperty(str) != null) {
            try {
                return Integer.parseInt(propertiesE.getProperty(str));
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    void b(int i2) {
        a("unzip_retry_num", i2);
    }

    void b(int i2, int i3) {
        a("tpatch_ver", i2);
        a("tpatch_status", i3);
    }

    int c() {
        return b("install_status");
    }

    int c(String str) throws Throwable {
        Properties propertiesE = e();
        if (propertiesE != null && propertiesE.getProperty(str) != null) {
            try {
                return Integer.parseInt(propertiesE.getProperty(str));
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    void c(int i2) {
        a("incrupdate_status", i2);
    }

    void c(int i2, int i3) {
        a("install_core_ver", i2);
        a("install_status", i3);
    }

    int d() {
        return b("incrupdate_status");
    }

    String d(String str) throws Throwable {
        Properties propertiesE = e();
        if (propertiesE == null || propertiesE.getProperty(str) == null) {
            return null;
        }
        return propertiesE.getProperty(str);
    }

    void d(int i2) {
        a("unlzma_status", i2);
    }
}
