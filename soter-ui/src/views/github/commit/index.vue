<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" v-show="showSearch" :inline="true">
      <el-form-item label="用户名" prop="username">
        <el-input
          placeholder="请输入用户名"
          v-model="queryParams.username"
          clearable
          size="small"
          style="width: 240px"
          required="true"
        />
      </el-form-item>
      <el-form-item label="仓库名" prop="repoName">
        <el-input
          placeholder="请输入仓库名"
          v-model="queryParams.repoName"
          clearable
          size="small"
          style="width: 240px"
          required="true"
        />
      </el-form-item>
      <el-form-item label="提交时间">
        <el-date-picker
          v-model="dateRange"
          size="small"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
          >搜索</el-button
        >
        <el-button
          icon="el-icon-refresh"
          size="mini"
          @click="resetQuery"
          >重置</el-button
        >
      </el-form-item>
    </el-form>

    <el-table
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="提交SHA" prop="rcommitSHA" width="120" />
      <el-table-column label="提交日期" prop="rcommitDate" width="120" />
      <el-table-column label="提交信息" prop="rcommitDate" width="120" />
      <el-table-column
        label="操作"
        align="center"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope" v-if="scope.row.roleId !== 1">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            >提交页面</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            >文件页面</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <pagination
    v-show="total>0"
    :total="total"
    :page.sync="queryParams.pageNum"
    :limit.sync="queryParams.pageSize"
    @pageination="getList"
    />

  </div>
</template>

<script>
import { listCommit } from "@/api/github/commit";

export default {
  data() {
    return {
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        username: undefined,
        repoName: undefined
      },
      showSearch: true,
      dateRange: [],
    }
  },
  methods: {
    /* 查询提交历史 */
    getList() {
      this.loading = true;
      listCommit(this.addDateRange(this.queryParams, this.dateRange)).then(reponse => {
        this.commitList = reponse.rows;
        this.total = response.total;
        this.loading = false;
      }
      );
    },
    // 搜索按钮
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList()
    },
    // 重置按钮
    resetQuery() {
      this.resetForm("queryFrom");
    }
  }
}
</script>

