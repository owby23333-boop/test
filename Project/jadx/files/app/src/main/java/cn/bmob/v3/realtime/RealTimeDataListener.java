package cn.bmob.v3.realtime;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface RealTimeDataListener {
    void onConnectCompleted(Client client, Exception exc);

    void onDataChange(Client client, JSONObject jSONObject);

    void onDisconnectCompleted(Client client);
}
