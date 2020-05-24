package org.squirrel.world.db.mapper;

import org.apache.ibatis.type.EnumTypeHandler;
import org.squirrel.world.db.model.Continent;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContinentHandler extends EnumTypeHandler<Continent> {
    public ContinentHandler(Class type) {
        super(type);
    }

    @Override
    public Continent getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String s = rs.getString(columnName);
        return s == null ? null : Continent.fromValue(s);
    }

    @Override
    public Continent getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String s = rs.getString(columnIndex);
        return s == null ? null : Continent.fromValue(s);
    }

    @Override
    public Continent getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String s = cs.getString(columnIndex);
        return s == null ? null : Continent.fromValue(s);
    }
}
