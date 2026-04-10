package com.open.hule.library.c;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import com.open.hule.library.entity.AppUpdate;
import com.open.hule.library.entity.SafBean;
import com.open.hule.library.view.m;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: compiled from: UpdateAppUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements com.open.hule.library.b.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f17657h;
    private final WeakReference<Context> a;
    private DownloadManager b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f17658c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AppUpdate f17659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.open.hule.library.b.a f17660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.open.hule.library.a f17661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private m f17662g;

    public c(Context context) {
        this.a = new WeakReference<>(context);
    }

    private void b(File file) {
        File[] fileArrListFiles;
        if (file.exists()) {
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    b(file2);
                }
            }
            file.delete();
        }
    }

    private boolean e() {
        if (this.f17659d != null) {
            return false;
        }
        Toast.makeText(this.a.get(), "下载失败，请重启应用后重试！", 0).show();
        return true;
    }

    private void f() {
        try {
            if (this.f17658c != -1) {
                this.b.remove(this.f17658c);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void g() {
        if (e()) {
            return;
        }
        try {
            Context context = this.a.get();
            if (context != null) {
                String newVersionUrl = this.f17659d.getNewVersionUrl();
                String str = (String) Objects.requireNonNull(newVersionUrl);
                if (!newVersionUrl.endsWith(com.anythink.china.common.a.a.f6395g)) {
                    this.f17662g.f();
                    Intent intent = new Intent();
                    Toast.makeText(context, "请在官网下载", 0).show();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(newVersionUrl));
                    intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                    context.startActivity(intent);
                    return;
                }
                this.b = (DownloadManager) context.getSystemService("download");
                f();
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                request.setNotificationVisibility(1);
                String savePath = this.f17659d.getSavePath();
                String strB = b.b(newVersionUrl);
                String str2 = savePath + " fileName: " + strB + " url: " + newVersionUrl;
                if (TextUtils.isEmpty(savePath)) {
                    request.setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS, strB);
                } else {
                    File file = new File(context.getExternalFilesDir(savePath), strB);
                    String str3 = file.exists() + " path: " + file.getAbsolutePath();
                    request.setDestinationInExternalFilesDir(context, savePath, strB);
                    b((File) Objects.requireNonNull(context.getExternalFilesDir(savePath)));
                }
                request.setTitle(j());
                request.setDescription("正在下载中...");
                request.setMimeType(AdBaseConstants.MIME_APK);
                this.f17658c = this.b.enqueue(request);
                this.f17661f = new com.open.hule.library.a(context, new a(context, this.f17661f, this.f17662g, this.f17660e, this, this.b, this.f17658c, this.f17659d), this.b, this.f17658c);
                context.getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, this.f17661f);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            i();
        }
    }

    private void h() {
        if (e()) {
            return;
        }
        this.f17662g.a(this.f17659d.getNewVersionUrl(), this.f17659d.getSavePath(), true);
    }

    private void i() {
        try {
            String downBrowserUrl = this.f17659d.getDownBrowserUrl();
            if (TextUtils.isEmpty(downBrowserUrl)) {
                downBrowserUrl = this.f17659d.getNewVersionUrl();
            }
            Intent intent = new Intent();
            Uri uri = Uri.parse(downBrowserUrl);
            intent.setAction("android.intent.action.VIEW");
            intent.setData(uri);
            this.a.get().startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String j() {
        try {
            Context context = this.a.get();
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "下载";
        }
    }

    private File k() {
        if (this.b == null) {
            return null;
        }
        Cursor cursorQuery = this.b.query(new DownloadManager.Query().setFilterById(this.f17658c));
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            return null;
        }
        String path = Uri.parse(cursorQuery.getString(cursorQuery.getColumnIndex("local_uri"))).getPath();
        if (path != null && !TextUtils.isEmpty(path)) {
            return new File(path);
        }
        cursorQuery.close();
        return null;
    }

    public void a(AppUpdate appUpdate, com.open.hule.library.b.a aVar) {
        Context context = this.a.get();
        if (context == null) {
            throw new NullPointerException(com.anythink.expressad.foundation.g.b.b.a);
        }
        if (appUpdate == null) {
            throw new NullPointerException("appUpdate is null");
        }
        this.f17659d = appUpdate;
        f17657h = true;
        this.f17660e = aVar;
        Bundle bundle = new Bundle();
        bundle.putParcelable("appUpdate", appUpdate);
        m mVar = this.f17662g;
        if (mVar == null || !mVar.f17680s) {
            this.f17662g = m.a(bundle).a(this);
            this.f17662g.show(((FragmentActivity) context).getSupportFragmentManager(), "UpdateAppUtils");
        }
    }

    @Override // com.open.hule.library.b.b
    public void c() {
        m mVar = this.f17662g;
        if (mVar == null || !mVar.f17680s || this.a.get() == null || ((Activity) this.a.get()).isFinishing()) {
            return;
        }
        this.f17662g.dismiss();
    }

    public AppUpdate d() {
        return this.f17659d;
    }

    @Override // com.open.hule.library.b.b
    public void forceExit() {
        com.open.hule.library.b.a aVar = this.f17660e;
        if (aVar != null) {
            aVar.forceExit();
        }
    }

    @Override // com.open.hule.library.b.b
    public void gotoFeedback() {
        com.open.hule.library.b.a aVar = this.f17660e;
        if (aVar != null) {
            aVar.gotoFeedback();
        }
    }

    @Override // com.open.hule.library.b.b
    public void b() {
        if (e()) {
            return;
        }
        if (this.f17659d.getDownloadScheme() == 0) {
            g();
        } else {
            h();
        }
    }

    @Override // com.open.hule.library.b.b
    public void a(boolean z2) {
        if (e()) {
            return;
        }
        if (this.f17659d.getDownloadScheme() == 0) {
            m mVar = this.f17662g;
            if (mVar != null && mVar.f17680s && this.a.get() != null && !((Activity) this.a.get()).isFinishing()) {
                if (this.f17659d.getForceUpdate() != 0) {
                    this.f17662g.g();
                } else if (z2) {
                    Toast.makeText(this.a.get(), "开始下载，可在通知栏查看下载进度!", 0).show();
                    this.f17662g.dismiss();
                } else {
                    this.f17662g.h();
                }
            }
            g();
            return;
        }
        h();
    }

    @Override // com.open.hule.library.b.b
    public void a(File file) {
        a(file);
    }

    @Override // com.open.hule.library.b.b
    public void a() {
        i();
    }

    public void a(File... fileArr) {
        Context context = this.a.get();
        if (context != null) {
            m mVar = this.f17662g;
            if (mVar != null && mVar.f17680s && this.a.get() != null && !((Activity) this.a.get()).isFinishing()) {
                this.f17662g.dismiss();
            }
            try {
                File fileK = k();
                if (fileArr != null && fileArr.length > 0) {
                    fileK = fileArr[0];
                }
                if (fileK == null) {
                    if (this.f17660e != null) {
                        this.f17660e.openBroswer();
                        return;
                    }
                    return;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                if (Build.VERSION.SDK_INT < 24) {
                    intent.setDataAndType(Uri.fromFile(fileK), AdBaseConstants.MIME_APK);
                } else if (Build.VERSION.SDK_INT >= 26 && !context.getPackageManager().canRequestPackageInstalls()) {
                    if (this.f17660e != null) {
                        this.f17660e.applyAndroidOInstall(fileK);
                        return;
                    }
                    return;
                } else {
                    Uri uriForFile = FileProvider.getUriForFile(context.getApplicationContext(), context.getPackageName() + ".fileProvider", fileK);
                    intent.addFlags(1);
                    intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
                }
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                context.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
                Toast.makeText(context, "请点击通知栏完成应用的安装！", 0).show();
            }
        }
    }

    @Override // com.open.hule.library.b.b
    public void a(SafBean safBean) {
        com.open.hule.library.b.a aVar = this.f17660e;
        if (aVar != null) {
            aVar.bauckUpData(safBean);
        }
    }
}
