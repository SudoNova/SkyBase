package org.skyfw.base.datamodel.annotation.GUI;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * An annotation which targets canvas, which might have a custom caption and
 * icon.
 * </p>
 */

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataModelGUI {
    /**
     * 
     * @return String Returns the title of GUI form.
     *         caption.
     * 
     */
    String caption(); // default "";

    /**
     * @return boolean Returns if canvas has an icon or not.
     */
    boolean iconURL();
}
