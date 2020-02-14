package com.junsir.community.community.Dao;

import com.junsir.community.community.Dto.QuestionDto;
import com.junsir.community.community.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CommentMapper {

    public List<Comment> selectCommentByQuestionId(Integer id) ;

    public  void  insert(Comment comment)  ;
}
