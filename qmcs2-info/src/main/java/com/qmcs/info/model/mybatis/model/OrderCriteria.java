package com.qmcs.info.model.mybatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrderCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdIsNull() {
            addCriterion("order_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdIsNotNull() {
            addCriterion("order_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdEqualTo(Long value) {
            addCriterion("order_user_id =", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdNotEqualTo(Long value) {
            addCriterion("order_user_id <>", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdGreaterThan(Long value) {
            addCriterion("order_user_id >", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_user_id >=", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdLessThan(Long value) {
            addCriterion("order_user_id <", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdLessThanOrEqualTo(Long value) {
            addCriterion("order_user_id <=", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdIn(List<Long> values) {
            addCriterion("order_user_id in", values, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdNotIn(List<Long> values) {
            addCriterion("order_user_id not in", values, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdBetween(Long value1, Long value2) {
            addCriterion("order_user_id between", value1, value2, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdNotBetween(Long value1, Long value2) {
            addCriterion("order_user_id not between", value1, value2, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderOpenIdIsNull() {
            addCriterion("order_open_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderOpenIdIsNotNull() {
            addCriterion("order_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderOpenIdEqualTo(String value) {
            addCriterion("order_open_id =", value, "orderOpenId");
            return (Criteria) this;
        }

        public Criteria andOrderOpenIdNotEqualTo(String value) {
            addCriterion("order_open_id <>", value, "orderOpenId");
            return (Criteria) this;
        }

        public Criteria andOrderOpenIdGreaterThan(String value) {
            addCriterion("order_open_id >", value, "orderOpenId");
            return (Criteria) this;
        }

        public Criteria andOrderOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_open_id >=", value, "orderOpenId");
            return (Criteria) this;
        }

        public Criteria andOrderOpenIdLessThan(String value) {
            addCriterion("order_open_id <", value, "orderOpenId");
            return (Criteria) this;
        }

        public Criteria andOrderOpenIdLessThanOrEqualTo(String value) {
            addCriterion("order_open_id <=", value, "orderOpenId");
            return (Criteria) this;
        }

        public Criteria andOrderOpenIdLike(String value) {
            addCriterion("order_open_id like", value, "orderOpenId");
            return (Criteria) this;
        }

        public Criteria andOrderOpenIdNotLike(String value) {
            addCriterion("order_open_id not like", value, "orderOpenId");
            return (Criteria) this;
        }

        public Criteria andOrderOpenIdIn(List<String> values) {
            addCriterion("order_open_id in", values, "orderOpenId");
            return (Criteria) this;
        }

        public Criteria andOrderOpenIdNotIn(List<String> values) {
            addCriterion("order_open_id not in", values, "orderOpenId");
            return (Criteria) this;
        }

        public Criteria andOrderOpenIdBetween(String value1, String value2) {
            addCriterion("order_open_id between", value1, value2, "orderOpenId");
            return (Criteria) this;
        }

        public Criteria andOrderOpenIdNotBetween(String value1, String value2) {
            addCriterion("order_open_id not between", value1, value2, "orderOpenId");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(Integer value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(Integer value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(Integer value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(Integer value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(Integer value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<Integer> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<Integer> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(Integer value1, Integer value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Integer> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Integer> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsPriceIsNull() {
            addCriterion("order_goods_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsPriceIsNotNull() {
            addCriterion("order_goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsPriceEqualTo(BigDecimal value) {
            addCriterion("order_goods_price =", value, "orderGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsPriceNotEqualTo(BigDecimal value) {
            addCriterion("order_goods_price <>", value, "orderGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsPriceGreaterThan(BigDecimal value) {
            addCriterion("order_goods_price >", value, "orderGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_goods_price >=", value, "orderGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsPriceLessThan(BigDecimal value) {
            addCriterion("order_goods_price <", value, "orderGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_goods_price <=", value, "orderGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsPriceIn(List<BigDecimal> values) {
            addCriterion("order_goods_price in", values, "orderGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsPriceNotIn(List<BigDecimal> values) {
            addCriterion("order_goods_price not in", values, "orderGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_goods_price between", value1, value2, "orderGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_goods_price not between", value1, value2, "orderGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceIsNull() {
            addCriterion("order_total_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceIsNotNull() {
            addCriterion("order_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceEqualTo(BigDecimal value) {
            addCriterion("order_total_price =", value, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("order_total_price <>", value, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("order_total_price >", value, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_total_price >=", value, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceLessThan(BigDecimal value) {
            addCriterion("order_total_price <", value, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_total_price <=", value, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceIn(List<BigDecimal> values) {
            addCriterion("order_total_price in", values, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("order_total_price not in", values, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_total_price between", value1, value2, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_total_price not between", value1, value2, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPostPriceIsNull() {
            addCriterion("order_post_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderPostPriceIsNotNull() {
            addCriterion("order_post_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPostPriceEqualTo(BigDecimal value) {
            addCriterion("order_post_price =", value, "orderPostPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPostPriceNotEqualTo(BigDecimal value) {
            addCriterion("order_post_price <>", value, "orderPostPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPostPriceGreaterThan(BigDecimal value) {
            addCriterion("order_post_price >", value, "orderPostPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPostPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_post_price >=", value, "orderPostPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPostPriceLessThan(BigDecimal value) {
            addCriterion("order_post_price <", value, "orderPostPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPostPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_post_price <=", value, "orderPostPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPostPriceIn(List<BigDecimal> values) {
            addCriterion("order_post_price in", values, "orderPostPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPostPriceNotIn(List<BigDecimal> values) {
            addCriterion("order_post_price not in", values, "orderPostPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPostPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_post_price between", value1, value2, "orderPostPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPostPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_post_price not between", value1, value2, "orderPostPrice");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameIsNull() {
            addCriterion("order_user_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameIsNotNull() {
            addCriterion("order_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameEqualTo(String value) {
            addCriterion("order_user_name =", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameNotEqualTo(String value) {
            addCriterion("order_user_name <>", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameGreaterThan(String value) {
            addCriterion("order_user_name >", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_user_name >=", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameLessThan(String value) {
            addCriterion("order_user_name <", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameLessThanOrEqualTo(String value) {
            addCriterion("order_user_name <=", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameLike(String value) {
            addCriterion("order_user_name like", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameNotLike(String value) {
            addCriterion("order_user_name not like", value, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameIn(List<String> values) {
            addCriterion("order_user_name in", values, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameNotIn(List<String> values) {
            addCriterion("order_user_name not in", values, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameBetween(String value1, String value2) {
            addCriterion("order_user_name between", value1, value2, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserNameNotBetween(String value1, String value2) {
            addCriterion("order_user_name not between", value1, value2, "orderUserName");
            return (Criteria) this;
        }

        public Criteria andOrderUserTelphoneIsNull() {
            addCriterion("order_user_telphone is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserTelphoneIsNotNull() {
            addCriterion("order_user_telphone is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserTelphoneEqualTo(String value) {
            addCriterion("order_user_telphone =", value, "orderUserTelphone");
            return (Criteria) this;
        }

        public Criteria andOrderUserTelphoneNotEqualTo(String value) {
            addCriterion("order_user_telphone <>", value, "orderUserTelphone");
            return (Criteria) this;
        }

        public Criteria andOrderUserTelphoneGreaterThan(String value) {
            addCriterion("order_user_telphone >", value, "orderUserTelphone");
            return (Criteria) this;
        }

        public Criteria andOrderUserTelphoneGreaterThanOrEqualTo(String value) {
            addCriterion("order_user_telphone >=", value, "orderUserTelphone");
            return (Criteria) this;
        }

        public Criteria andOrderUserTelphoneLessThan(String value) {
            addCriterion("order_user_telphone <", value, "orderUserTelphone");
            return (Criteria) this;
        }

        public Criteria andOrderUserTelphoneLessThanOrEqualTo(String value) {
            addCriterion("order_user_telphone <=", value, "orderUserTelphone");
            return (Criteria) this;
        }

        public Criteria andOrderUserTelphoneLike(String value) {
            addCriterion("order_user_telphone like", value, "orderUserTelphone");
            return (Criteria) this;
        }

        public Criteria andOrderUserTelphoneNotLike(String value) {
            addCriterion("order_user_telphone not like", value, "orderUserTelphone");
            return (Criteria) this;
        }

        public Criteria andOrderUserTelphoneIn(List<String> values) {
            addCriterion("order_user_telphone in", values, "orderUserTelphone");
            return (Criteria) this;
        }

        public Criteria andOrderUserTelphoneNotIn(List<String> values) {
            addCriterion("order_user_telphone not in", values, "orderUserTelphone");
            return (Criteria) this;
        }

        public Criteria andOrderUserTelphoneBetween(String value1, String value2) {
            addCriterion("order_user_telphone between", value1, value2, "orderUserTelphone");
            return (Criteria) this;
        }

        public Criteria andOrderUserTelphoneNotBetween(String value1, String value2) {
            addCriterion("order_user_telphone not between", value1, value2, "orderUserTelphone");
            return (Criteria) this;
        }

        public Criteria andOrderAddressIsNull() {
            addCriterion("order_address is null");
            return (Criteria) this;
        }

        public Criteria andOrderAddressIsNotNull() {
            addCriterion("order_address is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAddressEqualTo(String value) {
            addCriterion("order_address =", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotEqualTo(String value) {
            addCriterion("order_address <>", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressGreaterThan(String value) {
            addCriterion("order_address >", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressGreaterThanOrEqualTo(String value) {
            addCriterion("order_address >=", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressLessThan(String value) {
            addCriterion("order_address <", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressLessThanOrEqualTo(String value) {
            addCriterion("order_address <=", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressLike(String value) {
            addCriterion("order_address like", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotLike(String value) {
            addCriterion("order_address not like", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressIn(List<String> values) {
            addCriterion("order_address in", values, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotIn(List<String> values) {
            addCriterion("order_address not in", values, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressBetween(String value1, String value2) {
            addCriterion("order_address between", value1, value2, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotBetween(String value1, String value2) {
            addCriterion("order_address not between", value1, value2, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderQmcsNoIsNull() {
            addCriterion("order_qmcs_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderQmcsNoIsNotNull() {
            addCriterion("order_qmcs_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderQmcsNoEqualTo(String value) {
            addCriterion("order_qmcs_no =", value, "orderQmcsNo");
            return (Criteria) this;
        }

        public Criteria andOrderQmcsNoNotEqualTo(String value) {
            addCriterion("order_qmcs_no <>", value, "orderQmcsNo");
            return (Criteria) this;
        }

        public Criteria andOrderQmcsNoGreaterThan(String value) {
            addCriterion("order_qmcs_no >", value, "orderQmcsNo");
            return (Criteria) this;
        }

        public Criteria andOrderQmcsNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_qmcs_no >=", value, "orderQmcsNo");
            return (Criteria) this;
        }

        public Criteria andOrderQmcsNoLessThan(String value) {
            addCriterion("order_qmcs_no <", value, "orderQmcsNo");
            return (Criteria) this;
        }

        public Criteria andOrderQmcsNoLessThanOrEqualTo(String value) {
            addCriterion("order_qmcs_no <=", value, "orderQmcsNo");
            return (Criteria) this;
        }

        public Criteria andOrderQmcsNoLike(String value) {
            addCriterion("order_qmcs_no like", value, "orderQmcsNo");
            return (Criteria) this;
        }

        public Criteria andOrderQmcsNoNotLike(String value) {
            addCriterion("order_qmcs_no not like", value, "orderQmcsNo");
            return (Criteria) this;
        }

        public Criteria andOrderQmcsNoIn(List<String> values) {
            addCriterion("order_qmcs_no in", values, "orderQmcsNo");
            return (Criteria) this;
        }

        public Criteria andOrderQmcsNoNotIn(List<String> values) {
            addCriterion("order_qmcs_no not in", values, "orderQmcsNo");
            return (Criteria) this;
        }

        public Criteria andOrderQmcsNoBetween(String value1, String value2) {
            addCriterion("order_qmcs_no between", value1, value2, "orderQmcsNo");
            return (Criteria) this;
        }

        public Criteria andOrderQmcsNoNotBetween(String value1, String value2) {
            addCriterion("order_qmcs_no not between", value1, value2, "orderQmcsNo");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIsNull() {
            addCriterion("order_remark is null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIsNotNull() {
            addCriterion("order_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkEqualTo(String value) {
            addCriterion("order_remark =", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotEqualTo(String value) {
            addCriterion("order_remark <>", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkGreaterThan(String value) {
            addCriterion("order_remark >", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("order_remark >=", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLessThan(String value) {
            addCriterion("order_remark <", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLessThanOrEqualTo(String value) {
            addCriterion("order_remark <=", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLike(String value) {
            addCriterion("order_remark like", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotLike(String value) {
            addCriterion("order_remark not like", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIn(List<String> values) {
            addCriterion("order_remark in", values, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotIn(List<String> values) {
            addCriterion("order_remark not in", values, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkBetween(String value1, String value2) {
            addCriterion("order_remark between", value1, value2, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotBetween(String value1, String value2) {
            addCriterion("order_remark not between", value1, value2, "orderRemark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}