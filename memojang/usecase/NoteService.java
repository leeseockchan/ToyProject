package memojang.usecase;

import memojang.note.NoteEntity;
import memojang.note.NotePad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoteService {
    private final NotePad notePad;
    private final Scanner scanner;

    public NoteService() {
        List<NoteEntity> notes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.notePad = new NotePad(notes, scanner);
    }

    public void run() {

        while (true) {
            System.out.println("안녕하세요. 메모장입니다");
            System.out.println("1.메모 전체보기 2.메모보기 3.메모작성 4.메모수정 5.메모삭제 6.종료");
            System.out.println("번호를 입력해주세요");

            int selectedNumber;
            try{
                String input = scanner.nextLine();
                selectedNumber = Integer.parseInt(input);
            } catch(NumberFormatException e){
                System.out.println("\n 오류 : 잘못된 입력 입니다. 숫자만 입력 해주세요 \n");
                continue;
            }

            if (1 == selectedNumber) {
// TODO : 메모 전체보기 처리
                notePad.printAllNotes();
            } else if (2 == selectedNumber) {
// TODO : 메모 상세보기 처리
                notePad.printNote();
            } else if (3 == selectedNumber) {
// TODO : 메모 작성하기 처리
                notePad.addNote();
            } else if (4 == selectedNumber) {
// TODO : 메모 수정하기 처리
                notePad.updateNote();
            } else if (5 == selectedNumber) {
// TODO : 메모 삭제 하기 처리
                notePad.removeNote();
            } else if (6 == selectedNumber) {
// TODO : 메모 프로그램 종료
                System.out.println("프로그램을 종료합니다. 안녕히 가세요");
                this.scanner.close();
                break;
            } else {
                System.out.println("\n 오류: 1부터 6까지의 번호를 다시 입력해주세요.\n");
            }
        }
    }


}
