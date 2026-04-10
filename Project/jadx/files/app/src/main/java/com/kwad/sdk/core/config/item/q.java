package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends b<List<String>> {
    public q(String str, List<String> list) {
        super(str, list);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        List listEi = s.ei(b.bn(sharedPreferences.getString(getKey(), "")));
        if (ag.F(listEi)) {
            setValue(listEi);
        } else {
            setValue(vj());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        if (ag.F(getValue())) {
            editor.putString(getKey(), b.bm(s.toJsonArray(getValue()).toString()));
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void f(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray(getKey())) != null && jSONArrayOptJSONArray.length() > 0) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                String strOptString = jSONArrayOptJSONArray.optString(i2);
                if (strOptString != null && !strOptString.isEmpty()) {
                    copyOnWriteArrayList.add(strOptString);
                }
            }
            if (copyOnWriteArrayList.size() > 0) {
                setValue(copyOnWriteArrayList);
                return;
            }
        }
        setValue(vj());
    }

    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* JADX INFO: renamed from: vr, reason: merged with bridge method [inline-methods] */
    public final List<String> getValue() {
        List<String> list = (List) super.getValue();
        return list == null ? new ArrayList() : list;
    }
}
