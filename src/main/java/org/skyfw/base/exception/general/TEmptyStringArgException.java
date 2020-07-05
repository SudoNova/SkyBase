package org.skyfw.base.exception.general;

import org.skyfw.base.classes.validation.TArgValidationMCode;
import org.skyfw.base.mcodes.TMCode;
import org.skyfw.base.mcodes.TMCodeSeverity;

/**
 * <p>
 * This exception is thrown whenever an empty string is parsed as method
 * parameter.
 * </p>
 */
public class TEmptyStringArgException extends TIllegalArgumentException {

    /**
     * {@inheritDoc}
     */
    public TEmptyStringArgException(TMCode mCode, TMCodeSeverity severity, Throwable cause, String argName) {
        super(mCode, severity, cause, argName);
    }

    /**
     * {@inheritDoc}
     */
    public TEmptyStringArgException(TMCodeSeverity severity, Throwable cause, String argName) {
        super(TArgValidationMCode.EMPTY_STRING_ARG_IS_NOT_ACCEPTABLE, severity, cause, argName);
    }

}
