package org.lecture;

import lombok.extern.log4j.Log4j;

import java.io.IOException;

@Log4j
public class ApplicationDriver {

    /**
     * Main methode
     * @throws IOException when file reading or writing has a problem
     */
    public static void main(String[] args) throws IOException {
        Player.getInstance();
    }
}