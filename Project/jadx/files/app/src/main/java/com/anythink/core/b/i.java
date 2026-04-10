package com.anythink.core.b;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.k.s;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static String a = "i";
    com.anythink.core.common.e.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Map<String, Object> f6564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    a f6565d;

    /* JADX INFO: renamed from: com.anythink.core.b.i$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ ATBaseAdAdapter a;
        final /* synthetic */ ai b;

        AnonymousClass1(ATBaseAdAdapter aTBaseAdAdapter, ai aiVar) {
            this.a = aTBaseAdAdapter;
            this.b = aiVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i.a(i.this, this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.b.i$2, reason: invalid class name */
    final class AnonymousClass2 implements ATBidRequestInfoListener {
        final /* synthetic */ ai a;

        AnonymousClass2(ai aiVar) {
            this.a = aiVar;
        }

        @Override // com.anythink.core.api.ATBidRequestInfoListener
        public final void onFailed(String str) {
            a aVar = i.this.f6565d;
            if (aVar != null) {
                aVar.a(str, this.a);
            }
        }

        @Override // com.anythink.core.api.ATBidRequestInfoListener
        public final void onSuccess(ATBidRequestInfo aTBidRequestInfo) {
            i.a(i.this, this.a, aTBidRequestInfo);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.b.i$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ ATBidRequestInfo a;
        final /* synthetic */ ai b;

        AnonymousClass3(ATBidRequestInfo aTBidRequestInfo, ai aiVar) {
            this.a = aTBidRequestInfo;
            this.b = aiVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            JSONObject requestJSONObject;
            try {
                if (this.a != null && (requestJSONObject = this.a.toRequestJSONObject()) != null) {
                    ATBidRequestInfo.fillBaseCommonParams(requestJSONObject, String.valueOf(i.this.b.f7082e), i.this.b.f7091n, this.b);
                    if (this.b.l() == 3) {
                        try {
                            requestJSONObject.put("unit_id", this.b.t());
                            requestJSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.EXCLUDE_OFFER, n.a().l());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    if (i.this.f6565d != null) {
                        i.this.f6565d.a(this.b, requestJSONObject);
                        return;
                    }
                    return;
                }
                if (i.this.f6565d != null) {
                    i.this.f6565d.a(ATBidRequestInfo.RETURN_PARAMS_ERROR_TYPE, this.b);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                a aVar = i.this.f6565d;
                if (aVar != null) {
                    aVar.a(th2.getMessage(), this.b);
                }
            }
        }
    }

    public interface a {
        void a(ai aiVar, ATBaseAdAdapter aTBaseAdAdapter);

        void a(ai aiVar, JSONObject jSONObject);

        void a(String str, ai aiVar);
    }

    public i(com.anythink.core.common.e.a aVar) {
        this.b = aVar;
        this.f6564c = aVar.f7094q;
    }

    private void a(ai aiVar, a aVar) {
        this.f6565d = aVar;
        ATBaseAdAdapter aTBaseAdAdapterA = com.anythink.core.common.k.i.a(aiVar);
        if (aTBaseAdAdapterA == null) {
            aVar.a(ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE, aiVar);
        } else {
            com.anythink.core.common.k.b.a.a().a(new AnonymousClass1(aTBaseAdAdapterA, aiVar));
        }
    }

    private void a(ATBaseAdAdapter aTBaseAdAdapter, ai aiVar) {
        try {
            Map<String, Object> mapA = this.b.f7091n.a(this.b.f7081d, this.b.f7080c, aiVar);
            com.anythink.core.common.e.e eVarN = this.b.f7096s.N();
            s.a(eVarN, aiVar, 0, false);
            com.anythink.core.common.k.g.a(mapA, eVarN);
            aTBaseAdAdapter.getBidRequestInfo(this.b.a, mapA, this.f6564c, new AnonymousClass2(aiVar));
            if (this.f6565d != null) {
                this.f6565d.a(aiVar, aTBaseAdAdapter);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a aVar = this.f6565d;
            if (aVar != null) {
                aVar.a(th.getMessage(), aiVar);
            }
        }
    }

    private void a(ai aiVar, ATBidRequestInfo aTBidRequestInfo) {
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass3(aTBidRequestInfo, aiVar));
    }

    static /* synthetic */ void a(i iVar, ATBaseAdAdapter aTBaseAdAdapter, ai aiVar) {
        try {
            Map<String, Object> mapA = iVar.b.f7091n.a(iVar.b.f7081d, iVar.b.f7080c, aiVar);
            com.anythink.core.common.e.e eVarN = iVar.b.f7096s.N();
            s.a(eVarN, aiVar, 0, false);
            com.anythink.core.common.k.g.a(mapA, eVarN);
            aTBaseAdAdapter.getBidRequestInfo(iVar.b.a, mapA, iVar.f6564c, iVar.new AnonymousClass2(aiVar));
            if (iVar.f6565d != null) {
                iVar.f6565d.a(aiVar, aTBaseAdAdapter);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a aVar = iVar.f6565d;
            if (aVar != null) {
                aVar.a(th.getMessage(), aiVar);
            }
        }
    }

    static /* synthetic */ void a(i iVar, ai aiVar, ATBidRequestInfo aTBidRequestInfo) {
        com.anythink.core.common.k.b.a.a().a(iVar.new AnonymousClass3(aTBidRequestInfo, aiVar));
    }
}
