package com.kurilenko.xslsparser.config.dispatcher;

public interface Dispatcher<K, V> {
  V getByName(K name);
}
