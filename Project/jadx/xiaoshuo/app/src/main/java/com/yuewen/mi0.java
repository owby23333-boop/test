package com.yuewen;

import android.text.TextUtils;
import com.duokan.reader.domain.store.DkFictionChapterDiscountInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mi0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DkFictionChapterDiscountInfo[] f14381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14382b = false;

    public mi0(DkFictionChapterDiscountInfo[] dkFictionChapterDiscountInfoArr) {
        this.f14381a = new DkFictionChapterDiscountInfo[0];
        if (dkFictionChapterDiscountInfoArr.length > 0) {
            this.f14381a = dkFictionChapterDiscountInfoArr;
        }
    }

    public static mi0 b(String str) {
        try {
            return new mi0(new JSONArray(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean a(String str) {
        for (DkFictionChapterDiscountInfo dkFictionChapterDiscountInfo : this.f14381a) {
            if (dkFictionChapterDiscountInfo.mEndTime > System.currentTimeMillis() / 1000 && TextUtils.equals(dkFictionChapterDiscountInfo.mChapterId, str)) {
                return true;
            }
        }
        return false;
    }

    public int c(String str) {
        for (DkFictionChapterDiscountInfo dkFictionChapterDiscountInfo : this.f14381a) {
            if (dkFictionChapterDiscountInfo.mEndTime > System.currentTimeMillis() / 1000 && TextUtils.equals(dkFictionChapterDiscountInfo.mChapterId, str)) {
                return dkFictionChapterDiscountInfo.mPrice;
            }
        }
        return -1;
    }

    public long d() {
        return e(new LinkedList());
    }

    public long e(List<String> list) {
        long j;
        ArrayList<DkFictionChapterDiscountInfo> arrayListH = h(list);
        if (arrayListH.size() > 0) {
            j = arrayListH.get(0).mEndTime;
            Iterator<DkFictionChapterDiscountInfo> it = arrayListH.iterator();
            while (it.hasNext()) {
                long j2 = it.next().mEndTime;
                if (j2 < j) {
                    j = j2;
                }
            }
        } else {
            j = 0;
        }
        return j * 1000;
    }

    public int f() {
        int i;
        int iMax = 0;
        for (DkFictionChapterDiscountInfo dkFictionChapterDiscountInfo : this.f14381a) {
            if (iMax == 0) {
                iMax = dkFictionChapterDiscountInfo.mDiscount;
            }
            if (iMax > 0 && (i = dkFictionChapterDiscountInfo.mDiscount) > 0) {
                iMax = Math.max(iMax, i);
            }
        }
        return iMax;
    }

    public long g() {
        long j = 0;
        for (DkFictionChapterDiscountInfo dkFictionChapterDiscountInfo : this.f14381a) {
            long j2 = dkFictionChapterDiscountInfo.mStartTime;
            if (j2 > j) {
                j = j2;
            }
        }
        return j * 1000;
    }

    public ArrayList<DkFictionChapterDiscountInfo> h(List<String> list) {
        ArrayList<DkFictionChapterDiscountInfo> arrayList = new ArrayList<>();
        for (DkFictionChapterDiscountInfo dkFictionChapterDiscountInfo : this.f14381a) {
            if (!list.contains(dkFictionChapterDiscountInfo.mChapterId) && dkFictionChapterDiscountInfo.mEndTime > System.currentTimeMillis() / 1000) {
                arrayList.add(dkFictionChapterDiscountInfo);
            }
        }
        return arrayList;
    }

    public int i() {
        return j(new LinkedList());
    }

    public int j(List<String> list) {
        return h(list).size();
    }

    public String toString() {
        JSONArray jSONArray = new JSONArray();
        try {
            for (DkFictionChapterDiscountInfo dkFictionChapterDiscountInfo : this.f14381a) {
                jSONArray.put(new JSONObject(dkFictionChapterDiscountInfo.toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONArray.toString();
    }

    public mi0(JSONArray jSONArray) throws JSONException {
        this.f14381a = new DkFictionChapterDiscountInfo[0];
        int length = jSONArray.length();
        DkFictionChapterDiscountInfo[] dkFictionChapterDiscountInfoArr = new DkFictionChapterDiscountInfo[length];
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONObject) {
                dkFictionChapterDiscountInfoArr[i] = new DkFictionChapterDiscountInfo((JSONObject) obj);
            } else if (obj instanceof String) {
                dkFictionChapterDiscountInfoArr[i] = new DkFictionChapterDiscountInfo(new JSONObject((String) obj));
            } else {
                throw new JSONException("Value at " + i + "exception");
            }
        }
        if (length > 0) {
            this.f14381a = dkFictionChapterDiscountInfoArr;
        }
    }
}
