package com.bytedance.embedapplog;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class jq extends gp {
    private final Context gc;

    jq(Context context) {
        super(true, false);
        this.gc = context;
    }

    @Override // com.bytedance.embedapplog.gp
    protected boolean z(JSONObject jSONObject) throws JSONException {
        String str;
        DisplayMetrics displayMetrics = this.gc.getResources().getDisplayMetrics();
        int i = displayMetrics.densityDpi;
        switch (i) {
            case 120:
                str = "ldpi";
                break;
            case 240:
                str = "hdpi";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN /* 280 */:
            case 300:
            case MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME /* 320 */:
                str = "xhdpi";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_NEED_CHECK_DROP_AUDIO /* 340 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL /* 360 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL /* 400 */:
            case TypedValues.Cycle.TYPE_EASING /* 420 */:
            case 440:
            case 480:
                str = "xxhdpi";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ /* 560 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK /* 640 */:
                str = "xxxhdpi";
                break;
            default:
                str = "mdpi";
                break;
        }
        jSONObject.put("density_dpi", i);
        jSONObject.put("display_density", str);
        jSONObject.put(an.z, displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        return true;
    }
}
