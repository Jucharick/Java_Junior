package ru.jucharick;

import java.util.Collection;

public interface Repository {
    void add(Course item);
    void update(Course item);
    void delete(Course item);
    Course getById(Integer id);
    Collection<Course> getAll();
}