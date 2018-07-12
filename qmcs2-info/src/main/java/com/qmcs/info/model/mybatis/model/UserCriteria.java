package com.qmcs.info.model.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class UserCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public UserCriteria() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdIsNull() {
            addCriterion("user_open_id is null");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdIsNotNull() {
            addCriterion("user_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdEqualTo(String value) {
            addCriterion("user_open_id =", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdNotEqualTo(String value) {
            addCriterion("user_open_id <>", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdGreaterThan(String value) {
            addCriterion("user_open_id >", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_open_id >=", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdLessThan(String value) {
            addCriterion("user_open_id <", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdLessThanOrEqualTo(String value) {
            addCriterion("user_open_id <=", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdLike(String value) {
            addCriterion("user_open_id like", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdNotLike(String value) {
            addCriterion("user_open_id not like", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdIn(List<String> values) {
            addCriterion("user_open_id in", values, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdNotIn(List<String> values) {
            addCriterion("user_open_id not in", values, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdBetween(String value1, String value2) {
            addCriterion("user_open_id between", value1, value2, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdNotBetween(String value1, String value2) {
            addCriterion("user_open_id not between", value1, value2, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserTelphoneIsNull() {
            addCriterion("user_telphone is null");
            return (Criteria) this;
        }

        public Criteria andUserTelphoneIsNotNull() {
            addCriterion("user_telphone is not null");
            return (Criteria) this;
        }

        public Criteria andUserTelphoneEqualTo(String value) {
            addCriterion("user_telphone =", value, "userTelphone");
            return (Criteria) this;
        }

        public Criteria andUserTelphoneNotEqualTo(String value) {
            addCriterion("user_telphone <>", value, "userTelphone");
            return (Criteria) this;
        }

        public Criteria andUserTelphoneGreaterThan(String value) {
            addCriterion("user_telphone >", value, "userTelphone");
            return (Criteria) this;
        }

        public Criteria andUserTelphoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_telphone >=", value, "userTelphone");
            return (Criteria) this;
        }

        public Criteria andUserTelphoneLessThan(String value) {
            addCriterion("user_telphone <", value, "userTelphone");
            return (Criteria) this;
        }

        public Criteria andUserTelphoneLessThanOrEqualTo(String value) {
            addCriterion("user_telphone <=", value, "userTelphone");
            return (Criteria) this;
        }

        public Criteria andUserTelphoneLike(String value) {
            addCriterion("user_telphone like", value, "userTelphone");
            return (Criteria) this;
        }

        public Criteria andUserTelphoneNotLike(String value) {
            addCriterion("user_telphone not like", value, "userTelphone");
            return (Criteria) this;
        }

        public Criteria andUserTelphoneIn(List<String> values) {
            addCriterion("user_telphone in", values, "userTelphone");
            return (Criteria) this;
        }

        public Criteria andUserTelphoneNotIn(List<String> values) {
            addCriterion("user_telphone not in", values, "userTelphone");
            return (Criteria) this;
        }

        public Criteria andUserTelphoneBetween(String value1, String value2) {
            addCriterion("user_telphone between", value1, value2, "userTelphone");
            return (Criteria) this;
        }

        public Criteria andUserTelphoneNotBetween(String value1, String value2) {
            addCriterion("user_telphone not between", value1, value2, "userTelphone");
            return (Criteria) this;
        }

        public Criteria andUserCarCodeIsNull() {
            addCriterion("user_car_code is null");
            return (Criteria) this;
        }

        public Criteria andUserCarCodeIsNotNull() {
            addCriterion("user_car_code is not null");
            return (Criteria) this;
        }

        public Criteria andUserCarCodeEqualTo(String value) {
            addCriterion("user_car_code =", value, "userCarCode");
            return (Criteria) this;
        }

        public Criteria andUserCarCodeNotEqualTo(String value) {
            addCriterion("user_car_code <>", value, "userCarCode");
            return (Criteria) this;
        }

        public Criteria andUserCarCodeGreaterThan(String value) {
            addCriterion("user_car_code >", value, "userCarCode");
            return (Criteria) this;
        }

        public Criteria andUserCarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("user_car_code >=", value, "userCarCode");
            return (Criteria) this;
        }

        public Criteria andUserCarCodeLessThan(String value) {
            addCriterion("user_car_code <", value, "userCarCode");
            return (Criteria) this;
        }

        public Criteria andUserCarCodeLessThanOrEqualTo(String value) {
            addCriterion("user_car_code <=", value, "userCarCode");
            return (Criteria) this;
        }

        public Criteria andUserCarCodeLike(String value) {
            addCriterion("user_car_code like", value, "userCarCode");
            return (Criteria) this;
        }

        public Criteria andUserCarCodeNotLike(String value) {
            addCriterion("user_car_code not like", value, "userCarCode");
            return (Criteria) this;
        }

        public Criteria andUserCarCodeIn(List<String> values) {
            addCriterion("user_car_code in", values, "userCarCode");
            return (Criteria) this;
        }

        public Criteria andUserCarCodeNotIn(List<String> values) {
            addCriterion("user_car_code not in", values, "userCarCode");
            return (Criteria) this;
        }

        public Criteria andUserCarCodeBetween(String value1, String value2) {
            addCriterion("user_car_code between", value1, value2, "userCarCode");
            return (Criteria) this;
        }

        public Criteria andUserCarCodeNotBetween(String value1, String value2) {
            addCriterion("user_car_code not between", value1, value2, "userCarCode");
            return (Criteria) this;
        }

        public Criteria andUserQrCodeIsNull() {
            addCriterion("user_qr_code is null");
            return (Criteria) this;
        }

        public Criteria andUserQrCodeIsNotNull() {
            addCriterion("user_qr_code is not null");
            return (Criteria) this;
        }

        public Criteria andUserQrCodeEqualTo(String value) {
            addCriterion("user_qr_code =", value, "userQrCode");
            return (Criteria) this;
        }

        public Criteria andUserQrCodeNotEqualTo(String value) {
            addCriterion("user_qr_code <>", value, "userQrCode");
            return (Criteria) this;
        }

        public Criteria andUserQrCodeGreaterThan(String value) {
            addCriterion("user_qr_code >", value, "userQrCode");
            return (Criteria) this;
        }

        public Criteria andUserQrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("user_qr_code >=", value, "userQrCode");
            return (Criteria) this;
        }

        public Criteria andUserQrCodeLessThan(String value) {
            addCriterion("user_qr_code <", value, "userQrCode");
            return (Criteria) this;
        }

        public Criteria andUserQrCodeLessThanOrEqualTo(String value) {
            addCriterion("user_qr_code <=", value, "userQrCode");
            return (Criteria) this;
        }

        public Criteria andUserQrCodeLike(String value) {
            addCriterion("user_qr_code like", value, "userQrCode");
            return (Criteria) this;
        }

        public Criteria andUserQrCodeNotLike(String value) {
            addCriterion("user_qr_code not like", value, "userQrCode");
            return (Criteria) this;
        }

        public Criteria andUserQrCodeIn(List<String> values) {
            addCriterion("user_qr_code in", values, "userQrCode");
            return (Criteria) this;
        }

        public Criteria andUserQrCodeNotIn(List<String> values) {
            addCriterion("user_qr_code not in", values, "userQrCode");
            return (Criteria) this;
        }

        public Criteria andUserQrCodeBetween(String value1, String value2) {
            addCriterion("user_qr_code between", value1, value2, "userQrCode");
            return (Criteria) this;
        }

        public Criteria andUserQrCodeNotBetween(String value1, String value2) {
            addCriterion("user_qr_code not between", value1, value2, "userQrCode");
            return (Criteria) this;
        }

        public Criteria andUserIsDeleteIsNull() {
            addCriterion("user_is_delete is null");
            return (Criteria) this;
        }

        public Criteria andUserIsDeleteIsNotNull() {
            addCriterion("user_is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andUserIsDeleteEqualTo(Boolean value) {
            addCriterion("user_is_delete =", value, "userIsDelete");
            return (Criteria) this;
        }

        public Criteria andUserIsDeleteNotEqualTo(Boolean value) {
            addCriterion("user_is_delete <>", value, "userIsDelete");
            return (Criteria) this;
        }

        public Criteria andUserIsDeleteGreaterThan(Boolean value) {
            addCriterion("user_is_delete >", value, "userIsDelete");
            return (Criteria) this;
        }

        public Criteria andUserIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("user_is_delete >=", value, "userIsDelete");
            return (Criteria) this;
        }

        public Criteria andUserIsDeleteLessThan(Boolean value) {
            addCriterion("user_is_delete <", value, "userIsDelete");
            return (Criteria) this;
        }

        public Criteria andUserIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("user_is_delete <=", value, "userIsDelete");
            return (Criteria) this;
        }

        public Criteria andUserIsDeleteIn(List<Boolean> values) {
            addCriterion("user_is_delete in", values, "userIsDelete");
            return (Criteria) this;
        }

        public Criteria andUserIsDeleteNotIn(List<Boolean> values) {
            addCriterion("user_is_delete not in", values, "userIsDelete");
            return (Criteria) this;
        }

        public Criteria andUserIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("user_is_delete between", value1, value2, "userIsDelete");
            return (Criteria) this;
        }

        public Criteria andUserIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("user_is_delete not between", value1, value2, "userIsDelete");
            return (Criteria) this;
        }

        public Criteria andUserRamarkIsNull() {
            addCriterion("user_ramark is null");
            return (Criteria) this;
        }

        public Criteria andUserRamarkIsNotNull() {
            addCriterion("user_ramark is not null");
            return (Criteria) this;
        }

        public Criteria andUserRamarkEqualTo(String value) {
            addCriterion("user_ramark =", value, "userRamark");
            return (Criteria) this;
        }

        public Criteria andUserRamarkNotEqualTo(String value) {
            addCriterion("user_ramark <>", value, "userRamark");
            return (Criteria) this;
        }

        public Criteria andUserRamarkGreaterThan(String value) {
            addCriterion("user_ramark >", value, "userRamark");
            return (Criteria) this;
        }

        public Criteria andUserRamarkGreaterThanOrEqualTo(String value) {
            addCriterion("user_ramark >=", value, "userRamark");
            return (Criteria) this;
        }

        public Criteria andUserRamarkLessThan(String value) {
            addCriterion("user_ramark <", value, "userRamark");
            return (Criteria) this;
        }

        public Criteria andUserRamarkLessThanOrEqualTo(String value) {
            addCriterion("user_ramark <=", value, "userRamark");
            return (Criteria) this;
        }

        public Criteria andUserRamarkLike(String value) {
            addCriterion("user_ramark like", value, "userRamark");
            return (Criteria) this;
        }

        public Criteria andUserRamarkNotLike(String value) {
            addCriterion("user_ramark not like", value, "userRamark");
            return (Criteria) this;
        }

        public Criteria andUserRamarkIn(List<String> values) {
            addCriterion("user_ramark in", values, "userRamark");
            return (Criteria) this;
        }

        public Criteria andUserRamarkNotIn(List<String> values) {
            addCriterion("user_ramark not in", values, "userRamark");
            return (Criteria) this;
        }

        public Criteria andUserRamarkBetween(String value1, String value2) {
            addCriterion("user_ramark between", value1, value2, "userRamark");
            return (Criteria) this;
        }

        public Criteria andUserRamarkNotBetween(String value1, String value2) {
            addCriterion("user_ramark not between", value1, value2, "userRamark");
            return (Criteria) this;
        }

        public Criteria andUserWxNameIsNull() {
            addCriterion("user_wx_name is null");
            return (Criteria) this;
        }

        public Criteria andUserWxNameIsNotNull() {
            addCriterion("user_wx_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserWxNameEqualTo(String value) {
            addCriterion("user_wx_name =", value, "userWxName");
            return (Criteria) this;
        }

        public Criteria andUserWxNameNotEqualTo(String value) {
            addCriterion("user_wx_name <>", value, "userWxName");
            return (Criteria) this;
        }

        public Criteria andUserWxNameGreaterThan(String value) {
            addCriterion("user_wx_name >", value, "userWxName");
            return (Criteria) this;
        }

        public Criteria andUserWxNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_wx_name >=", value, "userWxName");
            return (Criteria) this;
        }

        public Criteria andUserWxNameLessThan(String value) {
            addCriterion("user_wx_name <", value, "userWxName");
            return (Criteria) this;
        }

        public Criteria andUserWxNameLessThanOrEqualTo(String value) {
            addCriterion("user_wx_name <=", value, "userWxName");
            return (Criteria) this;
        }

        public Criteria andUserWxNameLike(String value) {
            addCriterion("user_wx_name like", value, "userWxName");
            return (Criteria) this;
        }

        public Criteria andUserWxNameNotLike(String value) {
            addCriterion("user_wx_name not like", value, "userWxName");
            return (Criteria) this;
        }

        public Criteria andUserWxNameIn(List<String> values) {
            addCriterion("user_wx_name in", values, "userWxName");
            return (Criteria) this;
        }

        public Criteria andUserWxNameNotIn(List<String> values) {
            addCriterion("user_wx_name not in", values, "userWxName");
            return (Criteria) this;
        }

        public Criteria andUserWxNameBetween(String value1, String value2) {
            addCriterion("user_wx_name between", value1, value2, "userWxName");
            return (Criteria) this;
        }

        public Criteria andUserWxNameNotBetween(String value1, String value2) {
            addCriterion("user_wx_name not between", value1, value2, "userWxName");
            return (Criteria) this;
        }

        public Criteria andUserWxImgIsNull() {
            addCriterion("user_wx_img is null");
            return (Criteria) this;
        }

        public Criteria andUserWxImgIsNotNull() {
            addCriterion("user_wx_img is not null");
            return (Criteria) this;
        }

        public Criteria andUserWxImgEqualTo(String value) {
            addCriterion("user_wx_img =", value, "userWxImg");
            return (Criteria) this;
        }

        public Criteria andUserWxImgNotEqualTo(String value) {
            addCriterion("user_wx_img <>", value, "userWxImg");
            return (Criteria) this;
        }

        public Criteria andUserWxImgGreaterThan(String value) {
            addCriterion("user_wx_img >", value, "userWxImg");
            return (Criteria) this;
        }

        public Criteria andUserWxImgGreaterThanOrEqualTo(String value) {
            addCriterion("user_wx_img >=", value, "userWxImg");
            return (Criteria) this;
        }

        public Criteria andUserWxImgLessThan(String value) {
            addCriterion("user_wx_img <", value, "userWxImg");
            return (Criteria) this;
        }

        public Criteria andUserWxImgLessThanOrEqualTo(String value) {
            addCriterion("user_wx_img <=", value, "userWxImg");
            return (Criteria) this;
        }

        public Criteria andUserWxImgLike(String value) {
            addCriterion("user_wx_img like", value, "userWxImg");
            return (Criteria) this;
        }

        public Criteria andUserWxImgNotLike(String value) {
            addCriterion("user_wx_img not like", value, "userWxImg");
            return (Criteria) this;
        }

        public Criteria andUserWxImgIn(List<String> values) {
            addCriterion("user_wx_img in", values, "userWxImg");
            return (Criteria) this;
        }

        public Criteria andUserWxImgNotIn(List<String> values) {
            addCriterion("user_wx_img not in", values, "userWxImg");
            return (Criteria) this;
        }

        public Criteria andUserWxImgBetween(String value1, String value2) {
            addCriterion("user_wx_img between", value1, value2, "userWxImg");
            return (Criteria) this;
        }

        public Criteria andUserWxImgNotBetween(String value1, String value2) {
            addCriterion("user_wx_img not between", value1, value2, "userWxImg");
            return (Criteria) this;
        }

        public Criteria andUserIsBindIsNull() {
            addCriterion("user_is_bind is null");
            return (Criteria) this;
        }

        public Criteria andUserIsBindIsNotNull() {
            addCriterion("user_is_bind is not null");
            return (Criteria) this;
        }

        public Criteria andUserIsBindEqualTo(Integer value) {
            addCriterion("user_is_bind =", value, "userIsBind");
            return (Criteria) this;
        }

        public Criteria andUserIsBindNotEqualTo(Integer value) {
            addCriterion("user_is_bind <>", value, "userIsBind");
            return (Criteria) this;
        }

        public Criteria andUserIsBindGreaterThan(Integer value) {
            addCriterion("user_is_bind >", value, "userIsBind");
            return (Criteria) this;
        }

        public Criteria andUserIsBindGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_is_bind >=", value, "userIsBind");
            return (Criteria) this;
        }

        public Criteria andUserIsBindLessThan(Integer value) {
            addCriterion("user_is_bind <", value, "userIsBind");
            return (Criteria) this;
        }

        public Criteria andUserIsBindLessThanOrEqualTo(Integer value) {
            addCriterion("user_is_bind <=", value, "userIsBind");
            return (Criteria) this;
        }

        public Criteria andUserIsBindIn(List<Integer> values) {
            addCriterion("user_is_bind in", values, "userIsBind");
            return (Criteria) this;
        }

        public Criteria andUserIsBindNotIn(List<Integer> values) {
            addCriterion("user_is_bind not in", values, "userIsBind");
            return (Criteria) this;
        }

        public Criteria andUserIsBindBetween(Integer value1, Integer value2) {
            addCriterion("user_is_bind between", value1, value2, "userIsBind");
            return (Criteria) this;
        }

        public Criteria andUserIsBindNotBetween(Integer value1, Integer value2) {
            addCriterion("user_is_bind not between", value1, value2, "userIsBind");
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