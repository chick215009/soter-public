package cn.edu.nju.github.service;

import cn.edu.nju.github.domain.CommitEntity;
import cn.edu.nju.github.domain.GithubRepo;
import cn.nju.edu.common.core.domain.entity.GitHubRepo;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface IGitHubService {
    /**
     * 通过仓库信息查询提交历史
     * @param repo
     * @return
     */
    List<CommitEntity> selectCommitHistory(GitHubRepo repo) throws IOException, ParseException;

    /**
     * 通过仓库信息和文件路径查询提交历史
     * @param repo
     * @param path
     * @return
     */
    List<CommitEntity> selectCommitHistoryByPath(GitHubRepo repo, String path) throws IOException, ParseException;
}
