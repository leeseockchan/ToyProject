package memojang.note;

import java.time.LocalDateTime;

public class NoteEntity {
    private String title;       // 제목
    private String user;        // 작성자
    private String content;     // 본문
    private LocalDateTime lastUpdatedDateTime;
    
    private NoteEntity(String title, String user, String content){
        this.title = title;
        this.user = user;
        this.content = content;
        this.lastUpdatedDateTime = lastUpdatedDateTime.now();
    }

    static NoteEntity newInstance(String title, String user, String content){
        return new NoteEntity(title, user, content);
    }

    void updateTitle(String title){
        this.title = title;
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }
    void updateUser(String user){
        this.user = user;
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }

    void updateContent(String content){
        this.content = content;
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }


    String getTitle(){
        return title;
    }
    String getUser(){
        return user;
    }
    String getContent() {
        return content;
    }

    String getLastUpdatedDateTime() {
        return lastUpdatedDateTime.toString();
    }

    

}
