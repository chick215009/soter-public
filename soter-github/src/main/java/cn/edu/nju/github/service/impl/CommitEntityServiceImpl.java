package cn.edu.nju.github.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.nju.edu.github.mapper.CommitEntityMapper;
import cn.nju.edu.github.domain.CommitEntity;
import cn.nju.edu.github.service.ICommitEntityService;

/**
 * commitService业务层处理
 *
 * @author clm
 * @date 2022-02-14
 */
@Service
public class CommitEntityServiceImpl implements ICommitEntityService
{
    @Autowired
    private CommitEntityMapper commitEntityMapper;

    /**
     * 查询commit
     *
     * @param commitId commit主键
     * @return commit
     */
    @Override
    public CommitEntity selectCommitEntityByCommitId(Long commitId)
    {
        return commitEntityMapper.selectCommitEntityByCommitId(commitId);
    }

    /**
     * 查询commit列表
     *
     * @param commitEntity commit
     * @return commit
     */
    @Override
    public List<CommitEntity> selectCommitEntityList(CommitEntity commitEntity)
    {
        return commitEntityMapper.selectCommitEntityList(commitEntity);
    }

    /**
     * 新增commit
     *
     * @param commitEntity commit
     * @return 结果
     */
    @Override
    public int insertCommitEntity(CommitEntity commitEntity)
    {
        return commitEntityMapper.insertCommitEntity(commitEntity);
    }

    /**
     * 修改commit
     *
     * @param commitEntity commit
     * @return 结果
     */
    @Override
    public int updateCommitEntity(CommitEntity commitEntity)
    {
        return commitEntityMapper.updateCommitEntity(commitEntity);
    }

    /**
     * 批量删除commit
     *
     * @param commitIds 需要删除的commit主键
     * @return 结果
     */
    @Override
    public int deleteCommitEntityByCommitIds(Long[] commitIds)
    {
        return commitEntityMapper.deleteCommitEntityByCommitIds(commitIds);
    }

    /**
     * 删除commit信息
     *
     * @param commitId commit主键
     * @return 结果
     */
    @Override
    public int deleteCommitEntityByCommitId(Long commitId)
    {
        return commitEntityMapper.deleteCommitEntityByCommitId(commitId);
    }
}
