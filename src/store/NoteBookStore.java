package store;

import notebook.NoteBook;

import java.util.ArrayList;
import java.util.List;

public class NoteBookStore {
    List<NoteBook> noteBookList = new ArrayList<NoteBook>(0);

    public NoteBookStore(List<NoteBook> noteBookList) {
        this.noteBookList = noteBookList;
    }

    public NoteBookStore() {
        noteBookList = new ArrayList<NoteBook>(0);
    }

    public void addNewNotebook(NoteBook newNoteBook){
        if (noteBookList != null)
            noteBookList.add(newNoteBook);
    }


}
