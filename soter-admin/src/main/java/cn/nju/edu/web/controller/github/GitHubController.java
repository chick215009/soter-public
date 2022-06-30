package cn.nju.edu.web.controller.github;

import cn.edu.nju.github.domain.CommitEntity;
import cn.edu.nju.github.service.IGitHubService;
import cn.nju.edu.common.core.domain.entity.GitHubRepo;
import cn.nju.edu.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static cn.nju.edu.common.utils.PageUtils.startPage;

/**
 * GitHub接口
 */
@RestController
@RequestMapping("/github/commit")
public class GitHubController {
//    @Autowired
    private IGitHubService gitHubService;


    @GetMapping("/list")
    public TableDataInfo list(GitHubRepo repo) throws IOException, ParseException {
        startPage();
        List<CommitEntity> commitEntities = gitHubService.selectCommitHistory(repo);
        return null;
    }

}
