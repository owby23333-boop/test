package com.kwad.components.core.proxy.launchdialog;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes4.dex */
public interface g {

    public static class b implements g {
        private Lifecycle.Event Wz;

        public b(Lifecycle.Event event) {
            this.Wz = event;
        }

        public final boolean b(Lifecycle.Event event) {
            return this.Wz.equals(event);
        }

        public final String toString() {
            return "PageEventItem{mEvent=" + this.Wz + '}';
        }
    }

    public static class a implements g {
        private long WG;

        public a(long j) {
            this.WG = j;
        }

        public final boolean K(long j) {
            return this.WG > 0 && System.currentTimeMillis() - j >= this.WG;
        }

        public final String toString() {
            return "DurationMoreThanItem{mDuration=" + this.WG + '}';
        }
    }
}
