package com.anythink.core.common.res;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.k.j;
import com.anythink.core.common.res.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static final String a = "about:blank";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f7915d = "anythink_internal_resouce";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f7916e = "anythink_custom_resouce";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f7917f = "anythink_internal_extra_resource";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f7918g = "anythink_internal_video_resource";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f7919h = "anythink_internal_html_resouce";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile d f7920i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f7922j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private File f7923k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f7921c = d.class.getSimpleName();
    ConcurrentHashMap<Integer, a> b = new ConcurrentHashMap<>();

    private d(Context context) {
        this.f7922j = context.getApplicationContext();
        this.f7923k = j.a(this.f7922j);
    }

    public static d a(Context context) {
        if (f7920i == null) {
            synchronized (d.class) {
                if (f7920i == null) {
                    f7920i = new d(context);
                }
            }
        }
        return f7920i;
    }

    public final void b() {
        File[] fileArrListFiles;
        try {
            File file = new File(this.f7923k, f7919h);
            if (!file.exists() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                try {
                    if (file2.isFile() && System.currentTimeMillis() - file2.lastModified() > 86400000) {
                        file2.delete();
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public final String a() {
        return this.f7923k.getAbsolutePath();
    }

    public final String a(String str, com.anythink.core.common.e.j jVar, i iVar) {
        byte[] bytes;
        FileOutputStream fileOutputStream;
        File file = new File(this.f7923k, f7919h);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, jVar.f7303d + "_" + iVar.p() + ".html");
        FileOutputStream fileOutputStream2 = null;
        try {
            bytes = str.getBytes(com.anythink.expressad.foundation.g.a.bN);
            fileOutputStream = new FileOutputStream(file2);
        } catch (Throwable unused) {
        }
        try {
            fileOutputStream.write(bytes, 0, bytes.length);
            String string = file2.toURL().toString();
            try {
                fileOutputStream.close();
                return string;
            } catch (Throwable unused2) {
                return string;
            }
        } catch (Throwable unused3) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Throwable unused4) {
                }
            }
            return "";
        }
    }

    public final File b(com.anythink.core.common.e.j jVar, i iVar) {
        File file = new File(new File(this.f7923k, f7919h), jVar.f7303d + "_" + iVar.p() + ".html");
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public final String b(int i2, String str) {
        if (i2 != 4) {
            return a(i2) + File.separator + str + ".0";
        }
        return a(i2) + File.separator + str;
    }

    public final void a(com.anythink.core.common.e.j jVar, i iVar) {
        try {
            File file = new File(new File(this.f7923k, f7919h), jVar.f7303d + "_" + iVar.p() + ".html");
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean a(int i2, String str, InputStream inputStream) {
        a.C0168a c0168aB;
        a.c cVarA;
        byte[] bArr;
        boolean z2 = false;
        if (str != null && inputStream != null) {
            String strA = a(i2);
            if (TextUtils.isEmpty(strA)) {
                return false;
            }
            File file = new File(strA);
            if (!file.exists()) {
                file.mkdirs();
            }
            a aVarA = a(i2, file);
            if (aVarA != null) {
                OutputStream outputStreamA = null;
                try {
                    try {
                        cVarA = aVarA.a(str);
                    } catch (Throwable th) {
                        if (outputStreamA != null) {
                            try {
                                outputStreamA.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    c0168aB = null;
                }
                if (cVarA == null) {
                    c0168aB = aVarA.b(str);
                    if (c0168aB != null) {
                        try {
                            outputStreamA = c0168aB.a(0);
                            bArr = new byte[2048];
                        } catch (Exception e3) {
                            e = e3;
                            new StringBuilder("writeToDiskLruCache - ").append(e);
                            if (c0168aB != null) {
                                try {
                                    c0168aB.b();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (outputStreamA != null) {
                            }
                            return z2;
                        }
                        while (true) {
                            int i3 = inputStream.read(bArr);
                            if (i3 == -1) {
                                break;
                            }
                            outputStreamA.write(bArr, 0, i3);
                            try {
                                outputStreamA.close();
                            } catch (IOException unused2) {
                            }
                        }
                        c0168aB.a();
                        outputStreamA.close();
                    }
                } else {
                    cVarA.a().close();
                }
                z2 = true;
                if (outputStreamA != null) {
                    outputStreamA.close();
                }
            }
        }
        return z2;
    }

    public final FileInputStream a(int i2, String str) {
        InputStream inputStreamA;
        if (i2 != 4) {
            String strA = a(i2);
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            File file = new File(strA);
            if (!file.exists()) {
                file.mkdirs();
            }
            a aVarA = a(i2, file);
            if (aVarA != null) {
                try {
                    a.c cVarA = aVarA.a(str);
                    if (cVarA != null && (inputStreamA = cVarA.a()) != null) {
                        return (FileInputStream) inputStreamA;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        try {
            return new FileInputStream(new File(b(4, str)));
        } catch (Throwable unused) {
            return null;
        }
    }

    private synchronized a a(int i2, File file) {
        a aVarA;
        aVarA = this.b.get(Integer.valueOf(i2));
        if (aVarA == null) {
            try {
                aVarA = a.a(file, n.a().d(i2));
                this.b.put(Integer.valueOf(i2), aVarA);
            } catch (Throwable th) {
                if (n.a().A()) {
                    th.printStackTrace();
                }
            }
        }
        return aVarA;
    }

    public final String a(int i2) {
        return new File(this.f7923k, i2 != 1 ? i2 != 3 ? i2 != 4 ? f7916e : f7918g : f7917f : f7915d).getAbsolutePath();
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(a(1) + File.separator + str + ".0").exists();
    }
}
