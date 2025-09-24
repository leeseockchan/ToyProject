package memojang;

import memojang.usecase.NoteService;

public class Main {

    public static void main(String[] args) {
        NoteService noteService = new NoteService();
        noteService.run();
    }

}
