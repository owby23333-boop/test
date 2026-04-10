package com.ss.android.socialbase.downloader.utils;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadStenographer {
    private static final int MAX_NODE_COUNT = 20;
    private static final int SECONDS_TO_MILLS = 1000;
    private int count;
    private Node head;
    private int maxCount;
    private Node tail;

    private static class Node {
        long curBytes;
        Node next;
        Node prev;
        long when;

        private Node() {
        }
    }

    public DownloadStenographer() {
        this.maxCount = 10;
    }

    private Node findFirstNodeNearWhen(long j2) {
        Node node;
        Node node2 = this.head;
        Node node3 = null;
        while (true) {
            node = node3;
            node3 = node2;
            if (node3 == null || node3.when <= j2) {
                break;
            }
            node2 = node3.next;
        }
        return (node3 == null || node == null || node3 == node || j2 - node3.when >= node.when - j2) ? node : node3;
    }

    private Node obtainNode() {
        Node node;
        if (this.count < this.maxCount || (node = this.tail) == null) {
            this.count++;
            return new Node();
        }
        Node node2 = node.prev;
        node.prev = null;
        this.tail = node2;
        if (node2 != null) {
            node2.next = null;
        }
        return node;
    }

    public long getRecentDownloadSpeed(long j2, long j3) {
        synchronized (this) {
            Node node = this.head;
            if (node == null) {
                return -1L;
            }
            Node nodeFindFirstNodeNearWhen = findFirstNodeNearWhen(j2);
            if (nodeFindFirstNodeNearWhen == null) {
                return -1L;
            }
            long j4 = node.curBytes - nodeFindFirstNodeNearWhen.curBytes;
            long j5 = j3 - nodeFindFirstNodeNearWhen.when;
            if (j4 < 0 || j5 <= 0) {
                return -1L;
            }
            return j4 / j5;
        }
    }

    public boolean markProgress(long j2, long j3) {
        synchronized (this) {
            Node node = this.head;
            if (node != null) {
                if (j2 >= node.curBytes && j3 >= node.when) {
                    Node node2 = node.next;
                    if (node2 != null && j3 - node2.when < 1000) {
                        node.curBytes = j2;
                        node.when = j3;
                        return true;
                    }
                }
                return false;
            }
            Node nodeObtainNode = obtainNode();
            nodeObtainNode.curBytes = j2;
            nodeObtainNode.when = j3;
            if (node != null) {
                nodeObtainNode.next = node;
                node.prev = nodeObtainNode;
            }
            this.head = nodeObtainNode;
            return true;
        }
    }

    public DownloadStenographer(int i2) {
        this.maxCount = i2 > 20 ? 20 : i2;
    }
}
