package com.qmcs.common.util.enums;

/**
 * Created by zhoudu on 2017/5/18.
 *  定义错误码 分为ERROR 和INFO
 *
 *  ERROR 为错误
 *  INFO 为交互提示信息
 *
 *
 */
public enum TypeEnum {
    /**
     * 是否为传送员 0 不是 1 是
     */
    USER_IS_DELIVER(1,"是"),

    USER_IS_NOT_DELIVER(0,"否"),
    /**
     * 传送员开关。0 开 1关
     */
    USER_DELIVER_STATUS_ON(0,"开"),

    USER_DELIVER_STATUS_OFF(1,"关"),
    /**
     * 用户等级：1-新手； （具体状态需求还未给出）
     */
    USER_LEVEL_1(1,"新手"),
    /**
     * 传递员审核状态：0-未提交资料； 1-审核中；2-审核通过；3-审核未通过）（具体状态需求待定）
     */
    USER_DELIVER_AUTH_STATUS_0(0,"未提交资料"),

    USER_DELIVER_AUTH_STATUS_1(1,"审核中"),

    USER_DELIVER_AUTH_STATUS_2(2,"审核通过"),

    USER_DELIVER_AUTH_STATUS_3(3,"审核未通过"),

    /**
     * 考试状态(0-未通过考核；1已通过考核)
     */
    USER_EXAMINE_PASS_0(0,"未通过考核"),

    USER_EXAMINE_PASS_1(1,"通过考核"),

    /**
     * 是否删除了。0未删除、1已删除
     */
    IS_DELETE_0(0,"未删除"),

    IS_DELETE_1(1,"已删除"),

    /**
     * 是否应该转第三方物流
     */
    order_is_third_express_0(0,"否"),
    order_is_third_express_1(1,"是"),

    /**
     * 版本号
     */
    USER_VERSION(2,"版本号"),
    /**
     * 手机验证码发送类型(0:注册验证码,1:找回密码验证码)
     */
    PHONE_CODE_0(0,"注册验证码"),

    PHONE_CODE_1(1,"找回密码验证码"),
    /**
     * 登录记录类型
     */
    LOGIN_TYPE_0(0,"登录"),
    LOGIN_TYPE_1(1,"退出"),
    /**
     * 订单类型
     */
    ORDER_STATUS_1(1,"下单"),
    ORDER_STATUS_2(2,"确定"),
    ORDER_STATUS_3(3,"取件"),
    ORDER_STATUS_4(4,"封包"),
    ORDER_STATUS_5(5,"传送"),
    ORDER_STATUS_6(6,"验收"),
    ORDER_STATUS_7(7,"派送"),
    ORDER_STATUS_8(8,"送达"),
    ORDER_STATUS_9(9,"已评价"),
    ORDER_STATUS_10(10,"正常取消"),
    ORDER_STATUS_11(11,"非正常取消"),
    ORDER_STATUS_12(12,"拒收"),
    ORDER_STATUS_13(13,"丢失"),
    ORDER_STATUS_14(14,"破损"),
    ORDER_STATUS_15(15,"发布"),
    /**
     * 传送前用户类型
     */
    delivery_node_before_role_0(0,"发件用户"),
    delivery_node_before_role_1(1,"传送员"),
    delivery_node_before_role_2(2,"网点雇员"),

    /**
     * 传送后用户类型
     */
    delivery_node_after_role_0(0,"传送员"),
    delivery_node_after_role_1(1,"网点雇员"),
    delivery_node_after_role_2(2,"接收用户"),
    /**
     * 包裹状态
     */
    package_status_1(1,"发布"),
    package_status_2(2,"确认接包"),
    package_status_3(3,"取包"),
    package_status_4(4,"传送"),
    package_status_5(5,"验收"),
    package_status_6(6,"异常"),
    package_status_7(7,"封包"),
    /**
     * 异常订单处理状态
     */
    excep_handle_status_1(1,"处理中"),
    excep_handle_status_2(2,"已处理"),
    excep_handle_status_3(3,"已完结"),

    /**
     * 异常订单异常发送环节
     */
    excep_node_1(1,"取件"),
    excep_node_2(2,"发出网点"),
    excep_node_3(3,"传送"),
    excep_node_4(4,"接收网点"),
    excep_node_5(5,"派件"),

    /**
     * 异常订单类型
     */
    excep_type_1(1,"取件拒收"),
    excep_type_2(2,"用户无偿取消"),
    excep_type_3(3,"取件超时"),
    excep_type_4(4,"发送超时"),
    excep_type_5(5,"丢失"),
    excep_type_6(6,"破损"),
    excep_type_7(7,"传送员传送超时"),
    excep_type_8(8,"派件超时"),
    excep_type_9(9,"用户有偿取消"),
    excep_type_10(10,"蛋糕鲜花超时"),

    /**
     * 记录人类型
     */
    excep_recorder_type_1(1,"网点员工"),
    excep_recorder_type_2(2,"系统记录"),

    /**
     * 行程状态
     */
    carry_status_0(0,"已开始"),
    carry_status_1(1,"行程中"),
    carry_status_2(2,"已结束"),

    /**
     * 回报状态（具体状态需求还未给出）
     */
    carry_reward_status_0(0,"未产生"),
    carry_reward_status_1(1,"已产生，但未到账"),
    carry_reward_status_2(2,"已到账"),

    /**
     * 追加原因
     */
    addtion_reason_1(1,"超过距离"),
    addtion_reason_2(2,"超重"),
    addtion_reason_3(3,"尺寸"),

    /**
     * 责任承担人1-发货人； 2-收货网点； 3-传送人； 4-发货网点； 5-收货人； 6-平台
     */
    handle_respon_1(1,"发货人"),
    handle_respon_2(2,"收货网点"),
    handle_respon_3(3,"传送人"),
    handle_respon_4(4,"发货网点"),
    handle_respon_5(5,"收货人"),
    handle_respon_6(6,"平台"),
    /**
     * 用户资金账户冻结
     */
    account_is_frozen_0(0,"否"),
    account_is_frozen_1(1,"是"),

    /**
     * 是否已读
     */
    message_is_read_0(0,"未读"),
    message_is_read_1(1,"已读"),

    /**
     * 消息类型
     */
    message_type_1(1,"一般消息"),
    message_type_2(2,"推送消息"),
    message_type_3(3,"取件超时"),
    message_type_4(4,"发件超时"),


    /**
     * 拒收原因
     */
    excep_rejection_reason_1(1,"违禁物品"),
    excep_rejection_reason_2(2,"重量体积与实际不符"),
    excep_rejection_reason_3(3,"非本平台可接收快件"),
    excep_rejection_reason_4(4,"寄送地址无法送达"),
    excep_rejection_reason_5(5,"其他原因"),

    /**
     * 评分
     */
    ocomment_score_1(1,"1"),
    ocomment_score_2(2,"2"),
    ocomment_score_3(3,"3"),
    ocomment_score_4(4,"4"),
    ocomment_score_5(5,"5"),

    /**
     * 服务态度
     */
    ocomment_service_0(0,"不好"),
    ocomment_service_1(1,"好"),

    /**
     * 服务态度
     */
    ocomment_speed_0(0,"慢"),
    ocomment_speed_1(1,"快"),

    /**
     * 费用
     */
    ocomment_price_0(0,"一般"),
    ocomment_price_1(0,"便宜"),

    /**
     * 状态1停止 2开启3 离职
     */
    staff_status_1(1,"停止"),
    staff_status_2(2,"开启"),
    staff_status_3(2,"离职"),

    /**
     * 网点状态
     */
    affiliate_status_1(1,"正常"),
    affiliate_status_2(2,"暂停"),
    affiliate_status_3(2,"终止"),

    /**
     * 是否负责人：0 不是1是
     */
    staff_is_contractor_0(0,"不是"),
    staff_is_contractor_1(1,"是"),

    /**
     * 申请状态：1审核中2通过3拒绝
     */
    apply_status_1(1,"审核中"),
    apply_status_2(2,"通过"),
    apply_status_3(3,"通过"),

    /**
     * 网点级别
     */
    affiliate_type_0(0,"省级"),
    affiliate_type_1(1,"市级"),
    affiliate_type_2(2,"区级/县"),
    affiliate_type_3(3,"镇级/街道"),


    payment_way_10(10,"微信支付"),
    payment_way_20(20,"支付宝支付"),
    payment_way_30(30,"余额支付"),
    payment_way_40(40,"优惠券支付"),

    /**
     * 交易类型。1订单支出、2充值、3退款、4赔付5传送收益6扣手续费退款7提现
     */
    balance_tansaction_type_1(1,"订单支出"),
    balance_tansaction_type_2(2,"充值"),
    balance_tansaction_type_3(3,"退款"),
    balance_tansaction_type_4(4,"赔付"),
    balance_tansaction_type_5(5,"传送收益"),
    balance_tansaction_type_6(6,"扣手续费退款"),
    balance_tansaction_type_7(7,"提现"),
    balance_tansaction_type_8(8,"返款"),

    balance_operation_type_0(0,"收入"),
    balance_operation_type_1(1,"支出"),

    /**
     * 处理类型：0无1无偿退款2有偿退款3赔偿
     */
    handle_type_0(0,"无"),
    handle_type_1(1,"无偿退款"),
    handle_type_2(2,"有偿退款"),
    handle_type_3(3,"赔偿"),

    /**
     * 消息类型1系统消息,2新订单消息3取件超时4发件超时
     */
    staff_message_type_1(1,"系统消息"),
    staff_message_type_2(2,"新订单消息"),
    staff_message_type_3(3,"取件超时"),
    staff_message_type_4(4,"发件超时"),

    /**
     * 消息类型  0-发单消息； 1-推荐消息； 2-系统消息 3-退款成功 4-成为传送天使
     */
    umessage_type_0(0,"发单消息"),
    umessage_type_1(1,"推荐消息"),
    umessage_type_2(2,"系统消息"),
    umessage_type_3(3,"退款成功"),
    umessage_type_4(4,"成为传送天使"),

    /**
     * 订单支付状态
     */
    order_pay_status_0(0,"未支付"),
    order_pay_status_1(1,"部分支付"),
    order_pay_status_2(2,"已支付"),

    /**
     * 处理结果：0未通过1通过
     */
    handle_result_0(0,"未通过"),
    handle_result_1(1,"通过"),
    handle_result_2(2,"未处理"),

    /**
     * 责任目标对象1-发货人； 2-收货网点； 3-传送人； 4-发货网点； 5-收货人； 6-平台
     */
    handle_obj_1(1,"发货人"),
    handle_obj_2(3,"收货网点"),
    handle_obj_3(3,"传送人"),
    handle_obj_4(4,"发货网点"),
    handle_obj_5(5,"收货人"),
    handle_obj_6(6,"平台"),

    /**
     * 提现状态：0申请提现，1办理中，2提现成功, 3拒绝提现
     */
    withdrawl_status_0(0,"申请提现"),
    withdrawl_status_1(1,"办理中"),
    withdrawl_status_2(2,"提现成功"),
    withdrawl_status_3(3,"拒绝提现"),

    /**
     * 是否追加金额：0不是；1是
     */
    payment_is_addition_0(0,"不是"),
    payment_is_addition_1(1,"是"),

    /**
     * 类型(1订单支付 2充值 3提现)
     */
    payment_type_1(1,"订单支付"),
    payment_type_2(2,"充值"),
    payment_type_3(3,"提现"),


    /**
     * 物品类型   1: 文件； 2: 办公／居家； 3: 鲜花； 4: 包裹； 5: 蛋糕。
     */
    order_goods_type_1(1,"文件"),
    order_goods_type_2(2,"办公／居家"),
    order_goods_type_3(3,"鲜花"),
    order_goods_type_4(4,"包裹"),
    order_goods_type_5(5,"蛋糕"),

    /**
     * 状态：10=未完成，20=失败，30=成功，40=超时,50=进行中
     */
    payment_status_10(10,"未完成"),
    payment_status_20(20,"失败"),
    payment_status_30(30,"成功"),
    payment_status_40(40,"超时"),
    payment_status_50(50,"进行中"),

    qb_tansaction_type_1(1,"快件收入"),
    qb_tansaction_type_2(2,"网点缴纳"),
    qb_tansaction_type_3(3,"赔付"),
    qb_tansaction_type_5(5,"返款"),

    qb_operation_type_0(0,"收入"),
    qb_operation_type_1(1,"支出"),

    /**
     * 是否返了： 0否 1 是
     */
    brefund_is_completed_0(0,"否"),
    brefund_is_completed_1(1,"是");

    private int code;
    private String value;

    TypeEnum(int code , String value) {
        this.value = value;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
