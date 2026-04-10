package com.amgcyo.cuttadon.j.h;

import android.app.Activity;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.view.View;
import com.amgcyo.cuttadon.api.entity.other.EngineInfoBean;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.fatcatfat.io.R;
import java.util.HashMap;

/* JADX INFO: compiled from: OldTTSManager.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements e {
    private TextToSpeech a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HashMap<Integer, Long> f4109d = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<String, String> f4110e = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f4111f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f4112g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f4113h = 225;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private f f4114i;

    /* JADX INFO: compiled from: OldTTSManager.java */
    class a extends UtteranceProgressListener {
        a() {
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onDone(String str) {
            d.this.f4114i.a(str);
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onError(String str) {
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onStart(String str) {
            d.this.f4114i.onStart(str);
        }
    }

    /* JADX INFO: compiled from: OldTTSManager.java */
    class b extends UtteranceProgressListener {
        b(d dVar) {
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onDone(String str) {
            String str2 = "pause onDone..." + str;
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onError(String str) {
            String str2 = "pause onError..." + str;
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onStart(String str) {
            String str2 = "pause onStart..." + str;
        }
    }

    private d(final Context context, final f fVar, EngineInfoBean engineInfoBean) {
        this.f4114i = fVar;
        if (this.a != null) {
            release();
        }
        final String page_name = engineInfoBean.getPage_name();
        final String zh_cn_name = engineInfoBean.getZh_cn_name();
        this.a = new TextToSpeech(context, new TextToSpeech.OnInitListener() { // from class: com.amgcyo.cuttadon.j.h.c
            @Override // android.speech.tts.TextToSpeech.OnInitListener
            public final void onInit(int i2) {
                this.a.a(fVar, zh_cn_name, page_name, context, i2);
            }
        }, page_name);
    }

    @Override // com.amgcyo.cuttadon.j.h.e
    public void pause() {
        this.f4112g = System.currentTimeMillis() - this.f4111f;
        this.b = a(this.f4112g);
        this.f4110e.put("utteranceId", com.anythink.expressad.foundation.d.c.cb);
        this.a.speak("", 0, this.f4110e);
        this.a.setOnUtteranceProgressListener(new b(this));
    }

    @Override // com.amgcyo.cuttadon.j.h.e
    public void release() {
        TextToSpeech textToSpeech = this.a;
        if (textToSpeech != null) {
            textToSpeech.shutdown();
            this.a.stop();
        }
    }

    @Override // com.amgcyo.cuttadon.j.h.e
    public void resume() {
        a(this.b, this.f4108c);
    }

    @Override // com.amgcyo.cuttadon.j.h.e
    public void stop() {
        TextToSpeech textToSpeech = this.a;
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
    }

    public /* synthetic */ void a(f fVar, String str, String str2, Context context, int i2) {
        if (i2 != 0) {
            a(context);
        } else {
            fVar.a(i2, str, str2);
            g0.a().b("phone_tts_name", str);
        }
    }

    private void a(final Context context) {
        if (!g.a(MkApplication.getAppContext(), "com.iflytek.vflynote")) {
            o.a(context, "下载【讯飞语记】", "取消", "提示", o.d(R.string.xunfei_tips_msg), new View.OnClickListener() { // from class: com.amgcyo.cuttadon.j.h.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.a(context, view);
                }
            }, (View.OnClickListener) null);
        } else {
            o.a(context, "设置TTS引擎", "取消", "提示", "该功能需要文字转语音服务（TTS）支持。\n请在安装【讯飞语记】后，设置首选TTS引擎为【讯飞语记】", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.j.h.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.e((Activity) context);
                }
            }, (View.OnClickListener) null);
        }
    }

    static /* synthetic */ void a(Context context, View view) {
        o.b("请使用手机自带应用商店进行安装！");
        g.c(context, "com.iflytek.vflynote");
    }

    public static e a(Context context, f fVar, EngineInfoBean engineInfoBean) {
        return new d(context, fVar, engineInfoBean);
    }

    @Override // com.amgcyo.cuttadon.j.h.e
    public void a(String str, String str2) {
        if (this.a == null) {
            return;
        }
        this.b = str;
        this.f4108c = str2;
        this.f4109d.clear();
        this.f4111f = System.currentTimeMillis();
        this.f4110e.put("utteranceId", str2);
        this.a.speak(str, 0, this.f4110e);
        this.a.setOnUtteranceProgressListener(new a());
    }

    @Override // com.amgcyo.cuttadon.j.h.e
    public void a(float f2) {
        TextToSpeech textToSpeech = this.a;
        if (textToSpeech != null) {
            textToSpeech.stop();
            this.a.setSpeechRate(f2);
            long j2 = this.f4113h;
            this.f4113h = j2 + (((long) (f2 - 1.0f)) * j2);
        }
    }

    private String a(long j2) {
        int i2;
        if (this.f4113h == 0) {
            this.f4113h = 225L;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("residenceContent: ");
        sb.append(this.b == null);
        sb.toString();
        String str = this.b;
        if (str == null) {
            return "";
        }
        long j3 = this.f4113h;
        int i3 = (int) (j2 / j3);
        if (j2 > j3 * ((long) str.length()) || (i2 = i3 - 1) == -1) {
            return "";
        }
        this.b = this.b.substring(i2);
        return this.b;
    }
}
