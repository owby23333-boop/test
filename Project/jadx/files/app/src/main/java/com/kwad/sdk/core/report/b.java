package com.kwad.sdk.core.report;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.response.model.BatchReportResult;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T extends f, R extends com.kwad.sdk.core.network.g> {
    private static ExecutorService ahB;
    private static volatile Handler mHandler;
    private T ahE;
    private Context mContext;
    private volatile long ahz = 120000;
    private n ahA = new p();
    private AtomicInteger ahC = new AtomicInteger(0);
    private AtomicInteger mRetryCount = new AtomicInteger(0);
    private int ahD = 5;

    protected b() {
        if (ahB == null) {
            ahB = com.kwad.sdk.core.threads.b.ya();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Q(long j2) {
        if (mHandler == null) {
            return;
        }
        mHandler.removeMessages(R.attr.childDivider);
        Message messageObtain = Message.obtain(mHandler, a(this.mContext, this.ahA, this.ahC));
        messageObtain.what = R.attr.childDivider;
        mHandler.sendMessageDelayed(messageObtain, j2);
    }

    private void c(@NonNull final m<T> mVar) {
        new com.kwad.sdk.core.network.m<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.4
            @NonNull
            private static BatchReportResult ch(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final R createRequest() {
                f fVarXf = mVar.xf();
                b.this.ahE = fVarXf;
                return (R) b.this.a(fVarXf);
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.ahB;
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return ch(str);
            }
        }.request(new com.kwad.sdk.core.network.p<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.5
            private void a(@NonNull BatchReportResult batchReportResult) {
                com.kwad.sdk.core.d.b.d("BaseBatchReporter", "立即上报 onSuccess action= " + b.this.ahE + " result " + batchReportResult.getResult());
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
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final void onError(@NonNull R r2, int i2, String str) {
                b.this.a((m) new m<T>() { // from class: com.kwad.sdk.core.report.b.5.1
                    @Override // com.kwad.sdk.core.report.m
                    @NonNull
                    public final T xf() {
                        return (T) b.this.ahE;
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xa() {
        int i2 = this.mRetryCount.get();
        if (i2 > 16) {
            i2 = 16;
        }
        v vVar = (v) ServiceProvider.get(v.class);
        return this.ahA.size() >= (vVar != null ? (long) (vVar.sJ() << i2) : 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc() {
        int andIncrement = this.mRetryCount.getAndIncrement();
        if (andIncrement <= this.ahD) {
            if (andIncrement > 0) {
                this.ahz *= 2;
            }
            Q(this.ahz);
        }
    }

    protected final void P(long j2) {
        this.ahz = j2 < 60 ? 60000L : j2 * 1000;
    }

    protected R a(T t2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t2);
        return (R) p(arrayList);
    }

    protected Runnable a(Context context, n<T> nVar, AtomicInteger atomicInteger) {
        return new z(context, nVar, this, atomicInteger);
    }

    public final void a(@NonNull final m<T> mVar) {
        ahB.execute(new Runnable() { // from class: com.kwad.sdk.core.report.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.mHandler != null && !b.mHandler.hasMessages(R.attr.childDivider)) {
                    b bVar = b.this;
                    bVar.Q(bVar.ahz);
                }
                f fVarXf = mVar.xf();
                if (fVarXf != null) {
                    b.this.ahA.e(fVarXf);
                }
                if (b.this.xa()) {
                    b.this.xb();
                }
            }
        });
    }

    protected final void a(n nVar) {
        this.ahA = nVar;
    }

    public final void a(final List<T> list, final AtomicBoolean atomicBoolean) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.ahC.getAndIncrement();
        new com.kwad.sdk.core.network.m<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.2
            @NonNull
            private static BatchReportResult ch(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final R createRequest() {
                return (R) b.this.p(list);
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.ahB;
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return ch(str);
            }
        }.request(new com.kwad.sdk.core.network.p<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.3
            private void a(@NonNull BatchReportResult batchReportResult) {
                b.this.ahA.q(list);
                if (b.this.ahC.decrementAndGet() == 0 && atomicBoolean.get()) {
                    b.this.xc();
                }
                b.this.P(batchReportResult.getInterval());
                b bVar = b.this;
                bVar.Q(bVar.ahz);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final void onError(@NonNull R r2, int i2, String str) {
                atomicBoolean.set(true);
                if (b.this.ahC.decrementAndGet() == 0) {
                    b.this.xc();
                }
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    public final void b(@NonNull m<T> mVar) {
        try {
            c(mVar);
        } catch (Throwable th) {
            ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(th);
        }
    }

    public synchronized void i(Context context, int i2) {
        this.mContext = context;
        if (mHandler == null) {
            mHandler = com.kwad.sdk.core.threads.a.xV();
        }
    }

    protected abstract R p(List<T> list);

    public final void xb() {
        Q(0L);
    }
}
