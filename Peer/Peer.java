package Peer;

import java.net.Socket;

/*
    Peer class
*/

public class Peer {

    private int myPeerID;
    private int PeerID;
    private Socket socket;
    private byte[] bitfield;
    private boolean interest;

    public int getPeerID() {
        return PeerID;
    }

    public void setPeerID(int PeerID) {
        this.PeerID = PeerID;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public byte[] getBitfield() {
        return bitfield;
    }

    public void setBitfield(byte[] bitfield) {
        this.bitfield = bitfield;
    }

    public boolean isInterested() {
        return interest;
    }

    public void setInterested(boolean interested) {
        this.interest = interested;
    }

    public int getmyPeerID() {
        return myPeerID;
    }

    public void setmyPeerID(int myPeerID) {
        this.myPeerID = myPeerID;
    }

}