package org.skyfw.base.mcodes;

/**
 * <p>
 * An {@code enum} which returns type of exception, based on the returned error
 * code.
 * </p>
 */
public enum TBaseMCode implements TMCode {

    ANOTHER_SERVER_OFFER(100)

    , SUCCESS(200), PARTITIAL_SUCCESS(202), SUCCESS_BUT_EXPENSIVE(209)

    , CONNECTION_ERROR(300), NO_NETWORK_ACCESS(301), NO_INTERNET_ACCESS(302), NO_SERVER_ACCESS(302)

    , BAD_REQUEST(400)

    , BAD_ARGUMENT(440), NULL_ARGUMENT_IS_NOT_ACCEPTABLE(441)

    , AUTHENTICATION_FAILED(401)

    , DATA_NOT_FOUND(404), SERVICE_NOT_FOUND(414), METHOD_NOT_FOUND(424)

    // Forbidden means Authorization have failed
    , FORBIDDEN_DATA(403), FORBIDDEN_SERVICE(413), FORBIDDEN_METHOD(423), FORBIDDEN_PARAMETERS(433)

    , CLIENT_UPGRADE_REQUIRED(426)

    , TOO_MANY_REQUESTS(429)

    , SERVER_INTERNAL_ERROR(500), SERVER_CURRENTLY_BUSY(501), SERVER_RETRY_IN_MOMENTS(502), SERVER_OUT_OF_SERVICE(503),
    UNKNOWN_DATATYPES(504)// New !!!
    , RESULT_TYPE_MISMATCH(505) // New !!!

    , LOCAL_INTERNAL_ERROR(700), LOCAL_PREREQUISITES_DID_NOT_MET(710), LOCAL_LACK_OF_RESOURCES(730)

    , UNKNOWN_MESSAGE_CODE(900), UNKNOWN_EXCEPTION(901)

    , CODE_ALREADY_REGISTERED_WITH_SAME_MCODE_CLASS(908), CODE_ALREADY_REGISTERED_WITH_DIFFERENT_MCODE_CLASS(909)

    ;

    public static final String moduleName = "SkyBase";
    private final int resultCodeValue;

    private TBaseMCode(int resultCodeValue) {
        this.resultCodeValue = resultCodeValue;
    }
    /**
     * @return TBseMCodeFamily family of error type, which include:
     * <ul>
     * <li><code>1xx</code>: Informational</li>
     * <li><code>2xx</code>: Success</li>
     * <li><code>3xx</code>: Connection error</li>
     * <li><code>4xx</code>: Client error</li>
     * <li><code>5xx</code>: Server error</li>
     * <li><code>7xx</code>: Local error</li>
     * </ul>
     * <span>Finally, every other type which cannot be categorized in the above list,
     *  is recognized as <i>Unknown error</i></span>.
     * 
     */
    public TBaseMCodeFamily getCodeFamily() {
        int familyDigit = this.resultCodeValue / 100;
        switch (familyDigit) {
            case 1:
                return TBaseMCodeFamily.INFORMATIONAL_CODE__FAMILY;

            case 2:
                return TBaseMCodeFamily.SUCCESS_CODE_FAMILY;

            case 3:
                return TBaseMCodeFamily.CONNECTION_ERROR_CODE_FAMILY;

            case 4:
                return TBaseMCodeFamily.CLIENT_ERROR_CODE_FAMILY;

            case 5:
                return TBaseMCodeFamily.SERVER_ERROR_CODE_FAMILY;

            case 7:
                return TBaseMCodeFamily.LOCAL_ERROR_CODE_FAMILY;

        }

        return TBaseMCodeFamily.UNKNOWN_ERROR_CODE_FAMILY;
    }
    /**
     * @return {@link String} Returns name of code module which returned the error.
     */
    @Override
    public String getModuleName() {
        return "SkyBase";
    }
    // TODO does this return the actual code? If yes, then how? Because there are no implementations.
    public int getCode() {
        return resultCodeValue;
    }
    // TODO I believe some error codes might induce serverity as well (e.g. most server errors),
    // that's probably why author included this method here, so severity can be copied from here,
    // in addition, to Exception.SetSeverity() which user might call to change the severity.
    @Override
    public TMCodeSeverity getSeverity() {
        return null;
    }

    //FIXME this is supposed to be an override, but no interface/superclass implements it.
    @Override
    public String getRawMessage() {
        return null;
    }
    //FIXME same as above
    @Override
    public TBaseMCode getBaseCode() {
        return this;
    }

}
