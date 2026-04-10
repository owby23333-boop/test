package com.kwad.components.core.webview.tachikoma.e;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private List<Integer> ahH;
    private final List<Integer> ahI;

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.ahH = new ArrayList();
        this.ahI = Arrays.asList(123, Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO), Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY), Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME), Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH), 200);
    }

    /* JADX INFO: renamed from: com.kwad.components.core.webview.tachikoma.e.a$a, reason: collision with other inner class name */
    static class C0363a {
        private static final a ahM = new a(0);
    }

    public static a vI() {
        return C0363a.ahM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(int i) {
        if (this.ahI.contains(Integer.valueOf(i))) {
            this.ahH.add(Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(String str) {
        int iOptInt;
        try {
            iOptInt = new JSONObject(str).optInt("elementType");
        } catch (Exception unused) {
            iOptInt = Integer.MAX_VALUE;
        }
        if (this.ahI.contains(Integer.valueOf(iOptInt))) {
            this.ahH.add(Integer.valueOf(iOptInt));
        }
    }

    public final void bm(final int i) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.e.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.bl(i);
            }
        });
    }

    public final void bi(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.e.a.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.bh(str);
            }
        });
    }

    public final List<Integer> vJ() {
        return this.ahH;
    }

    public final void vK() {
        this.ahH.clear();
    }
}
