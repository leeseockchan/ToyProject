package memojang.note;

import java.time.LocalDateTime;

public class NoteEntity {
    private String title;       // 제목
    private String content;     // 본문
    private LocalDateTime lastUpdatedDateTime;
    
    private NoteEntity(String title, String content){
        this.title = title;
        this.content = content;
        this.lastUpdatedDateTime = lastUpdatedDateTime.now();
    }

    static NoteEntity newInstance(String title, String content){
        return new NoteEntity(title, content);
    }
    void updateTitle(String title){
        this.title = title;
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }

    void updateContent(String content){
        this.content = content;
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }

    String getTitle(){
        return title;
    }
    String getContent() {
        return content;
    }

    String getLastUpdatedDateTime() {
        return lastUpdatedDateTime.toString();
    }

    

}
