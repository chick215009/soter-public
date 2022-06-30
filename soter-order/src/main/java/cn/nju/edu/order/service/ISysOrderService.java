package cn.nju.edu.order.service;

import java.util.List;
import cn.nju.edu.order.domain.SysOrder;

/**
 * 订单明细Service接口
 * 
 * @author clm
 * @date 2022-02-14
 */
public interface ISysOrderService 
{
    /**
     * 查询订单明细
     * 
     * @param orderId 订单明细主键
     * @return 订单明细
     */
    public SysOrder selectSysOrderByOrderId(Long orderId);

    /**
     * 查询订单明细列表
     * 
     * @param sysOrder 订单明细
     * @return 订单明细集合
     */
    public List<SysOrder> selectSysOrderList(SysOrder sysOrder);

    /**
     * 新增订单明细
     * 
     * @param sysOrder 订单明细
     * @return 结果
     */
    public int insertSysOrder(SysOrder sysOrder);

    /**
     * 修改订单明细
     * 
     * @param sysOrder 订单明细
     * @return 结果
     */
    public int updateSysOrder(SysOrder sysOrder);

    /**
     * 批量删除订单明细
     * 
     * @param orderIds 需要删除的订单明细主键集合
     * @return 结果
     */
    public int deleteSysOrderByOrderIds(Long[] orderIds);

    /**
     * 删除订单明细信息
     * 
     * @param orderId 订单明细主键
     * @return 结果
     */
    public int deleteSysOrderByOrderId(Long orderId);
}
