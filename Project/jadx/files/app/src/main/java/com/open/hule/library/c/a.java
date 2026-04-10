package com.open.hule.library.c;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import com.open.hule.library.entity.AppUpdate;
import com.open.hule.library.entity.TipsBean;
import com.open.hule.library.view.l;
import com.open.hule.library.view.m;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: DownloadHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends Handler {
    private final WeakReference<Context> a;
    private final WeakReference<com.open.hule.library.a> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference<m> f17650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakReference<com.open.hule.library.b.a> f17651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final WeakReference<com.open.hule.library.b.b> f17652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f17653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final DownloadManager f17654g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AppUpdate f17655h;

    /* JADX INFO: renamed from: com.open.hule.library.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DownloadHandler.java */
    class RunnableC0501a implements Runnable {
        RunnableC0501a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    public a(Context context, com.open.hule.library.a aVar, m mVar, com.open.hule.library.b.a aVar2, com.open.hule.library.b.b bVar, DownloadManager downloadManager, long j2, AppUpdate appUpdate) {
        this.a = new WeakReference<>(context);
        this.b = new WeakReference<>(aVar);
        this.f17650c = new WeakReference<>(mVar);
        this.f17651d = new WeakReference<>(aVar2);
        this.f17652e = new WeakReference<>(bVar);
        this.f17653f = j2;
        this.f17654g = downloadManager;
        this.f17655h = appUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        m mVar = this.f17650c.get();
        Cursor cursorQuery = this.f17654g.query(new DownloadManager.Query().setFilterById(this.f17653f));
        if (this.f17655h == null || cursorQuery == null || !cursorQuery.moveToFirst()) {
            return;
        }
        String string = cursorQuery.getString(cursorQuery.getColumnIndex("local_uri"));
        cursorQuery.close();
        String path = Uri.parse(string).getPath();
        if (path == null || TextUtils.isEmpty(path)) {
            return;
        }
        File file = new File(path);
        TipsBean tipsBean = this.f17655h.getTipsBean();
        if (tipsBean != null && !TextUtils.isEmpty(tipsBean.getMd5_key()) && !b.a(tipsBean.getMd5_key(), file)) {
            if (this.a.get() != null) {
                Toast.makeText(this.a.get(), "为了安全性和更好的体验，为你推荐浏览器下载更新！", 0).show();
            }
            a();
        } else {
            if (mVar != null && mVar.f17680s && this.a.get() != null && !((Activity) this.a.get()).isFinishing()) {
                mVar.dismiss();
            }
            a(file);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        m mVar;
        super.handleMessage(message);
        int forceUpdate = this.f17655h.getForceUpdate();
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 == 2) {
                if (this.f17650c.get() != null) {
                    this.f17650c.get().c(message.arg1);
                    return;
                }
                return;
            }
            if (i2 != 4) {
                if (i2 == 8) {
                    if (this.f17650c.get() != null) {
                        this.f17650c.get().c(100);
                    }
                    if (this.a.get() != null && this.b.get() != null) {
                        this.a.get().getContentResolver().unregisterContentObserver(this.b.get());
                    }
                    postDelayed(new RunnableC0501a(), 200L);
                    return;
                }
                if (i2 != 16) {
                    if (i2 != 1317) {
                        return;
                    }
                    try {
                        if (this.f17653f != -1) {
                            this.f17654g.remove(this.f17653f);
                        }
                        if (this.a.get() != null && this.b.get() != null) {
                            this.a.get().getContentResolver().unregisterContentObserver(this.b.get());
                        }
                        if (this.a.get() == null || this.f17650c.get() == null || (mVar = this.f17650c.get()) == null || !mVar.f17680s || this.a.get() == null || ((Activity) this.a.get()).isFinishing()) {
                            return;
                        }
                        if (forceUpdate == 1) {
                            mVar.a("请重新点击下载");
                            return;
                        } else {
                            mVar.dismiss();
                            return;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                String str = "错误码：" + message.arg1;
                if (this.a.get() != null) {
                    Toast.makeText(this.a.get(), "更新失败，" + str, 0).show();
                }
                try {
                    if (this.f17653f != -1) {
                        this.f17654g.remove(this.f17653f);
                    }
                    if (this.a.get() != null && this.b.get() != null) {
                        this.a.get().getContentResolver().unregisterContentObserver(this.b.get());
                    }
                    if (this.a.get() == null || this.f17650c.get() == null) {
                        return;
                    }
                    m mVar2 = this.f17650c.get();
                    if (mVar2 != null && mVar2.f17680s && this.a.get() != null && !((Activity) this.a.get()).isFinishing()) {
                        mVar2.dismiss();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("forceUpdate", forceUpdate);
                    bundle.putString("newVersionCode", this.f17655h.getNewVersionCode());
                    bundle.putString("reason", str);
                    l lVarA = l.a(bundle);
                    lVarA.a(this.f17652e.get());
                    lVarA.show(((FragmentActivity) this.a.get()).getSupportFragmentManager(), "UpdateAppUtils");
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private void a() {
        b.a(this.f17655h.getDownBrowserUrl(), this.a.get());
    }

    private void a(File file) {
        Context context = this.a.get();
        if (context != null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (Build.VERSION.SDK_INT < 24) {
                    intent.setDataAndType(Uri.fromFile(file), AdBaseConstants.MIME_APK);
                } else if (Build.VERSION.SDK_INT >= 26 && !context.getPackageManager().canRequestPackageInstalls()) {
                    if (this.f17651d.get() != null) {
                        this.f17651d.get().applyAndroidOInstall(file);
                        return;
                    }
                    return;
                } else {
                    Uri uriForFile = FileProvider.getUriForFile(context.getApplicationContext(), context.getPackageName() + ".fileProvider", file);
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
}
