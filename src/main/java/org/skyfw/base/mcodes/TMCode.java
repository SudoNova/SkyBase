package org.skyfw.base.mcodes;

import java.util.Map;
/**
 * <p>
 * This class represents part of code which has thrown an exception.
 * </p>
 */
public interface TMCode {

    /**
     * @return String name of specific module which exception ocurred in it.
     */
    String getModuleName();
    /**
     * @return {@link TBaseMCode} of the thrown exception.
     */
    TBaseMCode getBaseCode();
    /**
     * 
     * @return returns a {@link TMCodeSeverity} which contains severity of the error.
     */
    TMCodeSeverity getSeverity();

    // >>> Processing the args will be on TMCodePrettifier
    String getRawMessage();
    default String getProcessedMessage(Map<String, String> details){
        details.forEach((s, s2) -> {

        });
        return "";
    }

    //ToDo: performance
    default String compile(Object ...args){

        String compiledMessage= this.getRawMessage();
        if (compiledMessage == null)
            return "";

        if (args != null)
        for (int i=0; i < args.length; i++){
            Object currentValue= args[i];
            if (currentValue == null)
                currentValue= "null";
            compiledMessage= compiledMessage.replace("{#" + (i+1) + "}", currentValue.toString());
        }

        return compiledMessage;
    }

}
