package com.mibi.sdk.component.recharge;

import android.text.TextUtils;
import com.mibi.sdk.common.BundleUtils;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.utils.MibiLog;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class EntryData implements Serializable {
    private static final String TAG = "EntryData";
    public Map<String, Object> mExtraData;
    public String mId;
    public String mIntentUri;
    private transient Map<String, Object> mMetaData;
    public String mPackageName;
    public Type mType;
    public String mUrl;

    /* JADX INFO: renamed from: com.mibi.sdk.component.recharge.EntryData$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$mibi$sdk$component$recharge$EntryData$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$mibi$sdk$component$recharge$EntryData$Type = iArr;
            try {
                iArr[Type.LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$mibi$sdk$component$recharge$EntryData$Type[Type.WEB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$mibi$sdk$component$recharge$EntryData$Type[Type.APP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum Type {
        LOCAL,
        WEB,
        APP;

        public static Type getType(String str) {
            try {
                return valueOf(str);
            } catch (IllegalArgumentException e) {
                MibiLog.e(EntryData.TAG, "EntryData Type IllegalArgumentException ", e);
                return null;
            }
        }

        public static String getTypes() {
            Type[] typeArrValues = values();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < typeArrValues.length; i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(typeArrValues[i].name());
            }
            return sb.toString();
        }
    }

    public <T> T getMetaData(String str, T t) {
        Map<String, Object> map = this.mMetaData;
        if (map != null && map.containsKey(str)) {
            try {
                return (T) t.getClass().cast(this.mMetaData.get(str));
            } catch (Exception unused) {
            }
        }
        return t;
    }

    public void parseEntryData(JSONObject jSONObject) throws PaymentException {
        if (jSONObject != null) {
            try {
                this.mId = jSONObject.getString("id");
                this.mExtraData = BundleUtils.convertJson2Map(jSONObject.optJSONObject("extra"));
                this.mMetaData = BundleUtils.convertJson2Map(jSONObject.optJSONObject("meta"));
                String string = jSONObject.getString("type");
                Type type = Type.getType(string);
                this.mType = type;
                if (type == null) {
                    throw new ResultException("entryData type is null, type is " + string);
                }
                int i = AnonymousClass1.$SwitchMap$com$mibi$sdk$component$recharge$EntryData$Type[type.ordinal()];
                if (i == 1) {
                    this.mUrl = jSONObject.optString("url");
                    return;
                }
                if (i == 2) {
                    String string2 = jSONObject.getString("url");
                    this.mUrl = string2;
                    if (TextUtils.isEmpty(string2)) {
                        throw new ResultException("mUrl should not all be null in WEB, type is " + string);
                    }
                    return;
                }
                if (i != 3) {
                    return;
                }
                this.mUrl = jSONObject.optString("url");
                this.mIntentUri = jSONObject.getString(CommonConstants.KEY_INTENT_URI);
                this.mPackageName = jSONObject.getString("packageName");
                if (TextUtils.isEmpty(this.mIntentUri) && TextUtils.isEmpty(this.mPackageName)) {
                    throw new ResultException("mIntentUri and mPackageName should not all be null in APP, type is " + string);
                }
            } catch (JSONException e) {
                throw new ResultException(e);
            }
        }
    }
}
