/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.

-Создать множество ноутбуков.
-Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру.
Критерии фильтрации можно хранить в Map.
Например:
Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
-Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
-Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */


package notebook;

import enums.OSTypes;

public class NoteBook {

    public NoteBook(String name, int sizeOfOZU, int sizeOfHDD, OSTypes OSName, String color) {
        this.name = name;
        this.sizeOfOZU = sizeOfOZU;
        this.sizeOfHDD = sizeOfHDD;
        this.OSName = OSName;
        this.color = color;
    }

    public NoteBook() {
        this.name = "NewNote";
        this.sizeOfHDD = 512;
        this.sizeOfOZU = 32;
        this.OSName = OSTypes.Windows;
        this.color  = "Silver";
    }

    public String name;

    public int sizeOfOZU;

    public int sizeOfHDD;

    public OSTypes OSName;

    public String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSizeOfOZU() {
        return sizeOfOZU;
    }

    public void setSizeOfOZU(int sizeOfOZU) {
        this.sizeOfOZU = sizeOfOZU;
    }

    public int getSizeOfHDD() {
        return sizeOfHDD;
    }

    public void setSizeOfHDD(int sizeOfHDD) {
        this.sizeOfHDD = sizeOfHDD;
    }

    public OSTypes getOSName() {
        return OSName;
    }

    public void setOSName(OSTypes OSName) {
        this.OSName = OSName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

