package com.amgcyo.cuttadon.j.b;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.z;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import l.b.a.j;

/* JADX INFO: compiled from: MkAsyncTaskDownload.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends AsyncTask<String, Integer, String> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static double f4050j = 1024.0d;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static double f4051k = f4050j * 1024.0d;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static double f4052l = f4051k * 1024.0d;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static double f4053m = f4052l * 1024.0d;
    private WeakReference<AppCompatActivity> a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f4054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ProgressDialog f4055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4056e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f4057f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4058g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f4059h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private NumberFormat f4060i;

    public c(AppCompatActivity appCompatActivity, String str, b bVar) {
        this.a = new WeakReference<>(appCompatActivity);
        this.b = str;
        String str2 = "dirPath:" + str;
        this.f4054c = bVar;
    }

    private void b() {
        ProgressDialog progressDialog = this.f4055d;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        Context baseContext = ((ContextWrapper) this.f4055d.getContext()).getBaseContext();
        if (baseContext instanceof Activity) {
            Activity activity = (Activity) baseContext;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                this.f4055d.dismiss();
            }
        } else {
            this.f4055d.dismiss();
        }
        this.f4055d = null;
    }

    private String c() {
        return this.b + com.anythink.china.common.a.a.f6393e;
    }

    private void d() {
        this.f4057f = 0L;
        this.f4058g = 0;
        AppCompatActivity appCompatActivity = this.a.get();
        if (appCompatActivity == null || appCompatActivity.isFinishing()) {
            return;
        }
        this.f4055d = new ProgressDialog(appCompatActivity);
        this.f4055d.setMessage("正在下载 ...");
        this.f4055d.setMax(100);
        this.f4055d.setProgressNumberFormat(a(this.f4057f) + "/" + a(this.f4058g));
        this.f4055d.setProgress(0);
        this.f4055d.setProgressStyle(1);
        this.f4055d.setCancelable(false);
        this.f4055d.setButton(-2, "取消", new DialogInterface.OnClickListener() { // from class: com.amgcyo.cuttadon.j.b.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f4049s.a(dialogInterface, i2);
            }
        });
        this.f4055d.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        try {
            URL url = new URL(strArr[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                return "下载失败：" + httpURLConnection.getResponseCode() + " " + httpURLConnection.getResponseMessage();
            }
            this.f4058g = httpURLConnection.getContentLength();
            this.f4059h = a(this.f4058g);
            String str = "totalSize:" + this.f4059h;
            BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream(), 8192);
            FileOutputStream fileOutputStream = new FileOutputStream(c());
            byte[] bArr = new byte[1024];
            this.f4057f = 0L;
            while (true) {
                int i2 = bufferedInputStream.read(bArr);
                if (i2 == -1 || (!this.f4056e && isCancelled())) {
                    break;
                }
                this.f4057f += (long) i2;
                publishProgress(Integer.valueOf((int) ((this.f4057f * 100) / ((long) this.f4058g))));
                fileOutputStream.write(bArr, 0, i2);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            bufferedInputStream.close();
            httpURLConnection.disconnect();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "下载失败：" + e2.getMessage();
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        d();
        j.a((CharSequence) "正在开始下载...");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        ProgressDialog progressDialog = this.f4055d;
        if (progressDialog != null) {
            this.f4056e = true;
            progressDialog.setProgressNumberFormat(a(this.f4057f) + "/" + this.f4059h);
            this.f4055d.setProgress(numArr[0].intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        if (TextUtils.isEmpty(str)) {
            if (z.f(c(), this.b)) {
                b bVar = this.f4054c;
                if (bVar != null) {
                    bVar.a();
                }
                File file = new File(this.b);
                if (file.exists() && file.getName().endsWith(com.anythink.china.common.a.a.f6395g)) {
                    AppCompatActivity appCompatActivity = this.a.get();
                    if (appCompatActivity == null || appCompatActivity.isFinishing()) {
                        return;
                    } else {
                        g.a(appCompatActivity, file);
                    }
                }
            } else {
                j.a((CharSequence) ("下载失败：" + str));
                a();
            }
        } else {
            j.a((CharSequence) ("下载失败：" + str));
            a();
        }
        this.f4056e = false;
        b();
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        cancel(true);
        this.f4056e = false;
        a();
        j.a((CharSequence) "下载已取消!");
        b();
    }

    private void a() {
        File file = new File(c());
        if (file.exists()) {
            file.delete();
        }
    }

    private String a(long j2) {
        if (this.f4060i == null) {
            this.f4060i = new DecimalFormat();
            this.f4060i.setMaximumFractionDigits(2);
        }
        double d2 = j2;
        try {
            if (d2 < f4050j) {
                return this.f4060i.format(j2) + " Byte(s)";
            }
            if (d2 < f4051k) {
                StringBuilder sb = new StringBuilder();
                NumberFormat numberFormat = this.f4060i;
                double d3 = f4050j;
                Double.isNaN(d2);
                sb.append(numberFormat.format(d2 / d3));
                sb.append(" KB");
                return sb.toString();
            }
            if (d2 < f4052l) {
                StringBuilder sb2 = new StringBuilder();
                NumberFormat numberFormat2 = this.f4060i;
                double d4 = f4051k;
                Double.isNaN(d2);
                sb2.append(numberFormat2.format(d2 / d4));
                sb2.append(" MB");
                return sb2.toString();
            }
            if (d2 < f4053m) {
                StringBuilder sb3 = new StringBuilder();
                NumberFormat numberFormat3 = this.f4060i;
                double d5 = f4052l;
                Double.isNaN(d2);
                sb3.append(numberFormat3.format(d2 / d5));
                sb3.append(" GB");
                return sb3.toString();
            }
            StringBuilder sb4 = new StringBuilder();
            NumberFormat numberFormat4 = this.f4060i;
            double d6 = f4053m;
            Double.isNaN(d2);
            sb4.append(numberFormat4.format(d2 / d6));
            sb4.append(" TB");
            return sb4.toString();
        } catch (Exception unused) {
            return j2 + " Byte(s)";
        }
    }
}
