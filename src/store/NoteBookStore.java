package store;

import enums.FiltertTypes;
import enums.OSTypes;
import notebook.NoteBook;

import java.util.*;

public class NoteBookStore {
    List<NoteBook> noteBookList = new ArrayList<NoteBook>(0);

    List<NoteBook> filterBookList = new ArrayList<NoteBook>(0);

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
                int selection = -1;
                try {
                    selection = Integer.parseInt(selectType);

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
                        default:
                            System.out.println("Неправильный выбор!");
                            break;
                    }
                }catch (NumberFormatException e) {
                    System.out.println("Неправильный формат ввода!");
                }

            }
        }while (!selectType.equals("Q"));
        in.close();
    }

    public void printFilter()
    {
        System.out.println(states);
    }

    public void applyFiler()
    {
        for(Map.Entry<FiltertTypes, String> item : states.entrySet()){
            FiltertTypes fT = item.getKey();
            filterBookList = new ArrayList<NoteBook>(0);
            if ((FiltertTypes)item.getKey() == FiltertTypes.OZU)
            {
                String f = item.getValue();
                int fOZU = Integer.parseInt(item.getValue());
                for (NoteBook nb : noteBookList)
                {
                    if (nb.getSizeOfOZU() >= fOZU)
                        filterBookList.add(nb);
                }
            }

            if ((FiltertTypes)item.getKey() == FiltertTypes.HDDSize)
            {
                int fHDD = Integer.parseInt(item.getValue());
                for (NoteBook nb : noteBookList)
                {
                    if (nb.getSizeOfHDD() >= fHDD)
                        filterBookList.add(nb);
                }
            }

            if ((FiltertTypes)item.getKey() == FiltertTypes.OSver)
            {
                String fOS = item.getValue();
                OSTypes osT = OSTypes.NoOS;
                //1-Windows, 2-Linux,3-AstraLinux,4-IOS,5-NoOS
                switch (fOS){
                    case "1":
                        osT = OSTypes.Windows;
                        break;
                    case "2":
                        osT = OSTypes.Linux;
                        break;
                    case "3":
                        osT = OSTypes.AstraLinux;
                        break;
                    case "4":
                        osT = OSTypes.IOS;
                        break;
                    default:
                        break;
                }
                for (NoteBook nb : noteBookList)
                {
                    if (nb.getOSName() == osT)
                        filterBookList.add(nb);
                }
            }

            if ((FiltertTypes)item.getKey() == FiltertTypes.Color)
            {
                String fColor = item.getValue();

                for (NoteBook nb : noteBookList)
                {
                    if (nb.getColor().equals(fColor))
                        filterBookList.add(nb);
                }
            }

            for (NoteBook noteBook : filterBookList){
                System.out.println(noteBook.toString());
            }
        }
    }

    @Override
    public String toString() {
        for (NoteBook noteBook : noteBookList){
            System.out.println(noteBook.toString());
        }
        return  "";
    }
}
