package com.dyf.myblog.common.cache;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ICache <K, V> {

    V get(K key);

    void set(K key, V value);

}
