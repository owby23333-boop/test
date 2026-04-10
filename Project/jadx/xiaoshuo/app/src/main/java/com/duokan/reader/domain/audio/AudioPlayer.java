package com.duokan.reader.domain.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.duokan.reader.DkApp;
import com.duokan.reader.abk.domain.PlayerStatus;
import com.duokan.reader.domain.document.RangeAnchor;
import com.duokan.reader.domain.document.TextAnchor;
import com.yuewen.Cif;
import com.yuewen.df;
import com.yuewen.ig;
import com.yuewen.jg;
import com.yuewen.ni1;
import com.yuewen.xl3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class AudioPlayer extends Binder implements xl3, ni1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioManager f4136a;
    public final String d;
    public jg e;
    public jg f;
    public df n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MediaPlayer f4137b = null;
    public int g = -1;
    public PlayerStatus i = PlayerStatus.IDLE;
    public final AudioManager.OnAudioFocusChangeListener k = new a();
    public long m = -1;
    public String c = "";
    public e l = new e();
    public Map<Integer, jg[]> h = new HashMap();
    public LinkedList<Cif> j = new LinkedList<>();

    public class a implements AudioManager.OnAudioFocusChangeListener {
        public a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (i == -1) {
                AudioPlayer.v().r();
            } else if (i == 1) {
                AudioPlayer.v().u();
            }
        }
    }

    public class b implements MediaPlayer.OnSeekCompleteListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            AudioPlayer.this.l.sendEmptyMessage(0);
        }
    }

    public class c implements MediaPlayer.OnCompletionListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            AudioPlayer.this.E();
        }
    }

    public class d implements MediaPlayer.OnPreparedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jg f4141a;

        public d(jg jgVar) {
            this.f4141a = jgVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            AudioPlayer.this.F(PlayerStatus.PLAYING);
            AudioPlayer.this.f4137b.seekTo(Math.round(this.f4141a.d() * 1000.0f));
            AudioPlayer.this.f4137b.start();
        }
    }

    public class e extends Handler {
        public e() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (!AudioPlayer.this.isPlaying() || AudioPlayer.this.f4137b == null) {
                return;
            }
            int currentPosition = AudioPlayer.this.f4137b.getCurrentPosition();
            long jMax = 1000;
            if (currentPosition <= 0) {
                AudioPlayer.this.l.sendEmptyMessageDelayed(0, 1000L);
                return;
            }
            jg jgVarX = AudioPlayer.this.x(currentPosition);
            if (jgVarX == null) {
                AudioPlayer.this.pause();
                AudioPlayer.this.E();
                return;
            }
            if (AudioPlayer.this.e != jgVarX) {
                AudioPlayer.this.B(jgVarX.e());
                AudioPlayer.this.e = jgVarX;
            } else if (AudioPlayer.this.e != null) {
                jMax = Math.max(1000, Math.round(AudioPlayer.this.e.c() * 1000.0f) - AudioPlayer.this.f4137b.getCurrentPosition());
            }
            AudioPlayer.this.l.sendEmptyMessageDelayed(0, jMax);
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AudioPlayer f4144a = new AudioPlayer(DkApp.get());
    }

    public AudioPlayer(Context context) {
        this.f4136a = (AudioManager) context.getSystemService("audio");
        ig igVarD = ig.d();
        this.n = igVarD;
        this.d = igVarD.b();
    }

    public static AudioPlayer v() {
        return f.f4144a;
    }

    public final String A(String str) {
        return this.d + str;
    }

    public final void B(TextAnchor textAnchor) {
        synchronized (this) {
            Iterator<Cif> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().b(textAnchor);
            }
        }
    }

    public final void C(int i) {
        synchronized (this) {
            Iterator<Cif> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().c(i);
            }
        }
    }

    public final void D(PlayerStatus playerStatus) {
        synchronized (this) {
            Iterator<Cif> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().a(playerStatus);
            }
        }
    }

    public final void E() {
        jg jgVarW = w(this.e);
        F(PlayerStatus.IDLE);
        if (jgVarW != null) {
            s(jgVarW);
        } else {
            C(this.g);
        }
    }

    public final void F(PlayerStatus playerStatus) {
        if (playerStatus == this.i) {
            return;
        }
        this.i = playerStatus;
        D(playerStatus);
        if (isPlaying()) {
            this.l.sendEmptyMessage(0);
        } else {
            this.l.removeMessages(0);
        }
    }

    @Override // com.yuewen.ni1
    public void a(Cif cif) {
        synchronized (this) {
            this.j.add(cif);
        }
    }

    @Override // com.yuewen.ni1
    public void b(RangeAnchor rangeAnchor, Integer[] numArr) {
        if (numArr == null || rangeAnchor == null || rangeAnchor.isEmpty()) {
            return;
        }
        int iIntValue = -1;
        jg jgVar = null;
        for (Integer num : numArr) {
            jg[] jgVarArr = this.h.get(num);
            if (jgVarArr != null && jgVarArr.length != 0) {
                int i = 0;
                while (true) {
                    if (i >= jgVarArr.length) {
                        break;
                    }
                    if (jgVarArr[i].e().intersects(rangeAnchor)) {
                        jgVar = jgVarArr[i];
                        iIntValue = num.intValue();
                        break;
                    }
                    i++;
                }
                if (jgVar != null) {
                    break;
                }
            }
        }
        if (jgVar != null) {
            if (this.f4136a.requestAudioFocus(this.k, 3, 1) == 1) {
                s(jgVar);
                this.g = iIntValue;
                return;
            }
            return;
        }
        MediaPlayer mediaPlayer = this.f4137b;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        this.e = null;
        this.c = "";
        this.f = null;
        this.g = -1;
        F(PlayerStatus.IDLE);
    }

    @Override // com.yuewen.ni1
    public void c(jg[] jgVarArr, Integer num, long j) {
        if (jgVarArr == null || jgVarArr.length <= 0) {
            return;
        }
        if (this.m != j) {
            this.h.clear();
            this.m = j;
        }
        if (this.h.containsKey(num)) {
            return;
        }
        this.n.a(jgVarArr, j);
        this.h.put(num, jgVarArr);
    }

    @Override // com.yuewen.ni1
    public TextAnchor d() {
        if (this.e == null || this.f4137b == null) {
            return null;
        }
        if (this.i == PlayerStatus.PAUSE || isPlaying()) {
            return this.e.e();
        }
        return null;
    }

    @Override // com.yuewen.ni1
    public void e(Cif cif) {
        synchronized (this) {
            Iterator<Cif> it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next() == cif) {
                    this.j.remove(cif);
                    break;
                }
            }
        }
    }

    @Override // com.yuewen.ni1
    public Class f() {
        return AudioPlayerService.class;
    }

    @Override // com.yuewen.ni1
    public boolean isPlaying() {
        PlayerStatus playerStatus = this.i;
        return playerStatus == PlayerStatus.PREPARING || playerStatus == PlayerStatus.PLAYING;
    }

    @Override // com.yuewen.ni1
    public void pause() {
        this.f4136a.abandonAudioFocus(this.k);
        r();
    }

    public final void r() {
        if (isPlaying()) {
            F(PlayerStatus.PAUSE);
            this.f4137b.pause();
        }
    }

    @Override // com.yuewen.ni1
    public void resume() {
        if (this.f4136a.requestAudioFocus(this.k, 3, 1) == 1) {
            u();
        }
    }

    public final void s(jg jgVar) {
        if (this.f4137b == null) {
            this.f4137b = new MediaPlayer();
        }
        this.f = jgVar;
        this.n.onStart();
        if (this.c.equals(jgVar.b())) {
            PlayerStatus playerStatus = this.i;
            PlayerStatus playerStatus2 = PlayerStatus.PLAYING;
            if (playerStatus == playerStatus2) {
                this.f4137b.seekTo(Math.round(jgVar.d() * 1000.0f));
                return;
            } else if (playerStatus == PlayerStatus.PAUSE) {
                F(playerStatus2);
                this.f4137b.start();
                this.f4137b.seekTo(Math.round(jgVar.d() * 1000.0f));
                return;
            }
        }
        this.f4137b.reset();
        F(PlayerStatus.PREPARING);
        this.c = jgVar.b();
        this.f4137b.setAudioStreamType(3);
        this.f4137b.setOnSeekCompleteListener(new b());
        this.f4137b.setOnCompletionListener(new c());
        try {
            this.f4137b.setDataSource(A(jgVar.b()));
            this.f4137b.setOnPreparedListener(new d(jgVar));
            this.f4137b.prepareAsync();
        } catch (Exception unused) {
        }
    }

    @Override // com.yuewen.ni1
    public void stop() {
        this.f4136a.abandonAudioFocus(this.k);
        MediaPlayer mediaPlayer = this.f4137b;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f4137b.release();
            this.f4137b = null;
        }
        this.m = -1L;
        this.e = null;
        this.c = "";
        this.h.clear();
        this.g = -1;
        this.f = null;
        F(PlayerStatus.IDLE);
        this.j.clear();
        this.n.onStop();
    }

    public final void u() {
        MediaPlayer mediaPlayer;
        if (this.i != PlayerStatus.PAUSE || (mediaPlayer = this.f4137b) == null) {
            return;
        }
        mediaPlayer.start();
        F(PlayerStatus.PLAYING);
    }

    public final jg w(jg jgVar) {
        int i;
        jg[] jgVarArr;
        if (jgVar == null || (i = this.g) < 0 || (jgVarArr = this.h.get(Integer.valueOf(i))) == null) {
            return null;
        }
        for (jg jgVar2 : jgVarArr) {
            if (jgVar2.e().isAfter(jgVar.e())) {
                return jgVar2;
            }
        }
        return null;
    }

    public final jg x(int i) {
        for (jg[] jgVarArr : this.h.values()) {
            for (jg jgVar : jgVarArr) {
                if (z(jgVar, i, this.c)) {
                    return jgVar;
                }
            }
        }
        return null;
    }

    public boolean y() {
        return d() != null;
    }

    public final boolean z(jg jgVar, int i, String str) {
        float f2 = i / 1000.0f;
        return (this.f == null || !jgVar.e().isBefore(this.f.e())) && jgVar.b().equals(str) && f2 >= jgVar.d() && f2 <= jgVar.c();
    }
}
