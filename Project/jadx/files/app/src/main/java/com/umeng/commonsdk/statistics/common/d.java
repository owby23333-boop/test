package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: StoreHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static d a = null;
    private static Context b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f20075c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f20076e = "mobclick_agent_user_";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f20077f = "mobclick_agent_header_";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f20078g = "mobclick_agent_cached_";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f20079d;

    /* JADX INFO: compiled from: StoreHelper.java */
    public static class a {
        private final int a;
        private File b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private FilenameFilter f20080c;

        public a(Context context) {
            this(context, ".um");
        }

        public boolean a() {
            File[] fileArrListFiles = this.b.listFiles();
            return fileArrListFiles != null && fileArrListFiles.length > 0;
        }

        public void b() {
            File[] fileArrListFiles = this.b.listFiles(this.f20080c);
            if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                return;
            }
            for (File file : fileArrListFiles) {
                file.delete();
            }
        }

        public int c() {
            File[] fileArrListFiles = this.b.listFiles(this.f20080c);
            if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                return 0;
            }
            return fileArrListFiles.length;
        }

        public a(Context context, String str) {
            this.a = 10;
            this.f20080c = new FilenameFilter() { // from class: com.umeng.commonsdk.statistics.common.d.a.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str2) {
                    return str2.startsWith("um");
                }
            };
            this.b = new File(context.getFilesDir(), str);
            if (this.b.exists() && this.b.isDirectory()) {
                return;
            }
            this.b.mkdir();
        }

        public void a(b bVar) {
            File file;
            File[] fileArrListFiles = this.b.listFiles(this.f20080c);
            if (fileArrListFiles != null && fileArrListFiles.length >= 10) {
                Arrays.sort(fileArrListFiles);
                int length = fileArrListFiles.length - 10;
                for (int i2 = 0; i2 < length; i2++) {
                    fileArrListFiles[i2].delete();
                }
            }
            if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                return;
            }
            bVar.a(this.b);
            int length2 = fileArrListFiles.length;
            for (int i3 = 0; i3 < length2; i3++) {
                try {
                } catch (Throwable unused) {
                    file = fileArrListFiles[i3];
                }
                if (bVar.b(fileArrListFiles[i3])) {
                    file = fileArrListFiles[i3];
                    file.delete();
                }
            }
            bVar.c(this.b);
        }

        public void a(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return;
            }
            try {
                HelperUtils.writeFile(new File(this.b, String.format(Locale.US, "um_cache_%d.env", Long.valueOf(System.currentTimeMillis()))), bArr);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: StoreHelper.java */
    public interface b {
        void a(File file);

        boolean b(File file);

        void c(File file);
    }

    public d(Context context) {
        this.f20079d = new a(context);
    }

    public static synchronized d a(Context context) {
        b = context.getApplicationContext();
        f20075c = context.getPackageName();
        if (a == null) {
            a = new d(context);
        }
        return a;
    }

    private SharedPreferences f() {
        return b.getSharedPreferences(f20076e + f20075c, 0);
    }

    public String b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public boolean c() {
        return UMFrUtils.envelopeFileNumber(b) > 0;
    }

    public String[] d() {
        try {
            SharedPreferences sharedPreferencesF = f();
            String string = sharedPreferencesF.getString("au_p", null);
            String string2 = sharedPreferencesF.getString("au_u", null);
            if (string != null && string2 != null) {
                return new String[]{string, string2};
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void e() {
        f().edit().remove("au_p").remove("au_u").commit();
    }

    public void a(int i2) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i2).commit();
        }
    }

    public int a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor editorEdit = f().edit();
        editorEdit.putString("au_p", str);
        editorEdit.putString("au_u", str2);
        editorEdit.commit();
    }
}
