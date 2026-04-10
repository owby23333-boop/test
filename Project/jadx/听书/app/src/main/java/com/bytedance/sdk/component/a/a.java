package com.bytedance.sdk.component.a;

import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.bytedance.sdk.component.a.z;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements z {
    Function z;

    public a(Function function) {
        this.z = function;
    }

    @Override // com.bytedance.sdk.component.a.z
    public byte[] decrypt(byte[] bArr) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, bArr);
        return (byte[]) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public String decryptWithCBC(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public boolean detectHostLocalIp(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.a.z
    public boolean enableSetHARSensorCallBack(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        sparseArray.put(1, Integer.valueOf(i));
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.a.z
    public byte[] encrypt(byte[] bArr) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, bArr);
        return (byte[]) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public String getArchEnv() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public Context getArmorContext() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (Context) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public boolean getArmorLoadStatus() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.a.z
    public String getSoftChara() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public int getSpecificArmorLoadStatus() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.a.z
    public void initPglArmorCallApi(z.g gVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        if (gVar != null) {
            gVar = new dl(gVar);
        }
        sparseArray.put(1, gVar);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public void initPglCryptUtils() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public void pglArmorCallApi2c(MotionEvent motionEvent) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, motionEvent);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public String pglArmorCallApi2ccc(String str, long j, int i, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, str);
        sparseArray.put(2, Long.valueOf(j));
        sparseArray.put(4, Integer.valueOf(i));
        sparseArray.put(5, Boolean.valueOf(z));
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public String pglArmorCallApi2getProperty(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public void pglArmorCallApi2src(long j, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, Long.valueOf(j));
        sparseArray.put(3, Integer.valueOf(i));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public void pglArmorCallApiCancelListener() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public boolean registerHarSensors() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.a.z
    public void setBlt(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, Boolean.valueOf(z));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public void setHARSensorCallBack(z.InterfaceC0115z interfaceC0115z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        if (interfaceC0115z != null) {
            interfaceC0115z = new g(interfaceC0115z);
        }
        sparseArray.put(1, interfaceC0115z);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public boolean signVerifyMD5withRSA(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.a.z
    public void softDecTool2ua(double d, long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, Double.valueOf(d));
        sparseArray.put(3, Long.valueOf(j));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public void updateHARSettings(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        sparseArray.put(1, jSONObject);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public void updateNetworkStatus(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        sparseArray.put(1, Integer.valueOf(i));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.z
    public void updateScreenStatus(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        sparseArray.put(1, str);
        this.z.apply(sparseArray);
    }
}
