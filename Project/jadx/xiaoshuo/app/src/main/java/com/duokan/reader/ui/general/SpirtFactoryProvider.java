package com.duokan.reader.ui.general;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.duokan.core.ui.DialogBox;
import com.yuewen.al1;

/* JADX INFO: loaded from: classes5.dex */
public class SpirtFactoryProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f5542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public al1 f5543b;

    public enum SpirtType {
        AUTO,
        PAD,
        PHONE,
        EINK
    }

    public class a implements al1 {
        public a() {
        }

        @Override // com.yuewen.al1
        public void a() {
        }

        @Override // com.yuewen.al1
        public View b(String str, int i, boolean z) {
            return null;
        }

        @Override // com.yuewen.al1
        public ViewGroup d() {
            return null;
        }

        @Override // com.yuewen.al1
        public int e() {
            return 0;
        }

        @Override // com.yuewen.al1
        public void h(boolean z) {
        }

        @Override // com.yuewen.al1
        public void i(String str) {
        }

        @Override // com.yuewen.al1
        public void j(Object obj) {
        }

        @Override // com.yuewen.al1
        public LinearLayout k() {
            return null;
        }
    }

    public interface b {
        al1 a(DialogBox dialogBox, SpirtType spirtType);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static SpirtFactoryProvider f5545a = new SpirtFactoryProvider();
    }

    public static SpirtFactoryProvider b() {
        return c.f5545a;
    }

    public al1 a(DialogBox dialogBox) {
        b bVar = this.f5542a;
        if (bVar != null) {
            return bVar.a(dialogBox, SpirtType.AUTO);
        }
        if (this.f5543b == null) {
            this.f5543b = new a();
        }
        return this.f5543b;
    }

    public void c(b bVar) {
        this.f5542a = bVar;
    }
}
