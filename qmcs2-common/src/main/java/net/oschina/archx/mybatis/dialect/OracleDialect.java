package net.oschina.archx.mybatis.dialect;

import net.oschina.archx.mybatis.IDialect;

/**
 * Oracle 数据库分页语句组装实现
 * 
 * @author suyl
 */
public class OracleDialect implements IDialect {

    @Override
    public String buildPaginationSql(String originalSql, int offset, int limit) {
        StringBuilder sql = new StringBuilder(originalSql);
        // ORACLE 分页是通过 ROWNUMBER 进行的， ROWNUMBER 是从 1 开始的
        offset++;
        sql.insert(0, "SELECT U.*, ROWNUM R FROM (").append(") U WHERE ROWNUM < ").append(offset + limit);
        sql.insert(0, "SELECT * FROM (").append(") TEMP WHERE R >= ").append(offset);
        return sql.toString();
    }

}
