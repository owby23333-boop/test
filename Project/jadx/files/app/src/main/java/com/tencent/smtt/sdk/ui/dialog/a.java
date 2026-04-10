package com.tencent.smtt.sdk.ui.dialog;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.sdk.ui.dialog.widget.RoundImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a extends ArrayAdapter<b> implements View.OnClickListener, ListAdapter {
    private ArrayList<b> a;
    private b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Intent f19100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakReference<ListView> f19101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WeakReference<d> f19102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f19103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f19104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<b> f19105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f19106i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String[] f19107j;

    public a(Context context, Intent intent, b bVar, List<b> list, b bVar2, d dVar, ListView listView) {
        super(context, 0);
        this.b = null;
        a(dVar);
        a(listView);
        this.f19104g = bVar;
        this.f19100c = intent;
        if ("com.tencent.rtxlite".equalsIgnoreCase(context.getApplicationContext().getPackageName()) || MttLoader.isBrowserInstalled(context)) {
            this.f19103f = null;
        } else {
            this.f19103f = this.f19104g;
        }
        this.f19105h = list;
        this.f19106i = new Handler() { // from class: com.tencent.smtt.sdk.ui.dialog.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                a.this.b();
            }
        };
        this.f19107j = new String[2];
        this.f19107j[0] = e.b("x5_tbs_activity_picker_recommend_to_trim");
        this.f19107j[1] = e.b("x5_tbs_activity_picker_recommend_with_chinese_brace_to_trim");
        a(context, bVar2);
    }

    private View a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, new ColorDrawable(Color.argb(41, 0, 0, 0)));
        stateListDrawable.addState(new int[]{-16842919}, new ColorDrawable(0));
        linearLayout.setBackgroundDrawable(stateListDrawable);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, c.a(getContext(), 144.0f)));
        RoundImageView roundImageView = new RoundImageView(context);
        roundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a(getContext(), 96.0f), c.a(getContext(), 96.0f));
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        layoutParams.setMargins(c.a(getContext(), 32.0f), c.a(getContext(), 24.0f), c.a(getContext(), 24.0f), c.a(getContext(), 24.0f));
        roundImageView.setLayoutParams(layoutParams);
        roundImageView.setId(101);
        relativeLayout.addView(roundImageView);
        LinearLayout linearLayout2 = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, 101);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setMaxLines(1);
        textView.setTextColor(Color.rgb(29, 29, 29));
        textView.setTextSize(1, 17.0f);
        textView.setId(102);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView2.setText(e.b("x5_tbs_wechat_activity_picker_label_recommend"));
        textView2.setTextColor(Color.parseColor("#00CAFC"));
        textView2.setTextSize(1, 14.0f);
        textView2.setId(103);
        linearLayout2.addView(textView2);
        relativeLayout.addView(linearLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(c.a(getContext(), 48.0f), c.a(getContext(), 48.0f));
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        layoutParams3.setMargins(0, 0, c.a(getContext(), 32.0f), 0);
        imageView.setLayoutParams(layoutParams3);
        imageView.setImageDrawable(e.a("x5_tbs_activity_picker_check"));
        imageView.setId(104);
        relativeLayout.addView(imageView);
        relativeLayout.setId(105);
        linearLayout.addView(relativeLayout);
        return linearLayout;
    }

    private void a(b bVar, View view) {
        if (view == null || bVar == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(101);
        TextView textView = (TextView) view.findViewById(102);
        TextView textView2 = (TextView) view.findViewById(103);
        ImageView imageView2 = (ImageView) view.findViewById(104);
        View viewFindViewById = view.findViewById(105);
        View viewFindViewById2 = view.findViewById(106);
        imageView.setImageDrawable(bVar.a());
        String strReplaceAll = bVar.b().trim().replaceAll(" ", "");
        String strReplaceAll2 = strReplaceAll;
        for (String str : this.f19107j) {
            if (str != null && str.length() > 0) {
                strReplaceAll2 = strReplaceAll2.replaceAll(str, "");
            }
        }
        textView.setText(strReplaceAll2);
        if (bVar.c() == null) {
            bVar.a(a(bVar));
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.smtt.sdk.ui.dialog.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object parent = view2.getParent();
                if (parent instanceof View) {
                    View view3 = (View) parent;
                    if (view3.getTag() == a.this.f19103f) {
                        a.this.onClick(view3);
                    }
                }
            }
        });
        if (TbsConfig.APP_QB.equals(bVar.d())) {
            textView2.setVisibility(0);
            textView2.setText(bVar.h());
        } else {
            textView2.setVisibility(8);
        }
        viewFindViewById.setClickable(false);
        viewFindViewById.setEnabled(false);
        if (bVar == this.b) {
            imageView2.setVisibility(0);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(0);
            }
        } else {
            imageView2.setVisibility(8);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(8);
            }
        }
        view.setTag(bVar);
        view.setOnClickListener(this);
    }

    private void a(boolean z2) {
        d dVar;
        WeakReference<d> weakReference = this.f19102e;
        if (weakReference == null || (dVar = weakReference.get()) == null) {
            return;
        }
        dVar.a(z2);
    }

    public static boolean a(Context context, String str) {
        if (str != null && !"".equals(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    private void b(Context context, b bVar) {
        this.b = bVar;
        b bVar2 = this.b;
        if (bVar2 == null) {
            return;
        }
        a((bVar2.e() || this.b.f()) ? true : a(context, this.b.d()));
    }

    public ResolveInfo a(b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.d())) {
            for (ResolveInfo resolveInfo : getContext().getPackageManager().queryIntentActivities(this.f19100c, 65536)) {
                if (bVar.d().equals(resolveInfo.activityInfo.packageName)) {
                    return resolveInfo;
                }
            }
        }
        return null;
    }

    public b a() {
        return this.b;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b getItem(int i2) {
        if (i2 < 0 || i2 >= this.a.size()) {
            return null;
        }
        return this.a.get(i2);
    }

    void a(Context context, b bVar) {
        b bVar2;
        this.a = new ArrayList<>();
        List<b> list = this.f19105h;
        if (list != null && list.size() != 0) {
            this.a.addAll(this.f19105h);
        }
        boolean z2 = false;
        boolean z3 = false;
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(this.f19100c, 65536)) {
            if (b.a(context, resolveInfo.activityInfo.packageName) != null || resolveInfo.loadIcon(context.getPackageManager()) != null) {
                b bVar3 = new b(context, resolveInfo);
                b bVar4 = this.f19103f;
                if (bVar4 != null && bVar4.d().equals(resolveInfo.activityInfo.packageName)) {
                    bVar3.a(this.f19103f.f());
                    bVar3.a(this.f19103f.h());
                    bVar3.a(this.f19103f.a());
                    this.a.add(0, bVar3);
                    z2 = true;
                } else if (TbsConfig.APP_QB.equals(resolveInfo.activityInfo.packageName)) {
                    b bVar5 = this.f19104g;
                    if (bVar5 != null) {
                        bVar3.a(bVar5.f());
                        bVar3.a(this.f19104g.h());
                        bVar3.a(this.f19104g.a());
                    }
                    this.a.add(0, bVar3);
                } else {
                    this.a.add(bVar3);
                }
                if (!z3 && bVar != null && bVar3.d().equals(bVar.d())) {
                    b(context, bVar3);
                    z3 = true;
                }
            }
        }
        if (!z2 && (bVar2 = this.f19103f) != null) {
            this.a.add(0, bVar2);
        }
        if (z3 || this.a.size() <= 0) {
            return;
        }
        b(context, this.a.get(0));
    }

    void a(ListView listView) {
        this.f19101d = new WeakReference<>(listView);
    }

    void a(d dVar) {
        this.f19102e = new WeakReference<>(dVar);
    }

    public void b() {
        View viewFindViewWithTag;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f19106i.obtainMessage(1).sendToTarget();
            return;
        }
        ListView listView = this.f19101d.get();
        if (listView == null || (viewFindViewWithTag = listView.findViewWithTag(this.f19103f)) == null) {
            return;
        }
        a(this.f19103f, viewFindViewWithTag);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.a.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b item = getItem(i2);
        if (item == null) {
            return null;
        }
        if (view == null) {
            view = a(getContext());
        }
        a(item, view);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        Object tag = view.getTag();
        if (tag == null || !(tag instanceof b) || (bVar = (b) tag) == this.b) {
            return;
        }
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        b bVar2 = this.b;
        b(view.getContext(), bVar);
        a(bVar2, view2.findViewWithTag(bVar2));
        a(this.b, view);
    }
}
