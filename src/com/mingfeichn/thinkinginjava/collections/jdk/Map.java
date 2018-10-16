package com.mingfeichn.thinkinginjava.collections.jdk;

public interface Map<K, V> {

    /**
     * 返回map中key-value映射数量
     * 如果元素数量大于Integer.MAX_VALUE，返回Integer.MAX_VALUE
     *
     * @return map中key-value映射数量
     */
    int size();

    /**
     * 如果map中没有key-value映射，返回true
     *
     * @return 如果map中没有key-value映射，返回true
     */
    boolean isEmpty();

    /**
     *
     * @param key
     * @return
     */
    boolean containsKey(Object key);

    /**
     *
     * @param value
     * @return
     */
    boolean containsValue(Object value);

    /**
     *
     * @param key
     * @return
     */
    V get(Object key);


    /**
     *
     * @param key
     * @param value
     */
    void put(Object key, Object value);
}
