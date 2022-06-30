package cn.nju.edu.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.nju.edu.order.mapper.SysOrderMapper;
import cn.nju.edu.order.domain.SysOrder;
import cn.nju.edu.order.service.ISysOrderService;

/**
 * 订单明细Service业务层处理
 * 
 * @author clm
 * @date 2022-02-14
 */
@Service
public class SysOrderServiceImpl implements ISysOrderService 
{
    @Autowired
    private SysOrderMapper sysOrderMapper;

    /**
     * 查询订单明细
     * 
     * @param orderId 订单明细主键
     * @return 订单明细
     */
    @Override
    public SysOrder selectSysOrderByOrderId(Long orderId)
    {
        return sysOrderMapper.selectSysOrderByOrderId(orderId);
    }

    /**
     * 查询订单明细列表
     * 
     * @param sysOrder 订单明细
     * @return 订单明细
     */
    @Override
    public List<SysOrder> selectSysOrderList(SysOrder sysOrder)
    {
        return sysOrderMapper.selectSysOrderList(sysOrder);
    }

    /**
     * 新增订单明细
     * 
     * @param sysOrder 订单明细
     * @return 结果
     */
    @Override
    public int insertSysOrder(SysOrder sysOrder)
    {
        return sysOrderMapper.insertSysOrder(sysOrder);
    }

    /**
     * 修改订单明细
     * 
     * @param sysOrder 订单明细
     * @return 结果
     */
    @Override
    public int updateSysOrder(SysOrder sysOrder)
    {
        return sysOrderMapper.updateSysOrder(sysOrder);
    }

    /**
     * 批量删除订单明细
     * 
     * @param orderIds 需要删除的订单明细主键
     * @return 结果
     */
    @Override
    public int deleteSysOrderByOrderIds(Long[] orderIds)
    {
        return sysOrderMapper.deleteSysOrderByOrderIds(orderIds);
    }

    /**
     * 删除订单明细信息
     * 
     * @param orderId 订单明细主键
     * @return 结果
     */
    @Override
    public int deleteSysOrderByOrderId(Long orderId)
    {
        return sysOrderMapper.deleteSysOrderByOrderId(orderId);
    }
}
