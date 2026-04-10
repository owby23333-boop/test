package com.bytedance.msdk.api;

import android.text.TextUtils;
import com.bytedance.msdk.api.v2.GMConfigUserInfoForSegment;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class UserInfoForSegment {
    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_UNKNOWN = "unknown";
    public final String TAG = "TTMediationSDK";
    private String a = "";
    private String b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14156c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14157d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14158e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14159f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, String> f14160g;

    public boolean equals(Object obj) {
        boolean z2;
        if (this != obj) {
            if (obj == null || UserInfoForSegment.class != obj.getClass()) {
                return false;
            }
            UserInfoForSegment userInfoForSegment = (UserInfoForSegment) obj;
            boolean z3 = getAge() == userInfoForSegment.getAge() && TextUtils.equals(getUserValueGroup(), userInfoForSegment.getUserValueGroup()) && TextUtils.equals(getUserId(), userInfoForSegment.getUserId()) && TextUtils.equals(getChannel(), userInfoForSegment.getChannel()) && TextUtils.equals(getSubChannel(), userInfoForSegment.getSubChannel()) && TextUtils.equals(getGender(), userInfoForSegment.getGender());
            Map<String, String> customInfos = userInfoForSegment.getCustomInfos();
            Map<String, String> map = this.f14160g;
            if (map != null && customInfos != null) {
                if (map.size() == customInfos.size()) {
                    for (String str : this.f14160g.keySet()) {
                        if (TextUtils.isEmpty(str) || TextUtils.equals(this.f14160g.get(str), customInfos.get(str))) {
                        }
                    }
                    z2 = true;
                }
                z2 = false;
                break;
            }
            if (this.f14160g != null || customInfos != null) {
                z2 = false;
                break;
            }
            z2 = true;
            if (!z3 || !z2) {
                return false;
            }
        }
        return true;
    }

    public int getAge() {
        return this.f14157d;
    }

    public String getChannel() {
        return this.b;
    }

    public Map<String, String> getCustomInfos() {
        return this.f14160g;
    }

    public String getGender() {
        return this.f14158e;
    }

    public String getSubChannel() {
        return this.f14156c;
    }

    public String getUserId() {
        return this.a;
    }

    public String getUserValueGroup() {
        return this.f14159f;
    }

    public void setAge(int i2) {
        this.f14157d = i2;
    }

    public void setChannel(String str) {
        if (GMConfigUserInfoForSegment.checkValid(str)) {
            this.b = str;
        }
    }

    public void setCustomInfos(Map<String, String> map) {
        StringBuilder sb;
        String str;
        this.f14160g = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!GMConfigUserInfoForSegment.checkValid(entry.getKey())) {
                    sb = new StringBuilder();
                    sb.append("流量分组");
                    sb.append(entry.getKey());
                    str = "字段存在不合法输入";
                } else if (GMConfigUserInfoForSegment.checkValid(entry.getValue())) {
                    this.f14160g.put(entry.getKey(), entry.getValue());
                } else {
                    sb = new StringBuilder();
                    sb.append("流量分组");
                    sb.append(entry.getKey());
                    sb.append("字段的值");
                    sb.append(entry.getValue());
                    str = "存在不合法输入";
                }
                sb.append(str);
                sb.toString();
            }
        }
    }

    public void setGender(String str) {
        if (GMConfigUserInfoForSegment.checkValid(str)) {
            this.f14158e = str;
        }
    }

    public void setSubChannel(String str) {
        if (GMConfigUserInfoForSegment.checkValid(str)) {
            this.f14156c = str;
        }
    }

    public void setUserId(String str) {
        if (GMConfigUserInfoForSegment.checkValid(str)) {
            this.a = str;
        }
    }

    public void setUserValueGroup(String str) {
        if (GMConfigUserInfoForSegment.checkValid(str)) {
            this.f14159f = str;
        }
    }
}
