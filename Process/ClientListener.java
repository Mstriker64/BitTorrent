package Process;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.ListIterator;


import Peer.Handshake;




public class ClientListener extends Thread {

    private String peerIP;
    private int port;
    private int myPeerID;
    private ArrayList<String[]> client = new ArrayList<String[]>();
    private int totalPieces;
    private boolean haveAllPieces;
    private long fileSize;
    private long pieceSize;

    public ClientListener(int peer_ID, int totalPieces, boolean haveAllPieces, long fileSize, long pieceSize) {
        myPeerID = peer_ID;
        this.totalPieces = totalPieces;
        this.haveAllPieces = haveAllPieces;
        this.fileSize = fileSize;
        this.pieceSize = pieceSize;
    }

    private void sendBitfield(Socket socket) {

        try {

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            // Add bitfield class
            //out.writeObject(BitField.bitfield);

        } catch (IOException e) {
            System.err.println(e);
        }

    }


    private byte[] receiveBitfield(Socket socket) {

        byte[] bitfield = null;
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            bitfield = (byte[]) in.readObject();
        } catch (IOException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }

        return bitfield;
    }


    private void sendHandShake(Socket socket, byte[] handshake) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(handshake);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private byte[] receiveHandShake(Socket socket) {
        byte[] handshake = null;
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            handshake = (byte[]) in.readObject();
        } catch (IOException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
        return handshake;
    }
}