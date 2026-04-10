package com.umeng.message.inapp;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.l;
import com.umeng.message.proguard.m;
import com.umeng.message.proguard.x;
import com.umeng.message.widget.UCloseView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class UmengCardMessage extends DialogFragment {
    private static final String a = UmengCardMessage.class.getName();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f20297r = 12;
    private Activity b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private UInAppMessage f20298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f20299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Bitmap f20300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ViewGroup f20301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f20302g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f20303h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f20304i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f20305j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private UInAppHandler f20306k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private IUmengInAppMsgCloseCallback f20307l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f20308m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f20309n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f20310o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f20311p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String[] f20312q = {"18", "16", "16"};

    private int a(boolean z2) {
        return z2 ? 1 : 0;
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f20301f != null) {
            RelativeLayout.LayoutParams layoutParams = configuration.orientation == 1 ? new RelativeLayout.LayoutParams(-1, -2) : new RelativeLayout.LayoutParams(-2, -1);
            int iA = m.a(this.b, 30.0f);
            int iA2 = m.a(this.b, 15.0f);
            layoutParams.setMargins(iA, iA2, iA, iA2);
            layoutParams.addRule(13);
            this.f20301f.setLayoutParams(layoutParams);
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onCreate(Bundle bundle) {
        String[] strArrB;
        super.onCreate(bundle);
        setStyle(2, R.style.Theme.NoTitleBar);
        setRetainInstance(true);
        try {
            this.b = getActivity();
            Bundle arguments = getArguments();
            this.f20298c = new UInAppMessage(new JSONObject(arguments.getString("msg")));
            this.f20299d = arguments.getString("label");
            byte[] byteArray = arguments.getByteArray("bitmapByte");
            if (byteArray != null) {
                this.f20300e = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            }
            this.f20306k = InAppMessageManager.getInstance(this.b).getInAppHandler();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int i2 = this.f20298c.msg_type;
        if ((i2 == 5 || i2 == 6) && (strArrB = InAppMessageManager.getInstance(this.b).b()) != null) {
            this.f20312q = strArrB;
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.requestWindowFeature(1);
        return dialogOnCreateDialog;
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Rect rect;
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            this.f20303h = rect.height() - m.a(this.b, 65.0f);
            double d2 = this.f20303h;
            Double.isNaN(d2);
            this.f20302g = (int) (d2 * 1.2d);
            this.f20304i = rect.width() - m.a(this.b, 70.0f);
            this.f20305j = (this.f20304i / 2) * 3;
        } else {
            rect = null;
        }
        int i2 = this.f20298c.msg_type;
        if (i2 == 2 || i2 == 3) {
            return a();
        }
        if (i2 == 4) {
            return a(layoutInflater, viewGroup, bundle);
        }
        if ((i2 == 5 || i2 == 6) && rect != null) {
            return a(rect);
        }
        return null;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        x xVarA = x.a(this.b);
        UInAppMessage uInAppMessage = this.f20298c;
        xVarA.a(uInAppMessage.msg_id, uInAppMessage.msg_type, 0, a(this.f20309n), 0, 0, a(this.f20311p), 0, a(this.f20310o));
        this.f20311p = false;
        this.f20309n = false;
        this.f20310o = false;
        this.f20308m = false;
        IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback = this.f20307l;
        if (iUmengInAppMsgCloseCallback != null) {
            iUmengInAppMsgCloseCallback.onClose();
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        if (!this.f20308m) {
            x xVarA = x.a(this.b);
            UInAppMessage uInAppMessage = this.f20298c;
            xVarA.a(uInAppMessage.msg_id, uInAppMessage.msg_type, 1, 0, 0, 0, 0, 0, 0);
        }
        this.f20308m = true;
    }

    private View a() {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(Color.parseColor("#33000000"));
        if (getResources().getConfiguration().orientation == 1) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        } else if (this.f20298c.msg_type == 2) {
            layoutParams = new RelativeLayout.LayoutParams(this.f20302g, this.f20303h);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        }
        int iA = m.a(this.b, 30.0f);
        int iA2 = m.a(this.b, 15.0f);
        layoutParams.setMargins(iA, iA2, iA, iA2);
        layoutParams.addRule(13);
        this.f20301f = new FrameLayout(this.b);
        this.f20301f.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        int iA3 = m.a(this.b, 12.0f);
        layoutParams2.setMargins(iA3, iA3, iA3, iA3);
        ImageView imageView = new ImageView(this.b);
        imageView.setLayoutParams(layoutParams2);
        imageView.setAdjustViewBounds(true);
        imageView.setId(l.a());
        imageView.setImageBitmap(this.f20300e);
        this.f20301f.addView(imageView);
        int iA4 = m.a(this.b, 24.0f);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iA4, iA4, 5);
        UCloseView uCloseView = new UCloseView(this.b);
        uCloseView.setLayoutParams(layoutParams3);
        this.f20301f.addView(uCloseView);
        relativeLayout.addView(this.f20301f);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UmengCardMessage.this.f20309n = true;
                if (TextUtils.equals("none", UmengCardMessage.this.f20298c.action_type)) {
                    return;
                }
                UmengCardMessage.this.f20306k.handleInAppMessage(UmengCardMessage.this.b, UmengCardMessage.this.f20298c, 16);
                UmengCardMessage.this.dismiss();
            }
        });
        uCloseView.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UmengCardMessage.this.f20311p = true;
                UmengCardMessage.this.dismiss();
            }
        });
        return relativeLayout;
    }

    private View a(Rect rect) {
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(Color.parseColor("#33000000"));
        if (getResources().getConfiguration().orientation == 1) {
            this.f20304i = rect.width() - m.a(this.b, 70.0f);
            if (this.f20298c.msg_type == 5) {
                this.f20305j = (this.f20304i / 6) * 5;
            } else {
                this.f20305j = (this.f20304i / 2) * 3;
            }
        } else {
            this.f20305j = rect.height() - m.a(this.b, 65.0f);
            this.f20304i = (this.f20305j / 5) * 6;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f20304i, this.f20305j);
        layoutParams.addRule(13);
        LinearLayout linearLayout = new LinearLayout(this.b);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        int iA = m.a(this.b, 20.0f);
        layoutParams2.setMargins(iA, iA, iA, iA);
        TextView textView = new TextView(this.b);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        textView.setText(this.f20298c.title);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        textView.setTextSize(Integer.parseInt(this.f20312q[0]));
        textView.setTextColor(Color.parseColor("#000000"));
        linearLayout.addView(textView);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.setMargins(iA, 0, iA, 0);
        layoutParams3.weight = 1.0f;
        ScrollView scrollView = new ScrollView(this.b);
        scrollView.setLayoutParams(layoutParams3);
        scrollView.setScrollBarStyle(16777216);
        scrollView.setVerticalScrollBarEnabled(false);
        TextView textView2 = new TextView(this.b);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView2.setText(this.f20298c.content);
        textView2.setTextSize(Integer.parseInt(this.f20312q[1]));
        textView2.setTextColor(Color.parseColor("#000000"));
        scrollView.addView(textView2);
        linearLayout.addView(scrollView);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(m.a(this.b, 1.0f), Color.parseColor("#D8D8D8"));
        gradientDrawable.setCornerRadius(20.0f);
        gradientDrawable.setColor(-1);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, m.a(this.b, 35.0f));
        layoutParams4.setMargins(iA, m.a(this.b, 30.0f), iA, iA);
        TextView textView3 = new TextView(this.b);
        textView3.setLayoutParams(layoutParams4);
        textView3.setGravity(17);
        textView3.setBackgroundColor(Color.parseColor("#FFFFFF"));
        textView3.setText(this.f20298c.button_text);
        textView3.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        textView3.setTextSize(Integer.parseInt(this.f20312q[2]));
        textView3.setTextColor(Color.parseColor("#000000"));
        textView3.setBackgroundDrawable(gradientDrawable);
        linearLayout.addView(textView3);
        relativeLayout.addView(linearLayout);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UmengCardMessage.this.f20309n = true;
                UmengCardMessage.this.f20306k.handleInAppMessage(UmengCardMessage.this.b, UmengCardMessage.this.f20298c, 18);
                UmengCardMessage.this.dismiss();
            }
        });
        return relativeLayout;
    }

    private View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(b.a("umeng_custom_card_message"), viewGroup, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(b.b("umeng_card_message_image"));
        Button button = (Button) viewInflate.findViewById(b.b("umeng_card_message_ok"));
        Button button2 = (Button) viewInflate.findViewById(b.b("umeng_card_message_close"));
        imageView.setImageBitmap(this.f20300e);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UmengCardMessage.this.f20309n = true;
                if (TextUtils.equals("none", UmengCardMessage.this.f20298c.action_type)) {
                    return;
                }
                UmengCardMessage.this.f20306k.handleInAppMessage(UmengCardMessage.this.b, UmengCardMessage.this.f20298c, 16);
                UmengCardMessage.this.dismiss();
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UmengCardMessage.this.f20310o = true;
                if (TextUtils.equals("none", UmengCardMessage.this.f20298c.action_type)) {
                    return;
                }
                UmengCardMessage.this.f20306k.handleInAppMessage(UmengCardMessage.this.b, UmengCardMessage.this.f20298c, 19);
                UmengCardMessage.this.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UmengCardMessage.this.f20311p = true;
                UmengCardMessage.this.dismiss();
            }
        });
        return viewInflate;
    }

    public void a(IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback) {
        this.f20307l = iUmengInAppMsgCloseCallback;
    }
}
