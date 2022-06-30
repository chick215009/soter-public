package cn.nju.edu.order.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import cn.nju.edu.common.annotation.Excel;
import cn.nju.edu.common.core.domain.BaseEntity;

/**
 * 订单明细对象 sys_order
 * 
 * @author clm
 * @date 2022-02-14
 */
public class SysOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单ID */
    private Long orderId;

    /** 订单名称 */
    @Excel(name = "订单名称")
    private String orderName;

    /** 订单组名 */
    @Excel(name = "订单组名")
    private String orderGroup;

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setOrderName(String orderName) 
    {
        this.orderName = orderName;
    }

    public String getOrderName() 
    {
        return orderName;
    }
    public void setOrderGroup(String orderGroup) 
    {
        this.orderGroup = orderGroup;
    }

    public String getOrderGroup() 
    {
        return orderGroup;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("orderName", getOrderName())
            .append("orderGroup", getOrderGroup())
            .toString();
    }
}
