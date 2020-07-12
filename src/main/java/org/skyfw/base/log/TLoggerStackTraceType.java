package org.skyfw.base.log;
/**
 * <p>
 * This enumeration is meant to specify how to get stack trace information
 * when some {@link TLogger} want's to print it.
 * </p>
 */
public enum TLoggerStackTraceType {
      /**
       * <p>
       * This means {@link TLogger} should copy stack trace from thread's stack trace
       * in all situations.
       * </p>
       */
      ALWAYS_AUTO_STACK_TRACE
      /**
       * <p>
       * This means a {@link TLogger} should copy stack trace from thread's stack trace,
       * only if developer has not supplied a custom stack trace.
       * </p>
       */
    , AUTO_STACK_TRACE_IF_NO_MANUAL_DATA_PROVIDED
      /**
       * <p>
       * This means that a {@link TLogger} instance should only print the stacktrace
       * if it's provided by the developer.
       */
      //TODO this has no references should be double checked with the author.
    , NO_AUTO_STACK_TRACE
    /**
     * <p>
     * This means that a {@link TLogger} should never print a stacktrace.
     * </p>
     */
    , ALWAYS_NO_STACK_TRACE
}
