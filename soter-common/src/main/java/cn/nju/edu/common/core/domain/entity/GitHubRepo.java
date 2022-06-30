package cn.nju.edu.common.core.domain.entity;

import cn.nju.edu.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GitHubRepo extends BaseEntity {
    private String username;
    private String repoName;
}
