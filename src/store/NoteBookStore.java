package store;

import enums.FiltertTypes;
import enums.OSTypes;
import notebook.NoteBook;

import java.util.*;

public class NoteBookStore {
    List<NoteBook> noteBookList = new ArrayList<NoteBook>(0);

    Map<FiltertTypes, String> states = new HashMap<FiltertTypes, String>();

    public NoteBookStore(List<NoteBook> noteBookList) {
        this.noteBookList = noteBookList;
    }

    public NoteBookStore() {
        noteBookList = new ArrayList<NoteBook>(0);
    }

    public void addNewNotebook(String name, int sizeOfOZU, int sizeOfHDD, OSTypes OSName ,  String color)
    {
        //NoteBook nbNew = new NoteBook(
        NoteBook nbNew = new NoteBook(name, sizeOfOZU,sizeOfHDD,OSName, color);
        noteBookList.add(nbNew);
    }

    public void addNewNotebook(NoteBook newNoteBook){
        if (noteBookList != null)
            noteBookList.add(newNoteBook);
    }

    public void queryFilter()
    {
        Scanner in = new Scanner(System.in);
        String selectType = "";
        do {
            System.out.println("Введите критерий, который хотите задайть или нажмите Q: ");
            System.out.println("1 - Минимальный размер ОЗУ. ");
            System.out.println("2 - Минимальный размер HDD. ");
            System.out.println("3 - Тип ОС: 1-Windows, 2-Linux,3-AstraLinux,4-IOS,5-NoOS.");
            System.out.println("4 - Цвет ноутбука: ");
            selectType = in.next();

            if (!selectType.equals("Q")){
                int selection = Integer.parseInt(selectType);
                switch (selection) {
                    case 1:
                        System.out.println("Введите минимальный размер ОЗУ: ");
                        String filterOZUSize = in.next();
                        states.put(FiltertTypes.OZU, filterOZUSize);
                        break;
                    case 2:
                        System.out.println("Введите минимальный размер HDD: ");
                        String filterHDDSize = in.next();
                        states.put(FiltertTypes.HDDSize, filterHDDSize);
                        break;
                    case 3:
                        System.out.println("Введите тип ОС: 1-Windows, 2-Linux,3-AstraLinux,4-IOS,5-NoOS: ");
                        String filterOSType = in.next();
                        states.put(FiltertTypes.OSver, filterOSType);
                        break;
                    case 4:
                        System.out.println("Введите цвет ноутбука: ");
                        String filterColor = in.next();
                        states.put(FiltertTypes.Color, filterColor);
                        break;
                }
            }
        }while (!selectType.equals("Q"));
        in.close();
    }

    public void pringFilter()
    {
        System.out.println(states);
    }

    @Override
    public String toString() {
        for (NoteBook noteBook : noteBookList){
            System.out.println(noteBook.toString());
        }
        return  "";
    }
}
