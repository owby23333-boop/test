package com.anythink.expressad.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.f.b;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener;
import com.anythink.expressad.playercommon.PlayerErrorConstant;
import com.anythink.expressad.playercommon.PlayerView;
import com.anythink.expressad.video.widget.SoundImageView;
import com.anythink.expressad.videocommon.b.c;
import com.anythink.expressad.videocommon.b.e;
import com.anythink.expressad.widget.FeedBackButton;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AnythinkBTVideoView extends BTBaseView {
    private static boolean H = false;
    private static final String N = "2";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f11513p = "anythink_reward_videoview_item";
    private a A;
    private int B;
    private int C;
    private boolean D;
    private int E;
    private int F;
    private String G;
    private boolean I;
    private boolean J;
    private boolean K;
    private RelativeLayout L;
    private ProgressBar M;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private PlayerView f11514q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private SoundImageView f11515r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f11516s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private View f11517t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private FeedBackButton f11518u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private WebView f11519v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private c f11520w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f11521x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f11522y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f11523z;

    private static final class a extends DefaultVideoPlayerStatusListener {
        private AnythinkBTVideoView a;
        private WebView b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f11524c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f11525d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f11526e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f11527f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f11528g;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f11532k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f11533l;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f11529h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f11530i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f11531j = false;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f11534m = false;

        public a(AnythinkBTVideoView anythinkBTVideoView, WebView webView) {
            this.a = anythinkBTVideoView;
            this.b = webView;
            this.f11524c = anythinkBTVideoView.f11550d;
            this.f11525d = anythinkBTVideoView.f11549c;
        }

        private int a() {
            return this.f11526e;
        }

        private void b() {
            this.a = null;
            this.b = null;
            boolean unused = AnythinkBTVideoView.H = false;
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onBufferingStart(String str) {
            try {
                super.onBufferingStart(str);
                if ((str.equals(PlayerErrorConstant.PREPARE_TIMEOUT) || str.equals("play buffering tiemout")) && this.b != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", BTBaseView.f11546n);
                        jSONObject.put("id", this.f11524c);
                        jSONObject.put("data", new JSONObject());
                        j.a();
                        j.a(this.b, "onPlayerTimeout", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e2) {
                        com.anythink.expressad.video.bt.a.c.a();
                        com.anythink.expressad.video.bt.a.c.a(this.b, e2.getMessage());
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayCompleted() {
            super.onPlayCompleted();
            AnythinkBTVideoView anythinkBTVideoView = this.a;
            com.anythink.expressad.foundation.d.c cVar = anythinkBTVideoView.b;
            if (cVar == null) {
                anythinkBTVideoView.f11516s.setText("0");
            } else if (cVar.i() > 0) {
                this.a.f11516s.setText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_complete", i.f10649g));
            } else {
                this.a.f11516s.setText("0");
            }
            this.a.f11514q.setClickable(false);
            WebView webView = this.b;
            if (webView != null) {
                BTBaseView.a(webView, "onPlayerFinish", this.f11524c);
            }
            this.f11526e = this.f11527f;
            boolean unused = AnythinkBTVideoView.H = true;
            this.a.stop();
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayError(String str) {
            super.onPlayError(str);
            if (this.b != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", BTBaseView.f11547o);
                    jSONObject.put("id", this.f11524c);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("error", str);
                    jSONObject2.put("id", this.f11524c);
                    jSONObject.put("data", jSONObject2);
                    j.a();
                    j.a(this.b, "onPlayerFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e2) {
                    com.anythink.expressad.video.bt.a.c.a();
                    com.anythink.expressad.video.bt.a.c.a(this.b, e2.getMessage());
                }
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayProgress(int i2, int i3) {
            int i4;
            String str;
            int i5;
            String strValueOf;
            super.onPlayProgress(i2, i3);
            AnythinkBTVideoView anythinkBTVideoView = this.a;
            if (anythinkBTVideoView.f11554h) {
                com.anythink.expressad.foundation.d.c cVar = anythinkBTVideoView.b;
                if (cVar != null) {
                    i5 = cVar.i();
                    b.a().a(this.a.b.K() + "_1", i2);
                } else {
                    i5 = 0;
                }
                if (i5 > i3) {
                    i5 = i3;
                }
                int i6 = i5 <= 0 ? i3 - i2 : i5 - i2;
                if (i6 <= 0) {
                    strValueOf = i5 <= 0 ? "0" : (String) this.a.getContext().getResources().getText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_complete", i.f10649g));
                } else if (i5 <= 0) {
                    strValueOf = String.valueOf(i6);
                } else {
                    strValueOf = i6 + ((String) this.a.getContext().getResources().getText(i.a(n.a().g(), "anythink_reward_video_view_reward_time_left", i.f10649g)));
                }
                this.a.f11516s.setText(strValueOf);
            }
            this.f11527f = i3;
            this.f11526e = i2;
            this.a.M.setMax(this.f11527f);
            this.a.M.setProgress(this.f11526e);
            if (this.b != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", BTBaseView.f11546n);
                    jSONObject.put("id", this.f11524c);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", this.f11524c);
                    jSONObject2.put(NotificationCompat.CATEGORY_PROGRESS, AnythinkBTVideoView.b(i2, i3));
                    jSONObject2.put("time", String.valueOf(i2));
                    jSONObject2.put("duration", String.valueOf(i3));
                    jSONObject.put("data", jSONObject2);
                    j.a();
                    j.a(this.b, "onPlayerProgressChanged", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e2) {
                    com.anythink.expressad.video.bt.a.c.a();
                    com.anythink.expressad.video.bt.a.c.a(this.b, e2.getMessage());
                }
            }
            try {
                if (this.f11532k == 100 || this.f11534m || this.f11532k == 0 || this.f11533l < 0 || i2 < (i4 = (i3 * this.f11533l) / 100)) {
                    return;
                }
                if (this.a.b.w() == 94 || this.a.b.w() == 287) {
                    str = this.a.b.Z() + this.a.b.aZ() + this.a.b.S();
                } else {
                    str = this.a.b.aZ() + this.a.b.S() + this.a.b.B();
                }
                c cVarA = e.a().a(this.f11525d, str);
                if (cVarA != null) {
                    cVarA.i();
                    this.f11534m = true;
                    o.d("DefaultVideoPlayerStatusListener", "CDRate is : " + i4 + " and start download !");
                }
            } catch (Exception e3) {
                o.d("DefaultVideoPlayerStatusListener", e3.getMessage());
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayStarted(int i2) {
            super.onPlayStarted(i2);
            if (!this.f11528g) {
                this.a.M.setMax(i2);
                WebView webView = this.b;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerPlay", this.f11524c);
                }
                this.f11528g = true;
            }
            boolean unused = AnythinkBTVideoView.H = false;
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onVideoDownloadResume() {
            String str;
            if (this.a.b.w() == 94 || this.a.b.w() == 287) {
                str = this.a.b.Z() + this.a.b.aZ() + this.a.b.S();
            } else {
                str = this.a.b.aZ() + this.a.b.S() + this.a.b.B();
            }
            c cVarA = e.a().a(this.f11525d, str);
            if (cVarA != null) {
                cVarA.i();
                this.f11534m = true;
                o.d("DefaultVideoPlayerStatusListener", "onVideoDownloadResume :  and start download !");
            }
        }

        public final void a(int i2, int i3) {
            this.f11532k = i2;
            this.f11533l = i3;
        }
    }

    public AnythinkBTVideoView(Context context) {
        super(context);
        this.f11521x = 0;
        this.f11522y = 0;
        this.f11523z = 0;
        this.B = 2;
        this.D = false;
        this.E = 2;
        this.F = 1;
        this.I = false;
        this.J = false;
        this.K = false;
    }

    private int f() {
        return com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.f11549c, false).x();
    }

    public int getMute() {
        return this.B;
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void init(Context context) {
        int iFindLayout = findLayout(f11513p);
        if (iFindLayout > 0) {
            this.f11552f.inflate(iFindLayout, this);
            this.f11554h = b();
            if (!this.f11554h) {
                o.d(BTBaseView.TAG, "AnythinkVideoView init fail");
            }
            a();
        }
        H = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.K) {
            com.anythink.expressad.video.bt.a.c.a();
            this.E = com.anythink.expressad.video.bt.a.c.e(this.f11549c);
        }
        View view = this.f11517t;
        if (view != null) {
            view.setVisibility(this.f11522y == 0 ? 8 : 0);
        }
        SoundImageView soundImageView = this.f11515r;
        if (soundImageView != null) {
            soundImageView.setVisibility(this.f11523z == 0 ? 8 : 0);
        }
        TextView textView = this.f11516s;
        if (textView != null) {
            textView.setVisibility(this.f11521x != 0 ? 0 : 8);
            if (this.f11516s.getVisibility() == 0 && b.a().b()) {
                this.b.l(this.f11549c);
                b.a().a(this.f11549c + "_1", this.b);
                b.a().a(this.f11549c + "_1", this.f11518u);
            }
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void onDestory() {
        try {
            if (this.f11514q != null) {
                this.f11514q.setOnClickListener(null);
                this.f11514q.release();
                this.f11514q = null;
            }
            if (this.f11515r != null) {
                this.f11515r.setOnClickListener(null);
            }
            if (this.f11517t != null) {
                this.f11517t.setOnClickListener(null);
            }
            if (this.f11519v != null) {
                this.f11519v = null;
            }
            setOnClickListener(null);
        } catch (Throwable th) {
            o.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void onPause() {
        PlayerView playerView = this.f11514q;
        if (playerView != null) {
            this.J = playerView.isPlayIng();
            this.f11514q.setIsBTVideoPlaying(this.J);
            this.f11514q.onPause();
        }
    }

    public void onResume() {
        PlayerView playerView = this.f11514q;
        if (playerView != null) {
            playerView.setDesk(true);
            this.f11514q.setIsCovered(false);
            if (this.J) {
                this.f11514q.onResume();
            }
        }
    }

    public void onStop() {
        PlayerView playerView = this.f11514q;
        if (playerView != null) {
            playerView.setIsCovered(true);
        }
    }

    public void pause() {
        try {
            if (this.f11514q != null) {
                this.f11514q.pause();
                if (this.f11519v != null) {
                    BTBaseView.a(this.f11519v, "onPlayerPause", this.f11550d);
                }
            }
        } catch (Exception e2) {
            o.b(BTBaseView.TAG, e2.getMessage(), e2);
        }
    }

    public void play() {
        try {
            if (this.K) {
                if (this.D) {
                    this.f11514q.playVideo(0);
                    this.D = false;
                } else {
                    this.f11514q.start(false);
                }
                if (this.f11519v != null) {
                    BTBaseView.a(this.f11519v, "onPlayerPlay", this.f11550d);
                    return;
                }
                return;
            }
            if (this.E == 1) {
                playMute();
            } else {
                playUnMute();
            }
            if (!this.f11514q.playVideo()) {
                o.d("MediaPlayer", "播放失败");
                if (this.A != null) {
                    this.A.onPlayError("play video failed");
                }
            }
            this.K = true;
            if (this.f11519v != null) {
                BTBaseView.a(this.f11519v, "onPlayerPlay", this.f11550d);
            }
        } catch (Exception e2) {
            o.b(BTBaseView.TAG, e2.getMessage(), e2);
        }
    }

    public boolean playMute() {
        try {
            if (this.f11514q != null && this.f11519v != null) {
                this.f11514q.closeSound();
                this.f11515r.setSoundStatus(false);
                this.B = 1;
                BTBaseView.a(this.f11519v, "onPlayerMute", this.f11550d);
                return true;
            }
        } catch (Exception e2) {
            o.d(BTBaseView.TAG, e2.getMessage());
        }
        return false;
    }

    public boolean playUnMute() {
        try {
            if (this.f11514q == null || this.f11519v == null) {
                return false;
            }
            this.f11514q.openSound();
            this.f11515r.setSoundStatus(true);
            this.B = 2;
            BTBaseView.a(this.f11519v, "onUnmute", this.f11550d);
            return true;
        } catch (Exception e2) {
            o.d(BTBaseView.TAG, e2.getMessage());
            return false;
        }
    }

    public void preLoadData() {
        String str;
        if (this.b.w() == 94 || this.b.w() == 287) {
            str = this.b.Z() + this.b.aZ() + this.b.S();
        } else {
            str = this.b.aZ() + this.b.S() + this.b.B();
        }
        c cVarA = e.a().a(this.f11549c, str);
        if (cVarA != null) {
            this.f11520w = cVarA;
        }
        this.C = e();
        this.G = d();
        if (this.f11554h && !TextUtils.isEmpty(this.G) && this.b != null) {
            this.A = new a(this, this.f11519v);
            a aVar = this.A;
            com.anythink.expressad.foundation.d.c cVar = this.b;
            int iV = (cVar == null || cVar.ao() == -1) ? com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.f11549c, false).v() : cVar.ao();
            aVar.a(iV, com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.f11549c, false).x());
            this.f11514q.setDesk(false);
            this.f11514q.initBufferIngParam(this.C);
            this.f11514q.initVFPData(this.G, this.b.S(), this.b.ao(), this.A);
            soundOperate(this.B, -1, null);
        }
        H = false;
    }

    public void resume() {
        try {
            if (this.f11514q != null) {
                if (this.D) {
                    this.f11514q.playVideo(0);
                    this.D = false;
                } else {
                    this.f11514q.onResume();
                }
                if (this.f11519v != null) {
                    BTBaseView.a(this.f11519v, "onPlayerResume", this.f11550d);
                }
            }
        } catch (Exception e2) {
            o.d(BTBaseView.TAG, e2.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void setCampaign(com.anythink.expressad.foundation.d.c cVar) {
        super.setCampaign(cVar);
        if (cVar == null || cVar.i() <= 0) {
            this.f11516s.setBackgroundResource(i.a(n.a().g(), "anythink_reward_shape_progress", i.f10645c));
            this.f11516s.setWidth(t.b(n.a().g(), 30.0f));
            return;
        }
        this.f11516s.setBackgroundResource(i.a(n.a().g(), "anythink_reward_video_time_count_num_bg", i.f10645c));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, t.b(n.a().g(), 30.0f));
        int iB = t.b(n.a().g(), 5.0f);
        layoutParams.setMargins(iB, 0, 0, 0);
        this.f11516s.setPadding(iB, 0, iB, 0);
        this.f11516s.setLayoutParams(layoutParams);
    }

    public void setCloseViewVisable(int i2) {
        this.f11517t.setVisibility(i2 == 0 ? 4 : 0);
    }

    public void setCountDownTextViewVisable(int i2) {
        this.f11516s.setVisibility(i2 == 0 ? 4 : 0);
    }

    public void setCreateWebView(WebView webView) {
        this.f11519v = webView;
    }

    public void setNotchPadding(int i2, int i3, int i4, int i5) {
        if (i2 <= 0) {
            i2 = this.L.getPaddingLeft();
        }
        if (i3 <= 0) {
            i3 = this.L.getPaddingRight();
        }
        if (i4 <= 0) {
            i4 = this.L.getPaddingTop();
        }
        if (i5 <= 0) {
            i5 = this.L.getPaddingBottom();
        }
        o.d(BTBaseView.TAG, "NOTCH BTVideoView " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)));
        this.L.setPadding(i2, i4, i3, i5);
    }

    public void setOrientation(int i2) {
        this.F = i2;
    }

    public void setPlaybackParams(float f2) {
        PlayerView playerView = this.f11514q;
        if (playerView != null) {
            playerView.setPlaybackParams(f2);
        }
    }

    public void setProgressBarState(int i2) {
        ProgressBar progressBar = this.M;
        if (progressBar != null) {
            progressBar.setVisibility(i2 == 0 ? 8 : 0);
        }
    }

    public void setShowClose(int i2) {
        this.f11522y = i2;
    }

    public void setShowMute(int i2) {
        this.f11523z = i2;
    }

    public void setShowTime(int i2) {
        this.f11521x = i2;
    }

    public void setSoundImageViewVisble(int i2) {
        this.f11515r.setVisibility(i2 == 0 ? 4 : 0);
    }

    public void setVolume(float f2, float f3) {
        PlayerView playerView = this.f11514q;
        if (playerView != null) {
            playerView.setVolume(f2, f3);
        }
    }

    public void soundOperate(int i2, int i3, String str) {
        if (this.f11554h) {
            this.B = i2;
            if (i2 == 1) {
                this.f11515r.setSoundStatus(false);
                this.f11514q.closeSound();
            } else if (i2 == 2) {
                this.f11515r.setSoundStatus(true);
                this.f11514q.openSound();
            }
            if (i3 == 1) {
                this.f11515r.setVisibility(8);
            } else if (i3 == 2) {
                this.f11515r.setVisibility(0);
            }
        }
    }

    public void stop() {
        try {
            if (this.f11514q != null) {
                this.f11514q.pause();
                this.f11514q.stop();
                try {
                    this.f11514q.prepare();
                    this.f11514q.justSeekTo(0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (this.f11519v != null) {
                    BTBaseView.a(this.f11519v, "onPlayerStop", this.f11550d);
                }
            }
        } catch (Exception e3) {
            o.b(BTBaseView.TAG, e3.getMessage(), e3);
        }
    }

    private boolean b() {
        try {
            this.f11514q = (PlayerView) findViewById(findID("anythink_vfpv"));
            this.f11515r = (SoundImageView) findViewById(findID("anythink_sound_switch"));
            this.f11516s = (TextView) findViewById(findID("anythink_tv_count"));
            this.f11517t = findViewById(findID("anythink_rl_playing_close"));
            this.L = (RelativeLayout) findViewById(findID("anythink_top_control"));
            this.M = (ProgressBar) findViewById(findID("anythink_video_progress_bar"));
            this.f11514q.setIsBTVideo(true);
            this.f11518u = (FeedBackButton) findViewById(findID("anythink_native_endcard_feed_btn"));
            return isNotNULL(this.f11514q, this.f11515r, this.f11516s, this.f11517t);
        } catch (Throwable th) {
            o.b(BTBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    private void c() {
        String str;
        if (this.b.w() == 94 || this.b.w() == 287) {
            str = this.b.Z() + this.b.aZ() + this.b.S();
        } else {
            str = this.b.aZ() + this.b.S() + this.b.B();
        }
        c cVarA = e.a().a(this.f11549c, str);
        if (cVarA != null) {
            this.f11520w = cVarA;
        }
    }

    private String d() {
        String strS = "";
        try {
            strS = this.b.S();
            if (this.f11520w == null || this.f11520w.k() != 5) {
                return strS;
            }
            String strE = this.f11520w.e();
            return !w.a(strE) ? new File(strE).exists() ? strE : strS : strS;
        } catch (Throwable th) {
            o.b(BTBaseView.TAG, th.getMessage(), th);
            return strS;
        }
    }

    private static int e() {
        try {
            com.anythink.expressad.videocommon.e.a aVarB = com.anythink.expressad.videocommon.e.c.a().b();
            if (aVarB == null) {
                com.anythink.expressad.videocommon.e.c.a();
                com.anythink.expressad.videocommon.e.c.c();
            }
            iG = aVarB != null ? (int) aVarB.g() : 5;
            o.b(BTBaseView.TAG, "AnythinkBaseView buffetTimeout:".concat(String.valueOf(iG)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return iG;
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    protected final void a() {
        super.a();
        if (this.f11554h) {
            this.f11515r.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTVideoView.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    boolean zIsSilent = AnythinkBTVideoView.this.f11514q.isSilent();
                    if (AnythinkBTVideoView.this.f11519v != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("code", BTBaseView.f11546n);
                            jSONObject.put("id", AnythinkBTVideoView.this.f11550d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("mute", AnythinkBTVideoView.this.B);
                            jSONObject.put("data", jSONObject2);
                            j.a();
                            j.a(AnythinkBTVideoView.this.f11519v, "onPlayerMuteBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                            o.a("OperateViews", "onPlayerMuteBtnClicked isMute = " + zIsSilent + " mute = " + AnythinkBTVideoView.this.B);
                        } catch (Exception e2) {
                            com.anythink.expressad.video.bt.a.c.a();
                            com.anythink.expressad.video.bt.a.c.a(AnythinkBTVideoView.this.f11519v, e2.getMessage());
                        }
                    }
                }
            });
            this.f11517t.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTVideoView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (AnythinkBTVideoView.this.f11519v != null) {
                        BTBaseView.a(AnythinkBTVideoView.this.f11519v, "onPlayerCloseBtnClicked", AnythinkBTVideoView.this.f11550d);
                    }
                }
            });
            setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTVideoView.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (AnythinkBTVideoView.this.f11519v != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("code", BTBaseView.f11546n);
                            jSONObject.put("id", AnythinkBTVideoView.this.f11550d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("x", String.valueOf(view.getX()));
                            jSONObject2.put("y", String.valueOf(view.getY()));
                            jSONObject.put("data", jSONObject2);
                            j.a();
                            j.a(AnythinkBTVideoView.this.f11519v, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        } catch (Exception unused) {
                            com.anythink.expressad.video.bt.a.c.a();
                            com.anythink.expressad.video.bt.a.c.a(AnythinkBTVideoView.this.f11519v, "onClicked", AnythinkBTVideoView.this.f11550d);
                        }
                    }
                }
            });
        }
    }

    private int a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            if (cVar.ao() != -1) {
                return cVar.ao();
            }
            return com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.f11549c, false).v();
        }
        return com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.f11549c, false).v();
    }

    public AnythinkBTVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11521x = 0;
        this.f11522y = 0;
        this.f11523z = 0;
        this.B = 2;
        this.D = false;
        this.E = 2;
        this.F = 1;
        this.I = false;
        this.J = false;
        this.K = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i2, int i3) {
        if (i3 != 0) {
            double d2 = i2 / i3;
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(t.a(Double.valueOf(d2)));
                return sb.toString();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return String.valueOf(i3);
    }
}
