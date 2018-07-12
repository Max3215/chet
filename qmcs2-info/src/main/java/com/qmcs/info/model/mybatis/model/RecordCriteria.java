package com.qmcs.info.model.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class RecordCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public RecordCriteria() {
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

        public Criteria andRecordIdIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(Long value) {
            addCriterion("record_id =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(Long value) {
            addCriterion("record_id <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(Long value) {
            addCriterion("record_id >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("record_id >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(Long value) {
            addCriterion("record_id <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("record_id <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<Long> values) {
            addCriterion("record_id in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<Long> values) {
            addCriterion("record_id not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(Long value1, Long value2) {
            addCriterion("record_id between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("record_id not between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordUserIdIsNull() {
            addCriterion("record_user_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordUserIdIsNotNull() {
            addCriterion("record_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordUserIdEqualTo(Long value) {
            addCriterion("record_user_id =", value, "recordUserId");
            return (Criteria) this;
        }

        public Criteria andRecordUserIdNotEqualTo(Long value) {
            addCriterion("record_user_id <>", value, "recordUserId");
            return (Criteria) this;
        }

        public Criteria andRecordUserIdGreaterThan(Long value) {
            addCriterion("record_user_id >", value, "recordUserId");
            return (Criteria) this;
        }

        public Criteria andRecordUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("record_user_id >=", value, "recordUserId");
            return (Criteria) this;
        }

        public Criteria andRecordUserIdLessThan(Long value) {
            addCriterion("record_user_id <", value, "recordUserId");
            return (Criteria) this;
        }

        public Criteria andRecordUserIdLessThanOrEqualTo(Long value) {
            addCriterion("record_user_id <=", value, "recordUserId");
            return (Criteria) this;
        }

        public Criteria andRecordUserIdIn(List<Long> values) {
            addCriterion("record_user_id in", values, "recordUserId");
            return (Criteria) this;
        }

        public Criteria andRecordUserIdNotIn(List<Long> values) {
            addCriterion("record_user_id not in", values, "recordUserId");
            return (Criteria) this;
        }

        public Criteria andRecordUserIdBetween(Long value1, Long value2) {
            addCriterion("record_user_id between", value1, value2, "recordUserId");
            return (Criteria) this;
        }

        public Criteria andRecordUserIdNotBetween(Long value1, Long value2) {
            addCriterion("record_user_id not between", value1, value2, "recordUserId");
            return (Criteria) this;
        }

        public Criteria andRecordCountIsNull() {
            addCriterion("record_count is null");
            return (Criteria) this;
        }

        public Criteria andRecordCountIsNotNull() {
            addCriterion("record_count is not null");
            return (Criteria) this;
        }

        public Criteria andRecordCountEqualTo(String value) {
            addCriterion("record_count =", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountNotEqualTo(String value) {
            addCriterion("record_count <>", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountGreaterThan(String value) {
            addCriterion("record_count >", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountGreaterThanOrEqualTo(String value) {
            addCriterion("record_count >=", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountLessThan(String value) {
            addCriterion("record_count <", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountLessThanOrEqualTo(String value) {
            addCriterion("record_count <=", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountLike(String value) {
            addCriterion("record_count like", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountNotLike(String value) {
            addCriterion("record_count not like", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountIn(List<String> values) {
            addCriterion("record_count in", values, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountNotIn(List<String> values) {
            addCriterion("record_count not in", values, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountBetween(String value1, String value2) {
            addCriterion("record_count between", value1, value2, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountNotBetween(String value1, String value2) {
            addCriterion("record_count not between", value1, value2, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordTypeIsNull() {
            addCriterion("record_type is null");
            return (Criteria) this;
        }

        public Criteria andRecordTypeIsNotNull() {
            addCriterion("record_type is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTypeEqualTo(Integer value) {
            addCriterion("record_type =", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeNotEqualTo(Integer value) {
            addCriterion("record_type <>", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeGreaterThan(Integer value) {
            addCriterion("record_type >", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_type >=", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeLessThan(Integer value) {
            addCriterion("record_type <", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeLessThanOrEqualTo(Integer value) {
            addCriterion("record_type <=", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeIn(List<Integer> values) {
            addCriterion("record_type in", values, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeNotIn(List<Integer> values) {
            addCriterion("record_type not in", values, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeBetween(Integer value1, Integer value2) {
            addCriterion("record_type between", value1, value2, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("record_type not between", value1, value2, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNull() {
            addCriterion("record_time is null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNotNull() {
            addCriterion("record_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeEqualTo(Long value) {
            addCriterion("record_time =", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotEqualTo(Long value) {
            addCriterion("record_time <>", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThan(Long value) {
            addCriterion("record_time >", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("record_time >=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThan(Long value) {
            addCriterion("record_time <", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThanOrEqualTo(Long value) {
            addCriterion("record_time <=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIn(List<Long> values) {
            addCriterion("record_time in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotIn(List<Long> values) {
            addCriterion("record_time not in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeBetween(Long value1, Long value2) {
            addCriterion("record_time between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotBetween(Long value1, Long value2) {
            addCriterion("record_time not between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordReturnNoIsNull() {
            addCriterion("record_return_no is null");
            return (Criteria) this;
        }

        public Criteria andRecordReturnNoIsNotNull() {
            addCriterion("record_return_no is not null");
            return (Criteria) this;
        }

        public Criteria andRecordReturnNoEqualTo(String value) {
            addCriterion("record_return_no =", value, "recordReturnNo");
            return (Criteria) this;
        }

        public Criteria andRecordReturnNoNotEqualTo(String value) {
            addCriterion("record_return_no <>", value, "recordReturnNo");
            return (Criteria) this;
        }

        public Criteria andRecordReturnNoGreaterThan(String value) {
            addCriterion("record_return_no >", value, "recordReturnNo");
            return (Criteria) this;
        }

        public Criteria andRecordReturnNoGreaterThanOrEqualTo(String value) {
            addCriterion("record_return_no >=", value, "recordReturnNo");
            return (Criteria) this;
        }

        public Criteria andRecordReturnNoLessThan(String value) {
            addCriterion("record_return_no <", value, "recordReturnNo");
            return (Criteria) this;
        }

        public Criteria andRecordReturnNoLessThanOrEqualTo(String value) {
            addCriterion("record_return_no <=", value, "recordReturnNo");
            return (Criteria) this;
        }

        public Criteria andRecordReturnNoLike(String value) {
            addCriterion("record_return_no like", value, "recordReturnNo");
            return (Criteria) this;
        }

        public Criteria andRecordReturnNoNotLike(String value) {
            addCriterion("record_return_no not like", value, "recordReturnNo");
            return (Criteria) this;
        }

        public Criteria andRecordReturnNoIn(List<String> values) {
            addCriterion("record_return_no in", values, "recordReturnNo");
            return (Criteria) this;
        }

        public Criteria andRecordReturnNoNotIn(List<String> values) {
            addCriterion("record_return_no not in", values, "recordReturnNo");
            return (Criteria) this;
        }

        public Criteria andRecordReturnNoBetween(String value1, String value2) {
            addCriterion("record_return_no between", value1, value2, "recordReturnNo");
            return (Criteria) this;
        }

        public Criteria andRecordReturnNoNotBetween(String value1, String value2) {
            addCriterion("record_return_no not between", value1, value2, "recordReturnNo");
            return (Criteria) this;
        }

        public Criteria andRecordOpenIdIsNull() {
            addCriterion("record_open_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordOpenIdIsNotNull() {
            addCriterion("record_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordOpenIdEqualTo(String value) {
            addCriterion("record_open_id =", value, "recordOpenId");
            return (Criteria) this;
        }

        public Criteria andRecordOpenIdNotEqualTo(String value) {
            addCriterion("record_open_id <>", value, "recordOpenId");
            return (Criteria) this;
        }

        public Criteria andRecordOpenIdGreaterThan(String value) {
            addCriterion("record_open_id >", value, "recordOpenId");
            return (Criteria) this;
        }

        public Criteria andRecordOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("record_open_id >=", value, "recordOpenId");
            return (Criteria) this;
        }

        public Criteria andRecordOpenIdLessThan(String value) {
            addCriterion("record_open_id <", value, "recordOpenId");
            return (Criteria) this;
        }

        public Criteria andRecordOpenIdLessThanOrEqualTo(String value) {
            addCriterion("record_open_id <=", value, "recordOpenId");
            return (Criteria) this;
        }

        public Criteria andRecordOpenIdLike(String value) {
            addCriterion("record_open_id like", value, "recordOpenId");
            return (Criteria) this;
        }

        public Criteria andRecordOpenIdNotLike(String value) {
            addCriterion("record_open_id not like", value, "recordOpenId");
            return (Criteria) this;
        }

        public Criteria andRecordOpenIdIn(List<String> values) {
            addCriterion("record_open_id in", values, "recordOpenId");
            return (Criteria) this;
        }

        public Criteria andRecordOpenIdNotIn(List<String> values) {
            addCriterion("record_open_id not in", values, "recordOpenId");
            return (Criteria) this;
        }

        public Criteria andRecordOpenIdBetween(String value1, String value2) {
            addCriterion("record_open_id between", value1, value2, "recordOpenId");
            return (Criteria) this;
        }

        public Criteria andRecordOpenIdNotBetween(String value1, String value2) {
            addCriterion("record_open_id not between", value1, value2, "recordOpenId");
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