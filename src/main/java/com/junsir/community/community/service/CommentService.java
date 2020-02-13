package com.junsir.community.community.service;

import com.junsir.community.community.model.Comment;

import java.util.List;

public interface CommentService {

    public List<Comment> selectCommentByQuestionId(Integer id) ;
}
