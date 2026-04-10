package com.umeng.message.common.inter;

import com.umeng.message.api.UPushAliasCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IUTrack {
    void addAlias(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) throws Exception;

    void deleteAlias(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) throws Exception;

    void sendMsgLog(JSONObject jSONObject, String str, int i2) throws Exception;

    void sendMsgShow(JSONObject jSONObject, String str, int i2, String str2) throws Exception;

    void setAlias(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) throws Exception;

    void trackAppLaunch(JSONObject jSONObject) throws Exception;

    void trackRegister(JSONObject jSONObject, String str) throws Exception;
}
