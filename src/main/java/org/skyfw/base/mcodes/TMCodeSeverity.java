package org.skyfw.base.mcodes;

import jdk.nashorn.internal.objects.annotations.Getter;

//TODO add more info about unknown i.e. when it happens.
/**
 * <p>
 * An {@link Enum} to represent different log severities.
 * <ul>
 * <li>{@link #value} is the current severity.</li>
 * </ul>
 * Severities by verbosity (increasing order):
 * <ol>
 * <li>FATAL</li>
 * <li>ERROR</li>
 * <li>WARNING</li>
 * <li>TRACE</li>
 * <li>DEBUG</li>
 * </ol>
 * Also, there is an UNKNOWN level
 * </p>
 */
public enum TMCodeSeverity {

    UNKNOWN((byte) 0), DEBUG((byte) 1), TRACE((byte) 2), INFO((byte) 3), WARNING((byte) 4), ERROR((byte) 5),
    FATAL((byte) 6);

    byte value;

    TMCodeSeverity(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return this.value;
    }
}
