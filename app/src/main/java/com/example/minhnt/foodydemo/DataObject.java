package com.example.minhnt.foodydemo;

import java.util.List;

/**
 * Created by minh.nt on 5/23/2017.
 */

public class DataObject {
    public InfoModel infoModel;
    public PhotosModel photosModel;
    public CommentModel commentModel;
    public StatusModel statusModel;

    public DataObject(InfoModel infoModel, PhotosModel photosModel, CommentModel commentModel, StatusModel statusModel) {
        this.infoModel = infoModel;
        this.photosModel = photosModel;
        this.commentModel = commentModel;
        this.statusModel = statusModel;
    }
}
