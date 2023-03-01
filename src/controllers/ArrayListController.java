package controllers;

import model.Dragon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayListController implements CollectionController {
    private ArrayList<Dragon> dragons;

    private int getIndexById(Integer id) {
        for (int i = 0; i < dragons.size(); ++i) {
            if (dragons.get(i).getId().equals(id)) {
                return i;
            }
        }
        // TODO: add exception
        throw new NoSuchElementException();
    }

    @Override
    public int size() {
        return dragons.size();
    }

    @Override
    public void add(Dragon dragon) {
        dragons.add(dragon);
    }

    @Override
    public void updateById(Integer id, Dragon dragon) {
        dragons.set(getIndexById(id), dragon);
    }

    @Override
    public void removeById(Integer id) {
        dragons.remove(getIndexById(id));
    }

    @Override
    public void clear() {
        dragons.clear();
    }

    @Override
    public void insertAt(int index, Dragon dragon) {
        dragons.add(index, dragon);
    }

    @Override
    public void addIfMax(Dragon dragon) {
        for (Dragon value : dragons) {
            if (value.getId() >= dragon.getId()) {
                return;
            }
        }

        add(dragon);
    }

    @Override
    public void removeGreater(Dragon dragon) {
        dragons.removeIf(x -> x.getId() > dragon.getId());
    }

    @Override
    public int countByAge(Integer age) {
        int count = 0;
        for (Dragon dragon : dragons) {
            if (dragon.getAge().equals(age)) {
                ++count;
            }
        }
        return count;
    }

    @Override
    public int countLessThanWingspan(Double wingspan) {
        int count = 0;
        for (Dragon dragon : dragons) {
            if (dragon.getWingspan() < wingspan) {
                ++count;
            }
        }
        return count;
    }

    @Override
    public Iterator<Dragon> iterator() {
        return dragons.iterator();
    }
}
