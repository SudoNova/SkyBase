package org.skyfw.base.datamodel.annotation.GUI;

import org.skyfw.base.datamodel.gui.TGUIFieldAvailableValues_IFace;
import org.skyfw.base.datamodel.gui.TGUIInputType;
import org.skyfw.base.locale.TFieldLocalMessageFeeder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * This annotation converts a data model field to a GUI field.
 * </p>
 */
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataModelGUIField {
    /**
     * @return String Returns caption of GUI component.
     */
    String   caption();
    // TODO see what this does in a test run.
    String   unitCaption() default "";
    /**
     * 
     * @return int Returns size of this element on the GUI form.
     */
    int      displaySize() default 0;
    /**
     * @return String Returns the location of icon image for this GUI component (if any).
     */
    String  iconURL() default "";

    TGUIInputType inputType() default TGUIInputType.DEFAULT;
    String defaultText() default "";
    String hint() default "";
    /**
     * 
     * @return Boolean Should user be able to change this component on the GUI?
     */
    boolean readOnly() default false;
    boolean numbersOnly() default false;
    //Just for COMBO_BOX items
    //Class<? extends Enum<?> , TGUIFieldAvailableValues_IFace> availableValues();
    Class<? extends TGUIFieldAvailableValues_IFace> availableValues() default DefaultGUIFieldAvailableValuesClass.class;
    boolean onlyAvailableValues() default false;

    //Lookup properties currently exists in Main FieldDescriptor
    //String lookupDataModelName() default "";
    //String lookupValueFieldName() default "";


    Class<? extends TFieldLocalMessageFeeder> localMessageFeeder() default DefaultlocalMessageFeeder.class;


    //~~~~
    //Crazy Syntax Of Java Do Not Let Us To Define a Null Value For an annotation With Class Type
    //So Wee Need To Define This Dummy Static Class
    //"XmlJavaTypeAdapter" With "DEFAULT.class" and Some Others Used This Approach Too.
    //-------------------------------------------------------------------------------------------

    //TODO probably this is for a multiple choice GUI element. We should examine this in a test to ensure.
    public static class DefaultGUIFieldAvailableValuesClass implements TGUIFieldAvailableValues_IFace{

        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getCaption() {
            return null;
        }
    }



    public static class DefaultlocalMessageFeeder implements TFieldLocalMessageFeeder{
        @Override
        public String getNullValueNotAllowedMessage() {
            return null;
        }
    }

}


