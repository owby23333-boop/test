package com.yuewen;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class wu3 {
    public static wu3 h;
    public static final /* synthetic */ boolean i = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19718a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f19719b;
    public mw1 c;
    public File d;
    public String e;
    public long f;
    public b g;

    public class a implements FileFilter {
        public a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return (!file.isFile() || file.getName().equalsIgnoreCase(Consts.DOT) || file.getName().equalsIgnoreCase("..")) ? false : true;
        }
    }

    public class b extends AsyncTask<Void, Long, Integer> {
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            synchronized (wu3.this.d) {
                try {
                    try {
                        wu3.this.k();
                        InputStream inputStream = wu3.this.c.a()[0].f17293b;
                        inputStream.reset();
                        FileOutputStream fileOutputStream = new FileOutputStream(wu3.this.d);
                        byte[] bArr = new byte[1024];
                        long j = 0;
                        while (!isCancelled()) {
                            long j2 = inputStream.read(bArr);
                            if (j2 == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr);
                            j += j2;
                            publishProgress(Long.valueOf(j), Long.valueOf(wu3.this.c.a()[0].d));
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        return -1;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return 0;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            if (wu3.this.f19719b != null) {
                if (num.intValue() == 0) {
                    wu3.this.f19719b.a();
                } else {
                    wu3.this.f19719b.b();
                    wu3.this.g();
                }
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Long... lArr) {
            if (wu3.this.f19719b != null) {
                wu3.this.f19719b.c((int) (((lArr[0].longValue() * 1.0f) / lArr[1].longValue()) * 100.0f));
            }
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            super.onCancelled();
            wu3.this.g();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        public b() {
        }
    }

    public interface c {
        void a();

        void b();

        void c(int i);
    }

    public static wu3 h() {
        if (h == null) {
            h = new wu3();
        }
        return h;
    }

    public void f() {
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        File[] fileArrListFiles = new File(this.e).listFiles();
        for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
            if (fileArrListFiles[i2].exists() && fileArrListFiles[i2].isFile()) {
                fileArrListFiles[i2].delete();
            }
        }
    }

    public final void g() {
        synchronized (this.d) {
            if (this.d.exists()) {
                this.d.delete();
            }
        }
    }

    public String i() {
        return this.d.getAbsolutePath();
    }

    public final void j(Context context) {
        this.e = context.getCacheDir().getAbsolutePath();
        File file = new File(context.getCacheDir(), od0.f(this.f + this.c.a()[0].c, "md5"));
        this.d = file;
        if (file.exists()) {
            this.f19719b.a();
            return;
        }
        b bVar = new b();
        this.g = bVar;
        bVar.execute(new Void[0]);
    }

    public final void k() {
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        File[] fileArrListFiles = new File(this.e).listFiles(new a());
        if (fileArrListFiles.length < 3) {
            return;
        }
        File file = fileArrListFiles[0];
        for (int i2 = 1; i2 < fileArrListFiles.length; i2++) {
            if (file.lastModified() > fileArrListFiles[i2].lastModified()) {
                file = fileArrListFiles[i2];
            }
        }
        file.delete();
    }

    public void l(long j, mw1 mw1Var, Context context, c cVar) {
        this.c = mw1Var;
        this.f = j;
        this.f19719b = cVar;
        j(context);
    }

    public void m() {
        b bVar = this.g;
        if (bVar != null) {
            bVar.cancel(true);
        }
    }
}
