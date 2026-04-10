package com.bytedance.sdk.openadsdk.ats;

import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.bytedance.sdk.component.a.z;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.bytedance.sdk.component.panglearmor.e;
import com.bytedance.sdk.component.panglearmor.fo;
import com.bytedance.sdk.component.panglearmor.g.a;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements com.bytedance.sdk.component.a.z, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return encrypt((byte[]) sparseArray.get(1));
            case 2:
                return Boolean.valueOf(getArmorLoadStatus());
            case 3:
                return decryptWithCBC((String) sparseArray.get(1));
            case 4:
                return decrypt((byte[]) sparseArray.get(1));
            case 5:
                return Boolean.valueOf(signVerifyMD5withRSA((String) sparseArray.get(1), (String) sparseArray.get(2)));
            case 6:
                return Boolean.valueOf(detectHostLocalIp((String) sparseArray.get(1)));
            case 7:
                return getSoftChara();
            case 8:
                pglArmorCallApi2c((MotionEvent) sparseArray.get(1));
                return null;
            case 9:
                return pglArmorCallApi2ccc((String) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue(), ((Integer) sparseArray.get(3)).intValue(), ((Boolean) sparseArray.get(4)).booleanValue());
            case 10:
                pglArmorCallApi2src(((Long) sparseArray.get(1)).longValue(), ((Integer) sparseArray.get(2)).intValue());
                return null;
            case 11:
                return pglArmorCallApi2getProperty((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 12:
                return getArmorContext();
            case 13:
                return getArchEnv();
            case 14:
                setBlt(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 15:
                softDecTool2ua(((Double) sparseArray.get(1)).doubleValue(), ((Long) sparseArray.get(2)).longValue());
                return null;
            case 16:
                Object gVar = sparseArray.get(1);
                if (gVar != null) {
                    gVar = new com.bytedance.sdk.component.a.g((Function) gVar);
                }
                setHARSensorCallBack((z.InterfaceC0115z) gVar);
                return null;
            case 17:
                return Boolean.valueOf(registerHarSensors());
            case 18:
                Object dlVar = sparseArray.get(1);
                if (dlVar != null) {
                    dlVar = new com.bytedance.sdk.component.a.dl((Function) dlVar);
                }
                initPglArmorCallApi((z.g) dlVar);
                return null;
            case 19:
                pglArmorCallApiCancelListener();
                return null;
            case 20:
                updateScreenStatus((String) sparseArray.get(1));
                return null;
            case 21:
                updateNetworkStatus(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 22:
                return Integer.valueOf(getSpecificArmorLoadStatus());
            case 23:
                updateHARSettings((JSONObject) sparseArray.get(1));
                return null;
            case 24:
                initPglCryptUtils();
                return null;
            case 25:
                return Boolean.valueOf(enableSetHARSensorCallBack(((Integer) sparseArray.get(1)).intValue()));
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.component.a.z
    public byte[] encrypt(byte[] bArr) {
        return fo.z().z(bArr);
    }

    @Override // com.bytedance.sdk.component.a.z
    public boolean getArmorLoadStatus() {
        return fo.g();
    }

    @Override // com.bytedance.sdk.component.a.z
    public String decryptWithCBC(String str) {
        return fo.z().z(str);
    }

    @Override // com.bytedance.sdk.component.a.z
    public byte[] decrypt(byte[] bArr) {
        return fo.z().g(bArr);
    }

    @Override // com.bytedance.sdk.component.a.z
    public boolean signVerifyMD5withRSA(String str, String str2) throws Exception {
        return com.bytedance.sdk.component.panglearmor.a.z(str, str2);
    }

    @Override // com.bytedance.sdk.component.a.z
    public boolean detectHostLocalIp(String str) {
        return com.bytedance.sdk.component.panglearmor.a.z(str);
    }

    @Override // com.bytedance.sdk.component.a.z
    public String getSoftChara() {
        return com.bytedance.sdk.component.panglearmor.m.g();
    }

    @Override // com.bytedance.sdk.component.a.z
    public void pglArmorCallApi2c(MotionEvent motionEvent) {
        com.bytedance.sdk.component.panglearmor.m.z(motionEvent);
    }

    @Override // com.bytedance.sdk.component.a.z
    public String pglArmorCallApi2ccc(String str, long j, int i, boolean z) {
        return com.bytedance.sdk.component.panglearmor.m.z(str, j, i, z);
    }

    @Override // com.bytedance.sdk.component.a.z
    public void pglArmorCallApi2src(long j, int i) {
        com.bytedance.sdk.component.panglearmor.m.z(j, i);
    }

    @Override // com.bytedance.sdk.component.a.z
    public String pglArmorCallApi2getProperty(String str, String str2) {
        return com.bytedance.sdk.component.panglearmor.m.z(str, str2);
    }

    @Override // com.bytedance.sdk.component.a.z
    public Context getArmorContext() {
        return com.bytedance.sdk.component.panglearmor.m.a();
    }

    @Override // com.bytedance.sdk.component.a.z
    public String getArchEnv() {
        return com.bytedance.sdk.component.panglearmor.m.dl();
    }

    @Override // com.bytedance.sdk.component.a.z
    public void setBlt(boolean z) {
        SoftDecTool.setBlt(z);
    }

    @Override // com.bytedance.sdk.component.a.z
    public void softDecTool2ua(double d, long j) {
        SoftDecTool.ua(d, j);
        new Object[]{"predict probability ", Double.valueOf(SoftDecTool.acs)};
    }

    @Override // com.bytedance.sdk.component.a.z
    public void setHARSensorCallBack(final z.InterfaceC0115z interfaceC0115z) {
        com.bytedance.sdk.component.panglearmor.g.a.z().z(new a.z() { // from class: com.bytedance.sdk.openadsdk.ats.g.1
            @Override // com.bytedance.sdk.component.panglearmor.g.a.z
            public void z(JSONObject jSONObject) {
                interfaceC0115z.reportSensorData(jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.component.a.z
    public boolean registerHarSensors() {
        return com.bytedance.sdk.component.panglearmor.g.a.z().g();
    }

    @Override // com.bytedance.sdk.component.a.z
    public void initPglArmorCallApi(final z.g gVar) {
        e.z zVarZ = new e.z(zw.getContext(), gk.m(), "7105").z(true);
        zVarZ.z(new com.bytedance.sdk.component.panglearmor.gz() { // from class: com.bytedance.sdk.openadsdk.ats.g.2
            @Override // com.bytedance.sdk.component.panglearmor.gz
            public void z(long j, boolean z) {
                gVar.setCryptInitStatus(j, z);
            }

            @Override // com.bytedance.sdk.component.panglearmor.gz
            public void z(String str, JSONObject jSONObject) {
                gVar.reportSoftDecData(str, jSONObject);
            }
        });
        com.bytedance.sdk.component.panglearmor.m.z(zVarZ.z());
    }

    @Override // com.bytedance.sdk.component.a.z
    public void pglArmorCallApiCancelListener() {
        com.bytedance.sdk.component.panglearmor.m.z();
    }

    @Override // com.bytedance.sdk.component.a.z
    public void updateScreenStatus(String str) {
        com.bytedance.sdk.component.panglearmor.g.g.z().g(str);
    }

    @Override // com.bytedance.sdk.component.a.z
    public void updateNetworkStatus(int i) {
        com.bytedance.sdk.component.panglearmor.g.g.z().z(i);
    }

    @Override // com.bytedance.sdk.component.a.z
    public int getSpecificArmorLoadStatus() {
        return fo.dl();
    }

    @Override // com.bytedance.sdk.component.a.z
    public void updateHARSettings(JSONObject jSONObject) {
        com.bytedance.sdk.component.panglearmor.g.gc.z().z(jSONObject);
    }

    @Override // com.bytedance.sdk.component.a.z
    public void initPglCryptUtils() {
        fo.z();
    }

    @Override // com.bytedance.sdk.component.a.z
    public boolean enableSetHARSensorCallBack(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zG = com.bytedance.sdk.component.panglearmor.g.gc.z().g();
        boolean z = ((long) (i - 1)) % com.bytedance.sdk.component.panglearmor.g.gc.z().gc() == 0;
        boolean z2 = jCurrentTimeMillis - com.bytedance.sdk.component.panglearmor.g.a.z().a() > com.bytedance.sdk.component.panglearmor.g.gc.z().a();
        boolean zDl = com.bytedance.sdk.component.panglearmor.g.a.z().dl();
        com.bytedance.sdk.component.panglearmor.g.gc.z();
        com.bytedance.sdk.component.panglearmor.g.gc.z();
        com.bytedance.sdk.component.panglearmor.g.gc.z();
        com.bytedance.sdk.component.panglearmor.g.gc.z();
        double d = SoftDecTool.acs;
        long j = SoftDecTool.act;
        return z && z2 && zG && !zDl;
    }
}
