package com.umeng.message.entity;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class UMessage {
    public static final String DISPLAY_TYPE_CUSTOM = "custom";
    public static final String DISPLAY_TYPE_NOTIFICATION = "notification";
    public static final String NOTIFICATION_GO_ACTIVITY = "go_activity";
    public static final String NOTIFICATION_GO_APP = "go_app";
    public static final String NOTIFICATION_GO_CUSTOM = "go_custom";
    public static final String NOTIFICATION_GO_URL = "go_url";
    private final JSONObject a;
    public String activity;
    public String after_open;
    public final String alias;
    public String bar_image;
    public int builder_id;
    public String custom;
    public boolean dismiss;
    public final String display_type;
    public String expand_image;
    public Map<String, String> extra;
    public String icon;
    public String img;
    public boolean isAction;
    public String largeIcon;
    public final String message_id;
    public final String msg_id;
    public boolean play_lights;
    public boolean play_sound;
    public boolean play_vibrate;
    public String pulledWho;
    public String pulled_package;
    public String pulled_service;
    public long random_min;
    public String recall;
    public boolean screen_on;
    public String sound;
    public final String task_id;
    public String text;
    public String ticker;
    public String title;
    public String url;

    public UMessage(JSONObject jSONObject) {
        this.a = jSONObject;
        this.message_id = jSONObject.optString("agoo_msg_id");
        this.task_id = jSONObject.optString("agoo_task_id");
        this.msg_id = jSONObject.optString("msg_id");
        this.display_type = jSONObject.optString("display_type");
        this.alias = jSONObject.optString("alias");
        this.random_min = jSONObject.optLong("random_min");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(AgooConstants.MESSAGE_BODY);
        if (jSONObjectOptJSONObject != null) {
            this.ticker = jSONObjectOptJSONObject.optString("ticker");
            this.title = jSONObjectOptJSONObject.optString("title");
            this.text = jSONObjectOptJSONObject.optString("text");
            this.play_vibrate = jSONObjectOptJSONObject.optBoolean("play_vibrate", true);
            this.play_lights = jSONObjectOptJSONObject.optBoolean("play_lights", true);
            this.play_sound = jSONObjectOptJSONObject.optBoolean("play_sound", true);
            this.screen_on = jSONObjectOptJSONObject.optBoolean("screen_on", false);
            this.url = jSONObjectOptJSONObject.optString("url");
            this.img = jSONObjectOptJSONObject.optString("img");
            this.sound = jSONObjectOptJSONObject.optString("sound");
            this.icon = jSONObjectOptJSONObject.optString("icon");
            this.after_open = jSONObjectOptJSONObject.optString("after_open");
            this.largeIcon = jSONObjectOptJSONObject.optString("largeIcon");
            this.activity = jSONObjectOptJSONObject.optString("activity");
            this.custom = jSONObjectOptJSONObject.optString("custom");
            this.recall = jSONObjectOptJSONObject.optString("recall");
            this.bar_image = jSONObjectOptJSONObject.optString("bar_image");
            this.expand_image = jSONObjectOptJSONObject.optString("expand_image");
            this.builder_id = jSONObjectOptJSONObject.optInt("builder_id", 0);
            this.isAction = jSONObjectOptJSONObject.optBoolean("isAction", false);
            this.pulled_service = jSONObjectOptJSONObject.optString("pulled_service");
            this.pulled_package = jSONObjectOptJSONObject.optString("pulled_package");
            this.pulledWho = jSONObjectOptJSONObject.optString("pa");
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("extra");
        if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.length() <= 0) {
            return;
        }
        this.extra = new HashMap();
        Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.extra.put(next, jSONObjectOptJSONObject2.optString(next));
        }
    }

    public JSONObject getRaw() {
        return this.a;
    }

    public boolean hasResourceFromInternet() {
        return isLargeIconFromInternet() || isSoundFromInternet() || !TextUtils.isEmpty(this.bar_image) || !TextUtils.isEmpty(this.expand_image);
    }

    public boolean isLargeIconFromInternet() {
        return !TextUtils.isEmpty(this.img);
    }

    public boolean isSoundFromInternet() {
        return !TextUtils.isEmpty(this.sound) && (this.sound.startsWith("http://") || this.sound.startsWith("https://"));
    }
}
