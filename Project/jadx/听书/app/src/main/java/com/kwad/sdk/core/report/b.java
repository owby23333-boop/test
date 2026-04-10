package com.kwad.sdk.core.report;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b<T extends e, R extends com.kwad.sdk.core.network.f> {
    private static ExecutorService aGh;
    private static volatile Handler iK;
    private T aGk;
    private Context mContext;
    private volatile long YL = 120000;
    protected l aGg = new m();
    private AtomicInteger aGi = new AtomicInteger(0);
    private AtomicInteger mRetryCount = new AtomicInteger(0);
    private int aGj = 5;

    protected abstract R A(List<T> list);

    protected b() {
        if (aGh == null) {
            aGh = GlobalThreadPools.Jr();
        }
    }

    public synchronized void j(Context context, int i) {
        this.mContext = context;
        if (iK == null) {
            iK = com.kwad.sdk.core.threads.a.Ji();
        }
    }

    protected final void a(l lVar) {
        this.aGg = lVar;
    }

    public final void a(final k<T> kVar) {
        aGh.execute(new Runnable() { // from class: com.kwad.sdk.core.report.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.iK != null && !b.iK.hasMessages(R.attr.childDivider)) {
                    b bVar = b.this;
                    bVar.aF(bVar.YL);
                }
                e eVarIo = kVar.Io();
                if (eVarIo != null) {
                    b.this.aGg.l(eVarIo);
                }
                if (b.this.Ij()) {
                    b.this.Ik();
                }
            }
        });
    }

    protected final boolean Ij() {
        int i = this.mRetryCount.get();
        if (i > 16) {
            i = 16;
        }
        s sVar = (s) ServiceProvider.get(s.class);
        return this.aGg.size() >= (sVar != null ? (long) (sVar.Bh() << i) : 20L);
    }

    public final void Ik() {
        aF(0L);
    }

    protected final void aE(long j) {
        if (j < 60) {
            this.YL = 60000L;
        } else {
            this.YL = j * 1000;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aF(long j) {
        if (iK == null) {
            return;
        }
        iK.removeMessages(R.attr.childDivider);
        Message messageObtain = Message.obtain(iK, a(this.mContext, this.aGg, this.aGi));
        messageObtain.what = R.attr.childDivider;
        iK.sendMessageDelayed(messageObtain, j);
    }

    protected Runnable a(Context context, l<T> lVar, AtomicInteger atomicInteger) {
        return new u(context, lVar, this, atomicInteger);
    }

    public final void a(final List<T> list, final AtomicBoolean atomicBoolean, final u.a aVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.aGi.getAndIncrement();
        new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.2
            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return ew(str);
            }

            private static BatchReportResult ew(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.aGh;
            }

            @Override // com.kwad.sdk.core.network.a
            public final R createRequest() {
                return (R) b.this.A(list);
            }
        }.request(new com.kwad.sdk.core.network.o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.3
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }

            private void a(BatchReportResult batchReportResult) {
                b.this.aGg.B(list);
                u.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.IH();
                }
                if (b.this.aGi.decrementAndGet() == 0 && atomicBoolean.get()) {
                    b.this.Il();
                }
                b.this.aE(batchReportResult.getInterval());
                b bVar = b.this;
                bVar.aF(bVar.YL);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(R r, int i, String str) {
                atomicBoolean.set(true);
                if (b.this.aGi.decrementAndGet() == 0) {
                    b.this.Il();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Il() {
        int andIncrement = this.mRetryCount.getAndIncrement();
        if (andIncrement <= this.aGj) {
            if (andIncrement > 0) {
                this.YL *= 2;
            }
            aF(this.YL);
        }
    }

    public final void b(k<T> kVar) {
        try {
            c(kVar);
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
    }

    private void c(final k<T> kVar) {
        new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.4
            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return ew(str);
            }

            private static BatchReportResult ew(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.a
            public final R createRequest() {
                e eVarIo = kVar.Io();
                b.this.aGk = eVarIo;
                return (R) b.this.a(eVarIo);
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.aGh;
            }
        }.request(new com.kwad.sdk.core.network.o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.5
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }

            private void a(BatchReportResult batchReportResult) {
                com.kwad.sdk.core.d.c.d("BaseBatchReporter", "立即上报 onSuccess action= " + b.this.aGk + " result " + batchReportResult.getResult());
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(R r, int i, String str) {
                com.kwad.sdk.core.d.c.e("BaseBatchReporter", "立即上报 onError errorCode:" + i + " errorMsg:" + str + "\naction=" + b.this.aGk);
                b.this.a((k) new k<T>() { // from class: com.kwad.sdk.core.report.b.5.1
                    @Override // com.kwad.sdk.core.report.k
                    public final T Io() {
                        return (T) b.this.aGk;
                    }
                });
            }
        });
    }

    protected R a(T t) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        return (R) A(arrayList);
    }
}
