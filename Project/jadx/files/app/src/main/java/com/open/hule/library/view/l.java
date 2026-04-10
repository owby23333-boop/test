package com.open.hule.library.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.open.hule.library.R$id;
import com.open.hule.library.R$layout;
import com.open.hule.library.R$string;

/* JADX INFO: compiled from: UpdateFailureDialog.java */
/* JADX INFO: loaded from: classes3.dex */
public class l extends k {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private com.open.hule.library.b.b f17681t;

    public static l a(Bundle bundle) {
        l lVar = new l();
        if (bundle != null) {
            lVar.setArguments(bundle);
        }
        return lVar;
    }

    public /* synthetic */ void b(View view) {
        if (getArguments() != null) {
            if (getArguments().getInt("forceUpdate", 0) == 0) {
                com.open.hule.library.b.b bVar = this.f17681t;
                if (bVar != null) {
                    bVar.c();
                }
            } else {
                com.open.hule.library.b.b bVar2 = this.f17681t;
                if (bVar2 != null) {
                    bVar2.forceExit();
                }
            }
        }
        dismiss();
    }

    public /* synthetic */ void c(View view) {
        com.open.hule.library.b.b bVar = this.f17681t;
        if (bVar != null) {
            bVar.b();
        }
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R$id.version);
        if (getArguments() != null) {
            if (TextUtils.isEmpty(getArguments().getString("newVersionCode"))) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(String.format(getResources().getString(R$string.down_version), getArguments().getString("newVersionCode")));
            }
            String string = getArguments().getString("reason");
            if (!TextUtils.isEmpty(string)) {
                ((TextView) view.findViewById(R$id.tv_error)).setText(String.format("下载失败，%s，请反馈给客服或点击重试或使用浏览器下载？", string));
            }
        } else {
            textView.setVisibility(8);
        }
        Button button = (Button) view.findViewById(R$id.btnBrowser);
        Button button2 = (Button) view.findViewById(R$id.btnCancel);
        Button button3 = (Button) view.findViewById(R$id.btnOk);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.open.hule.library.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f17666s.a(view2);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.open.hule.library.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f17665s.b(view2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.open.hule.library.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f17664s.c(view2);
            }
        });
    }

    public void a(com.open.hule.library.b.b bVar) {
        this.f17681t = bVar;
    }

    @Override // com.open.hule.library.view.k
    int a() {
        return R$layout.lib_update_download_failed;
    }

    public /* synthetic */ void a(View view) {
        com.open.hule.library.b.b bVar = this.f17681t;
        if (bVar != null) {
            bVar.a();
        }
        dismiss();
    }
}
