package controllers;

import model.Dragon;

public interface CollectionController extends Iterable<Dragon> {
    int size();
    void add(Dragon dragon);
    boolean containsId(Integer id);
    boolean isEmpty();
    void updateById(Integer id, Dragon dragon);
    void removeById(Integer id);
    void clear();
    void insertAt(int index, Dragon dragon);
    void addIfMax(Dragon dragon);
    void removeGreater(Dragon dragon);
    int countByAge(Integer age);
    int countLessThanWingspan(Double wingspan);
}
