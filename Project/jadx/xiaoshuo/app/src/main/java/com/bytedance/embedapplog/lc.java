package com.bytedance.embedapplog;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.market.sdk.utils.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class lc extends k {
    private final Context ga;

    public lc(Context context) {
        super(true, false);
        this.ga = context;
    }

    @Override // com.bytedance.embedapplog.k
    public boolean e(JSONObject jSONObject) throws JSONException {
        String str;
        DisplayMetrics displayMetrics = this.ga.getResources().getDisplayMetrics();
        int i = displayMetrics.densityDpi;
        switch (i) {
            case 120:
                str = "ldpi";
                break;
            case 240:
                str = "hdpi";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
            case 280:
            case 300:
            case MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME /* 320 */:
                str = "xhdpi";
                break;
            case 340:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL /* 360 */:
            case 400:
            case TypedValues.CycleType.TYPE_EASING /* 420 */:
            case 440:
            case 480:
                str = "xxhdpi";
                break;
            case 560:
            case 640:
                str = "xxxhdpi";
                break;
            default:
                str = "mdpi";
                break;
        }
        jSONObject.put("density_dpi", i);
        jSONObject.put("display_density", str);
        jSONObject.put(Constants.JSON_RESOLUTION, displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        return true;
    }
}
