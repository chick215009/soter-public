package cn.edu.nju.github.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GithubRepoTree {
    private String sha;
    private String url;
}
