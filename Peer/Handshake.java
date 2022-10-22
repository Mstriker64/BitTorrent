package Peer;


import java.util.Arrays;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/*
    32 bit message:
        18 byte Handshake Header
        10 byte zero bits
        4 byte peer ID
*/

public class Handshake {

    private static String handshakeHeader = "P2PFILESHARINGPROJ";
    byte[] zeroBits = new byte[10];
    private int peerID;

    public Handshake(int ID) {
        this.peerID = ID;
    }

    public byte[] receiveMessage() {

        ByteArrayOutputStream output = new ByteArrayOutputStream(32);
        output.write(handshakeHeader.getBytes(), 0, 18);

        Arrays.fill(zeroBits, (byte)0);
        output.write(zeroBits, 0, 10);
        output.write(helper.intToByteArray(peerID), 0, 4);

        return output.toByteArray();
    }

    public static int checkMessage(byte[] message) {

        // Checck if valid length
        if (message.length != 32) {
            return -1;
        }

        ByteArrayInputStream input = new ByteArrayInputStream(message);
        byte[] byteHeader = new byte[18];

        // Read first 18 bytes of message
        input.read(byteHeader, 0, 18);

        // Check if equal to handshake header
        if (!new String(byteHeader).equals(handshakeHeader)) {
            return -1;
        }


        // Check next 10 bytes if they are equal to zero
        for (int i = 0; i < 10; i++) {
            if (input.read() != 0) {
                return -1;
            }
        }

        byte[] id = new byte[4];
        input.read(id, 0, 4);

        // Return ID
        return helper.byteArrayToInt(id);
    }
}