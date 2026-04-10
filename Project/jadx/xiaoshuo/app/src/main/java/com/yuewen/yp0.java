package com.yuewen;

import android.content.Context;
import android.util.Pair;
import com.duokan.reader.domain.store.DkStoreSpecialEventInfo;
import com.yuewen.st2;
import java.lang.reflect.Array;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public class yp0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DkStoreSpecialEventInfo f20405a;

    public yp0(DkStoreSpecialEventInfo dkStoreSpecialEventInfo) {
        this.f20405a = dkStoreSpecialEventInfo;
    }

    public static float a(Context context, List<yp0> list, int i) {
        Pair<String, Integer> pairB;
        float fIntValue = 0.0f;
        if (list != null) {
            for (yp0 yp0Var : list) {
                if (yp0Var.d() && (pairB = yp0Var.b(context, i)) != null) {
                    fIntValue += ((Integer) pairB.second).intValue();
                }
            }
        }
        return fIntValue;
    }

    public Pair<String, Integer> b(Context context, int i) {
        try {
            JSONArray jSONArray = this.f20405a.mStrategy;
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, jSONArray.length(), 2);
            int[] iArr2 = {0, 0};
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(i2);
                iArr[i2][0] = (int) Math.round(jSONArray2.getDouble(0) * 100.0d);
                iArr[i2][1] = (int) Math.round(jSONArray2.getDouble(1) * 100.0d);
                int[] iArr3 = iArr[i2];
                int i3 = iArr3[0];
                if (i >= i3 && iArr2[0] < i3) {
                    iArr2 = iArr3;
                }
            }
            int i4 = iArr2[0];
            if (i4 == 0) {
                return null;
            }
            return new Pair<>(String.format(context.getString(st2.s.iq0), Float.valueOf(iArr2[0] / 100.0f), Float.valueOf(iArr2[1] / 100.0f)), Integer.valueOf((i / i4) * iArr2[1]));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String c() {
        return this.f20405a.mEventName;
    }

    public boolean d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        DkStoreSpecialEventInfo dkStoreSpecialEventInfo = this.f20405a;
        long j = jCurrentTimeMillis - (dkStoreSpecialEventInfo.mServerTime - dkStoreSpecialEventInfo.mClientTime);
        return dkStoreSpecialEventInfo.mStartTime <= j && j <= dkStoreSpecialEventInfo.mEndTime;
    }
}
