package Peer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


import Process.ServerListener;
import Process.ClientListener;


public class PeerProcess {

    public static String fileName;
    private long fileSize;
    private long pieceSize;
    private int totalPieces;
    private int peerID;
    private int port;
    private boolean hasCompleteFile;

    public static void main(String[] args) {

        PeerProcess peerProcess = new PeerProcess();
    }

}