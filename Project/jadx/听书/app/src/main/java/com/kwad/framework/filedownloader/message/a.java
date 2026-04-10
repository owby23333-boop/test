package com.kwad.framework.filedownloader.message;

/* JADX INFO: loaded from: classes4.dex */
public interface a {
    MessageSnapshot yL();

    /* JADX INFO: renamed from: com.kwad.framework.filedownloader.message.a$a, reason: collision with other inner class name */
    public static class C0377a extends MessageSnapshot implements a {
        private final MessageSnapshot aoE;

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) 4;
        }

        public C0377a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.getId());
            if (messageSnapshot.wJ() != -3) {
                throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.c("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.wJ())));
            }
            this.aoE = messageSnapshot;
        }

        @Override // com.kwad.framework.filedownloader.message.a
        public final MessageSnapshot yL() {
            return this.aoE;
        }
    }
}
