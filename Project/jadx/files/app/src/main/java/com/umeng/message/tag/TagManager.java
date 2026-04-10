package com.umeng.message.tag;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushTagCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.common.impl.JTagManager;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.proguard.ai;
import com.umeng.message.proguard.c;
import com.umeng.message.proguard.e;
import com.umeng.message.proguard.r;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TagManager {
    private static final String a = "TagManager";
    private static final String b = "ok";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f20589c = "fail";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile TagManager f20590e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ITagManager f20591d;

    @Deprecated
    public interface TCallBack extends UPushTagCallback<ITagManager.Result> {
    }

    @Deprecated
    public interface TagListCallBack extends UPushTagCallback<List<String>> {
    }

    @Deprecated
    public interface WeightedTagListCallBack extends UPushTagCallback<Hashtable<String, Integer>> {
    }

    private TagManager(Context context) {
        this.f20591d = new JTagManager(context);
    }

    public static TagManager getInstance(Context context) {
        if (f20590e == null) {
            synchronized (TagManager.class) {
                if (f20590e == null) {
                    f20590e = new TagManager(context.getApplicationContext());
                }
            }
        }
        return f20590e;
    }

    public void addTags(final UPushTagCallback<ITagManager.Result> uPushTagCallback, final String... strArr) {
        c.a(new Runnable() { // from class: com.umeng.message.tag.TagManager.1
            @Override // java.lang.Runnable
            public void run() {
                ITagManager.Result result = new ITagManager.Result();
                boolean z2 = true;
                try {
                    try {
                        if (strArr != null && strArr.length != 0) {
                            if (!TagManager.this.b()) {
                                UPLog.e(TagManager.a, "No utdid or device_token");
                                result.setErrors("No utdid or device_token");
                                try {
                                    uPushTagCallback.onMessage(false, result);
                                    return;
                                } catch (Throwable unused) {
                                    return;
                                }
                            }
                            if (TagManager.this.c()) {
                                UPLog.e(TagManager.a, "Tag api is disabled by the server");
                                result.setErrors("Tag api is disabled by the server");
                                try {
                                    uPushTagCallback.onMessage(false, result);
                                    return;
                                } catch (Throwable unused2) {
                                    return;
                                }
                            }
                            Context contextB = r.b();
                            String strA = TagManager.this.a(MessageSharedPrefs.getInstance(contextB).getAddTagsInterval(), strArr);
                            if (!TextUtils.isEmpty(strA)) {
                                UMLog.mutlInfo(TagManager.a, 0, strA);
                                result.setErrors(strA);
                                try {
                                    uPushTagCallback.onMessage(false, result);
                                    return;
                                } catch (Throwable unused3) {
                                    return;
                                }
                            }
                            ArrayList arrayList = new ArrayList();
                            for (String str : strArr) {
                                if (!MessageSharedPrefs.getInstance(contextB).isTagSet(str) && !arrayList.contains(str)) {
                                    byte[] bytes = null;
                                    try {
                                        bytes = str.getBytes("UTF-8");
                                    } catch (UnsupportedEncodingException e2) {
                                        e2.printStackTrace();
                                    }
                                    if (bytes != null && bytes.length <= 128 && bytes.length > 0) {
                                        arrayList.add(str);
                                    }
                                }
                            }
                            if (arrayList.size() == 0) {
                                try {
                                    uPushTagCallback.onMessage(true, TagManager.this.d());
                                    return;
                                } catch (Throwable unused4) {
                                    return;
                                }
                            }
                            try {
                                JSONObject jSONObjectA = TagManager.this.a();
                                jSONObjectA.put("tags", ai.a(arrayList));
                                result = TagManager.this.f20591d.addTags(jSONObjectA, strArr);
                            } catch (Exception unused5) {
                                UPLog.e(TagManager.a, "add tag error!");
                                z2 = false;
                            }
                            uPushTagCallback.onMessage(z2, result);
                            return;
                        }
                        UPLog.e(TagManager.a, "No tags");
                        result.setErrors("No tags");
                        try {
                            uPushTagCallback.onMessage(false, result);
                        } catch (Throwable unused6) {
                        }
                    } catch (Throwable unused7) {
                    }
                } catch (Throwable th) {
                    try {
                        UPLog.e(TagManager.a, "addTags error:", th);
                        uPushTagCallback.onMessage(false, result);
                    } catch (Throwable th2) {
                        try {
                            uPushTagCallback.onMessage(false, result);
                        } catch (Throwable unused8) {
                        }
                        throw th2;
                    }
                }
            }
        });
    }

    public void addWeightedTags(final UPushTagCallback<ITagManager.Result> uPushTagCallback, final Hashtable<String, Integer> hashtable) {
        c.a(new Runnable() { // from class: com.umeng.message.tag.TagManager.2
            @Override // java.lang.Runnable
            public void run() {
                ITagManager.Result result = new ITagManager.Result();
                boolean z2 = true;
                try {
                    try {
                        if (!TagManager.this.b()) {
                            result.setErrors("No utdid or device token");
                            UPLog.e(TagManager.a, "No utdid or device token");
                            try {
                                uPushTagCallback.onMessage(false, result);
                                return;
                            } catch (Throwable unused) {
                                return;
                            }
                        }
                        if (hashtable != null && hashtable.size() != 0) {
                            if (hashtable.size() > 64) {
                                UPLog.e(TagManager.a, "The maximum number of adding weighted tags per request is 64");
                                result.setErrors("The maximum number of adding weighted tags per request is 64");
                                try {
                                    uPushTagCallback.onMessage(false, result);
                                    return;
                                } catch (Throwable unused2) {
                                    return;
                                }
                            }
                            String strA = TagManager.this.a(MessageSharedPrefs.getInstance(r.b()).getAddWeightedTagsInterval(), (Hashtable<String, Integer>) hashtable);
                            if (!TextUtils.isEmpty(strA)) {
                                UPLog.e(TagManager.a, strA);
                                result.setErrors(strA);
                                try {
                                    uPushTagCallback.onMessage(false, result);
                                    return;
                                } catch (Throwable unused3) {
                                    return;
                                }
                            }
                            try {
                                JSONObject jSONObject = new JSONObject();
                                for (String str : hashtable.keySet()) {
                                    Integer num = (Integer) hashtable.get(str);
                                    if (num != null) {
                                        jSONObject.put(str, num.intValue());
                                    }
                                }
                                JSONObject jSONObjectA = TagManager.this.a();
                                jSONObjectA.put("tags", jSONObject);
                                result = TagManager.this.f20591d.addWeightedTags(jSONObjectA, hashtable);
                            } catch (Exception e2) {
                                UPLog.e(TagManager.a, "addWeightedTags error:", e2);
                                z2 = false;
                            }
                            uPushTagCallback.onMessage(z2, result);
                            return;
                        }
                        UPLog.e(TagManager.a, "No weighted tags");
                        result.setErrors("No weighted tags");
                        try {
                            uPushTagCallback.onMessage(false, result);
                        } catch (Throwable unused4) {
                        }
                    } catch (Throwable th) {
                        try {
                            UPLog.e(TagManager.a, "addWeightedTags error:", th);
                            uPushTagCallback.onMessage(false, result);
                        } catch (Throwable th2) {
                            try {
                                uPushTagCallback.onMessage(false, result);
                            } catch (Throwable unused5) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable unused6) {
                }
            }
        });
    }

    public void deleteTags(final UPushTagCallback<ITagManager.Result> uPushTagCallback, final String... strArr) {
        c.a(new Runnable() { // from class: com.umeng.message.tag.TagManager.3
            @Override // java.lang.Runnable
            public void run() {
                ITagManager.Result result = new ITagManager.Result();
                boolean z2 = true;
                try {
                    try {
                        String strA = TagManager.this.a(MessageSharedPrefs.getInstance(r.b()).getDeleteTagsInterval(), strArr);
                        if (!TextUtils.isEmpty(strA)) {
                            result.setErrors(strA);
                            try {
                                return;
                            } catch (Throwable unused) {
                                return;
                            }
                        }
                        if (TagManager.this.c()) {
                            result.setErrors("tag server disable.");
                            try {
                                uPushTagCallback.onMessage(false, result);
                                return;
                            } catch (Throwable unused2) {
                                return;
                            }
                        }
                        if (!TagManager.this.b()) {
                            result.setErrors("check request failed.");
                            try {
                                uPushTagCallback.onMessage(false, result);
                            } catch (Throwable unused3) {
                            }
                        } else {
                            if (strArr == null || strArr.length == 0) {
                                UPLog.e(TagManager.a, "No tags.");
                                result.setErrors("No tags.");
                                try {
                                    uPushTagCallback.onMessage(true, result);
                                    return;
                                } catch (Throwable unused4) {
                                    return;
                                }
                            }
                            try {
                                JSONObject jSONObjectA = TagManager.this.a();
                                jSONObjectA.put("tags", ai.a(strArr));
                                result = TagManager.this.f20591d.deleteTags(jSONObjectA, strArr);
                            } catch (Exception e2) {
                                UPLog.e(TagManager.a, "deleteTags error:", e2);
                                z2 = false;
                            }
                            uPushTagCallback.onMessage(z2, result);
                        }
                    } catch (Throwable unused5) {
                    }
                } catch (Throwable th) {
                    try {
                        UPLog.e(TagManager.a, "deleteTags error:", th);
                        uPushTagCallback.onMessage(false, result);
                    } finally {
                        try {
                            uPushTagCallback.onMessage(false, result);
                        } catch (Throwable unused6) {
                        }
                    }
                }
            }
        });
    }

    public void deleteWeightedTags(final UPushTagCallback<ITagManager.Result> uPushTagCallback, final String... strArr) {
        c.a(new Runnable() { // from class: com.umeng.message.tag.TagManager.4
            @Override // java.lang.Runnable
            public void run() {
                ITagManager.Result result = new ITagManager.Result();
                boolean z2 = true;
                try {
                    try {
                        if (!TagManager.this.b()) {
                            result.setErrors("check request failed.");
                            UPLog.e(TagManager.a, "check request failed.");
                            try {
                                return;
                            } catch (Throwable unused) {
                                return;
                            }
                        }
                        if (strArr != null && strArr.length != 0) {
                            if (strArr.length > 64) {
                                result.setErrors("tags count must be <= 64");
                                UPLog.e(TagManager.a, "tags count must be <= 64");
                                try {
                                    uPushTagCallback.onMessage(false, result);
                                    return;
                                } catch (Throwable unused2) {
                                    return;
                                }
                            }
                            String strB = TagManager.this.b(MessageSharedPrefs.getInstance(r.b()).getDeleteWeightedTagsInterval(), strArr);
                            if (!TextUtils.isEmpty(strB)) {
                                UPLog.e(TagManager.a, strB);
                                result.setErrors(strB);
                                try {
                                    uPushTagCallback.onMessage(false, result);
                                    return;
                                } catch (Throwable unused3) {
                                    return;
                                }
                            }
                            try {
                                JSONObject jSONObjectA = TagManager.this.a();
                                jSONObjectA.put("tags", ai.a(strArr));
                                result = TagManager.this.f20591d.deleteWeightedTags(jSONObjectA, strArr);
                            } catch (Exception e2) {
                                UPLog.e(TagManager.a, "deleteWeightedTags failed:", e2);
                                z2 = false;
                            }
                            uPushTagCallback.onMessage(z2, result);
                            return;
                        }
                        result.setErrors("No tags.");
                        UPLog.e(TagManager.a, "No tags.");
                        try {
                            uPushTagCallback.onMessage(false, result);
                        } catch (Throwable unused4) {
                        }
                    } catch (Throwable th) {
                        try {
                            UPLog.e(TagManager.a, "deleteWeightedTags:", th);
                            uPushTagCallback.onMessage(false, result);
                        } finally {
                            try {
                                uPushTagCallback.onMessage(false, result);
                            } catch (Throwable unused5) {
                            }
                        }
                    }
                } catch (Throwable unused6) {
                }
            }
        });
    }

    public void getTags(final UPushTagCallback<List<String>> uPushTagCallback) {
        c.a(new Runnable() { // from class: com.umeng.message.tag.TagManager.5
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                boolean z2 = true;
                try {
                    try {
                        if (!TextUtils.isEmpty(TagManager.this.a(MessageSharedPrefs.getInstance(r.b()).getGetTagsInterval(), false))) {
                            try {
                                uPushTagCallback.onMessage(false, arrayList);
                                return;
                            } catch (Throwable unused) {
                                return;
                            }
                        }
                        if (TagManager.this.c()) {
                            try {
                                uPushTagCallback.onMessage(false, arrayList);
                            } catch (Throwable unused2) {
                            }
                        } else {
                            if (!TagManager.this.b()) {
                                try {
                                    return;
                                } catch (Throwable unused3) {
                                    return;
                                }
                            }
                            try {
                                List<String> tags = TagManager.this.f20591d.getTags(TagManager.this.a());
                                if (tags != null) {
                                    arrayList.addAll(tags);
                                }
                            } catch (Exception e2) {
                                UPLog.e(TagManager.a, "getTags error:", e2);
                                z2 = false;
                            }
                            uPushTagCallback.onMessage(z2, arrayList);
                        }
                    } catch (Throwable th) {
                        try {
                            UPLog.e(TagManager.a, "getTags:", th);
                            uPushTagCallback.onMessage(false, arrayList);
                        } finally {
                            try {
                                uPushTagCallback.onMessage(false, arrayList);
                            } catch (Throwable unused4) {
                            }
                        }
                    }
                } catch (Throwable unused5) {
                }
            }
        });
    }

    public void getWeightedTags(final UPushTagCallback<Hashtable<String, Integer>> uPushTagCallback) {
        c.a(new Runnable() { // from class: com.umeng.message.tag.TagManager.6
            @Override // java.lang.Runnable
            public void run() {
                Hashtable hashtable = new Hashtable();
                if (TagManager.this.b() && TextUtils.isEmpty(TagManager.this.a(MessageSharedPrefs.getInstance(r.b()).getListWeightedTagsInterval(), true))) {
                    try {
                        try {
                            Hashtable<String, Integer> weightedTags = TagManager.this.f20591d.getWeightedTags(TagManager.this.a());
                            if (weightedTags != null) {
                                hashtable.putAll(weightedTags);
                            }
                            try {
                                uPushTagCallback.onMessage(true, hashtable);
                            } catch (Throwable th) {
                                UPLog.e(TagManager.a, "getWeightedTags:", th);
                            }
                        } catch (Exception e2) {
                            UPLog.e(TagManager.a, "getWeightedTags failed:", e2);
                            try {
                                uPushTagCallback.onMessage(false, hashtable);
                            } catch (Throwable th2) {
                                UPLog.e(TagManager.a, "getWeightedTags:", th2);
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            uPushTagCallback.onMessage(false, hashtable);
                        } catch (Throwable th4) {
                            UPLog.e(TagManager.a, "getWeightedTags:", th4);
                        }
                        throw th3;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        boolean z2 = MessageSharedPrefs.getInstance(r.b()).getTagSendPolicy() == 1;
        if (z2) {
            UPLog.d(a, "tag server disable!");
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ITagManager.Result d() {
        ITagManager.Result result = new ITagManager.Result(new JSONObject(), false);
        result.remain = MessageSharedPrefs.getInstance(r.b()).getTagRemain();
        result.status = "ok";
        result.jsonString = "status:" + result.status + ", remain:" + result.remain + ",description:" + result.status;
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        if (TextUtils.isEmpty(UmengMessageDeviceConfig.getUtdid(r.b()))) {
            UPLog.e(a, "utdid empty.");
            return false;
        }
        if (!TextUtils.isEmpty(PushAgent.getInstance(r.b()).getRegistrationId())) {
            return true;
        }
        UPLog.e(a, "deviceToken empty.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a() throws JSONException {
        Context contextB = r.b();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", e.a());
        jSONObject.put("utdid", UmengMessageDeviceConfig.getUtdid(contextB));
        jSONObject.put(MsgConstant.KEY_DEVICE_TOKEN, MessageSharedPrefs.getInstance(contextB).getDeviceToken());
        jSONObject.put("ts", System.currentTimeMillis());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str, String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr) {
            try {
                byte[] bytes = str2.getBytes("UTF-8");
                if (bytes == null || bytes.length > 128 || bytes.length <= 0) {
                    return "pls check tag length limit. must be 1 ~ 128";
                }
                arrayList.add(str2);
            } catch (UnsupportedEncodingException e2) {
                UPLog.e(a, "checkWeightedTags:", e2);
                return "pls check tag length limit. must be 1 ~ 128";
            }
        }
        if (str == null) {
            return null;
        }
        try {
            ITagManager.Result result = new ITagManager.Result(new JSONObject(str), true);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (arrayList.size() <= 0 || result.interval == 0) {
                return null;
            }
            if ((jCurrentTimeMillis - result.last_requestTime) / 1000 > result.interval) {
                return null;
            }
            return "interval limit";
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String... strArr) {
        String str2;
        Context contextB = r.b();
        ArrayList arrayList = new ArrayList();
        if (strArr != null && strArr.length > 0) {
            for (String str3 : strArr) {
                if (!MessageSharedPrefs.getInstance(contextB).isTagSet(str3) && !arrayList.contains(str3)) {
                    byte[] bytes = null;
                    try {
                        bytes = str3.getBytes("UTF-8");
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                    if (bytes == null || bytes.length > 128 || bytes.length <= 0) {
                        return "tag length must be 1~128 byte";
                    }
                    arrayList.add(str3);
                }
            }
        }
        if (str == null) {
            return "";
        }
        try {
            ITagManager.Result result = new ITagManager.Result(new JSONObject(str), false);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (arrayList.size() <= 0) {
                return "";
            }
            if (result.remain < 0 || arrayList.size() > result.remain) {
                str2 = "tags count > 1024";
            } else {
                if (result.interval == 0) {
                    return "";
                }
                if ((jCurrentTimeMillis - result.last_requestTime) / 1000 > result.interval) {
                    return "";
                }
                str2 = "interval limit";
            }
            return str2;
        } catch (Exception e3) {
            UPLog.e(a, "checkTags error:", e3);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, Hashtable<String, Integer> hashtable) {
        for (String str2 : hashtable.keySet()) {
            try {
                byte[] bytes = str2.getBytes("UTF-8");
                if (bytes == null || bytes.length > 128 || bytes.length == 0) {
                    return "pls check tag limit";
                }
                Integer num = hashtable.get(str2);
                if (num == null || num.intValue() < -10 || num.intValue() > 10) {
                    return "pls check tag weight, weight must be >= -10 && <=10";
                }
            } catch (UnsupportedEncodingException e2) {
                UPLog.e(a, "checkWeightedTags:", e2);
                return "pls check tag limit";
            }
        }
        if (str == null) {
            return null;
        }
        try {
            ITagManager.Result result = new ITagManager.Result(new JSONObject(str), true);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (result.interval == 0) {
                return null;
            }
            if ((jCurrentTimeMillis - result.last_requestTime) / 1000 > result.interval) {
                return null;
            }
            return "interval limit";
        } catch (Exception e3) {
            UPLog.e(a, "checkWeightedTags error:", e3);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, boolean z2) {
        if (str == null) {
            return null;
        }
        try {
            ITagManager.Result result = new ITagManager.Result(new JSONObject(str), z2);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (result.interval == 0) {
                return null;
            }
            if ((jCurrentTimeMillis - result.last_requestTime) / 1000 > result.interval) {
                return null;
            }
            return "interval limit";
        } catch (Exception e2) {
            UPLog.e(a, "checkTagsInterval error:", e2);
            return null;
        }
    }
}
