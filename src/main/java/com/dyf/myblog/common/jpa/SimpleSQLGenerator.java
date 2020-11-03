package com.dyf.myblog.common.jpa;





import com.dyf.myblog.common.base.BasePO;
import com.dyf.myblog.common.cache.CachePool;
import com.dyf.myblog.common.cache.ORMCache;

public class SimpleSQLGenerator extends AbstractSQLGenerator {

    private final ORMCache ormCache = CachePool.getCache(ORMCache.KEY, ORMCache.class);
    @Override
    public String insert(BasePO entity) {
        StringBuilder insert = new StringBuilder();
        if (entity != null) {
            ORMEntity ormEntity = ormCache.get(entity.getClass());
            insert.append("INSERT INTO ").append(ormEntity.getTableName());
            insert.append(insertClause(ormEntity));
        }
        return insert.toString();
    }

    @Override
    public String update(BasePO entity) {
        StringBuilder update = new StringBuilder();
        if (entity != null) {
            ORMEntity ormEntity = ormCache.get(entity.getClass());
            update.append("UPDATE ").append(ormEntity.getTableName());
            update.append(updateClause(ormEntity));
        }
        return update.toString();
    }

    @Override
    public String delete(BasePO entity) {
        StringBuilder delete = new StringBuilder();
        if (entity != null) {
            ORMEntity ormEntity = ormCache.get(entity.getClass());
            delete.append("DELETE FROM ").append(ormEntity.getTableName());
            delete.append(whereClause(ormEntity));
        }
        return delete.toString();
    }

    @Override
    public String select(BasePO entity) {
        StringBuilder select = new StringBuilder();
        if (entity != null) {
            ORMEntity ormEntity = ormCache.get(entity.getClass());
            select.append("SELECT * FROM ").append(ormEntity.getTableName());
            select.append(whereClause(ormEntity));
        }
        return select.toString();
    }
}
