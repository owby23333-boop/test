package cn.bmob.v3.realtime;

import cn.bmob.v3.realtime.Client;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class RealTimeDataManager {
    private static RealTimeDataManager mInstance;

    private RealTimeDataManager() {
    }

    public static RealTimeDataManager getInstance() {
        if (mInstance == null) {
            mInstance = new RealTimeDataManager();
        }
        return mInstance;
    }

    public void start(final RealTimeDataListener realTimeDataListener) {
        new Client().connect(new Client.ClientListener() { // from class: cn.bmob.v3.realtime.RealTimeDataManager.1
            @Override // cn.bmob.v3.realtime.Client.ClientListener
            public void onConnectCompleted(Client client, Exception exc) {
                realTimeDataListener.onConnectCompleted(client, exc);
            }

            @Override // cn.bmob.v3.realtime.Client.ClientListener
            public void onDataChange(Client client, JSONObject jSONObject) {
                realTimeDataListener.onDataChange(client, jSONObject);
            }

            @Override // cn.bmob.v3.realtime.Client.ClientListener
            public void onDisconnectCompleted(Client client) {
                realTimeDataListener.onDisconnectCompleted(client);
            }
        });
    }
}
