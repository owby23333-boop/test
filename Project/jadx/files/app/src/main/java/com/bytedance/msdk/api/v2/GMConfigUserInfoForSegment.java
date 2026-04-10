package com.bytedance.msdk.api.v2;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GMConfigUserInfoForSegment {
    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_UNKNOWN = "unknown";
    public final String TAG = "TTMediationSDK";
    private String a = "";
    private String b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14201c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14202d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14203e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14204f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, String> f14205g;

    public static boolean checkValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }

    public boolean equals(Object obj) {
        boolean z2;
        if (this != obj) {
            if (obj == null || GMConfigUserInfoForSegment.class != obj.getClass()) {
                return false;
            }
            GMConfigUserInfoForSegment gMConfigUserInfoForSegment = (GMConfigUserInfoForSegment) obj;
            boolean z3 = getAge() == gMConfigUserInfoForSegment.getAge() && TextUtils.equals(getUserValueGroup(), gMConfigUserInfoForSegment.getUserValueGroup()) && TextUtils.equals(getUserId(), gMConfigUserInfoForSegment.getUserId()) && TextUtils.equals(getChannel(), gMConfigUserInfoForSegment.getChannel()) && TextUtils.equals(getSubChannel(), gMConfigUserInfoForSegment.getSubChannel()) && TextUtils.equals(getGender(), gMConfigUserInfoForSegment.getGender());
            Map<String, String> customInfos = gMConfigUserInfoForSegment.getCustomInfos();
            Map<String, String> map = this.f14205g;
            if (map != null && customInfos != null) {
                if (map.size() == customInfos.size()) {
                    for (String str : this.f14205g.keySet()) {
                        if (TextUtils.isEmpty(str) || TextUtils.equals(this.f14205g.get(str), customInfos.get(str))) {
                        }
                    }
                    z2 = true;
                }
                z2 = false;
                break;
            }
            if (this.f14205g != null || customInfos != null) {
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
        return this.f14202d;
    }

    public String getChannel() {
        return this.b;
    }

    public Map<String, String> getCustomInfos() {
        return this.f14205g;
    }

    public String getGender() {
        return this.f14203e;
    }

    public String getSubChannel() {
        return this.f14201c;
    }

    public String getUserId() {
        return this.a;
    }

    public String getUserValueGroup() {
        return this.f14204f;
    }

    public void setAge(int i2) {
        this.f14202d = i2;
    }

    public void setChannel(String str) {
        if (checkValid(str)) {
            this.b = str;
        }
    }

    public void setCustomInfos(Map<String, String> map) {
        StringBuilder sb;
        String str;
        this.f14205g = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!checkValid(entry.getKey())) {
                    sb = new StringBuilder();
                    sb.append("流量分组");
                    sb.append(entry.getKey());
                    str = "字段存在不合法输入";
                } else if (checkValid(entry.getValue())) {
                    this.f14205g.put(entry.getKey(), entry.getValue());
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
        if (checkValid(str)) {
            this.f14203e = str;
        }
    }

    public void setSubChannel(String str) {
        if (checkValid(str)) {
            this.f14201c = str;
        }
    }

    public void setUserId(String str) {
        if (checkValid(str)) {
            this.a = str;
        }
    }

    public void setUserValueGroup(String str) {
        if (checkValid(str)) {
            this.f14204f = str;
        }
    }
}
