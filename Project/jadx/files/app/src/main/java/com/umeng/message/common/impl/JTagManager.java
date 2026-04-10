package com.umeng.message.common.impl;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.common.inter.ITagManager;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class JTagManager implements ITagManager {
    private static final String a = "JTagManager";
    private final Context b;

    public JTagManager(Context context) {
        this.b = context;
    }

    @Override // com.umeng.message.common.inter.ITagManager
    public ITagManager.Result addTags(JSONObject jSONObject, String... strArr) throws Exception {
        JSONObject jSONObjectSendRequest;
        String str = MsgConstant.TAG_ENDPOINT + "/add";
        try {
            jSONObjectSendRequest = JUTrack.sendRequest(jSONObject, str);
        } catch (Exception e2) {
            if (!(e2 instanceof UnknownHostException) || !UmengMessageDeviceConfig.isOnline(this.b)) {
                throw new Exception(e2);
            }
            UPLog.d(a, "addTags:", e2);
            jSONObjectSendRequest = JUTrack.sendRequest(this.b, jSONObject, str);
        }
        ITagManager.Result result = new ITagManager.Result(jSONObjectSendRequest, false);
        if (TextUtils.equals(result.status, "ok")) {
            MessageSharedPrefs.getInstance(this.b).addTags(strArr);
            MessageSharedPrefs.getInstance(this.b).setTagRemain(result.remain);
            MessageSharedPrefs.getInstance(this.b).setAddTagsInterval(result.toString());
        }
        return result;
    }

    @Override // com.umeng.message.common.inter.ITagManager
    public ITagManager.Result addWeightedTags(JSONObject jSONObject, Hashtable<String, Integer> hashtable) throws Exception {
        JSONObject jSONObjectSendRequest;
        String str = MsgConstant.WEIGHTED_TAG_ENDPOINT + "/incr";
        try {
            jSONObjectSendRequest = JUTrack.sendRequest(jSONObject, str);
        } catch (Exception e2) {
            if (!(e2 instanceof UnknownHostException) || !UmengMessageDeviceConfig.isOnline(this.b)) {
                throw new Exception(e2);
            }
            UPLog.d(a, "addWeightedTags:", e2);
            jSONObjectSendRequest = JUTrack.sendRequest(this.b, jSONObject, str);
        }
        ITagManager.Result result = new ITagManager.Result(jSONObjectSendRequest, true);
        MessageSharedPrefs.getInstance(this.b).setAddWeightedTagsInterval(result.toString());
        return result;
    }

    @Override // com.umeng.message.common.inter.ITagManager
    public ITagManager.Result deleteTags(JSONObject jSONObject, String... strArr) throws Exception {
        JSONObject jSONObjectSendRequest;
        String str = MsgConstant.TAG_ENDPOINT + "/delete";
        try {
            jSONObjectSendRequest = JUTrack.sendRequest(jSONObject, str);
        } catch (Exception e2) {
            if (!(e2 instanceof UnknownHostException) || !UmengMessageDeviceConfig.isOnline(this.b)) {
                throw new Exception(e2);
            }
            jSONObjectSendRequest = JUTrack.sendRequest(this.b, jSONObject, str);
        }
        ITagManager.Result result = new ITagManager.Result(jSONObjectSendRequest, false);
        if (TextUtils.equals(result.status, "ok")) {
            MessageSharedPrefs.getInstance(this.b).removeTags(strArr);
            MessageSharedPrefs.getInstance(this.b).setTagRemain(result.remain);
            MessageSharedPrefs.getInstance(this.b).setDeleteTagsInterval(result.toString());
        }
        return result;
    }

    @Override // com.umeng.message.common.inter.ITagManager
    public ITagManager.Result deleteWeightedTags(JSONObject jSONObject, String... strArr) throws Exception {
        JSONObject jSONObjectSendRequest;
        String str = MsgConstant.WEIGHTED_TAG_ENDPOINT + "/delete";
        try {
            jSONObjectSendRequest = JUTrack.sendRequest(jSONObject, str);
        } catch (Exception e2) {
            if (!(e2 instanceof UnknownHostException) || !UmengMessageDeviceConfig.isOnline(this.b)) {
                throw new Exception(e2);
            }
            jSONObjectSendRequest = JUTrack.sendRequest(this.b, jSONObject, str);
        }
        ITagManager.Result result = new ITagManager.Result(jSONObjectSendRequest, true);
        MessageSharedPrefs.getInstance(this.b).setDeleteWeightedTagsInterval(result.toString());
        return result;
    }

    @Override // com.umeng.message.common.inter.ITagManager
    public List<String> getTags(JSONObject jSONObject) throws Exception {
        JSONObject jSONObjectSendRequest;
        String str = MsgConstant.TAG_ENDPOINT + "/get";
        try {
            jSONObjectSendRequest = JUTrack.sendRequest(jSONObject, str);
        } catch (Exception e2) {
            if (!(e2 instanceof UnknownHostException) || !UmengMessageDeviceConfig.isOnline(this.b)) {
                throw new Exception(e2);
            }
            jSONObjectSendRequest = JUTrack.sendRequest(this.b, jSONObject, str);
        }
        ITagManager.Result result = new ITagManager.Result(jSONObjectSendRequest, false);
        if (!TextUtils.equals(result.status, "ok") || jSONObjectSendRequest == null) {
            return null;
        }
        String strOptString = jSONObjectSendRequest.optString("tags");
        MessageSharedPrefs.getInstance(this.b).setGetTagsInterval(result.toString());
        return Arrays.asList(strOptString.split(","));
    }

    @Override // com.umeng.message.common.inter.ITagManager
    public Hashtable<String, Integer> getWeightedTags(JSONObject jSONObject) throws Exception {
        JSONObject jSONObjectSendRequest;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        String str = MsgConstant.WEIGHTED_TAG_ENDPOINT + "/list";
        try {
            jSONObjectSendRequest = JUTrack.sendRequest(jSONObject, str);
        } catch (Exception e2) {
            if (!(e2 instanceof UnknownHostException) || !UmengMessageDeviceConfig.isOnline(this.b)) {
                throw new Exception(e2);
            }
            jSONObjectSendRequest = JUTrack.sendRequest(this.b, jSONObject, str);
        }
        MessageSharedPrefs.getInstance(this.b).setListWeightedTagsInterval(new ITagManager.Result(jSONObjectSendRequest, true).toString());
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        if (jSONObjectSendRequest != null && (jSONObjectOptJSONObject = jSONObjectSendRequest.optJSONObject("data")) != null && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("tags")) != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                hashtable.put(next, Integer.valueOf(jSONObjectOptJSONObject2.getInt(next)));
            }
        }
        return hashtable;
    }
}
