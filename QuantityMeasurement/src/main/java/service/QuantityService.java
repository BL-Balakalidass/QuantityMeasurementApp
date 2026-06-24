package main.java.service;

import main.java.IMeasurable;
import main.java.entity.QuantityEntity;

public interface QuantityService {

    <U extends Enum<U> & IMeasurable>
    QuantityEntity<U> add(QuantityEntity<U> request);

    <U extends Enum<U> & IMeasurable>
    QuantityEntity<U> subtract(QuantityEntity<U> request);

    <U extends Enum<U> & IMeasurable>
    QuantityEntity<U> divide(QuantityEntity<U> request);

    <U extends Enum<U> & IMeasurable>
    QuantityEntity<U> convert(QuantityEntity<U> request);

    <U extends Enum<U> & IMeasurable>
    QuantityEntity<U> compare(QuantityEntity<U> request);
}