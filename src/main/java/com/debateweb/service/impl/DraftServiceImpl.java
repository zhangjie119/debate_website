package com.debateweb.service.impl;

import com.debateweb.dao.DraftDao;
import com.debateweb.entity.Draft;
import com.debateweb.service.DraftService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("draftService")
public class DraftServiceImpl implements DraftService {

    @Resource
    private DraftDao draftDao;

    @Override
    public Draft queryById(Integer did) {
        return this.draftDao.queryById(did);
    }

    /**
     * 根据用户id查询数据列表
     *
     * @param uid 用户id
     * @return 稿件对象列表
     */
    @Override
    public List<Draft> queryByUid(Integer uid) {
        return this.draftDao.queryByUid(uid);
    }

    @Override
    public Draft insert(Draft draft) {
        this.draftDao.insert(draft);
        return draft;
    }

    @Override
    public Boolean update(Draft draft) {
        return this.draftDao.update(draft) > 0;
    }

    @Override
    public boolean deleteById(Integer did) {
        return this.draftDao.deleteById(did) > 0;
    }

    @Override
    public List<Draft> queryByKeyword(String keyword) {
        //把关键字两边加上“%”以实现模糊查询
        keyword = '%' + keyword + '%';
        return this.draftDao.queryByKeyword(keyword);
    }

    @Override
    public boolean upload(String draftName, String draftSchool, String draftType, String uploader, String address, Integer uid) {
        Draft draft = new Draft();
        draft.setDraftname(draftName);
        draft.setDraftschool(draftSchool);
        draft.setDrafttype(draftType);
        draft.setUploder(uploader);
        draft.setAddress(address);
        draft.setUploaderid(uid);
        return this.draftDao.insert(draft) > 0;
    }

    /**
     * 查询所有数据
     *
     * @param page 页码
     * @param size 每页数量
     * @return 对象列表
     */
    @Override
    public List<Draft> queryAll(int page,int size) {
        //pageName——页码取值;pageSize——每页显示条数
        PageHelper.startPage(page,size);
        return draftDao.queryAll();
    }
}
