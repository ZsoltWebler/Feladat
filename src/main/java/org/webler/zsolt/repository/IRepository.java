package org.webler.zsolt.repository;

import org.webler.zsolt.exceptions.NotFound;
import org.webler.zsolt.exceptions.NotUnique;

public interface IRepository<T> {

    boolean add(T t) throws NotUnique;

    boolean remove(T t) throws NotFound;

}
