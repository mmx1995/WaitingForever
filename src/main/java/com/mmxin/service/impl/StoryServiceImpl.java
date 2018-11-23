package com.mmxin.service.impl;

import com.mmxin.mapper.StoryMapper;
import com.mmxin.pojo.Story;
import com.mmxin.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    StoryMapper storyMapper;

    @Override
    public List<Story> getMorePopular() {
        return null;
    }

    @Override
    public List<Story> getMoreUseful() {
        return null;
    }

    @Override
    public List<Story> getMoreConsent() {
        return null;
    }

    @Override
    public List<Story> getMoreComment() {
        return null;
    }

    @Override
    public List<Story> getIndex() {
        List<Story> list = this.storyMapper.selectAll();
        return list;
    }
}
