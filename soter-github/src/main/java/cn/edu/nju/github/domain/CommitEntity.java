package cn.edu.nju.github.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import cn.nju.edu.common.annotation.Excel;
import cn.nju.edu.common.core.domain.BaseEntity;

/**
 * commit对象 commit_entity
 *
 * @author clm
 * @date 2022-02-14
 */
public class CommitEntity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** commit SHA值 */
    @Excel(name = "commit SHA值")
    private String commitSha;

    /** 提交日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "提交日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date commitDate;

    /** 提交信息 */
    @Excel(name = "提交信息")
    private String commitMessage;

    /** commit id */
    private Long commitId;

    /** 用户名 */
    private String username;

    /** 仓库名 */
    private String repoName;

    public void setCommitSha(String commitSha)
    {
        this.commitSha = commitSha;
    }

    public String getCommitSha()
    {
        return commitSha;
    }
    public void setCommitDate(Date commitDate)
    {
        this.commitDate = commitDate;
    }

    public Date getCommitDate()
    {
        return commitDate;
    }
    public void setCommitMessage(String commitMessage)
    {
        this.commitMessage = commitMessage;
    }

    public String getCommitMessage()
    {
        return commitMessage;
    }
    public void setCommitId(Long commitId)
    {
        this.commitId = commitId;
    }

    public Long getCommitId()
    {
        return commitId;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }
    public void setRepoName(String repoName)
    {
        this.repoName = repoName;
    }

    public String getRepoName()
    {
        return repoName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("commitSha", getCommitSha())
            .append("commitDate", getCommitDate())
            .append("commitMessage", getCommitMessage())
            .append("commitId", getCommitId())
            .append("username", getUsername())
            .append("repoName", getRepoName())
            .toString();
    }
}
