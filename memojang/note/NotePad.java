package memojang.note;

import memojang.usecase.NoteService;

import java.util.List;
import java.util.Scanner;

public class NotePad {

    private final List<NoteEntity> noteEntities;
    private final Scanner scanner;
//    private int noteLength = 0;
//    private final int NOTE_SIZE = 20;

    public NotePad(List<NoteEntity> list, Scanner scanner){
        this.noteEntities = list;
        this.scanner = scanner;
    }

//    메모 전체 보기
    public void printAllNotes() {
        System.out.println("-- 메모 전체 보기 --");
        if (noteEntities.isEmpty()) {
            System.out.println("작성된 메모가 없습니다. \n");
            return;
        }
        for (int i = 0; i < this.noteEntities.size(); i++) {
            NoteEntity noteEntity = noteEntities.get(i);

            String headLine = String.format("번호:%d 제목:%s 작성날짜:%s", i, noteEntity.getTitle(),
                    noteEntity.getLastUpdatedDateTime());
            System.out.println(headLine);
        }
        System.out.println("=============================\n");
    }

//    메모 상세 보기
    public void printNote() {
        System.out.println("-- 메모 상세 보기 --");
        System.out.println("확인할 메모의 번호를 입력해주세요");
        int selectedNumber = Integer.parseInt(scanner.nextLine());

        if (selectedNumber < 0 || selectedNumber >= noteEntities.size()) {
            System.out.println("오류 : 작성되지 않은 메모 입니다. \n");
            return;
        }
        NoteEntity noteEntity = noteEntities.get(selectedNumber);

        System.out.println("=============================");
        String headLine = String.format("번호:%d 제목:%s", selectedNumber, noteEntity.getTitle());
        System.out.println(headLine);
        System.out.println("작성일 : " + noteEntity.getLastUpdatedDateTime());
        System.out.println("내용 : " + noteEntity.getContent());
        System.out.println("=============================\n");
    }

//    메모 추가
    public void addNote() {
        System.out.println("-- 메모 신규 등록 --");
//        TODO ArrayList로 변경 해서 무쓸모
//        if (NOTE_SIZE == this.noteLength) {
//            System.out.println("메모가 가득 찼습니다");
//            System.out.println("");
//            return;
//        }
        System.out.println("제목을 작성해주세요");
        String title = scanner.nextLine();
        System.out.println("본문을 작성해주세요");
        String content = scanner.nextLine();

        noteEntities.add(NoteEntity.newInstance(title, content));

        System.out.println("메모가 성공적으로 작성되었습니다. \n");
    }

//    메모 수정
    public void updateNote(){
        System.out.println("-- 메모 수정 --");
        System.out.println("수정하실 메모의 번호를 입력해주세요");
        int selectedNumber = Integer.parseInt(scanner.nextLine());

//        인덱스 유효성 검사
        if (selectedNumber < 0 || selectedNumber >= noteEntities.size()) {
            System.out.println("오류 : 작성되지 않은 메모 입니다. \n");
            return;
        }

        System.out.println("수정 할 제목을 작성해주세요");
        String title = scanner.nextLine();

        System.out.println("수정 할 본문을 작성해주세요");
        String content = scanner.nextLine();

        NoteEntity noteEntity = noteEntities.get(selectedNumber);
        noteEntity.updateTitle(title);
        noteEntity.updateContent(content);

        System.out.println("메모가 수정되었습니다. \n");
    }

    public void removeNote(){
        System.out.println("-- 메모 삭제 --");
        System.out.println("삭제 할 메모장 번호를 입력해 주세요");
        int selectedNumber = Integer.parseInt(scanner.nextLine());

        if (selectedNumber < 0 || selectedNumber >= noteEntities.size()) {
            System.out.println("오류 : 작성되지 않은 메모 입니다. \n");
            return;
        }

        NoteEntity noteEntity = noteEntities.remove(selectedNumber);
        System.out.println("메모가 삭제 되었습니다. \n");
    }

}
