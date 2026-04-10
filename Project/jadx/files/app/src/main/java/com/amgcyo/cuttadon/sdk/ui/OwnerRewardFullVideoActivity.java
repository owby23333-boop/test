package com.amgcyo.cuttadon.sdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.sdk.self.video.TikTokController;
import com.amgcyo.cuttadon.view.otherview.CommonShapeButton;
import com.amgcyo.cuttadon.view.otherview.ProgressWheel;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.fatcatfat.io.R;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;
import xyz.doikki.videoplayer.player.BaseVideoView;
import xyz.doikki.videoplayer.player.VideoView;

/* JADX INFO: loaded from: classes.dex */
public class OwnerRewardFullVideoActivity extends BaseTitleBarActivity {

    @BindView(R.id.btn_action)
    CommonShapeButton btn_action;

    @BindView(R.id.cb_vloume)
    CheckBox cb_vloume;

    @BindView(R.id.imageview)
    ImageView imageview;

    @BindView(R.id.iv_adImg)
    ImageView iv_adImg;

    @BindView(R.id.iv_close_ad)
    ImageView iv_close_ad;

    @BindView(R.id.logoImgeview)
    ImageView logoImgeview;

    @BindView(R.id.logoImgeview_small)
    ImageView logoImgeview_small;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private NewApiAd f4278n0;

    @BindView(R.id.progress_wheel)
    ProgressWheel progress_wheel;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private Timer f4282r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private TimerTask f4283s0;

    @BindView(R.id.tv_adTitle)
    TextView tv_adTitle;

    @BindView(R.id.tv_ad_score)
    TextView tv_ad_score;

    @BindView(R.id.tv_ad_time)
    TextView tv_ad_time;

    @BindView(R.id.player)
    VideoView videoView;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f4279o0 = 0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private boolean f4280p0 = false;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private boolean f4281q0 = false;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private boolean f4284t0 = false;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private long f4285u0 = 0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    Handler f4286v0 = new e(Looper.getMainLooper());

    class a implements com.bumptech.glide.request.g<Drawable> {
        a() {
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, com.bumptech.glide.request.k.j<Drawable> jVar, boolean z2) {
            ImageView imageView = OwnerRewardFullVideoActivity.this.logoImgeview_small;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(Drawable drawable, Object obj, com.bumptech.glide.request.k.j<Drawable> jVar, DataSource dataSource, boolean z2) {
            ImageView imageView = OwnerRewardFullVideoActivity.this.logoImgeview_small;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            return false;
        }
    }

    class b implements BaseVideoView.OnStateChangeListener {
        final /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
        }

        @Override // xyz.doikki.videoplayer.player.BaseVideoView.OnStateChangeListener
        public void onPlayStateChanged(int i2) {
            switch (i2) {
                case -1:
                    String str = "STATE_ERROR " + hashCode();
                    OwnerRewardFullVideoActivity ownerRewardFullVideoActivity = OwnerRewardFullVideoActivity.this;
                    ownerRewardFullVideoActivity.a(ownerRewardFullVideoActivity.progress_wheel);
                    OwnerRewardFullVideoActivity ownerRewardFullVideoActivity2 = OwnerRewardFullVideoActivity.this;
                    ownerRewardFullVideoActivity2.b(ownerRewardFullVideoActivity2.imageview, ownerRewardFullVideoActivity2.iv_close_ad);
                    OwnerRewardFullVideoActivity.this.r();
                    OwnerRewardFullVideoActivity.this.c("出了点小问题，请稍后重试!");
                    break;
                case 0:
                    String str2 = "STATE_IDLE " + hashCode();
                    break;
                case 2:
                    String str3 = "STATE_PREPARED " + hashCode();
                    OwnerRewardFullVideoActivity ownerRewardFullVideoActivity3 = OwnerRewardFullVideoActivity.this;
                    ownerRewardFullVideoActivity3.a(ownerRewardFullVideoActivity3.imageview, ownerRewardFullVideoActivity3.progress_wheel);
                    OwnerRewardFullVideoActivity ownerRewardFullVideoActivity4 = OwnerRewardFullVideoActivity.this;
                    ownerRewardFullVideoActivity4.b(ownerRewardFullVideoActivity4.cb_vloume, ownerRewardFullVideoActivity4.iv_close_ad);
                    OwnerRewardFullVideoActivity.this.r();
                    OwnerRewardFullVideoActivity.this.videoView.setMute(this.a == 0);
                    OwnerRewardFullVideoActivity.this.n();
                    break;
                case 3:
                    String str4 = "STATE_PLAYING " + hashCode();
                    break;
                case 4:
                    String str5 = "STATE_PAUSED " + hashCode();
                    break;
                case 5:
                    String str6 = "STATE_PLAYBACK_COMPLETED " + hashCode();
                    if (OwnerRewardFullVideoActivity.this.f4286v0 != null) {
                        Message message = new Message();
                        message.what = 101;
                        message.obj = 0L;
                        OwnerRewardFullVideoActivity.this.f4286v0.sendMessage(message);
                    }
                    OwnerRewardFullVideoActivity.this.destroyTimer();
                    break;
                case 6:
                    String str7 = "STATE_BUFFERING " + hashCode();
                    OwnerRewardFullVideoActivity ownerRewardFullVideoActivity5 = OwnerRewardFullVideoActivity.this;
                    ownerRewardFullVideoActivity5.b(ownerRewardFullVideoActivity5.progress_wheel);
                    OwnerRewardFullVideoActivity.this.o();
                    break;
                case 7:
                    String str8 = "STATE_BUFFERED " + hashCode();
                    OwnerRewardFullVideoActivity ownerRewardFullVideoActivity6 = OwnerRewardFullVideoActivity.this;
                    ownerRewardFullVideoActivity6.a(ownerRewardFullVideoActivity6.progress_wheel);
                    OwnerRewardFullVideoActivity.this.p();
                    break;
            }
        }

        @Override // xyz.doikki.videoplayer.player.BaseVideoView.OnStateChangeListener
        public void onPlayerStateChanged(int i2) {
        }
    }

    class c implements com.bumptech.glide.request.g<Drawable> {
        c() {
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, com.bumptech.glide.request.k.j<Drawable> jVar, boolean z2) {
            OwnerRewardFullVideoActivity.this.r();
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(Drawable drawable, Object obj, com.bumptech.glide.request.k.j<Drawable> jVar, DataSource dataSource, boolean z2) {
            OwnerRewardFullVideoActivity.this.r();
            OwnerRewardFullVideoActivity.this.n();
            return false;
        }
    }

    class d extends TimerTask {
        d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (OwnerRewardFullVideoActivity.this.f4285u0 == 0) {
                OwnerRewardFullVideoActivity.this.f4285u0 = r0.f4278n0.getSecond() * 1000;
            } else {
                OwnerRewardFullVideoActivity.b(OwnerRewardFullVideoActivity.this, 1000L);
            }
            Message message = new Message();
            message.what = 101;
            message.obj = Long.valueOf(OwnerRewardFullVideoActivity.this.f4285u0);
            OwnerRewardFullVideoActivity.this.f4286v0.sendMessage(message);
        }
    }

    class e extends Handler {
        e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 101 || OwnerRewardFullVideoActivity.this.tv_ad_time == null) {
                return;
            }
            long jLongValue = ((Long) message.obj).longValue();
            if (jLongValue > 0) {
                OwnerRewardFullVideoActivity.this.f4280p0 = false;
                OwnerRewardFullVideoActivity.this.tv_ad_time.setText(String.format("还剩%ss", String.valueOf((int) (jLongValue / 1000))));
                return;
            }
            if (OwnerRewardFullVideoActivity.this.f4282r0 != null) {
                OwnerRewardFullVideoActivity.this.f4282r0.cancel();
            }
            OwnerRewardFullVideoActivity.this.f4285u0 = 0L;
            OwnerRewardFullVideoActivity.this.f4280p0 = true;
            if (OwnerRewardFullVideoActivity.this.f4279o0 != 8) {
                if (OwnerRewardFullVideoActivity.this.f4279o0 == 9) {
                    OwnerRewardFullVideoActivity.this.tv_ad_time.setText("关闭");
                }
            } else {
                if (!OwnerRewardFullVideoActivity.this.f4281q0) {
                    OwnerRewardFullVideoActivity.this.tv_ad_time.setText("获取数据成功");
                    OwnerRewardFullVideoActivity.this.d("获取数据成功，请返回继续操作！");
                }
                OwnerRewardFullVideoActivity.this.f4281q0 = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Timer timer;
        if (this.f4285u0 == 0 || (timer = this.f4282r0) == null || this.f4284t0) {
            return;
        }
        this.f4284t0 = true;
        timer.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f4285u0 == 0 || !this.f4284t0) {
            return;
        }
        destroyTimer();
        initTimer();
        this.f4282r0.schedule(this.f4283s0, 0L, 1000L);
        this.f4284t0 = false;
    }

    private void q() {
        this.tv_adTitle.setText(this.f4278n0.getName());
        this.btn_action.setText(this.f4278n0.getDesc());
        this.tv_ad_score.setText(String.format(Locale.getDefault(), "(%d个评分)", Integer.valueOf(this.f4278n0.getScore())));
        String image_logo = this.f4278n0.getImage_logo();
        if (TextUtils.isEmpty(image_logo)) {
            return;
        }
        this.G.a(this.f2277w, ImageConfigImpl.builder().imageRadius(8).url(image_logo).listener(new a()).isNeedPlaceholder(false).imageView(this.iv_adImg).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        destroyTimer();
        initTimer();
        this.f4284t0 = false;
        this.f4282r0.schedule(this.f4283s0, 0L, 1000L);
        b(this.logoImgeview);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    public void destroyTimer() {
        Timer timer = this.f4282r0;
        if (timer != null) {
            timer.cancel();
            this.f4282r0 = null;
        }
        TimerTask timerTask = this.f4283s0;
        if (timerTask != null) {
            timerTask.cancel();
            this.f4283s0 = null;
        }
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        if (intent == null) {
            g("找不到对象(1)");
            return;
        }
        this.f4279o0 = intent.getIntExtra("key_txmoney", 0);
        Integer.valueOf(this.f4279o0);
        if (this.f4279o0 <= 0) {
            g("参数异常！");
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("ltype", false);
        Boolean.valueOf(booleanExtra);
        com.amgcyo.cuttadon.utils.otherutils.g.d((Activity) this);
        String[] strArr = com.amgcyo.cuttadon.f.n.f3698l;
        if (this.f4279o0 == 9) {
            strArr = com.amgcyo.cuttadon.f.n.f3699m;
        }
        this.f4278n0 = com.amgcyo.cuttadon.app.o.c.a(strArr, this.f4279o0, booleanExtra);
        NewApiAd newApiAd = this.f4278n0;
        if (newApiAd == null) {
            g("找不到对象(2)");
            return;
        }
        String image = newApiAd.getImage();
        if (TextUtils.isEmpty(image)) {
            g("缺少必要参数！");
            return;
        }
        if (1 == this.f4278n0.getVideo_type()) {
            f(image);
        } else {
            e(image);
        }
        q();
    }

    public void initTimer() {
        this.f4283s0 = new d();
        this.f4282r0 = new Timer();
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.activity_reward_splash;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    protected void n() {
        NewApiAd newApiAd = this.f4278n0;
        if (newApiAd != null) {
            com.amgcyo.cuttadon.h.h.c.a(this, "OWNADSHOW", newApiAd, newApiAd.getLocation(), this.f4278n0.getOwnerType());
        }
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        VideoView videoView = this.videoView;
        if (videoView == null || videoView.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        VideoView videoView = this.videoView;
        if (videoView != null) {
            videoView.release();
        }
        destroyTimer();
        Handler handler = this.f4286v0;
        if (handler != null) {
            handler.removeMessages(101);
            this.f4286v0 = null;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 || i2 == 3) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        VideoView videoView = this.videoView;
        if (videoView != null) {
            videoView.pause();
        }
        o();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        VideoView videoView = this.videoView;
        if (videoView != null) {
            videoView.resume();
        }
        p();
    }

    @OnClick({R.id.iv_close_ad, R.id.tv_ad_time, R.id.btn_action, R.id.rl_ad_bottom, R.id.imageview, R.id.player})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_action /* 2131296728 */:
            case R.id.imageview /* 2131297089 */:
            case R.id.player /* 2131298165 */:
            case R.id.rl_ad_bottom /* 2131298251 */:
                com.amgcyo.cuttadon.h.h.a.a(this.f2277w, this.f4278n0);
                break;
            case R.id.iv_close_ad /* 2131297163 */:
            case R.id.tv_ad_time /* 2131298585 */:
                if (!this.f4280p0) {
                    showErrorMsgGravityBottom("请等待倒计时结束后再操作！");
                } else {
                    g("获取奖励成功！");
                }
                break;
        }
    }

    static /* synthetic */ long b(OwnerRewardFullVideoActivity ownerRewardFullVideoActivity, long j2) {
        long j3 = ownerRewardFullVideoActivity.f4285u0 - j2;
        ownerRewardFullVideoActivity.f4285u0 = j3;
        return j3;
    }

    private void g(String str) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent();
        bundle.putBoolean("LocalMp3Bean", this.f4280p0);
        bundle.putString("title", str);
        intent.putExtras(bundle);
        setResult(836, intent);
        finish();
    }

    private void e(String str) {
        a(this.videoView, this.cb_vloume, this.progress_wheel);
        this.imageview.setVisibility(0);
        this.G.a(this.f2277w, ImageConfigImpl.builder().isNeedPlaceholder(false).listener(new c()).url(str).imageView(this.imageview).build());
    }

    private void f(String str) {
        ImageView imageView = this.imageview;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        this.G.a(this.f2277w, ImageConfigImpl.builder().isNeedPlaceholder(false).imageRadius(8).url(str).imageView(this.imageview).build());
        b(this.videoView, this.progress_wheel);
        int video_sound = this.f4278n0.getVideo_sound();
        this.cb_vloume.setChecked(video_sound == 1);
        this.cb_vloume.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.amgcyo.cuttadon.sdk.ui.o
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.a.a(compoundButton, z2);
            }
        });
        this.videoView.addOnStateChangeListener(new b(video_sound));
        String image_video = this.f4278n0.getImage_video();
        if (TextUtils.isEmpty(image_video)) {
            return;
        }
        this.videoView.setUrl(com.amgcyo.cuttadon.sdk.self.video.a.a(this).b(image_video));
        this.videoView.setRenderViewFactory(com.amgcyo.cuttadon.sdk.self.video.c.create());
        this.videoView.setVideoController(new TikTokController(this));
        this.videoView.start();
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z2) {
        if (compoundButton.isPressed()) {
            this.videoView.setMute(!z2);
        }
    }
}
