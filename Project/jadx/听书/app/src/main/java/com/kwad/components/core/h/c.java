package com.kwad.components.core.h;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.core.h.a;
import com.kwad.components.core.video.i;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements ImageLoadingListener {
    private b QF;
    private a QG;
    private long QJ;
    private long jY;
    private int QH = 1;
    private int QI = 16;
    private List<i> QK = new CopyOnWriteArrayList();

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
        return false;
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingCancelled(String str, View view) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingStarted(String str, View view) {
    }

    static /* synthetic */ int a(c cVar, FailReason.FailType failType) {
        return a(failType);
    }

    public c() {
        a aVar = new a(new Handler(Looper.getMainLooper()));
        this.QG = aVar;
        aVar.a(new a.InterfaceC0334a() { // from class: com.kwad.components.core.h.c.1
            private boolean QL = false;
            private boolean QM = false;

            @Override // com.kwad.components.core.h.a.InterfaceC0334a
            public final void D(final long j) {
                com.kwad.sdk.core.d.c.d("KSImagePlayer", "onTimerProgress: " + j);
                if (j == 0) {
                    qm();
                }
                c.this.jY = j;
                c.this.b(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.1.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                    public void accept(i iVar) {
                        iVar.onMediaPlayProgress(c.this.QJ, j);
                    }
                });
                if (c.this.jY < c.this.QJ || c.this.QJ <= 0) {
                    return;
                }
                mf();
            }

            private void mf() {
                if (this.QL) {
                    return;
                }
                c.this.b(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.1.2
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(i iVar) {
                        e(iVar);
                    }

                    private static void e(i iVar) {
                        iVar.onMediaPlayCompleted();
                    }
                });
                this.QL = true;
            }

            private void qm() {
                if (this.QM) {
                    return;
                }
                com.kwad.sdk.core.d.c.d("KSImagePlayer", "onFirstFrame: ");
                this.QM = true;
                c.this.b(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.1.3
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(i iVar) {
                        e(iVar);
                    }

                    private static void e(i iVar) {
                        iVar.onMediaPlayStart();
                    }
                });
            }
        });
    }

    public final FrameLayout getImagePlayerView(Context context) {
        if (this.QF == null) {
            this.QF = new b(context);
        }
        return this.QF;
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        b bVar = this.QF;
        if (bVar != null) {
            bVar.setRadius(f, f2, f3, f4);
        }
    }

    public final void setURLs(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        String str = list.get(0);
        b bVar = this.QF;
        if (bVar != null) {
            bVar.a(str, this);
        }
    }

    public final void E(long j) {
        this.QJ = j;
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        b bVar = this.QF;
        if (bVar != null) {
            bVar.setImageScaleType(scaleType);
        }
    }

    public final void setVerticalGravity(int i) {
        this.QI = com.kwad.components.core.b.c.aw(i);
        ql();
    }

    public final void setHorizontalGravity(int i) {
        this.QI = com.kwad.components.core.b.c.ax(i);
        ql();
    }

    public final void play() {
        a aVar = this.QG;
        if (aVar != null) {
            aVar.start();
        }
    }

    public final void pause() {
        a aVar = this.QG;
        if (aVar != null) {
            aVar.pause();
        }
        b(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.2
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(i iVar) {
                e(iVar);
            }

            private static void e(i iVar) {
                iVar.onMediaPlayPaused();
            }
        });
    }

    public final void resume() {
        a aVar = this.QG;
        if (aVar != null) {
            aVar.resume();
            b(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.3
                @Override // com.kwad.sdk.g.a
                public final /* synthetic */ void accept(i iVar) {
                    e(iVar);
                }

                private static void e(i iVar) {
                    iVar.onMediaPlaying();
                }
            });
        }
    }

    public final void stop() {
        a aVar = this.QG;
        if (aVar != null) {
            aVar.stop();
        }
    }

    public final void skipToEnd() {
        b(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.4
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(i iVar) {
                e(iVar);
            }

            private static void e(i iVar) {
                iVar.onMediaPlayCompleted();
            }
        });
    }

    public final long getPlayDuration() {
        return this.jY;
    }

    public final void c(i iVar) {
        if (iVar != null) {
            this.QK.add(iVar);
        }
    }

    public final void d(i iVar) {
        if (iVar != null) {
            this.QK.remove(iVar);
        }
    }

    public final void destroy() {
        this.QK.clear();
        b bVar = this.QF;
        if (bVar != null && bVar.getParent() != null) {
            ((ViewGroup) this.QF.getParent()).removeView(this.QF);
        }
        this.QF = null;
        a aVar = this.QG;
        if (aVar != null) {
            aVar.destroy();
            this.QG = null;
        }
    }

    public final void setSpeed(float f) {
        a aVar = this.QG;
        if (aVar != null) {
            aVar.setSpeed(f);
        }
    }

    private void ql() {
        b bVar = this.QF;
        if (bVar != null) {
            bVar.setImageGravity(this.QH | this.QI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void b(com.kwad.sdk.g.a<i> aVar) {
        List<i> list;
        if (aVar == null || (list = this.QK) == null) {
            return;
        }
        Iterator<i> it = list.iterator();
        while (it.hasNext()) {
            aVar.accept(it.next());
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingFailed(String str, View view, final FailReason failReason) {
        b(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void accept(i iVar) {
                iVar.onMediaPlayError(-1, c.a(c.this, failReason.getType()));
            }
        });
    }

    /* JADX INFO: renamed from: com.kwad.components.core.h.c$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType;

        static {
            int[] iArr = new int[FailReason.FailType.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType = iArr;
            try {
                iArr[FailReason.FailType.IO_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.DECODING_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.NETWORK_DENIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.OUT_OF_MEMORY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static int a(FailReason.FailType failType) {
        int i = AnonymousClass6.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[failType.ordinal()];
        if (i == 1) {
            return -2;
        }
        if (i == 2) {
            return -3;
        }
        if (i != 3) {
            return i != 4 ? -1 : -5;
        }
        return -4;
    }
}
