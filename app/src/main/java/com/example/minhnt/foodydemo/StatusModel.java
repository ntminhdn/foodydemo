package com.example.minhnt.foodydemo;

/**
 * Created by minh.nt on 5/23/2017.
 */

public class StatusModel {
    public long totalComment;
    public long totalPhotos;
    public boolean status;

    public StatusModel(long totalComment, long totalPhotos, boolean status) {
        this.totalComment = totalComment;
        this.totalPhotos = totalPhotos;
        this.status = status;
    }
}
