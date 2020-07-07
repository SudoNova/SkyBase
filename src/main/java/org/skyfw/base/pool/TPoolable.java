package org.skyfw.base.pool;

import org.skyfw.base.pool.exception.TPoolableInitException;
import org.skyfw.base.result.TResult;
// TODO add to gradle or maven manifest.
import stormpot.Poolable;

public interface TPoolable<T extends TPoolConfig> extends Poolable {

    void init(T poolConfig) throws TPoolableInitException;

    /**
     * The main purpose of defining this methods is to warn everyone to keep mother pool instance some where in
     * their <strong>`Poolable`</strong> objects.
     * @param objectPool
     */
    //TODO what's the use of the mother pool?
    void setMotherPool(TObjectPool objectPool);
    TObjectPool getMotherPool();


    @Override
    default void release() {

        this.getMotherPool().releaseObject(this);
    }

    Class<? extends T> getConfigClass();
}
