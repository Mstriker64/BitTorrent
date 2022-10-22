package Process;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ListIterator;


import Peer.Handshake;



public class ServerListener extends Thread {

    private int listenPort;
    private int myPeer_ID;
    private int totalPieces;
    private boolean haveAllPieces;
    private long fileSize;
    private long pieceSize;

    public ServerListener(int listenPort, int peerID, int totalPieces, boolean haveAllPieces, long fileSize, long pieceSize) {
        this.listenPort = listenPort;
        myPeer_ID = peerID;
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
        }
        catch (IOException e) {
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