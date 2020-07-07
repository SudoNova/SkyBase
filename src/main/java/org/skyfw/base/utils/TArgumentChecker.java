package org.skyfw.base.utils;

import org.skyfw.base.exception.general.TIllegalArgumentException;
import org.skyfw.base.exception.general.TNullArgException;
// TODO actually, I think this could be better as an annotation.
/**
 * 
 */
public class TArgumentChecker {
    /**
     * 
     * @param objects Some method arguments.
     * @throws TIllegalArgumentException Thrown if the argument is illegal.
     * <ul>
     * Cases of illegal argument:
     * <li> A null argument</li>
     * </ul>
     * 
     */
    public static void check(Object ...objects) throws TIllegalArgumentException {

        for (Object object: objects){

            if (object == null)
                throw TNullArgException.create("");
        }

    }

}
