package com.debateweb.service;

import com.debateweb.entity.Draft;

import java.text.ParseException;
import java.util.List;

/**
 * (Draft)表服务接口
 *
 * @author makejava
 * @since 2020-03-26 15:36:05
 */
public interface DraftService {

    /**
     * 通过ID查询单条数据
     *
     * @param did 主键
     * @return 实例对象
     */
    Draft queryById(Integer did);

    /**
     * 根据用户id查询数据列表
     *
     * @param uid 用户id
     * @return 稿件对象列表
     */
    List<Draft> queryByUid(Integer uid);

    /**
     * 新增数据
     *
     * @param draft 实例对象
     * @return 实例对象
     */
    Draft insert(Draft draft);

    /**
     * 修改数据
     *
     * @param draft 实例对象
     * @return 实例对象
     */
    Boolean update(Draft draft);

    /**
     * 通过主键删除数据
     *
     * @param did 主键
     * @return 是否成功
     */
    boolean deleteById(Integer did);

    /**
     * 根据关键词搜索数据
     *
     * @param keyword
     * @return
     */
    List<Draft> queryByKeyword(String keyword);

    /**
     * 上传辩论稿
     *
     * @param draftName
     * @param draftSchool
     * @param draftType
     * @param uploader
     * @param address
     * @return
     */
    boolean upload(String draftName, String draftSchool, String draftType, String uploader, String address, Integer uid) throws ParseException;

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Draft> queryAll(int page, int size);
}