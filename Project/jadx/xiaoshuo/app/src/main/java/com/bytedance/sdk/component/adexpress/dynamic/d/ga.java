package com.bytedance.sdk.component.adexpress.dynamic.d;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.xiaomi.verificationsdk.internal.Constants;
import com.yuewen.qe0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ga {
    public static final Map<String, Integer> e;
    private String bf;
    private String d;
    private vn ga;
    private vn tg;
    private String vn;

    static {
        HashMap map = new HashMap();
        e = map;
        map.put(Constants.ROOT, 8);
        map.put("footer", 6);
        map.put("empty", 6);
        map.put("title", 0);
        map.put(MediaFormat.KEY_SUBTITLE, 0);
        map.put("source", 0);
        map.put("score-count", 0);
        map.put("text_star", 0);
        map.put("text", 0);
        map.put("tag-group", 17);
        map.put("app-version", 0);
        map.put("development-name", 0);
        map.put("privacy-detail", 23);
        map.put("image", 1);
        map.put("image-wide", 1);
        map.put("image-square", 1);
        map.put("image-long", 1);
        map.put("image-splash", 1);
        map.put("image-cover", 1);
        map.put("app-icon", 1);
        map.put("icon-download", 1);
        map.put("logoad", 4);
        map.put("logounion", 5);
        map.put("logo-union", 9);
        map.put("dislike", 3);
        map.put(qe0.c.O, 3);
        map.put("close-fill", 3);
        map.put("webview-close", 22);
        map.put("feedback-dislike", 12);
        map.put("button", 2);
        map.put("downloadWithIcon", 2);
        map.put("downloadButton", 2);
        map.put("fillButton", 2);
        map.put("laceButton", 2);
        map.put("cardButton", 2);
        map.put("colourMixtureButton", 2);
        map.put("arrowButton", 1);
        map.put("download-progress-button", 2);
        map.put("vessel", 6);
        map.put("image-group", 6);
        map.put("custom-component-vessel", 6);
        map.put("carousel", 24);
        map.put("carousel-vessel", 26);
        map.put("leisure-interact", 25);
        map.put("video-hd", 7);
        map.put("video", 7);
        map.put("video-vd", 7);
        map.put("video-sq", 7);
        map.put("muted", 10);
        map.put("star", 11);
        map.put("skip-countdowns", 19);
        map.put("skip-with-countdowns-skip-btn", 21);
        map.put("skip-with-countdowns-video-countdown", 13);
        map.put("skip-with-countdowns-skip-countdown", 20);
        map.put("skip-with-time", 14);
        map.put("skip-with-time-countdown", 13);
        map.put("skip-with-time-skip-btn", 15);
        map.put("skip", 15);
        map.put("timedown", 13);
        map.put("icon", 16);
        map.put("scoreCountWithIcon", 6);
        map.put("split-line", 18);
        map.put("creative-playable-bait", 0);
        map.put("score-count-type-2", 0);
    }

    public String bf() {
        return this.d;
    }

    public void d(String str) {
        this.vn = str;
    }

    public int e() {
        if (TextUtils.isEmpty(this.bf)) {
            return 0;
        }
        if (this.bf.equals("logo")) {
            String str = this.bf + this.d;
            this.bf = str;
            if (str.contains("logoad")) {
                return 4;
            }
            if (this.bf.contains("logounion")) {
                return 5;
            }
        }
        Map<String, Integer> map = e;
        if (map.get(this.bf) != null) {
            return map.get(this.bf).intValue();
        }
        return -1;
    }

    public vn ga() {
        return this.ga;
    }

    public String getType() {
        return this.bf;
    }

    public vn tg() {
        return this.tg;
    }

    public String toString() {
        return "DynamicLayoutBrick{type='" + this.bf + "', data='" + this.d + "', value=" + this.tg + ", themeValue=" + this.ga + ", dataExtraInfo='" + this.vn + "'}";
    }

    public void bf(String str) {
        this.d = str;
    }

    public String d() {
        return this.vn;
    }

    public void bf(vn vnVar) {
        this.ga = vnVar;
    }

    public void e(String str) {
        this.bf = str;
    }

    public void e(vn vnVar) {
        this.tg = vnVar;
    }
}
