package com.example.minhnt.foodydemo;

import java.util.List;

/**
 * Created by minh.nt on 5/23/2017.
 */

public class CommentModel {
    public String[] avatar;
    public String[] username;
    public String[] comment;
    public double[] userRate;

    public CommentModel(String[] avatar, String[] username, String[] comment, double[] userRate) {
        this.avatar = avatar;
        this.username = username;
        this.comment = comment;
        this.userRate = userRate;
    }
}
