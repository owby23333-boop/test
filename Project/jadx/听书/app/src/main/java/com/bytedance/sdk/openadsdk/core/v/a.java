package com.bytedance.sdk.openadsdk.core.v;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.zw;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Comparable<a> {
    private int dl;
    private int e;
    private final String g;
    private int gc;
    private long v;
    private final ArrayList<Long> z = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<Long> f1389a = new ArrayList<>();
    private final ArrayList<Long> m = new ArrayList<>();
    private final ArrayList<Long> gz = new ArrayList<>();
    private final HashMap<String, gc> fo = new HashMap<>();
    private int uy = 0;
    private int kb = 0;
    private final HashMap<String, gc> wp = new HashMap<>();
    private int i = 0;

    public a(String str) {
        this.g = str;
    }

    public void z(String str, String str2) {
        gc gcVar;
        gc gcVar2;
        gc gcVar3;
        gc gcVar4;
        gc gcVar5;
        gc gcVar6;
        str.hashCode();
        switch (str) {
            case "landingContinue":
                if (!TextUtils.isEmpty(str2) && (gcVar = this.wp.get(str2)) != null) {
                    gcVar.a(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingPause":
                if (!TextUtils.isEmpty(str2) && (gcVar2 = this.wp.get(str2)) != null) {
                    gcVar2.dl(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingStart":
                if (!TextUtils.isEmpty(str2)) {
                    gc gcVar7 = this.wp.get(str2);
                    if (gcVar7 == null) {
                        gcVar7 = new gc();
                        this.wp.put(str2, gcVar7);
                    }
                    gcVar7.z(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_over":
            case "feed_break":
                if (!TextUtils.isEmpty(str2) && (gcVar3 = this.fo.get(str2)) != null && gcVar3.z() != gc.gc) {
                    gcVar3.g(SystemClock.elapsedRealtime());
                    if (zw.g().jc()) {
                        this.uy = (int) (((long) this.uy) + gcVar3.z(this.v, SystemClock.elapsedRealtime()));
                    }
                    break;
                }
                break;
            case "show":
                this.z.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (zw.g().jc()) {
                    this.dl++;
                    break;
                }
                break;
            case "click":
                this.f1389a.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (zw.g().jc()) {
                    this.gc++;
                    break;
                }
                break;
            case "feed_continue":
                if (!TextUtils.isEmpty(str2) && (gcVar4 = this.fo.get(str2)) != null) {
                    gcVar4.a(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_pause":
                if (!TextUtils.isEmpty(str2) && (gcVar5 = this.fo.get(str2)) != null) {
                    gcVar5.dl(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingFinish":
                if (!TextUtils.isEmpty(str2) && (gcVar6 = this.wp.get(str2)) != null && gcVar6.z() != gc.gc) {
                    gcVar6.g(SystemClock.elapsedRealtime());
                    if (zw.g().jc()) {
                        this.i = (int) (((long) this.i) + gcVar6.z(this.v, SystemClock.elapsedRealtime()));
                    }
                    break;
                }
                break;
            case "videoPercent30":
                if (zw.g().jc()) {
                    this.kb++;
                    break;
                }
                break;
            case "dislike":
                this.gz.add(Long.valueOf(SystemClock.elapsedRealtime()));
                break;
            case "play_start":
                this.m.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (zw.g().jc()) {
                    this.e++;
                }
                if (!TextUtils.isEmpty(str2)) {
                    gc gcVar8 = this.fo.get(str2);
                    if (gcVar8 == null) {
                        gcVar8 = new gc();
                        this.fo.put(str2, gcVar8);
                    }
                    gcVar8.z(SystemClock.elapsedRealtime());
                    break;
                }
                break;
        }
    }

    public JSONArray z() {
        JSONArray jSONArray = new JSONArray();
        try {
            z(jSONArray);
            g(jSONArray);
        } catch (Throwable th) {
            wp.dl(th.getMessage());
        }
        return jSONArray;
    }

    private void z(String str, JSONArray jSONArray, ArrayList<Long> arrayList, List<Integer> list, long j) throws JSONException {
        int size = arrayList.size() - 1;
        Iterator<Integer> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            long j2 = j - (((long) iIntValue) * 60000);
            while (size >= 0 && arrayList.get(size).longValue() >= j2) {
                i++;
                size--;
            }
            if (i != 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(an.aI, str + iIntValue);
                jSONObject.put("v", i);
                jSONArray.put(jSONObject);
            }
        }
        while (size >= 0) {
            arrayList.remove(0);
            size--;
        }
    }

    private void z(JSONArray jSONArray) throws JSONException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        z("show_", jSONArray, this.z, zw.g().he(), jElapsedRealtime);
        z("click_", jSONArray, this.f1389a, zw.g().he(), jElapsedRealtime);
        z("play_", jSONArray, this.m, zw.g().he(), jElapsedRealtime);
        z("dis_", jSONArray, this.gz, zw.g().he(), jElapsedRealtime);
        if (zw.g().jc() && this.dl != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(an.aI, "show_0");
            jSONObject.put("v", this.dl);
            jSONArray.put(jSONObject);
        }
        if (zw.g().jc() && this.gc != 0) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(an.aI, "click_0");
            jSONObject2.put("v", this.gc);
            jSONArray.put(jSONObject2);
        }
        if (!zw.g().jc() || this.e == 0) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(an.aI, "play_0");
        jSONObject3.put("v", this.e);
        jSONArray.put(jSONObject3);
    }

    private void g(JSONArray jSONArray) throws JSONException {
        Iterator<String> it;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        List<Integer> listHe = zw.g().he();
        long j = 60000;
        if (listHe != null) {
            int i = 0;
            while (i < listHe.size()) {
                int iIntValue = listHe.get(i).intValue();
                long j2 = jElapsedRealtime - (((long) iIntValue) * j);
                Iterator<String> it2 = this.wp.keySet().iterator();
                long jZ = 0;
                while (it2.hasNext()) {
                    Iterator<String> it3 = it2;
                    HashSet hashSet3 = hashSet2;
                    gc gcVar = this.wp.get(it2.next());
                    if (gcVar != null) {
                        jZ += gcVar.z(j2, jElapsedRealtime);
                    }
                    hashSet2 = hashSet3;
                    it2 = it3;
                }
                HashSet hashSet4 = hashSet2;
                if (jZ != 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(an.aI, "lpstay_".concat(String.valueOf(iIntValue)));
                    jSONObject.put("v", jZ);
                    jSONArray.put(jSONObject);
                }
                i++;
                hashSet2 = hashSet4;
                j = 60000;
            }
        }
        HashSet hashSet5 = hashSet2;
        if (listHe != null) {
            int i2 = 0;
            while (i2 < listHe.size()) {
                int iIntValue2 = listHe.get(i2).intValue();
                long j3 = jElapsedRealtime - (((long) iIntValue2) * 60000);
                Iterator<String> it4 = this.fo.keySet().iterator();
                long j4 = 0;
                while (it4.hasNext()) {
                    List<Integer> list = listHe;
                    gc gcVar2 = this.fo.get(it4.next());
                    if (gcVar2 != null) {
                        it = it4;
                        wp.z("FeatureCalc", "startTime is " + j3 + " currentTime is " + jElapsedRealtime);
                        long jZ2 = gcVar2.z(j3, jElapsedRealtime);
                        wp.z("FeatureCalc", "duration is ".concat(String.valueOf(jZ2)));
                        j4 += jZ2;
                    } else {
                        it = it4;
                    }
                    listHe = list;
                    it4 = it;
                }
                List<Integer> list2 = listHe;
                if (j4 != 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(an.aI, "vstay_".concat(String.valueOf(iIntValue2)));
                    jSONObject2.put("v", j4);
                    jSONArray.put(jSONObject2);
                }
                Iterator it5 = hashSet.iterator();
                while (it5.hasNext()) {
                    this.wp.remove((String) it5.next());
                }
                Iterator it6 = hashSet5.iterator();
                while (it6.hasNext()) {
                    this.fo.remove((String) it6.next());
                }
                i2++;
                listHe = list2;
            }
        }
        if (zw.g().jc() && this.uy != 0) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(an.aI, "vstay_0");
            jSONObject3.put("v", this.uy);
            jSONArray.put(jSONObject3);
        }
        if (zw.g().jc() && this.i != 0) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(an.aI, "lpstay_0");
            jSONObject4.put("v", this.i);
            jSONArray.put(jSONObject4);
        }
        if (this.kb != 0) {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(an.aI, "v30p");
            jSONObject5.put("v", this.kb);
            jSONArray.put(jSONObject5);
        }
    }

    public void g() {
        this.v = SystemClock.elapsedRealtime();
        this.kb = 0;
        this.gc = 0;
        this.dl = 0;
        this.i = 0;
        this.uy = 0;
        this.e = 0;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        return aVar.dl - this.dl;
    }
}
