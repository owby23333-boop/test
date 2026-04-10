package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.TextAnchor;

/* JADX INFO: loaded from: classes5.dex */
public class HighlighterAssistant {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextAnchor f5804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HighlighterStyle f5805b;
    public boolean c;
    public boolean d;

    public enum HighlighterStyle {
        Unkonw,
        Rect,
        Line
    }

    public HighlighterAssistant() {
        this(null, HighlighterStyle.Unkonw, false, false);
    }

    public HighlighterAssistant(TextAnchor textAnchor, HighlighterStyle highlighterStyle, boolean z, boolean z2) {
        this.f5805b = highlighterStyle;
        this.f5804a = textAnchor;
        this.c = z;
        this.d = z2;
    }
}
