package criminalintent.com.example.lenovo.schedule.Data;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/11/28.
 */

public class Projects implements Serializable {

    ////////project的信息
    private String title;
    private String desc;
    private int photoId;
    private int progress;


    public Projects(String title,String desc,int photoId,int progress){
        this.title=title;
        this.desc=desc;
        this.photoId=photoId;
        this.progress=progress;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }




}
