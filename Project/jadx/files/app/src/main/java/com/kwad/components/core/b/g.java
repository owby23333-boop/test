package com.kwad.components.core.b;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements h, Comparable<g> {
    private String IA = null;
    private final String Ip;
    private final String Iw;
    private final String Ix;
    private final String Iy;
    private final long Iz;
    private final long createTime;
    private final int ecpm;

    private g(String str, String str2, String str3, int i2, String str4, long j2, long j3) {
        this.Iw = str;
        this.Ip = str2;
        this.Ix = str3;
        this.ecpm = i2;
        this.Iy = str4;
        this.createTime = j2;
        this.Iz = j3;
    }

    public static List<g> a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(c(cursor));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        return arrayList;
    }

    public static List<g> a(e eVar, AdResultData adResultData) {
        AdResultData adResultData2;
        AdResultData adResultData3 = adResultData;
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        int size = proceedTemplateList.size();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jMD = (jCurrentTimeMillis / 1000) + eVar.mD();
        ArrayList arrayList = new ArrayList();
        SceneImpl defaultAdScene = adResultData.getDefaultAdScene();
        Iterator<AdTemplate> it = proceedTemplateList.iterator();
        while (it.hasNext()) {
            AdTemplate next = it.next();
            Iterator<AdTemplate> it2 = it;
            ArrayList arrayList2 = arrayList;
            g gVar = new g(String.valueOf(com.kwad.sdk.core.response.a.d.ck(next)), String.valueOf(adResultData.getPosId()), new AdResultData(adResultData3, defaultAdScene, Collections.singletonList(next)).getResponseJson(), com.kwad.sdk.core.response.a.d.cp(next), adResultData.getDefaultAdScene().toJson().toString(), ((long) size) + jCurrentTimeMillis, jMD);
            if (next.hasPlayAgain()) {
                adResultData2 = adResultData;
                gVar.ah(new AdResultData(adResultData2, defaultAdScene, Collections.singletonList(next.mPlayAgain)).getResponseJson());
            } else {
                adResultData2 = adResultData;
            }
            arrayList2.add(gVar);
            size--;
            it = it2;
            arrayList = arrayList2;
            adResultData3 = adResultData2;
        }
        return arrayList;
    }

    private void ah(String str) {
        this.IA = str;
    }

    @SuppressLint({"Range"})
    private static synchronized g c(@NonNull Cursor cursor) {
        g gVar;
        String string = cursor.getString(cursor.getColumnIndex("creativeId"));
        String string2 = cursor.getString(cursor.getColumnIndex("posId"));
        String string3 = cursor.getString(cursor.getColumnIndex("adJson"));
        int i2 = cursor.getInt(cursor.getColumnIndex("ecpm"));
        String string4 = cursor.getString(cursor.getColumnIndex("adSenseJson"));
        long j2 = cursor.getLong(cursor.getColumnIndex("createTime"));
        long j3 = cursor.getLong(cursor.getColumnIndex("expireTime"));
        String string5 = cursor.getString(cursor.getColumnIndex("playAgainJson"));
        gVar = new g(string, string2, string3, i2, string4, j2, j3);
        gVar.ah(string5);
        return gVar;
    }

    @Nullable
    private static AdResultData c(g gVar) {
        if (gVar == null) {
            return null;
        }
        if (gVar.mH() == null || gVar.mL() == null) {
            com.kwad.sdk.core.d.b.w("CachedAd", "createAdResultData cachedAd data illegal");
            return null;
        }
        try {
            String strML = gVar.mL();
            SceneImpl sceneImpl = new SceneImpl();
            sceneImpl.parseJson(new JSONObject(strML));
            AdResultData adResultDataCreateFromResponseJson = AdResultData.createFromResponseJson(gVar.mH(), sceneImpl);
            String strMN = gVar.mN();
            if (!TextUtils.isEmpty(strMN)) {
                AdTemplate firstAdTemplate = adResultDataCreateFromResponseJson.getFirstAdTemplate();
                AdResultData adResultDataCreateFromResponseJson2 = AdResultData.createFromResponseJson(strMN, sceneImpl);
                Iterator<AdTemplate> it = adResultDataCreateFromResponseJson2.getProceedTemplateList().iterator();
                while (it.hasNext()) {
                    it.next().fromCache = true;
                }
                firstAdTemplate.setPlayAgain(adResultDataCreateFromResponseJson2.getFirstAdTemplate());
            }
            Iterator<AdTemplate> it2 = adResultDataCreateFromResponseJson.getProceedTemplateList().iterator();
            while (it2.hasNext()) {
                it2.next().fromCache = true;
            }
            return adResultDataCreateFromResponseJson;
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        return gVar.mI() == mI() ? (int) (gVar.mJ() - mJ()) : gVar.mI() - mI();
    }

    public static AdResultData j(List<g> list) {
        ArrayList arrayList = new ArrayList();
        AdResultData adResultDataC = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        Iterator<g> it = list.iterator();
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
        return new AdResultData(adResultDataC, defaultAdScene, arrayList);
    }

    private String mH() {
        return this.Ix;
    }

    private int mI() {
        return this.ecpm;
    }

    private long mJ() {
        return this.createTime;
    }

    private String mL() {
        return this.Iy;
    }

    private String mN() {
        return this.IA;
    }

    @Override // com.kwad.components.core.b.h
    public final ContentValues mE() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("creativeId", this.Iw);
        contentValues.put("posId", this.Ip);
        contentValues.put("adJson", this.Ix);
        contentValues.put("ecpm", Integer.valueOf(this.ecpm));
        contentValues.put("adSenseJson", this.Iy);
        contentValues.put("createTime", Long.valueOf(this.createTime));
        contentValues.put("expireTime", Long.valueOf(this.Iz));
        contentValues.put("playAgainJson", this.IA);
        return contentValues;
    }

    public final String mG() {
        return this.Ip;
    }

    public final long mK() {
        return this.Iz;
    }

    public final String mM() {
        return this.Iw;
    }
}
