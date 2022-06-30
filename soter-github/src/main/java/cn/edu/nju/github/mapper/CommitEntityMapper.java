package cn.edu.nju.github.mapper;

import java.util.List;
import cn.nju.edu.github.domain.CommitEntity;

/**
 * commitMapper接口
 *
 * @author clm
 * @date 2022-02-14
 */
public interface CommitEntityMapper
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
     * 删除commit
     *
     * @param commitId commit主键
     * @return 结果
     */
    public int deleteCommitEntityByCommitId(Long commitId);

    /**
     * 批量删除commit
     *
     * @param commitIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCommitEntityByCommitIds(Long[] commitIds);
}
