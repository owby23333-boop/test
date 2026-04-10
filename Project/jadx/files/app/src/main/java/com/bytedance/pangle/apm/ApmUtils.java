package com.bytedance.pangle.apm;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class ApmUtils {
    private static volatile AbsApm sApm;

    public static AbsApm getApmInstance() {
        if (sApm == null) {
            synchronized (AbsApm.class) {
                if (sApm == null) {
                    sApm = new AbsApm() { // from class: com.bytedance.pangle.apm.ApmUtils.1
                        @Override // com.bytedance.pangle.apm.AbsApm
                        public final String getDid() {
                            return "0";
                        }

                        @Override // com.bytedance.pangle.apm.AbsApm
                        public final void init() {
                        }

                        @Override // com.bytedance.pangle.apm.AbsApm
                        public final void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                        }

                        @Override // com.bytedance.pangle.apm.AbsApm
                        public final void reportError(String str, @NonNull Throwable th) {
                        }
                    };
                }
            }
        }
        return sApm;
    }

    public static synchronized void register(AbsApm absApm) {
        sApm = absApm;
    }
}
