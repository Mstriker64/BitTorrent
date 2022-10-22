package Peer;

/*

Class that helps with byte array and integer conversions

 */

public class helper {

    // Convert byte array into integer to output ID
    public static final int byteArrayToInt(byte[] byteArray) {
        if (byteArray.length != 4) {
            return -1;
        }

        int out = 0;
        for (int i = 3; i >= 0; i--) {
            out |= ((byteArray[3-i] & 0xFF) << i*8);
        }
        return out;
    }

    // Convert integer into byte array
    public static byte[] intToByteArray(int val) {
        byte[] byteArray = new byte[4];
        for (int i = 3; i >= 0; i--) {
            byteArray[3-i] = (byte) (val >> i*8);
        }
        return byteArray;
    }

}