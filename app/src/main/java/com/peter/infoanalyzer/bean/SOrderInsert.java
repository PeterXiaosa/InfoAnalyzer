package com.peter.infoanalyzer.bean;

public class SOrderInsert
{
    private String CompanyNo;          //经纪公司编号
    private String UserNo;             //资金帐号
    private String AddressNo;          //地址号
    private String ContractNo;         //合约编号
    private char                                                OrderType;          //定单类型
    private char                                                OrderWay;           //委托来源
    private char                                                ValidType;          //有效类型
    private String ValidTime;          //有效日期时间(GTD情况下使用)
    private char                                                Direct;             //买卖方向
    private char                                                Offset;             //开仓 平仓 开平 平开(内盘)
    private char                                                Hedge;              //投机保值(内盘)

    private double                                              OrderPrice;         //委托价格 或 期权应价买入价格(委托价格类型为指定时有效)（策略单委托价格类型为指定价时有效)
    private double                                              OrderPriceOver;     //委托价超出值(委托价格类型为最新价 挂单价 对盘价时有效)(限策略单使用)

    private java.math.BigInteger                                OrderQty;           //委托数量 或 期权应价数量

    //价格条件1
    private double                                              TriggerPrice;       //触发价格
    private char                                                TriggerMode;        //触发模式
    private char                                                TriggerCondition;   //触发条件

    private char                                                StrategyType;       //策略类型(条件单，止损单、浮动止损、保本止损、止盈单)

    private String ParentNo;

    private long                                                OrderReqId;         //报单请求号
    private long                                                ParentReqId;        //父单请求号
    private char                                                OrderPriceType;     //委托价格类型(指定价 最新价 挂单价 对盘价 市价 反向停板，只有指定价时委托价格字段才有效)(限策略单使用)

    private String TimeCondition;      //时间条件(HH:MM:SS)

    //价格条件2
    private double                                              TriggerPrice2;      //触发价格2
    private char                                                TriggerMode2;       //触发模式2
    private char                                                TriggerCondition2;  //触发条件2

    //停损
    private char                                                StopPriceType;      //止损止盈价格类型：价格(停损价)、价差(停损价差、浮动止损回撤价差、保本盈利价差)
    private double                                              StopPrice;          //止损止盈价或价差，具体含义由止损止盈价格类型字段决定
    private String OrderRef;           //报单引用
    private byte                                                AddOne;             //是否T+1
    private byte                                                AutoCloseFlag;      //自对冲标记

    public SOrderInsert()
    {
        CompanyNo="";
        UserNo="";
        AddressNo="";
        ContractNo="";
        ValidTime="";
        ParentNo="";
        TimeCondition="";
        OrderRef = "";
    }

    public void setCompanyNo(String value)
    {
        CompanyNo=value;
    }

    public String getCompanyNo()
    {
        return CompanyNo;
    }

    public void setUserNo(String value)
    {
        UserNo=value;
    }

    public String getUserNo()
    {
        return UserNo;
    }

    public String getAddressNo() {
        return AddressNo;
    }

    public void setAddressNo(String addressNo) {
        AddressNo = addressNo;
    }

    public void setContractNo(String value)
    {
        ContractNo=value;
    }

    public String getContractNo()
    {
        return ContractNo;
    }

    public void setOrderType(char value)
    {
        OrderType=value;
    }

    public char getOrderType()
    {
        return OrderType;
    }

    public void setOrderWay(char value)
    {
        OrderWay=value;
    }

    public char getOrderWay()
    {
        return OrderWay;
    }

    public void setValidType(char value)
    {
        ValidType=value;
    }

    public char getValidType()
    {
        return ValidType;
    }

    public void setValidTime(String value)
    {
        ValidTime=value;
    }

    public String getValidTime()
    {
        return ValidTime;
    }


    public void setDirect(char value)
    {
        Direct=value;
    }

    public char getDirect()
    {
        return Direct;
    }

    public void setOffset(char value)
    {
        Offset=value;
    }

    public char getOffset()
    {
        return Offset;
    }

    public void setHedge(char value)
    {
        Hedge=value;
    }

    public char getHedge()
    {
        return Hedge;
    }

    public void setOrderPriceType(char value)
    {
        OrderPriceType=value;
    }

    public char getOrderPriceType()
    {
        return OrderPriceType;
    }

    public void setOrderPrice(double value) { OrderPrice=value; }

    public double getOrderPrice()
    {
        return OrderPrice;
    }

    public void setOrderPriceOver(double value)
    {
        OrderPriceOver=value;
    }

    public double getOrderPriceOver()
    {
        return OrderPriceOver;
    }

    public void setOrderQty(java.math.BigInteger value)
    {
        OrderQty=value;
    }

    public java.math.BigInteger getOrderQty()
    {
        return OrderQty;
    }

    public void setTriggerPrice(double value)
    {
        TriggerPrice=value;
    }

    public double getTriggerPrice()
    {
        return TriggerPrice;
    }

    public void setTriggerMode(char value)
    {
        TriggerMode=value;
    }

    public char getTriggerMode()
    {
        return TriggerMode;
    }

    public void setTriggerCondition(char value)
    {
        TriggerCondition=value;
    }

    public char getTriggerCondition()
    {
        return TriggerCondition;
    }

    public void setStrategyType(char value)
    {
        StrategyType=value;
    }

    public char getStrategyType()
    {
        return StrategyType;
    }

    public void setParentNo(String value)
    {
        ParentNo=value;
    }

    public String getParentNo()
    {
        return ParentNo;
    }

    public void setOrderReqId(long value)
    {
        OrderReqId=value;
    }

    public long getOrderReqId()
    {
        return OrderReqId;
    }

    public void setParentReqId(long value)
    {
        ParentReqId=value;
    }

    public long getParentReqId()
    {
        return ParentReqId;
    }

    public void setTimeCondition(String value)
    {
        TimeCondition=value;
    }

    public String getTimeCondition()
    {
        return TimeCondition;
    }

    public void setTriggerPrice2(double value)
    {
        TriggerPrice2=value;
    }

    public double getTriggerPrice2()
    {
        return TriggerPrice2;
    }

    public void setTriggerMode2(char value)
    {
        TriggerMode2=value;
    }

    public char getTriggerMode2()
    {
        return TriggerMode2;
    }

    public void setTriggerCondition2(char value)
    {
        TriggerCondition2=value;
    }

    public char getTriggerCondition2()
    {
        return TriggerCondition2;
    }

    public void setStopPriceType(char value)
    {
        StopPriceType=value;
    }

    public char getStopPriceType()
    {
        return StopPriceType;
    }

    public void setStopPrice(double value)
    {
        StopPrice=value;
    }

    public double getStopPrice()
    {
        return StopPrice;
    }

    public void setOrderRef(String value)
    {
        OrderRef = value;
    }

    public String getOrderRef()
    {
        return OrderRef;
    }

    public byte getAddOne() {
        return AddOne;
    }

    public void setAddOne(byte addOne) {
        AddOne = addOne;
    }

    public byte getAutoCloseFlag() {
        return AutoCloseFlag;
    }

    public void setAutoCloseFlag(byte autoCloseFlag) {
        AutoCloseFlag = autoCloseFlag;
    }
}