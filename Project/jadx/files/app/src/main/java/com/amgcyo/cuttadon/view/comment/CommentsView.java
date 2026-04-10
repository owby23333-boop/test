package com.amgcyo.cuttadon.view.comment;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.comment.ReplyArrBean;
import com.amgcyo.cuttadon.api.entity.comment.ReplyToCommentBean;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.fatcatfat.io.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommentsView extends LinearLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4617s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<ReplyArrBean> f4618t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private d f4619u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private MkUser f4620v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f4621w;

    class a extends ClickableSpan {
        a(CommentsView commentsView) {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(-9934744);
            textPaint.setUnderlineText(false);
        }
    }

    class b extends ClickableSpan {
        b(CommentsView commentsView) {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(-13074996);
            textPaint.setUnderlineText(false);
        }
    }

    public interface c {
    }

    public interface d {
        void a(int i2, ReplyArrBean replyArrBean, int i3);

        void a(ReplyArrBean replyArrBean);
    }

    public CommentsView(Context context) {
        this(context, null);
    }

    private void b(ReplyArrBean replyArrBean, SpannableStringBuilder spannableStringBuilder) {
        if (replyArrBean == null || replyArrBean.getReply_to_comment() == null || !replyArrBean.getReply_to_comment().isFloor_host()) {
            return;
        }
        a(spannableStringBuilder);
    }

    public void a() {
        removeAllViews();
        List<ReplyArrBean> list = this.f4618t;
        if (list == null || list.size() <= 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 10, 0, 10);
        for (int i2 = 0; i2 < this.f4618t.size(); i2++) {
            View viewA = a(i2);
            if (viewA == null) {
                throw new NullPointerException("listview item layout is null, please check getView()...");
            }
            addView(viewA, i2, layoutParams);
        }
    }

    public void setList(List<ReplyArrBean> list) {
        this.f4618t = list;
    }

    public void setOnItemClickListener(d dVar) {
        this.f4619u = dVar;
    }

    public void setSpanclickListener(c cVar) {
    }

    public CommentsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentsView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setOrientation(1);
        this.f4617s = context;
    }

    private View a(final int i2) {
        final ReplyArrBean replyArrBean = this.f4618t.get(i2);
        ReplyToCommentBean reply_to_comment = replyArrBean.getReply_to_comment();
        boolean z2 = reply_to_comment != null;
        TextView textView = (TextView) View.inflate(this.f4617s, R.layout.reply_item, null);
        textView.setTextSize(13.0f);
        textView.setTextColor(-9934744);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String nick = replyArrBean.getNick();
        if (z2) {
            spannableStringBuilder.append((CharSequence) a(nick, replyArrBean));
            spannableStringBuilder.append(" ");
            a(replyArrBean, spannableStringBuilder);
            spannableStringBuilder.append(" 回复 ");
            spannableStringBuilder.append((CharSequence) a(reply_to_comment.getNick(), replyArrBean));
            if (replyArrBean.getReply_to_comment() != null) {
                b(replyArrBean, spannableStringBuilder);
            } else {
                a(replyArrBean, spannableStringBuilder);
            }
        } else {
            spannableStringBuilder.append((CharSequence) a(nick, replyArrBean));
            spannableStringBuilder.append(" ");
            a(replyArrBean, spannableStringBuilder);
        }
        spannableStringBuilder.append(" : ");
        spannableStringBuilder.append((CharSequence) a(replyArrBean, i2));
        spannableStringBuilder.append(" ");
        textView.setText(spannableStringBuilder);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.comment.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4623s.a(replyArrBean, i2, view);
            }
        });
        return textView;
    }

    public /* synthetic */ void a(ReplyArrBean replyArrBean, int i2, View view) {
        if (this.f4619u != null) {
            this.f4620v = g.j();
            if (this.f4620v != null && replyArrBean.getUser_id() == this.f4620v.getUser_id()) {
                this.f4619u.a(replyArrBean);
                return;
            }
            this.f4621w = replyArrBean.getComment_id();
            if (replyArrBean.getComment_reply_id() != 0) {
                this.f4621w = replyArrBean.getComment_reply_id();
            }
            this.f4619u.a(i2, replyArrBean, this.f4621w);
        }
    }

    private void a(ReplyArrBean replyArrBean, SpannableStringBuilder spannableStringBuilder) {
        if (replyArrBean.isFloor_host()) {
            a(spannableStringBuilder);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        SpannableString spannableString = new SpannableString("楼主");
        spannableString.setSpan(new com.amgcyo.cuttadon.view.comment.b(g.a(R.color.colorPrimary), g.a(R.color.colorPrimary), 15), 0, 2, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(10, true), 0, 2, 33);
        spannableStringBuilder.append((CharSequence) spannableString);
    }

    public SpannableString a(ReplyArrBean replyArrBean, int i2) {
        SpannableString spannableString = new SpannableString(replyArrBean.getContent());
        spannableString.setSpan(new a(this), 0, spannableString.length(), 33);
        return spannableString;
    }

    public SpannableString a(String str, ReplyArrBean replyArrBean) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new b(this), 0, spannableString.length(), 33);
        return spannableString;
    }
}
