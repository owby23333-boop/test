package com.kwad.components.core.e;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.f;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.x;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends d implements f {
    private String JB;
    private long JC;
    private String JD;
    private Context mContext;

    private void ah(Context context) {
        b.i("EncryptComponentsImpl", "initGId");
        try {
            if (as.DS()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("64", 0);
                KWEGIDDFP.handlePolicy(jSONObject);
            }
        } catch (Throwable th) {
            b.printStackTrace(th);
        }
        KWEGIDDFP.instance().getEGidByCallback(context, false, new ResponseDfpCallback() { // from class: com.kwad.components.core.e.a.1
            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onFailed(int i2, String str) {
                b.e("EncryptComponentsImpl", "initGId onFailed errorCode:" + i2 + "errorMessage :" + str);
            }

            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onSuccess(String str, String str2) {
                b.d("initGId onSuccess", "deviceInfo：" + str2);
                a.this.nP();
                a.this.ap(str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(String str) {
        if (this.mContext == null || ba.isNullString(str) || ba.isEquals(nU(), str)) {
            return;
        }
        this.JD = str;
        x.W(this.mContext, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nP() {
        String strCf = x.cf(this.mContext);
        String strEB = bc.EB();
        if (TextUtils.isEmpty(strCf)) {
            x.O(this.mContext, strEB);
            return;
        }
        if (TextUtils.equals(strCf, strEB)) {
            return;
        }
        this.JB = "";
        this.JC = 0L;
        this.JD = "";
        x.N(this.mContext, this.JB);
        x.d(this.mContext, this.JC);
        x.W(this.mContext, this.JD);
        x.O(this.mContext, strEB);
    }

    private String nS() {
        if (TextUtils.isEmpty(this.JB)) {
            this.JB = x.cc(this.mContext);
        }
        return this.JB;
    }

    private long nT() {
        if (this.JC == 0) {
            this.JC = x.cd(this.mContext);
        }
        return this.JC;
    }

    private String nU() {
        if (TextUtils.isEmpty(this.JD)) {
            this.JD = x.ci(this.mContext);
        }
        return this.JD;
    }

    @Override // com.kwad.sdk.components.f
    public final void aq(String str) {
        if (this.mContext == null || ba.isNullString(str) || ba.isEquals(nS(), str)) {
            return;
        }
        try {
            this.JB = str;
            x.N(this.mContext, str);
            KWEGIDDFP.instance().setEgid(this.mContext, str);
        } catch (Throwable th) {
            b.e("EncryptComponentsImpl", "setEGid error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return f.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
        try {
            this.mContext = context;
            ah(context);
        } catch (Throwable th) {
            b.e("EncryptComponentsImpl", "initGId error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.f
    public final String nQ() {
        return (com.kwad.sdk.core.config.d.uC() || System.currentTimeMillis() >= nT() || TextUtils.isEmpty(nS())) ? nU() : "";
    }

    @Override // com.kwad.sdk.components.f
    public final com.kwad.sdk.core.kwai.f nR() {
        return new com.kwad.sdk.core.kwai.a();
    }

    @Override // com.kwad.sdk.components.d, com.kwad.sdk.components.a
    public final int priority() {
        return -200;
    }

    @Override // com.kwad.sdk.components.f
    public final void r(long j2) {
        if (this.mContext == null || j2 <= 0 || j2 == nT()) {
            return;
        }
        this.JC = j2;
        x.d(this.mContext, j2);
    }
}
