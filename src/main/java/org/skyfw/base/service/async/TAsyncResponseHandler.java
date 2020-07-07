package org.skyfw.base.service.async;
//TODO what's RES? Do you mean TGenericResponse ?
public interface TAsyncResponseHandler<RES> {

    /*Runnable*/ void onResponse(RES response);

}
