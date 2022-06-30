package cn.edu.nju.github.service.impl;

import cn.edu.nju.github.domain.CommitEntity;
import cn.edu.nju.github.domain.GithubRepo;
import cn.edu.nju.github.domain.GithubRepoTree;
import cn.edu.nju.github.service.IGitHubService;
import cn.nju.edu.common.core.domain.entity.GitHubRepo;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class GitHubServiceImpl implements IGitHubService {
    private static SimpleDateFormat TZDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    @Override
    public List<CommitEntity> selectCommitHistory(GitHubRepo repo) throws IOException, ParseException {
        List<CommitEntity> commitEntities = new ArrayList<>();

        String urlStr = "https://api.github.com/repos" + "/" + repo.getUsername() + "/" + repo.getRepoName() + "/commits";
        URL url = new URL(urlStr);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String line = br.readLine();
        for (Object o : JSONArray.parseArray(line)) {
            JSONObject jsonObject = (JSONObject) o;

            String sha = jsonObject.getString("sha");
            String dateStr = jsonObject.getJSONObject("commit").getJSONObject("author").getString("date");
            String message = jsonObject.getJSONObject("commit").getString("message");
            String htmlUrl = jsonObject.getString("html_url");
            String treeSha = jsonObject.getJSONObject("commit").getJSONObject("tree").getString("sha");
            String treeUrl = jsonObject.getJSONObject("commit").getJSONObject("tree").getString("url");

            commitEntities.add(new CommitEntity(sha, TZDateFormat.parse(dateStr), message, htmlUrl, new GithubRepoTree(treeSha, treeUrl)));

        }


        return commitEntities;
    }

    @Override
    public List<CommitEntity> selectCommitHistoryByPath(GitHubRepo repo, String path) throws IOException, ParseException {
        List<CommitEntity> commitEntities = new ArrayList<>();
        //https://api.github.com/repos/Netflix/Hystrix/commits?path=OSSMETADATA
        String urlStr = "https://api.github.com/repos" + "/" + repo.getUsername() + "/" + repo.getRepoName() + "/commits"
                + "?" + "path=" + "path";
        URL url = new URL(urlStr);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String line = br.readLine();
        for (Object o : JSONArray.parseArray(line)) {
            JSONObject jsonObject = (JSONObject) o;

            String sha = jsonObject.getString("sha");
            String dateStr = jsonObject.getJSONObject("commit").getJSONObject("author").getString("date");
            String message = jsonObject.getJSONObject("commit").getString("message");
            String htmlUrl = jsonObject.getString("html_url");
            String treeSha = jsonObject.getJSONObject("commit").getJSONObject("tree").getString("sha");
            String treeUrl = jsonObject.getJSONObject("commit").getJSONObject("tree").getString("url");

            commitEntities.add(new CommitEntity(sha, TZDateFormat.parse(dateStr), message, htmlUrl, new GithubRepoTree(treeSha, treeUrl)));

        }

        return commitEntities;
    }
}
