package com.conagyurig.tursoDemo;

import org.springframework.data.relational.core.dialect.AbstractDialect;
import org.springframework.data.relational.core.dialect.LimitClause;
import org.springframework.data.relational.core.dialect.LockClause;
import org.springframework.data.relational.core.sql.IdentifierProcessing;
import org.springframework.data.relational.core.sql.LockOptions;

public class LibSQLDialect extends AbstractDialect {
    public static final LibSQLDialect INSTANCE = new LibSQLDialect();

    public LimitClause LIMIT_CLAUSE = new LimitClause() {

        @Override
        public String getLimit(long limit) {
            return String.format("limit %d", limit);
        }

        @Override
        public String getOffset(long offset) {
            throw new UnsupportedOperationException("offset alone not supported");
        }

        @Override
        public String getLimitOffset(long limit, long offset) {
            return String.format("limit %d offset %d", limit, offset);
        }

        @Override
        public Position getClausePosition() {
            return Position.AFTER_ORDER_BY;
        }
    };

    private static final LockClause LOCK_CLAUSE = new LockClause() {
        @Override
        public String getLock(LockOptions lockOptions) {
            return "";
        }

        @Override
        public Position getClausePosition() {
            return Position.AFTER_ORDER_BY;
        }
    };

    @Override
    public LimitClause limit() {
        return LIMIT_CLAUSE;
    }

    @Override
    public LockClause lock() {
        return LOCK_CLAUSE;
    }

    @Override
    public IdentifierProcessing getIdentifierProcessing() {
        return IdentifierProcessing.create(
                IdentifierProcessing.Quoting.NONE,
                IdentifierProcessing.LetterCasing.UPPER_CASE
        );
    }
}
