package com.yuewen;

import com.duokan.reader.elegant.ui.user.data.ReadingItemInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d43 extends t90<ReadingItemInfo> {
    @Override // com.yuewen.t90
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ReadingItemInfo a(JSONObject jSONObject) throws Exception {
        return ReadingItemInfo.fromJson(jSONObject);
    }
}
