package com.qmcs.info.model.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SystemCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public SystemCriteria() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andSysIdIsNull() {
            addCriterion("sys_id is null");
            return (Criteria) this;
        }

        public Criteria andSysIdIsNotNull() {
            addCriterion("sys_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysIdEqualTo(Integer value) {
            addCriterion("sys_id =", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotEqualTo(Integer value) {
            addCriterion("sys_id <>", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdGreaterThan(Integer value) {
            addCriterion("sys_id >", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_id >=", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLessThan(Integer value) {
            addCriterion("sys_id <", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLessThanOrEqualTo(Integer value) {
            addCriterion("sys_id <=", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdIn(List<Integer> values) {
            addCriterion("sys_id in", values, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotIn(List<Integer> values) {
            addCriterion("sys_id not in", values, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdBetween(Integer value1, Integer value2) {
            addCriterion("sys_id between", value1, value2, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_id not between", value1, value2, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysNameIsNull() {
            addCriterion("sys_name is null");
            return (Criteria) this;
        }

        public Criteria andSysNameIsNotNull() {
            addCriterion("sys_name is not null");
            return (Criteria) this;
        }

        public Criteria andSysNameEqualTo(String value) {
            addCriterion("sys_name =", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotEqualTo(String value) {
            addCriterion("sys_name <>", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameGreaterThan(String value) {
            addCriterion("sys_name >", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameGreaterThanOrEqualTo(String value) {
            addCriterion("sys_name >=", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLessThan(String value) {
            addCriterion("sys_name <", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLessThanOrEqualTo(String value) {
            addCriterion("sys_name <=", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLike(String value) {
            addCriterion("sys_name like", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotLike(String value) {
            addCriterion("sys_name not like", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameIn(List<String> values) {
            addCriterion("sys_name in", values, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotIn(List<String> values) {
            addCriterion("sys_name not in", values, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameBetween(String value1, String value2) {
            addCriterion("sys_name between", value1, value2, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotBetween(String value1, String value2) {
            addCriterion("sys_name not between", value1, value2, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysUsernameIsNull() {
            addCriterion("sys_username is null");
            return (Criteria) this;
        }

        public Criteria andSysUsernameIsNotNull() {
            addCriterion("sys_username is not null");
            return (Criteria) this;
        }

        public Criteria andSysUsernameEqualTo(String value) {
            addCriterion("sys_username =", value, "sysUsername");
            return (Criteria) this;
        }

        public Criteria andSysUsernameNotEqualTo(String value) {
            addCriterion("sys_username <>", value, "sysUsername");
            return (Criteria) this;
        }

        public Criteria andSysUsernameGreaterThan(String value) {
            addCriterion("sys_username >", value, "sysUsername");
            return (Criteria) this;
        }

        public Criteria andSysUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("sys_username >=", value, "sysUsername");
            return (Criteria) this;
        }

        public Criteria andSysUsernameLessThan(String value) {
            addCriterion("sys_username <", value, "sysUsername");
            return (Criteria) this;
        }

        public Criteria andSysUsernameLessThanOrEqualTo(String value) {
            addCriterion("sys_username <=", value, "sysUsername");
            return (Criteria) this;
        }

        public Criteria andSysUsernameLike(String value) {
            addCriterion("sys_username like", value, "sysUsername");
            return (Criteria) this;
        }

        public Criteria andSysUsernameNotLike(String value) {
            addCriterion("sys_username not like", value, "sysUsername");
            return (Criteria) this;
        }

        public Criteria andSysUsernameIn(List<String> values) {
            addCriterion("sys_username in", values, "sysUsername");
            return (Criteria) this;
        }

        public Criteria andSysUsernameNotIn(List<String> values) {
            addCriterion("sys_username not in", values, "sysUsername");
            return (Criteria) this;
        }

        public Criteria andSysUsernameBetween(String value1, String value2) {
            addCriterion("sys_username between", value1, value2, "sysUsername");
            return (Criteria) this;
        }

        public Criteria andSysUsernameNotBetween(String value1, String value2) {
            addCriterion("sys_username not between", value1, value2, "sysUsername");
            return (Criteria) this;
        }

        public Criteria andSysPasswordIsNull() {
            addCriterion("sys_password is null");
            return (Criteria) this;
        }

        public Criteria andSysPasswordIsNotNull() {
            addCriterion("sys_password is not null");
            return (Criteria) this;
        }

        public Criteria andSysPasswordEqualTo(String value) {
            addCriterion("sys_password =", value, "sysPassword");
            return (Criteria) this;
        }

        public Criteria andSysPasswordNotEqualTo(String value) {
            addCriterion("sys_password <>", value, "sysPassword");
            return (Criteria) this;
        }

        public Criteria andSysPasswordGreaterThan(String value) {
            addCriterion("sys_password >", value, "sysPassword");
            return (Criteria) this;
        }

        public Criteria andSysPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("sys_password >=", value, "sysPassword");
            return (Criteria) this;
        }

        public Criteria andSysPasswordLessThan(String value) {
            addCriterion("sys_password <", value, "sysPassword");
            return (Criteria) this;
        }

        public Criteria andSysPasswordLessThanOrEqualTo(String value) {
            addCriterion("sys_password <=", value, "sysPassword");
            return (Criteria) this;
        }

        public Criteria andSysPasswordLike(String value) {
            addCriterion("sys_password like", value, "sysPassword");
            return (Criteria) this;
        }

        public Criteria andSysPasswordNotLike(String value) {
            addCriterion("sys_password not like", value, "sysPassword");
            return (Criteria) this;
        }

        public Criteria andSysPasswordIn(List<String> values) {
            addCriterion("sys_password in", values, "sysPassword");
            return (Criteria) this;
        }

        public Criteria andSysPasswordNotIn(List<String> values) {
            addCriterion("sys_password not in", values, "sysPassword");
            return (Criteria) this;
        }

        public Criteria andSysPasswordBetween(String value1, String value2) {
            addCriterion("sys_password between", value1, value2, "sysPassword");
            return (Criteria) this;
        }

        public Criteria andSysPasswordNotBetween(String value1, String value2) {
            addCriterion("sys_password not between", value1, value2, "sysPassword");
            return (Criteria) this;
        }

        public Criteria andSysSexIsNull() {
            addCriterion("sys_sex is null");
            return (Criteria) this;
        }

        public Criteria andSysSexIsNotNull() {
            addCriterion("sys_sex is not null");
            return (Criteria) this;
        }

        public Criteria andSysSexEqualTo(Integer value) {
            addCriterion("sys_sex =", value, "sysSex");
            return (Criteria) this;
        }

        public Criteria andSysSexNotEqualTo(Integer value) {
            addCriterion("sys_sex <>", value, "sysSex");
            return (Criteria) this;
        }

        public Criteria andSysSexGreaterThan(Integer value) {
            addCriterion("sys_sex >", value, "sysSex");
            return (Criteria) this;
        }

        public Criteria andSysSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_sex >=", value, "sysSex");
            return (Criteria) this;
        }

        public Criteria andSysSexLessThan(Integer value) {
            addCriterion("sys_sex <", value, "sysSex");
            return (Criteria) this;
        }

        public Criteria andSysSexLessThanOrEqualTo(Integer value) {
            addCriterion("sys_sex <=", value, "sysSex");
            return (Criteria) this;
        }

        public Criteria andSysSexIn(List<Integer> values) {
            addCriterion("sys_sex in", values, "sysSex");
            return (Criteria) this;
        }

        public Criteria andSysSexNotIn(List<Integer> values) {
            addCriterion("sys_sex not in", values, "sysSex");
            return (Criteria) this;
        }

        public Criteria andSysSexBetween(Integer value1, Integer value2) {
            addCriterion("sys_sex between", value1, value2, "sysSex");
            return (Criteria) this;
        }

        public Criteria andSysSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_sex not between", value1, value2, "sysSex");
            return (Criteria) this;
        }

        public Criteria andSysAgeIsNull() {
            addCriterion("sys_age is null");
            return (Criteria) this;
        }

        public Criteria andSysAgeIsNotNull() {
            addCriterion("sys_age is not null");
            return (Criteria) this;
        }

        public Criteria andSysAgeEqualTo(Integer value) {
            addCriterion("sys_age =", value, "sysAge");
            return (Criteria) this;
        }

        public Criteria andSysAgeNotEqualTo(Integer value) {
            addCriterion("sys_age <>", value, "sysAge");
            return (Criteria) this;
        }

        public Criteria andSysAgeGreaterThan(Integer value) {
            addCriterion("sys_age >", value, "sysAge");
            return (Criteria) this;
        }

        public Criteria andSysAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_age >=", value, "sysAge");
            return (Criteria) this;
        }

        public Criteria andSysAgeLessThan(Integer value) {
            addCriterion("sys_age <", value, "sysAge");
            return (Criteria) this;
        }

        public Criteria andSysAgeLessThanOrEqualTo(Integer value) {
            addCriterion("sys_age <=", value, "sysAge");
            return (Criteria) this;
        }

        public Criteria andSysAgeIn(List<Integer> values) {
            addCriterion("sys_age in", values, "sysAge");
            return (Criteria) this;
        }

        public Criteria andSysAgeNotIn(List<Integer> values) {
            addCriterion("sys_age not in", values, "sysAge");
            return (Criteria) this;
        }

        public Criteria andSysAgeBetween(Integer value1, Integer value2) {
            addCriterion("sys_age between", value1, value2, "sysAge");
            return (Criteria) this;
        }

        public Criteria andSysAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_age not between", value1, value2, "sysAge");
            return (Criteria) this;
        }

        public Criteria andSysBirthdayIsNull() {
            addCriterion("sys_birthday is null");
            return (Criteria) this;
        }

        public Criteria andSysBirthdayIsNotNull() {
            addCriterion("sys_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andSysBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("sys_birthday =", value, "sysBirthday");
            return (Criteria) this;
        }

        public Criteria andSysBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("sys_birthday <>", value, "sysBirthday");
            return (Criteria) this;
        }

        public Criteria andSysBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("sys_birthday >", value, "sysBirthday");
            return (Criteria) this;
        }

        public Criteria andSysBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sys_birthday >=", value, "sysBirthday");
            return (Criteria) this;
        }

        public Criteria andSysBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("sys_birthday <", value, "sysBirthday");
            return (Criteria) this;
        }

        public Criteria andSysBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sys_birthday <=", value, "sysBirthday");
            return (Criteria) this;
        }

        public Criteria andSysBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("sys_birthday in", values, "sysBirthday");
            return (Criteria) this;
        }

        public Criteria andSysBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("sys_birthday not in", values, "sysBirthday");
            return (Criteria) this;
        }

        public Criteria andSysBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sys_birthday between", value1, value2, "sysBirthday");
            return (Criteria) this;
        }

        public Criteria andSysBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sys_birthday not between", value1, value2, "sysBirthday");
            return (Criteria) this;
        }

        public Criteria andSysPhoneIsNull() {
            addCriterion("sys_phone is null");
            return (Criteria) this;
        }

        public Criteria andSysPhoneIsNotNull() {
            addCriterion("sys_phone is not null");
            return (Criteria) this;
        }

        public Criteria andSysPhoneEqualTo(String value) {
            addCriterion("sys_phone =", value, "sysPhone");
            return (Criteria) this;
        }

        public Criteria andSysPhoneNotEqualTo(String value) {
            addCriterion("sys_phone <>", value, "sysPhone");
            return (Criteria) this;
        }

        public Criteria andSysPhoneGreaterThan(String value) {
            addCriterion("sys_phone >", value, "sysPhone");
            return (Criteria) this;
        }

        public Criteria andSysPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("sys_phone >=", value, "sysPhone");
            return (Criteria) this;
        }

        public Criteria andSysPhoneLessThan(String value) {
            addCriterion("sys_phone <", value, "sysPhone");
            return (Criteria) this;
        }

        public Criteria andSysPhoneLessThanOrEqualTo(String value) {
            addCriterion("sys_phone <=", value, "sysPhone");
            return (Criteria) this;
        }

        public Criteria andSysPhoneLike(String value) {
            addCriterion("sys_phone like", value, "sysPhone");
            return (Criteria) this;
        }

        public Criteria andSysPhoneNotLike(String value) {
            addCriterion("sys_phone not like", value, "sysPhone");
            return (Criteria) this;
        }

        public Criteria andSysPhoneIn(List<String> values) {
            addCriterion("sys_phone in", values, "sysPhone");
            return (Criteria) this;
        }

        public Criteria andSysPhoneNotIn(List<String> values) {
            addCriterion("sys_phone not in", values, "sysPhone");
            return (Criteria) this;
        }

        public Criteria andSysPhoneBetween(String value1, String value2) {
            addCriterion("sys_phone between", value1, value2, "sysPhone");
            return (Criteria) this;
        }

        public Criteria andSysPhoneNotBetween(String value1, String value2) {
            addCriterion("sys_phone not between", value1, value2, "sysPhone");
            return (Criteria) this;
        }

        public Criteria andSysEmailIsNull() {
            addCriterion("sys_email is null");
            return (Criteria) this;
        }

        public Criteria andSysEmailIsNotNull() {
            addCriterion("sys_email is not null");
            return (Criteria) this;
        }

        public Criteria andSysEmailEqualTo(String value) {
            addCriterion("sys_email =", value, "sysEmail");
            return (Criteria) this;
        }

        public Criteria andSysEmailNotEqualTo(String value) {
            addCriterion("sys_email <>", value, "sysEmail");
            return (Criteria) this;
        }

        public Criteria andSysEmailGreaterThan(String value) {
            addCriterion("sys_email >", value, "sysEmail");
            return (Criteria) this;
        }

        public Criteria andSysEmailGreaterThanOrEqualTo(String value) {
            addCriterion("sys_email >=", value, "sysEmail");
            return (Criteria) this;
        }

        public Criteria andSysEmailLessThan(String value) {
            addCriterion("sys_email <", value, "sysEmail");
            return (Criteria) this;
        }

        public Criteria andSysEmailLessThanOrEqualTo(String value) {
            addCriterion("sys_email <=", value, "sysEmail");
            return (Criteria) this;
        }

        public Criteria andSysEmailLike(String value) {
            addCriterion("sys_email like", value, "sysEmail");
            return (Criteria) this;
        }

        public Criteria andSysEmailNotLike(String value) {
            addCriterion("sys_email not like", value, "sysEmail");
            return (Criteria) this;
        }

        public Criteria andSysEmailIn(List<String> values) {
            addCriterion("sys_email in", values, "sysEmail");
            return (Criteria) this;
        }

        public Criteria andSysEmailNotIn(List<String> values) {
            addCriterion("sys_email not in", values, "sysEmail");
            return (Criteria) this;
        }

        public Criteria andSysEmailBetween(String value1, String value2) {
            addCriterion("sys_email between", value1, value2, "sysEmail");
            return (Criteria) this;
        }

        public Criteria andSysEmailNotBetween(String value1, String value2) {
            addCriterion("sys_email not between", value1, value2, "sysEmail");
            return (Criteria) this;
        }

        public Criteria andSysIsDeletedIsNull() {
            addCriterion("sys_is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andSysIsDeletedIsNotNull() {
            addCriterion("sys_is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andSysIsDeletedEqualTo(Boolean value) {
            addCriterion("sys_is_deleted =", value, "sysIsDeleted");
            return (Criteria) this;
        }

        public Criteria andSysIsDeletedNotEqualTo(Boolean value) {
            addCriterion("sys_is_deleted <>", value, "sysIsDeleted");
            return (Criteria) this;
        }

        public Criteria andSysIsDeletedGreaterThan(Boolean value) {
            addCriterion("sys_is_deleted >", value, "sysIsDeleted");
            return (Criteria) this;
        }

        public Criteria andSysIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("sys_is_deleted >=", value, "sysIsDeleted");
            return (Criteria) this;
        }

        public Criteria andSysIsDeletedLessThan(Boolean value) {
            addCriterion("sys_is_deleted <", value, "sysIsDeleted");
            return (Criteria) this;
        }

        public Criteria andSysIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("sys_is_deleted <=", value, "sysIsDeleted");
            return (Criteria) this;
        }

        public Criteria andSysIsDeletedIn(List<Boolean> values) {
            addCriterion("sys_is_deleted in", values, "sysIsDeleted");
            return (Criteria) this;
        }

        public Criteria andSysIsDeletedNotIn(List<Boolean> values) {
            addCriterion("sys_is_deleted not in", values, "sysIsDeleted");
            return (Criteria) this;
        }

        public Criteria andSysIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("sys_is_deleted between", value1, value2, "sysIsDeleted");
            return (Criteria) this;
        }

        public Criteria andSysIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("sys_is_deleted not between", value1, value2, "sysIsDeleted");
            return (Criteria) this;
        }

        public Criteria andDeptidIsNull() {
            addCriterion("deptId is null");
            return (Criteria) this;
        }

        public Criteria andDeptidIsNotNull() {
            addCriterion("deptId is not null");
            return (Criteria) this;
        }

        public Criteria andDeptidEqualTo(String value) {
            addCriterion("deptId =", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotEqualTo(String value) {
            addCriterion("deptId <>", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidGreaterThan(String value) {
            addCriterion("deptId >", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidGreaterThanOrEqualTo(String value) {
            addCriterion("deptId >=", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidLessThan(String value) {
            addCriterion("deptId <", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidLessThanOrEqualTo(String value) {
            addCriterion("deptId <=", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidLike(String value) {
            addCriterion("deptId like", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotLike(String value) {
            addCriterion("deptId not like", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidIn(List<String> values) {
            addCriterion("deptId in", values, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotIn(List<String> values) {
            addCriterion("deptId not in", values, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidBetween(String value1, String value2) {
            addCriterion("deptId between", value1, value2, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotBetween(String value1, String value2) {
            addCriterion("deptId not between", value1, value2, "deptid");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentId is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentId is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(String value) {
            addCriterion("parentId =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(String value) {
            addCriterion("parentId <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(String value) {
            addCriterion("parentId >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(String value) {
            addCriterion("parentId >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(String value) {
            addCriterion("parentId <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(String value) {
            addCriterion("parentId <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLike(String value) {
            addCriterion("parentId like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotLike(String value) {
            addCriterion("parentId not like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<String> values) {
            addCriterion("parentId in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<String> values) {
            addCriterion("parentId not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(String value1, String value2) {
            addCriterion("parentId between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(String value1, String value2) {
            addCriterion("parentId not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andCreataDateIsNull() {
            addCriterion("creata_date is null");
            return (Criteria) this;
        }

        public Criteria andCreataDateIsNotNull() {
            addCriterion("creata_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreataDateEqualTo(Date value) {
            addCriterion("creata_date =", value, "creataDate");
            return (Criteria) this;
        }

        public Criteria andCreataDateNotEqualTo(Date value) {
            addCriterion("creata_date <>", value, "creataDate");
            return (Criteria) this;
        }

        public Criteria andCreataDateGreaterThan(Date value) {
            addCriterion("creata_date >", value, "creataDate");
            return (Criteria) this;
        }

        public Criteria andCreataDateGreaterThanOrEqualTo(Date value) {
            addCriterion("creata_date >=", value, "creataDate");
            return (Criteria) this;
        }

        public Criteria andCreataDateLessThan(Date value) {
            addCriterion("creata_date <", value, "creataDate");
            return (Criteria) this;
        }

        public Criteria andCreataDateLessThanOrEqualTo(Date value) {
            addCriterion("creata_date <=", value, "creataDate");
            return (Criteria) this;
        }

        public Criteria andCreataDateIn(List<Date> values) {
            addCriterion("creata_date in", values, "creataDate");
            return (Criteria) this;
        }

        public Criteria andCreataDateNotIn(List<Date> values) {
            addCriterion("creata_date not in", values, "creataDate");
            return (Criteria) this;
        }

        public Criteria andCreataDateBetween(Date value1, Date value2) {
            addCriterion("creata_date between", value1, value2, "creataDate");
            return (Criteria) this;
        }

        public Criteria andCreataDateNotBetween(Date value1, Date value2) {
            addCriterion("creata_date not between", value1, value2, "creataDate");
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