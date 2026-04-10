package cn.bmob.v3.listener;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface ValueEventListener {
    void onConnectCompleted(Exception exc);

    void onDataChange(JSONObject jSONObject);
}
