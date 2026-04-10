package com.bytedance.sdk.openadsdk.mediation.init;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.m;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MediationConfigUserInfoForSegment implements Serializable {
    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_UNKNOWN = "unknown";
    private Map<String, String> e;
    public final String TAG = "TTMediationSDK";
    private String z = "";
    private String g = "";
    private String dl = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1469a = 0;
    private String gc = "";
    private String m = "";

    public void setCustomInfos(Map<String, String> map) {
        this.e = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!checkValid(entry.getKey())) {
                    m.gc("TTMediationSDK", "流量分组" + entry.getKey() + "字段存在不合法输入");
                } else if (!checkValid(entry.getValue())) {
                    m.gc("TTMediationSDK", "流量分组" + entry.getKey() + "字段的值" + entry.getValue() + "存在不合法输入");
                } else {
                    this.e.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public Map<String, String> getCustomInfos() {
        return this.e;
    }

    public String getUserId() {
        return this.z;
    }

    public void setUserId(String str) {
        if (checkValid(str)) {
            this.z = str;
        } else {
            m.gc("TTMediationSDK", "流量分组user_id字段存在不合法输入");
        }
    }

    public String getChannel() {
        return this.g;
    }

    public void setChannel(String str) {
        if (checkValid(str)) {
            this.g = str;
        } else {
            m.gc("TTMediationSDK", "流量分组channer字段存在不合法输入");
        }
    }

    public String getSubChannel() {
        return this.dl;
    }

    public void setSubChannel(String str) {
        if (checkValid(str)) {
            this.dl = str;
        } else {
            m.gc("TTMediationSDK", "流量分组sub_channer字段存在不合法输入");
        }
    }

    public int getAge() {
        return this.f1469a;
    }

    public void setAge(int i) {
        this.f1469a = i;
    }

    public String getGender() {
        return this.gc;
    }

    public void setGender(String str) {
        if (checkValid(str)) {
            this.gc = str;
        } else {
            m.gc("TTMediationSDK", "流量分组gender字段存在不合法输入");
        }
    }

    public String getUserValueGroup() {
        return this.m;
    }

    public void setUserValueGroup(String str) {
        if (checkValid(str)) {
            this.m = str;
        } else {
            m.gc("TTMediationSDK", "流量分组user_value_group字段存在不合法输入");
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment = (MediationConfigUserInfoForSegment) obj;
            boolean z2 = getAge() == mediationConfigUserInfoForSegment.getAge() && TextUtils.equals(getUserValueGroup(), mediationConfigUserInfoForSegment.getUserValueGroup()) && TextUtils.equals(getUserId(), mediationConfigUserInfoForSegment.getUserId()) && TextUtils.equals(getChannel(), mediationConfigUserInfoForSegment.getChannel()) && TextUtils.equals(getSubChannel(), mediationConfigUserInfoForSegment.getSubChannel()) && TextUtils.equals(getGender(), mediationConfigUserInfoForSegment.getGender());
            Map<String, String> customInfos = mediationConfigUserInfoForSegment.getCustomInfos();
            Map<String, String> map = this.e;
            if (map != null && customInfos != null) {
                if (map.size() == customInfos.size()) {
                    for (String str : this.e.keySet()) {
                        if (TextUtils.isEmpty(str) || TextUtils.equals(this.e.get(str), customInfos.get(str))) {
                        }
                    }
                    z = true;
                }
                z = false;
                break;
            }
            if (map != null || customInfos != null) {
                z = false;
                break;
            }
            z = true;
            if (z2 && z) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }
}
