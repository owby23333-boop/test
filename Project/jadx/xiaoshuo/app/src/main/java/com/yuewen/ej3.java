package com.yuewen;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.duokan.account.oauth.ThirdConstans;
import com.duokan.account.oauth.weixin.Weixin;
import com.duokan.account.oauth.weixin.WeixinFactory;
import com.duokan.reader.BasePrivacyManager;
import com.duokan.reader.ui.general.DkToast;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.yuewen.st2;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ej3 extends BottomSheetDialog implements BasePrivacyManager.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f10615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<b> f10616b;
    public String c;

    public interface a {
        void a(String str);
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10618b;
        public int c;

        public b(String str, String str2, int i) {
            this.f10618b = str2;
            this.f10617a = str;
            this.c = i;
        }
    }

    public ej3(Context context, a aVar) {
        super(context, st2.t.ua);
        this.f10615a = aVar;
        this.f10616b = new LinkedList();
        String[] stringArray = getContext().getResources().getStringArray(st2.c.C);
        Weixin weixinBuild = new WeixinFactory().build();
        if (weixinBuild.isWeiXinInstalled(getContext())) {
            this.f10616b.add(new b(stringArray[0], ThirdConstans.WEIXIN_NAME_FRIEND, st2.h.en));
            if (weixinBuild.isSupportShareWeiXinFriends(getContext())) {
                this.f10616b.add(new b(stringArray[1], ThirdConstans.WEIXIN_NAME_FRIENDS, st2.h.Jk));
            }
        }
        fj3 fj3Var = new fj3(getContext(), new a() { // from class: com.yuewen.cj3
            @Override // com.yuewen.ej3.a
            public final void a(String str) {
                this.f9676a.f(str);
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.yuewen.dj3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f10182a.g(dialogInterface);
            }
        });
        fj3Var.setSharePlatforms(this.f10616b);
        setContentView(fj3Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(String str) {
        this.c = str;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(DialogInterface dialogInterface) {
        this.f10615a.a(this.c);
    }

    @Override // com.duokan.reader.BasePrivacyManager.c
    public void a() {
        View viewFindViewById;
        super.show();
        if (getContext().getResources().getConfiguration().orientation != 2 || (viewFindViewById = findViewById(st2.k.qe)) == null) {
            return;
        }
        BottomSheetBehavior.from(viewFindViewById).setState(3);
    }

    @Override // com.duokan.reader.BasePrivacyManager.c
    public void b() {
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.f10616b.isEmpty()) {
            DkToast.makeText(getContext(), st2.s.vf0, 0).show();
        } else {
            com.duokan.reader.e.S().i(this, so2.cb);
        }
    }
}
