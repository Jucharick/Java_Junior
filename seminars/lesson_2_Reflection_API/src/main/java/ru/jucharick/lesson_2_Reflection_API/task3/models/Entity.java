package ru.jucharick.lesson_2_Reflection_API.task3.models;

import ru.jucharick.lesson_2_Reflection_API.task3.Column;

import java.util.UUID;

@ru.jucharick.lesson_2_Reflection_API.task3.Entity
public class Entity {

    @Column(name = "id", primaryKey = true)
    private UUID id;

}
