package com.yuewen;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.duokan.reader.tts.domain.TtsSpeaker;
import com.yuewen.st2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class j44 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final TtsSpeaker f12824a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j44(@NotNull Context context, @NotNull TtsSpeaker speaker) {
        super(context, st2.t.Jo);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(speaker, "speaker");
        this.f12824a = speaker;
    }

    public static final void c(j44 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cancel();
    }

    @NotNull
    public final TtsSpeaker b() {
        return this.f12824a;
    }

    @Override // android.app.Dialog
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(st2.n.Jk);
        View viewFindViewById = findViewById(st2.k.nv0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.tv_content)");
        ((TextView) viewFindViewById).setText(getContext().getString(st2.s.Gc0, this.f12824a.getResName()));
        findViewById(st2.k.lv0).setOnClickListener(new View.OnClickListener() { // from class: com.yuewen.i44
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j44.c(this.f12363a, view);
            }
        });
    }
}
