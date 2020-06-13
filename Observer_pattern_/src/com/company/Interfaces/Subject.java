package com.company.Interfaces;

/*
Интерфейс Subject реализуется субъктом(он же главный объект), который посылает данные наблюдателям.
Этот интерфейс реализует только один объект.
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
