package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.tencent.smtt.export.external.DexLoader;

/* JADX INFO: loaded from: classes3.dex */
class t extends FrameLayout implements MediaPlayer.OnErrorListener {
    private Object a;
    private v b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private VideoView f19092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f19093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f19094e;

    public t(Context context) {
        super(context.getApplicationContext());
        this.f19093d = null;
        this.f19093d = context;
    }

    private void b(Bundle bundle, Object obj) {
        boolean zA;
        a();
        if (b()) {
            bundle.putInt("callMode", bundle.getInt("callMode"));
            zA = this.b.a(this.a, bundle, this, obj);
        } else {
            zA = false;
        }
        if (zA) {
            return;
        }
        VideoView videoView = this.f19092c;
        if (videoView != null) {
            videoView.stopPlayback();
        }
        if (this.f19092c == null) {
            this.f19092c = new VideoView(getContext());
        }
        this.f19094e = bundle.getString("videoUrl");
        this.f19092c.setVideoURI(Uri.parse(this.f19094e));
        this.f19092c.setOnErrorListener(this);
        Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        Context applicationContext = getContext().getApplicationContext();
        intent.setPackage(applicationContext.getPackageName());
        applicationContext.startActivity(intent);
    }

    void a() {
        setBackgroundColor(-16777216);
        if (this.b == null) {
            g.a(true).a(getContext().getApplicationContext(), false, false);
            u uVarA = g.a(true).a();
            DexLoader dexLoaderC = uVarA != null ? uVarA.c() : null;
            if (dexLoaderC != null && QbSdk.canLoadVideo(getContext())) {
                this.b = new v(dexLoaderC);
            }
        }
        v vVar = this.b;
        if (vVar == null || this.a != null) {
            return;
        }
        this.a = vVar.a(getContext().getApplicationContext());
    }

    public void a(Activity activity) {
        VideoView videoView;
        if (b() || (videoView = this.f19092c) == null) {
            return;
        }
        if (videoView.getParent() == null) {
            Window window = activity.getWindow();
            FrameLayout frameLayout = (FrameLayout) window.getDecorView();
            window.addFlags(1024);
            window.addFlags(128);
            frameLayout.setBackgroundColor(-16777216);
            MediaController mediaController = new MediaController(activity);
            mediaController.setMediaPlayer(this.f19092c);
            this.f19092c.setMediaController(mediaController);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            frameLayout.addView(this.f19092c, layoutParams);
        }
        if (Build.VERSION.SDK_INT >= 8) {
            this.f19092c.start();
        }
    }

    void a(Activity activity, int i2) {
        VideoView videoView;
        VideoView videoView2;
        if (i2 == 3 && !b() && (videoView2 = this.f19092c) != null) {
            videoView2.pause();
        }
        if (i2 == 4) {
            this.f19093d = null;
            if (!b() && (videoView = this.f19092c) != null) {
                videoView.stopPlayback();
                this.f19092c = null;
            }
        }
        if (i2 == 2 && !b()) {
            this.f19093d = activity;
            a(activity);
        }
        if (b()) {
            this.b.a(this.a, activity, i2);
        }
    }

    void a(Bundle bundle, Object obj) {
        b(bundle, obj);
    }

    public boolean b() {
        return (this.b == null || this.a == null) ? false : true;
    }

    public void c() {
        if (b()) {
            this.b.a(this.a);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        try {
            if (this.f19093d instanceof Activity) {
                Activity activity = (Activity) this.f19093d;
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            Context context = getContext();
            if (context != null) {
                Toast.makeText(context, "播放失败，请选择其它播放器播放", 1).show();
                Context applicationContext = context.getApplicationContext();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                intent.setDataAndType(Uri.parse(this.f19094e), "video/*");
                applicationContext.startActivity(intent);
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
