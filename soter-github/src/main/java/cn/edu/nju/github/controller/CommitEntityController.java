package cn.edu.nju.github.controller;

import cn.edu.nju.github.domain.CommitEntity;
import cn.edu.nju.github.service.ICommitEntityService;
import cn.nju.edu.common.annotation.Log;
import cn.nju.edu.common.core.controller.BaseController;
import cn.nju.edu.common.core.domain.AjaxResult;
import cn.nju.edu.common.core.page.TableDataInfo;
import cn.nju.edu.common.enums.BusinessType;
import cn.nju.edu.common.utils.poi.ExcelUtil;
import cn.nju.edu.github.domain.CommitEntity;
import cn.nju.edu.github.service.ICommitEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * commitController
 *
 * @author clm
 * @date 2022-02-14
 */
@RestController
@RequestMapping("/github/list")
public class CommitEntityController extends BaseController
{
    @Autowired
    private ICommitEntityService commitEntityService;

    /**
     * 查询commit列表
     */
    @PreAuthorize("@ss.hasPermi('github:list:list')")
    @GetMapping("/list")
    public TableDataInfo list(CommitEntity commitEntity)
    {
        startPage();
        List<CommitEntity> list = commitEntityService.selectCommitEntityList(commitEntity);
        return getDataTable(list);
    }

    /**
     * 导出commit列表
     */
    @PreAuthorize("@ss.hasPermi('github:list:export')")
    @Log(title = "commit", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CommitEntity commitEntity)
    {
        List<CommitEntity> list = commitEntityService.selectCommitEntityList(commitEntity);
        ExcelUtil<CommitEntity> util = new ExcelUtil<CommitEntity>(CommitEntity.class);
        util.exportExcel(response, list, "commit数据");
    }

    /**
     * 获取commit详细信息
     */
    @PreAuthorize("@ss.hasPermi('github:list:query')")
    @GetMapping(value = "/{commitId}")
    public AjaxResult getInfo(@PathVariable("commitId") Long commitId)
    {
        return AjaxResult.success(commitEntityService.selectCommitEntityByCommitId(commitId));
    }

    /**
     * 新增commit
     */
    @PreAuthorize("@ss.hasPermi('github:list:add')")
    @Log(title = "commit", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CommitEntity commitEntity)
    {
        return toAjax(commitEntityService.insertCommitEntity(commitEntity));
    }

    /**
     * 修改commit
     */
    @PreAuthorize("@ss.hasPermi('github:list:edit')")
    @Log(title = "commit", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CommitEntity commitEntity)
    {
        return toAjax(commitEntityService.updateCommitEntity(commitEntity));
    }

    /**
     * 删除commit
     */
    @PreAuthorize("@ss.hasPermi('github:list:remove')")
    @Log(title = "commit", businessType = BusinessType.DELETE)
	@DeleteMapping("/{commitIds}")
    public AjaxResult remove(@PathVariable Long[] commitIds)
    {
        return toAjax(commitEntityService.deleteCommitEntityByCommitIds(commitIds));
    }
}
