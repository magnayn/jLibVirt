package com.nirima.libvirt.util;

import junit.framework.TestCase;

import java.util.UUID;

/**
 * Created by magnayn on 05/02/2014.
 */
public class UtilsTest extends TestCase {

    public void testUUID() {
        UUID uuid = UUID.randomUUID();

        byte[] array = Utils.UUIDtoByteArray(uuid);

        UUID uuid2 = Utils.UUIDfromByteArray(array);

        assertEquals(uuid.toString(), uuid2.toString());


    }
}
