package com.facebook.rebound.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TableLayout;
import android.widget.TextView;
import com.arialyy.aria.core.listener.ISchedulers;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.tencent.smtt.sdk.TbsListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import l.a.a.g;
import l.a.a.h;
import l.a.a.j;

/* JADX INFO: loaded from: classes2.dex */
public class SpringConfiguratorView extends FrameLayout {
    private static final DecimalFormat F = new DecimalFormat("#.#");
    private SeekBar A;
    private Spinner B;
    private TextView C;
    private TextView D;
    private l.a.a.f E;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final e f14795s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final List<l.a.a.f> f14796t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final l.a.a.e f14797u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final float f14798v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final float f14799w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final g f14800x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f14801y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private SeekBar f14802z;

    private class b implements View.OnTouchListener {
        private b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return true;
            }
            SpringConfiguratorView.this.c();
            return true;
        }
    }

    private class c implements h {
        private c() {
        }

        @Override // l.a.a.h
        public void a(l.a.a.e eVar) {
            float fA = (float) eVar.a();
            float f2 = SpringConfiguratorView.this.f14799w;
            SpringConfiguratorView.this.setTranslationY((fA * (SpringConfiguratorView.this.f14798v - f2)) + f2);
        }

        @Override // l.a.a.h
        public void b(l.a.a.e eVar) {
        }

        @Override // l.a.a.h
        public void c(l.a.a.e eVar) {
        }

        @Override // l.a.a.h
        public void d(l.a.a.e eVar) {
        }
    }

    private class d implements SeekBar.OnSeekBarChangeListener {
        private d() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            if (seekBar == SpringConfiguratorView.this.f14802z) {
                double d2 = ((i2 * 200.0f) / 100000.0f) + 0.0f;
                SpringConfiguratorView.this.E.b = l.a.a.c.d(d2);
                String str = SpringConfiguratorView.F.format(d2);
                SpringConfiguratorView.this.D.setText("T:" + str);
            }
            if (seekBar == SpringConfiguratorView.this.A) {
                double d3 = ((i2 * 50.0f) / 100000.0f) + 0.0f;
                SpringConfiguratorView.this.E.a = l.a.a.c.a(d3);
                String str2 = SpringConfiguratorView.F.format(d3);
                SpringConfiguratorView.this.C.setText("F:" + str2);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    private class f implements AdapterView.OnItemSelectedListener {
        private f() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            SpringConfiguratorView springConfiguratorView = SpringConfiguratorView.this;
            springConfiguratorView.E = (l.a.a.f) springConfiguratorView.f14796t.get(i2);
            SpringConfiguratorView springConfiguratorView2 = SpringConfiguratorView.this;
            springConfiguratorView2.a(springConfiguratorView2.E);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public SpringConfiguratorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private class e extends BaseAdapter {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final Context f14804s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final List<String> f14805t = new ArrayList();

        public e(Context context) {
            this.f14804s = context;
        }

        public void a(String str) {
            this.f14805t.add(str);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f14805t.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return this.f14805t.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            TextView textView;
            if (view == null) {
                textView = new TextView(this.f14804s);
                textView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                int iA = com.facebook.rebound.ui.a.a(12.0f, SpringConfiguratorView.this.getResources());
                textView.setPadding(iA, iA, iA, iA);
                textView.setTextColor(SpringConfiguratorView.this.f14801y);
            } else {
                textView = (TextView) view;
            }
            textView.setText(this.f14805t.get(i2));
            return textView;
        }

        public void a() {
            this.f14805t.clear();
            notifyDataSetChanged();
        }
    }

    @TargetApi(11)
    public SpringConfiguratorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14796t = new ArrayList();
        this.f14801y = Color.argb(255, TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR);
        j jVarC = j.c();
        this.f14800x = g.b();
        this.f14795s = new e(context);
        Resources resources = getResources();
        this.f14799w = com.facebook.rebound.ui.a.a(40.0f, resources);
        this.f14798v = com.facebook.rebound.ui.a.a(280.0f, resources);
        this.f14797u = jVarC.a();
        c cVar = new c();
        l.a.a.e eVar = this.f14797u;
        eVar.b(1.0d);
        eVar.c(1.0d);
        eVar.a(cVar);
        addView(a(context));
        d dVar = new d();
        this.f14802z.setMax(100000);
        this.f14802z.setOnSeekBarChangeListener(dVar);
        this.A.setMax(100000);
        this.A.setOnSeekBarChangeListener(dVar);
        this.B.setAdapter((SpinnerAdapter) this.f14795s);
        this.B.setOnItemSelectedListener(new f());
        a();
        setTranslationY(this.f14798v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f14797u.c(this.f14797u.b() == 1.0d ? PangleAdapterUtils.CPM_DEFLAUT_VALUE : 1.0d);
    }

    private View a(Context context) {
        Resources resources = getResources();
        int iA = com.facebook.rebound.ui.a.a(5.0f, resources);
        int iA2 = com.facebook.rebound.ui.a.a(10.0f, resources);
        int iA3 = com.facebook.rebound.ui.a.a(20.0f, resources);
        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMargins(0, 0, iA, 0);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(com.facebook.rebound.ui.a.a(-1, com.facebook.rebound.ui.a.a(300.0f, resources)));
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParamsA = com.facebook.rebound.ui.a.a();
        layoutParamsA.setMargins(0, iA3, 0, 0);
        frameLayout2.setLayoutParams(layoutParamsA);
        frameLayout2.setBackgroundColor(Color.argb(100, 0, 0, 0));
        frameLayout.addView(frameLayout2);
        this.B = new Spinner(context, 0);
        FrameLayout.LayoutParams layoutParamsB = com.facebook.rebound.ui.a.b();
        layoutParamsB.gravity = 48;
        layoutParamsB.setMargins(iA2, iA2, iA2, 0);
        this.B.setLayoutParams(layoutParamsB);
        frameLayout2.addView(this.B);
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParamsB2 = com.facebook.rebound.ui.a.b();
        layoutParamsB2.setMargins(0, 0, 0, com.facebook.rebound.ui.a.a(80.0f, resources));
        layoutParamsB2.gravity = 80;
        linearLayout.setLayoutParams(layoutParamsB2);
        linearLayout.setOrientation(1);
        frameLayout2.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParamsB3 = com.facebook.rebound.ui.a.b();
        layoutParamsB3.setMargins(iA2, iA2, iA2, iA3);
        linearLayout2.setPadding(iA2, iA2, iA2, iA2);
        linearLayout2.setLayoutParams(layoutParamsB3);
        linearLayout2.setOrientation(0);
        linearLayout.addView(linearLayout2);
        this.f14802z = new SeekBar(context);
        this.f14802z.setLayoutParams(layoutParams);
        linearLayout2.addView(this.f14802z);
        this.D = new TextView(getContext());
        this.D.setTextColor(this.f14801y);
        FrameLayout.LayoutParams layoutParamsA2 = com.facebook.rebound.ui.a.a(com.facebook.rebound.ui.a.a(50.0f, resources), -1);
        this.D.setGravity(19);
        this.D.setLayoutParams(layoutParamsA2);
        this.D.setMaxLines(1);
        linearLayout2.addView(this.D);
        LinearLayout linearLayout3 = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParamsB4 = com.facebook.rebound.ui.a.b();
        layoutParamsB4.setMargins(iA2, iA2, iA2, iA3);
        linearLayout3.setPadding(iA2, iA2, iA2, iA2);
        linearLayout3.setLayoutParams(layoutParamsB4);
        linearLayout3.setOrientation(0);
        linearLayout.addView(linearLayout3);
        this.A = new SeekBar(context);
        this.A.setLayoutParams(layoutParams);
        linearLayout3.addView(this.A);
        this.C = new TextView(getContext());
        this.C.setTextColor(this.f14801y);
        FrameLayout.LayoutParams layoutParamsA3 = com.facebook.rebound.ui.a.a(com.facebook.rebound.ui.a.a(50.0f, resources), -1);
        this.C.setGravity(19);
        this.C.setLayoutParams(layoutParamsA3);
        this.C.setMaxLines(1);
        linearLayout3.addView(this.C);
        View view = new View(context);
        FrameLayout.LayoutParams layoutParamsA4 = com.facebook.rebound.ui.a.a(com.facebook.rebound.ui.a.a(60.0f, resources), com.facebook.rebound.ui.a.a(40.0f, resources));
        layoutParamsA4.gravity = 49;
        view.setLayoutParams(layoutParamsA4);
        view.setOnTouchListener(new b());
        view.setBackgroundColor(Color.argb(255, 0, ISchedulers.SUB_CANCEL, 209));
        frameLayout.addView(view);
        return frameLayout;
    }

    public void a() {
        Map<l.a.a.f, String> mapA = this.f14800x.a();
        this.f14795s.a();
        this.f14796t.clear();
        for (Map.Entry<l.a.a.f, String> entry : mapA.entrySet()) {
            if (entry.getKey() != l.a.a.f.f21029c) {
                this.f14796t.add(entry.getKey());
                this.f14795s.a(entry.getValue());
            }
        }
        this.f14796t.add(l.a.a.f.f21029c);
        this.f14795s.a(mapA.get(l.a.a.f.f21029c));
        this.f14795s.notifyDataSetChanged();
        if (this.f14796t.size() > 0) {
            this.B.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l.a.a.f fVar) {
        int iRound = Math.round(((((float) l.a.a.c.c(fVar.b)) - 0.0f) * 100000.0f) / 200.0f);
        int iRound2 = Math.round(((((float) l.a.a.c.b(fVar.a)) - 0.0f) * 100000.0f) / 50.0f);
        this.f14802z.setProgress(iRound);
        this.A.setProgress(iRound2);
    }
}
