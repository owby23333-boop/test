package com.bytedance.msdk.api;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class TTRequestExtraParams {
    public static final int AD_VIDEO_PLAY_MUTE = 1;
    public static final int AD_VIDEO_PLAY_NOT_MUTE = 2;
    public static final String PARAM_AD_HEIGHT = "ad_height";
    public static final String PARAM_AD_LOAD_TIMEOUT = "ad_load_timeout";
    public static final String PARAM_AD_MUTE = "ad_mute";
    public static final String PARAM_AD_TYPE = "ad_type";
    public static final String PARAM_AD_WIDTH = "ad_width";
    public static final String PARAM_BANNER_ALLOW_SHOW_CLOSE_BTN = "allow_show_close_btn";
    protected Map<String, Object> a;

    public TTRequestExtraParams() {
        this.a = null;
        this.a = new HashMap();
    }

    public Map<String, Object> getExtraObject() {
        Map<String, Object> map = this.a;
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap();
        this.a = map2;
        return map2;
    }

    public TTRequestExtraParams setExtraObject(String str, Object obj) {
        Map<String, Object> map = this.a;
        if (map != null) {
            map.put(str, obj);
        }
        return this;
    }
}
