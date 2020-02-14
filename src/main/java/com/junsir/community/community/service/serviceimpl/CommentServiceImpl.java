package com.junsir.community.community.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.junsir.community.community.Dao.CommentMapper;
import com.junsir.community.community.Dao.QuestionDao;
import com.junsir.community.community.Dto.PageDto;
import com.junsir.community.community.Dto.QuestionDto;
import com.junsir.community.community.model.Comment;
import com.junsir.community.community.model.GitHubUser;
import com.junsir.community.community.service.CommentService;
import com.junsir.community.community.service.PageService;
import com.junsir.community.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper  ;

    @Autowired
    private UserService userService ;

    @Override
    public List<Comment> selectCommentByQuestionId(Integer id) {

          List<Comment> commentList = (List<Comment>) commentMapper.selectCommentByQuestionId(id);

            for (Comment comment : commentList) {
            String userId = comment.getUserId();
            GitHubUser user = userService.selectUserById(userId) ;
            comment.setUser(user);
        }

        return commentList ;
    }

    @Override
    public void insert(Comment comment) {
        commentMapper.insert(comment);
    }
}