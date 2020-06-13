package com.company.Interfaces;

/*
Интерфейс Observer реализуется всеми наблюдателями. Наблюдатели должны реализовывать метод update().
 */
public interface Observer {
   void update(float temp, float hum, float pressure);
}
