package com.bytedance.sdk.component.a;

import android.content.Context;
import android.view.MotionEvent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface z {

    public interface g {
        void reportSoftDecData(String str, JSONObject jSONObject);

        void setCryptInitStatus(long j, boolean z);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.a.z$z, reason: collision with other inner class name */
    public interface InterfaceC0115z {
        void reportSensorData(JSONObject jSONObject);
    }

    byte[] decrypt(byte[] bArr);

    String decryptWithCBC(String str);

    boolean detectHostLocalIp(String str);

    boolean enableSetHARSensorCallBack(int i);

    byte[] encrypt(byte[] bArr);

    String getArchEnv();

    Context getArmorContext();

    boolean getArmorLoadStatus();

    String getSoftChara();

    int getSpecificArmorLoadStatus();

    void initPglArmorCallApi(g gVar);

    void initPglCryptUtils();

    void pglArmorCallApi2c(MotionEvent motionEvent);

    String pglArmorCallApi2ccc(String str, long j, int i, boolean z);

    String pglArmorCallApi2getProperty(String str, String str2);

    void pglArmorCallApi2src(long j, int i);

    void pglArmorCallApiCancelListener();

    boolean registerHarSensors();

    void setBlt(boolean z);

    void setHARSensorCallBack(InterfaceC0115z interfaceC0115z);

    boolean signVerifyMD5withRSA(String str, String str2) throws Exception;

    void softDecTool2ua(double d, long j);

    void updateHARSettings(JSONObject jSONObject);

    void updateNetworkStatus(int i);

    void updateScreenStatus(String str);
}
