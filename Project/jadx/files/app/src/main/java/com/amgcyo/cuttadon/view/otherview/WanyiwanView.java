package com.amgcyo.cuttadon.view.otherview;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amgcyo.cuttadon.adapter.other.t;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.api.entity.other.NewApiAdList;
import com.amgcyo.cuttadon.utils.otherutils.b0;
import com.amgcyo.cuttadon.utils.otherutils.u;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class WanyiwanView extends FrameLayout {
    private String[] A;
    private int B;
    protected Disposable C;
    private Handler D;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    View f5094s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    RecyclerView f5095t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    LinearLayout f5096u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    TextView f5097v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    ImageView f5098w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    t f5099x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Context f5100y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private me.jessyan.art.c.e.c f5101z;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 4 || WanyiwanView.this.f5100y == null || WanyiwanView.this.f5101z == null || WanyiwanView.this.A == null || WanyiwanView.this.B <= 0) {
                return;
            }
            WanyiwanView wanyiwanView = WanyiwanView.this;
            if (wanyiwanView.f5099x != null) {
                List wanyiwanListData = wanyiwanView.getWanyiwanListData();
                if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) wanyiwanListData)) {
                    return;
                }
                WanyiwanView.this.f5099x.b((Collection) wanyiwanListData);
            }
        }
    }

    public WanyiwanView(Context context) {
        super(context);
        this.D = new a(Looper.getMainLooper());
        this.f5100y = context;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<NewApiAd> getWanyiwanListData() {
        NewApiAdList newApiAdListB = com.amgcyo.cuttadon.utils.otherutils.h.b();
        ArrayList arrayList = null;
        if (newApiAdListB == null) {
            return null;
        }
        List<NewApiAd> type_6 = newApiAdListB.getType_6();
        if (com.amgcyo.cuttadon.utils.otherutils.g.b(type_6)) {
            List<NewApiAd> listA = com.amgcyo.cuttadon.utils.otherutils.g.a(type_6, this.B);
            if (com.amgcyo.cuttadon.utils.otherutils.g.b((List<?>) listA)) {
                arrayList = new ArrayList();
                for (NewApiAd newApiAd : listA) {
                    newApiAd.setOwnerType("玩一玩");
                    newApiAd.setLocation(this.A[1]);
                    arrayList.add(newApiAd);
                }
            }
        }
        return arrayList;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (isInEditMode()) {
            return;
        }
        if (i2 != 0) {
            b();
            return;
        }
        int iN = com.amgcyo.cuttadon.utils.otherutils.h.N();
        if (iN > 0) {
            a(iN);
        }
    }

    private void b() {
        Disposable disposable = this.C;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.C.dispose();
    }

    private void c() {
        Context context = this.f5100y;
        if (context == null) {
            return;
        }
        this.f5094s = LayoutInflater.from(context).inflate(R.layout.mk_view_wanyiwan, (ViewGroup) null);
        View view = this.f5094s;
        if (view == null) {
            return;
        }
        this.f5095t = (RecyclerView) view.findViewById(R.id.recycler_view);
        this.f5095t.setHasFixedSize(true);
        this.f5095t.setNestedScrollingEnabled(false);
        this.f5096u = (LinearLayout) this.f5094s.findViewById(R.id.ll_change);
        this.f5098w = (ImageView) this.f5094s.findViewById(R.id.img_change);
        this.f5097v = (TextView) this.f5094s.findViewById(R.id.tv_top_title);
        this.f5095t.setLayoutManager(new LinearLayoutManager(this.f5100y));
        this.f5096u.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.otherview.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f5114s.a(view2);
            }
        });
    }

    public /* synthetic */ void a(View view) {
        this.f5098w.startAnimation(u.a(this.f5100y));
        final List<NewApiAd> wanyiwanListData = getWanyiwanListData();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(wanyiwanListData)) {
            return;
        }
        new Handler().postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.view.otherview.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f5110s.a(wanyiwanListData);
            }
        }, 400L);
    }

    public WanyiwanView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = new a(Looper.getMainLooper());
        this.f5100y = context;
        c();
    }

    public /* synthetic */ void a(List list) {
        this.f5099x.b((Collection) list);
        this.f5098w.clearAnimation();
    }

    public void a(me.jessyan.art.c.e.c cVar, String[] strArr, final Context context, int i2) {
        boolean zM0 = com.amgcyo.cuttadon.utils.otherutils.h.M0();
        if (context != null && strArr != null && zM0) {
            if (com.amgcyo.cuttadon.utils.otherutils.h.O() == 0) {
                setVisibility(8);
                return;
            }
            this.f5101z = cVar;
            this.A = strArr;
            this.B = i2;
            List<NewApiAd> wanyiwanListData = getWanyiwanListData();
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(wanyiwanListData) && this.f5095t != null && this.f5094s != null) {
                String str = "大小：" + wanyiwanListData.size();
                this.f5097v.setText(com.amgcyo.cuttadon.f.o.d(R.string.wanyiwandajia));
                this.f5099x = new t(cVar);
                this.f5095t.setAdapter(this.f5099x);
                if (!com.amgcyo.cuttadon.utils.otherutils.g.a(wanyiwanListData)) {
                    this.f5099x.b((Collection) wanyiwanListData);
                    this.f5099x.a(new BaseQuickAdapter.g() { // from class: com.amgcyo.cuttadon.view.otherview.i
                        @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
                        public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                            this.f5112s.a(context, baseQuickAdapter, view, i3);
                        }
                    });
                }
                removeAllViews();
                addView(this.f5094s);
                setVisibility(0);
                if (context instanceof Activity) {
                    ((Activity) context).getWindow().setSoftInputMode(2);
                }
                for (NewApiAd newApiAd : wanyiwanListData) {
                    com.amgcyo.cuttadon.h.h.c.a(context, "OWNADSHOW", newApiAd, newApiAd.getLocation(), newApiAd.getOwnerType());
                }
                return;
            }
            setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    public /* synthetic */ void a(Context context, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        NewApiAd item = this.f5099x.getItem(i2);
        if (item != null) {
            com.amgcyo.cuttadon.h.h.a.a(context, item);
        }
    }

    public boolean a() {
        t tVar;
        return (getVisibility() != 0 || (tVar = this.f5099x) == null || com.amgcyo.cuttadon.utils.otherutils.g.a(tVar.getData())) ? false : true;
    }

    private void a(int i2) {
        b();
        if (this.D != null) {
            long j2 = i2;
            this.C = b0.a(j2, j2, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).subscribe(new Consumer() { // from class: com.amgcyo.cuttadon.view.otherview.g
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    this.f5109s.a((Long) obj);
                }
            });
        }
    }

    public /* synthetic */ void a(Long l2) throws Exception {
        Handler handler = this.D;
        if (handler != null) {
            handler.removeMessages(4);
            this.D.sendEmptyMessage(4);
        }
    }
}
