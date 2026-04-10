package com.kwad.components.core.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements i, Comparable<h> {
    private final String NF;
    private final String NN;
    private final String NO;
    private final String NP;
    private final long NQ;
    private final long createTime;
    private final int ecpm;

    private h(String str, String str2, String str3, int i, String str4, long j, long j2) {
        this.NN = str;
        this.NF = str2;
        this.NO = str3;
        this.ecpm = i;
        this.NP = str4;
        this.createTime = j;
        this.NQ = j2;
    }

    public static List<h> a(e eVar, AdResultData adResultData) {
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        int size = proceedTemplateList.size();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jOj = (jCurrentTimeMillis / 1000) + eVar.oj();
        ArrayList arrayList = new ArrayList();
        SceneImpl defaultAdScene = adResultData.getDefaultAdScene();
        Iterator<AdTemplate> it = proceedTemplateList.iterator();
        while (it.hasNext()) {
            AdTemplate next = it.next();
            arrayList.add(new h(String.valueOf(com.kwad.sdk.core.response.b.e.ev(next)), String.valueOf(adResultData.getPosId()), new AdResultData(adResultData, defaultAdScene, Collections.singletonList(next)).getResponseJson(), com.kwad.sdk.core.response.b.e.ez(next), adResultData.getDefaultAdScene().toJson().toString(), jCurrentTimeMillis + ((long) size), jOj));
            size--;
            it = it;
            defaultAdScene = defaultAdScene;
        }
        return arrayList;
    }

    public static List<h> a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(c(cursor));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return arrayList;
    }

    private static synchronized h c(Cursor cursor) {
        return new h(cursor.getString(cursor.getColumnIndex("creativeId")), cursor.getString(cursor.getColumnIndex("posId")), cursor.getString(cursor.getColumnIndex("adJson")), cursor.getInt(cursor.getColumnIndex(MediationConstant.KEY_ECPM)), cursor.getString(cursor.getColumnIndex("adSenseJson")), cursor.getLong(cursor.getColumnIndex("createTime")), cursor.getLong(cursor.getColumnIndex("expireTime")));
    }

    public static AdResultData k(List<h> list) {
        ArrayList arrayList = new ArrayList();
        AdResultData adResultDataC = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        Iterator<h> it = list.iterator();
        SceneImpl defaultAdScene = null;
        while (it.hasNext()) {
            adResultDataC = c(it.next());
            if (adResultDataC != null) {
                if (defaultAdScene == null) {
                    defaultAdScene = adResultDataC.getDefaultAdScene();
                }
                arrayList.addAll(adResultDataC.getProceedTemplateList());
            }
        }
        AdResultData adResultData = new AdResultData(adResultDataC, defaultAdScene, arrayList);
        adResultData.setAdSource("cache");
        return adResultData;
    }

    private static AdResultData c(h hVar) {
        if (hVar == null) {
            return null;
        }
        if (hVar.on() == null || hVar.or() == null) {
            com.kwad.sdk.core.d.c.w("CachedAd", "createAdResultData cachedAd data illegal");
            return null;
        }
        try {
            String strOr = hVar.or();
            SceneImpl sceneImpl = new SceneImpl();
            sceneImpl.parseJson(new JSONObject(strOr));
            AdResultData adResultDataCreateFromResponseJson = AdResultData.createFromResponseJson(hVar.on(), sceneImpl);
            Iterator<AdTemplate> it = adResultDataCreateFromResponseJson.getProceedTemplateList().iterator();
            while (it.hasNext()) {
                it.next().fromCache = true;
            }
            return adResultDataCreateFromResponseJson;
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    public final String og() {
        return this.NF;
    }

    private String on() {
        return this.NO;
    }

    private int oo() {
        return this.ecpm;
    }

    private long op() {
        return this.createTime;
    }

    public final long oq() {
        return this.NQ;
    }

    private String or() {
        return this.NP;
    }

    public final String os() {
        return this.NN;
    }

    @Override // com.kwad.components.core.c.i
    public final ContentValues ok() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("creativeId", this.NN);
        contentValues.put("posId", this.NF);
        contentValues.put("adJson", this.NO);
        contentValues.put(MediationConstant.KEY_ECPM, Integer.valueOf(this.ecpm));
        contentValues.put("adSenseJson", this.NP);
        contentValues.put("createTime", Long.valueOf(this.createTime));
        contentValues.put("expireTime", Long.valueOf(this.NQ));
        contentValues.put("playAgainJson", (String) null);
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        if (hVar.oo() == oo()) {
            return (int) (hVar.op() - op());
        }
        return hVar.oo() - oo();
    }
}
