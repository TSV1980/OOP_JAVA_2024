import enums.OSTypes;
import store.NoteBookStore;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        NoteBookStore noteBookStore = new NoteBookStore();
        noteBookStore.addNewNotebook("Lenovo", 32, 256, OSTypes.Windows, "Silver");
        noteBookStore.addNewNotebook("IBM", 64, 512, OSTypes.Linux, "Black");
        noteBookStore.addNewNotebook("HP", 16, 1024, OSTypes.Windows, "White");

        System.out.println(noteBookStore.toString());

        noteBookStore.queryFilter();
        noteBookStore.pringFilter();

        }
    }
