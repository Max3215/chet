package net.oschina.archx.mybatis.dialect;

import net.oschina.archx.mybatis.IDialect;

/**
 * MySql 数据库分页语句组装实现
 * 
 * @author suyl
 */
public class MySqlDialect implements IDialect {

    @Override
    public String buildPaginationSql(String originalSql, int offset, int limit) {
        StringBuilder sql = new StringBuilder(originalSql);
        sql.append(" LIMIT ").append(offset).append(",").append(limit);
        return sql.toString();
    }

}
