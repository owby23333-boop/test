package com.bytedance.adsdk.ugeno.dl;

/* JADX INFO: loaded from: classes2.dex */
public enum p {
    UNKNOWN_EVENT("UNKNOWN_EVENT", 0),
    TAP_EVENT("onTap", 1),
    LONG_TAP_EVENT("onLongTap", 2),
    SHAKE_EVENT("onShake", 3),
    TWIST_EVENT("onTwist", 18),
    SLIDE_EVENT("onSlide", 4),
    EXPOSURE_EVENT("onExposure", 5),
    SCROLL_EVENT("onScroll", 6),
    PULL_TO_REFRESH_EVENT("onPullToRefresh", 7),
    LOAD_MORE_EVENT("onLoadMore", 8),
    TIMER("onTimer", 9),
    DELAY("onDelay", 10),
    ANIMATION("onAnimation", 11),
    VIDEO_PROGRESS("onVideoProgress", 12),
    VIDEO_PAUSE("onVideoPause", 13),
    VIDEO_RESUME("onVideoResume", 14),
    VIDEO_FINISH("onVideoFinish", 15),
    VIDEO_PLAY("onVideoPlay", 16),
    DOWN_EVENT("onDown", 17),
    RENDER_SUCCESS("onRenderSuccess", 22);

    private int iq;
    private String q;

    p(String str, int i) {
        this.q = str;
        this.iq = i;
    }

    public int getType() {
        return this.iq;
    }

    public static p z(String str) {
        for (p pVar : values()) {
            if (pVar.q.equals(str)) {
                return pVar;
            }
        }
        return UNKNOWN_EVENT;
    }
}
