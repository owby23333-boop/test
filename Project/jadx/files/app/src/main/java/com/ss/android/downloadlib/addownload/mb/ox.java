package com.ss.android.downloadlib.addownload.mb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.x;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class ox {
    ox() {
    }

    @NonNull
    CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.model.mb> mb(String str, String str2) {
        CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.model.mb> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = x.getContext().getSharedPreferences(str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    com.ss.android.downloadlib.addownload.model.mb mbVarMb = com.ss.android.downloadlib.addownload.model.mb.mb(jSONObject.optJSONObject(itKeys.next()));
                    if (mbVarMb != null) {
                        copyOnWriteArrayList.add(mbVarMb);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    void ox(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        x.getContext().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
    }

    void mb(String str, String str2, CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.model.mb> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (com.ss.android.downloadlib.addownload.model.mb mbVar : copyOnWriteArrayList) {
                if (mbVar != null) {
                    jSONObject.put(String.valueOf(mbVar.ox), mbVar.mb());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        x.getContext().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }
}
