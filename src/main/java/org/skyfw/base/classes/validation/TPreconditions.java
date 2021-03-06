package org.skyfw.base.classes.validation;

import org.skyfw.base.exception.general.TEmptyStringArgException;
import org.skyfw.base.exception.general.TIllegalArgumentException;
import org.skyfw.base.exception.general.TNullArgException;
import org.skyfw.base.mcodes.TBaseMCode;
import org.skyfw.base.mcodes.TMCodeSeverity;

public class TPreconditions {

    public static void checkArgForNotNull(Object argValue, String argName) throws TIllegalArgumentException {
        if (argValue == null)
            throw new TNullArgException(TBaseMCode.NULL_ARGUMENT_IS_NOT_ACCEPTABLE, TMCodeSeverity.ERROR, null, argName);
    }

    public static void checkArgForNotNullOrEmpty(String argValue, String argName) throws TIllegalArgumentException {

        if (argValue == null)
            throw new TNullArgException(TBaseMCode.NULL_ARGUMENT_IS_NOT_ACCEPTABLE, TMCodeSeverity.ERROR, null, argName);

        if (argValue.isEmpty())
            throw new TEmptyStringArgException(TArgValidationMCode.EMPTY_STRING_ARG_IS_NOT_ACCEPTABLE
                    , TMCodeSeverity.ERROR, null, argName);
    }

    public static void checkArgForNotNullOrEmpty(Object argValue, String argName) throws TIllegalArgumentException {

        if (argValue == null)
            throw new TNullArgException(TBaseMCode.NULL_ARGUMENT_IS_NOT_ACCEPTABLE, TMCodeSeverity.ERROR, null, argName);

        checkArgForNotNullOrEmpty(argValue.toString(), argName);
    }




}
