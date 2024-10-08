package Exceptions;

import java.rmi.NoSuchObjectException;

public class NoDeviceFoundException extends NoSuchObjectException {
    /**
     * Constructs a <code>NoSuchObjectException</code> with the specified
     * detail message.
     *
     * @param s the detail message
     * @since 1.1
     */
    public NoDeviceFoundException(String s) {
        super(s);
    }
}
