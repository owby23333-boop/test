package com.kwad.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends c {
    private int bdA;
    private String bdB;
    private int bdC;
    private b bdx;
    private String bdy;
    private String bdz;

    public interface b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public e(a aVar) {
        super(aVar.mContext);
        a(aVar);
    }

    private void a(a aVar) {
        int color;
        int color2;
        if (aVar.mContext instanceof Activity) {
            setOwnerActivity((Activity) aVar.mContext);
        }
        this.bdx = aVar.bdx;
        this.bdy = aVar.bdy;
        this.bdz = !TextUtils.isEmpty(aVar.bdz) ? aVar.bdz : aVar.mContext.getString(R.string.ksad_no_title_common_dialog_positivebtn_title);
        if (aVar.bdA == 0) {
            color = aVar.mContext.getResources().getColor(R.color.ksad_no_title_common_dialog_positivebtn_color);
        } else {
            color = aVar.bdA;
        }
        this.bdA = color;
        this.bdB = !TextUtils.isEmpty(aVar.bdB) ? aVar.bdB : aVar.mContext.getString(R.string.ksad_no_title_common_dialog_negativebtn_title);
        if (aVar.bdC == 0) {
            color2 = aVar.mContext.getResources().getColor(R.color.ksad_no_title_common_dialog_negativebtn_color);
        } else {
            color2 = aVar.bdC;
        }
        this.bdC = color2;
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(rO());
            setCanceledOnTouchOutside(true);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private View rO() {
        View viewInflate = LayoutInflater.from(m.wrapContextIfNeed(getContext())).inflate(R.layout.ksad_no_title_common_dialog_content_layout, (ViewGroup) null, false);
        viewInflate.findViewById(R.id.ksad_no_title_common_dialog_layout).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (e.this.bdx != null) {
                    e.this.bdx.c(e.this);
                }
            }
        });
        TextView textView = (TextView) viewInflate.findViewById(R.id.ksad_no_title_common_positive_btn);
        if (!TextUtils.isEmpty(this.bdz)) {
            textView.setText(this.bdz);
        }
        textView.setTextColor(this.bdA);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.e.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (e.this.bdx != null) {
                    e.this.bdx.a(e.this);
                }
            }
        });
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ksad_no_title_common_negative_btn);
        if (!TextUtils.isEmpty(this.bdB)) {
            textView2.setText(this.bdB);
        }
        textView2.setTextColor(this.bdC);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.e.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (e.this.bdx != null) {
                    e.this.bdx.b(e.this);
                }
            }
        });
        ((TextView) viewInflate.findViewById(R.id.ksad_no_title_common_content_text)).setText(this.bdy);
        return viewInflate;
    }

    public static class a {
        private int bdA;
        private String bdB;
        private int bdC;
        private b bdx;
        private String bdy;
        private String bdz;
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        public final a hJ(String str) {
            this.bdy = str;
            return this;
        }

        public final a hK(String str) {
            this.bdz = str;
            return this;
        }

        public final a hL(String str) {
            this.bdB = str;
            return this;
        }

        public final a a(b bVar) {
            this.bdx = bVar;
            return this;
        }

        public final e SO() {
            return new e(this);
        }
    }
}
