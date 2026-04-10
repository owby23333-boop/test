package com.amgcyo.cuttadon.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.anythink.expressad.exoplayer.k.o;
import com.fatcatfat.io.R;
import com.umeng.message.entity.UMessage;
import java.io.File;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class MkReaderTtsService extends Service {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f4348v = MkReaderTtsService.class.getSimpleName();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private MediaPlayer f4349s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private AudioManager f4350t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private AudioManager.OnAudioFocusChangeListener f4351u = new a();

    class a implements AudioManager.OnAudioFocusChangeListener {
        a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            if (i2 == -3) {
                String unused = MkReaderTtsService.f4348v;
                return;
            }
            if (i2 == -2) {
                String unused2 = MkReaderTtsService.f4348v;
                return;
            }
            if (i2 == -1) {
                String unused3 = MkReaderTtsService.f4348v;
                MkReaderTtsService.this.f4350t.abandonAudioFocus(MkReaderTtsService.this.f4351u);
            } else {
                if (i2 != 1) {
                    return;
                }
                String unused4 = MkReaderTtsService.f4348v;
                try {
                    MkReaderTtsService.this.e();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "tts_bgm")
    private void changeTtsBgm(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("changeTtsBgmchangeTtsBgm:");
        sb.append(this.f4349s == null);
        sb.toString();
        if (this.f4349s != null) {
            String str = "bgmType:" + i2;
            if (this.f4349s.isPlaying()) {
                this.f4349s.stop();
            }
            if (i2 == 0) {
                this.f4349s = MediaPlayer.create(getApplicationContext(), R.raw.music);
            } else {
                d();
            }
            MediaPlayer mediaPlayer = this.f4349s;
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(true);
            }
            e();
        }
    }

    private void d() {
        File fileC = c();
        if (fileC == null || !fileC.exists()) {
            this.f4349s = MediaPlayer.create(getApplicationContext(), R.raw.gaoshanliushui);
            return;
        }
        String str = "PATH:" + fileC.getAbsolutePath();
        try {
            if (this.f4349s == null) {
                this.f4349s = new MediaPlayer();
            }
            if (this.f4349s.isPlaying()) {
                this.f4349s.pause();
            }
            this.f4349s.reset();
            this.f4349s.setDataSource(fileC.getAbsolutePath());
            this.f4349s.prepare();
        } catch (Exception unused) {
            this.f4349s = MediaPlayer.create(getApplicationContext(), R.raw.gaoshanliushui);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        MediaPlayer mediaPlayer = this.f4349s;
        if (mediaPlayer == null || mediaPlayer.isPlaying()) {
            return;
        }
        this.f4350t.getStreamMaxVolume(3);
        float fA = g0.a().a("tts_bgm_volume_float", 0.1f);
        this.f4349s.setVolume(fA, fA);
        this.f4349s.start();
    }

    private void f() {
        MediaPlayer mediaPlayer = this.f4349s;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            startForeground(InputDeviceCompat.SOURCE_DPAD, b());
        }
        g.s0();
        EventBus.getDefault().register(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f();
        stopForeground(true);
        EventBus.getDefault().unregister(this);
        String str = f4348v + "---->onCreate,停止服务";
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        this.f4350t = (AudioManager) getSystemService(o.b);
        AudioManager audioManager = this.f4350t;
        if (audioManager != null) {
            audioManager.requestAudioFocus(this.f4351u, 3, 1);
        }
        if ((intent != null ? intent.getIntExtra("reader_tts_bgm", 0) : 0) == 0) {
            this.f4349s = MediaPlayer.create(getApplicationContext(), R.raw.music);
        } else {
            d();
        }
        MediaPlayer mediaPlayer = this.f4349s;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(true);
        }
        e();
        return 1;
    }

    private Notification b() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("notification_channel_id_tts", "语音听书通知", 2);
            notificationChannel.setDescription("用于后台语音听书");
            notificationChannel.setVibrationPattern(new long[]{0});
            notificationChannel.enableVibration(false);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "notification_channel_id_tts");
        builder.setVibrate(new long[]{0});
        builder.setSmallIcon(R.mipmap.app_logo);
        builder.setContentTitle(com.amgcyo.cuttadon.f.o.d(R.string.app_name));
        builder.setContentText("正在语音朗读...");
        builder.setWhen(System.currentTimeMillis());
        return builder.build();
    }

    private File c() {
        String strD = g0.a().d("tts_mp3_path");
        if (TextUtils.isEmpty(strD)) {
            return null;
        }
        return new File(strD);
    }
}
