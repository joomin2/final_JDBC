package edu.sm.frame;

import edu.sm.exception.DuplicatedIdException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Dao<K,V> {
    V insert(V v, Connection con) throws Exception;
    V update(V v, Connection con) throws Exception;
    Boolean delete(K k, Connection con) throws Exception;
    V select(K k, Connection con) throws Exception;
    List<V> select(Connection con) throws Exception;
}