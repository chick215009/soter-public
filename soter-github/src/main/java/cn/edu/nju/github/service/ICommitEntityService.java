package cn.edu.nju.github.service;

import java.util.List;

import cn.edu.nju.github.domain.CommitEntity;
import cn.nju.edu.github.domain.CommitEntity;

/**
 * commitService接口
 *
 * @author clm
 * @date 2022-02-14
 */
public interface ICommitEntityService
{
    /**
     * 查询commit
     *
     * @param commitId commit主键
     * @return commit
     */
    public CommitEntity selectCommitEntityByCommitId(Long commitId);

    /**
     * 查询commit列表
     *
     * @param commitEntity commit
     * @return commit集合
     */
    public List<CommitEntity> selectCommitEntityList(CommitEntity commitEntity);

    /**
     * 新增commit
     *
     * @param commitEntity commit
     * @return 结果
     */
    public int insertCommitEntity(CommitEntity commitEntity);

    /**
     * 修改commit
     *
     * @param commitEntity commit
     * @return 结果
     */
    public int updateCommitEntity(CommitEntity commitEntity);

    /**
     * 批量删除commit
     *
     * @param commitIds 需要删除的commit主键集合
     * @return 结果
     */
    public int deleteCommitEntityByCommitIds(Long[] commitIds);

    /**
     * 删除commit信息
     *
     * @param commitId commit主键
     * @return 结果
     */
    public int deleteCommitEntityByCommitId(Long commitId);
}
